package de.goldmann.portfolio.ui.stocks;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.core.env.Environment;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.csv.CsvReader;
import de.goldmann.portfolio.csv.StockWithinCsv;
import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.repository.OrderHistoryRepository;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.services.YahooFinanceService;

public class StocksView extends HorizontalLayout {

    private static final long  serialVersionUID = 1L;
    private final StocksTable  stocksTable;

    public StocksView(final EntityManager em,
            final StockWithinDepotRepository stockWithinDepotRepository,
            final OrderHistoryRepository orderHistoryRepository,
            final YahooFinanceService yahooFinanceService,
            final StockType stockType,
            final Environment env,
            final UI mainUi,
            final CsvReader csvReader) {
        super();
        setSpacing(true);

        stocksTable = new StocksTable(
                em,
                yahooFinanceService,
                stockType,
                env,
                stockWithinDepotRepository,
                orderHistoryRepository,
                mainUi
                );


        final VerticalLayout stocksTableLayout = new VerticalLayout();
        stocksTableLayout.setSpacing(true);
        stocksTableLayout.addComponent(stocksTable);
        final HorizontalLayout orderLayout = new HorizontalLayout();
        orderLayout.setSpacing(true);

        final Label validationMsg = new Label();
        final Button validateBtn = new Button("Validiere Depot");
        validateBtn.addClickListener(e -> {
            final long depotCount = stockWithinDepotRepository.count();
            try {
                final Set<StockWithinCsv> stocksWithinCsv = csvReader.readPortfolioFile();
                final long stocksWithinCount = stocksWithinCsv.size();
                if(depotCount != stocksWithinCount){
                    validationMsg.setValue("stockWithinDepot:" + depotCount + ", StocksWithinCsv:" + stocksWithinCount);
                    final Set<String> isinsInDepot = stockWithinDepotRepository.findAll().stream()
                            .map(stockData -> stockData.getStockData().getIsin()).collect(Collectors.toSet());
                    final Set<String> isinsInCsv = stocksWithinCsv.stream().map(csv -> csv.getIsin())
                            .collect(Collectors.toSet());
                    System.out.println(isinsInCsv.size());
                    isinsInCsv.removeAll(isinsInDepot);
                    System.out.println(isinsInCsv.size());
                    System.out.println(isinsInCsv);
                }
            } catch (final UnexpectedInputException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (final ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (final Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        orderLayout.addComponent(validateBtn);
        orderLayout.addComponent(validationMsg);
        stocksTableLayout.addComponent(orderLayout);
        addComponent(stocksTableLayout);

        addComponent(new StocksOverView(stockWithinDepotRepository));
    }


    public void update(final String depotName) {
        stocksTable.update(depotName);
    }
}
