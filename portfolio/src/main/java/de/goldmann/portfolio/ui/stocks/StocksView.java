package de.goldmann.portfolio.ui.stocks;

import java.util.List;

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

public class StocksView extends VerticalLayout {

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

        stocksTable = new StocksTable(
                                      em,
                                      yahooFinanceService,
                                      stockType,
                                      env,
                                      stockWithinDepotRepository,
                                      orderHistoryRepository,
                                      mainUi
                );

        // final Sparklines s = new Sparklines("Stuff", 0, 0, 50, 100);
        // s.setDescription("Everything turned on");
        // s.setValue("15,26,23,56,35,37,21");
        // s.setAverageVisible(true);
        // s.setNormalRangeColor("#444");
        // s.setNormalRangeMax(80);
        // s.setNormalRangeMin(60);
        // s.setNormalRangeVisible(true);
        // s.setMaxColor("#f69");
        // s.setMinColor("#6f9");
        // return s;
        // }
        // });

        final VerticalLayout stocksTableLayout = new VerticalLayout();
        stocksTableLayout.setSpacing(true);
        stocksTableLayout.addComponent(stocksTable);
        final HorizontalLayout orderLayout = new HorizontalLayout();
        orderLayout.setSpacing(true);
        // final TextField selectedIsinField = new TextField();
        // selectedIsinField.setInputPrompt("ISIN");
        // orderLayout.addComponent(selectedIsinField);
        // orderLayout.addComponent(new Button("Kaufen"));
        // orderLayout.addComponent(new Button("Verkauf"));
        final Label validationMsg = new Label();
        final Button validateBtn = new Button("Validiere Depot");
        validateBtn.addClickListener(e -> {
            final long depotCount = stockWithinDepotRepository.count();
            try {
                final List<StockWithinCsv> stocksWithinCsv = csvReader.readPortfolioFile();
                final long stocksWithinCount = stocksWithinCsv.size();
                if(depotCount != stocksWithinCount){
                    validationMsg.setValue("stockWithinDepot:" + depotCount + ", StocksWithinCsv:" + stocksWithinCount);
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
    }

    public void update(final String depotName) {
        stocksTable.update(depotName);
    }
}
