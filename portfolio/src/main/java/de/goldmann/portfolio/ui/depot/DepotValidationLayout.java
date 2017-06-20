package de.goldmann.portfolio.ui.depot;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import de.goldmann.portfolio.csv.CsvReader;
import de.goldmann.portfolio.csv.StockWithinCsv;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;

@SuppressWarnings("serial")
public class DepotValidationLayout extends HorizontalLayout {

    public DepotValidationLayout(
        final StockWithinDepotRepository stockWithinDepotRepository,
        final CsvReader csvReader) {
        super();
        setSpacing(true);

        final Label validationMsg = new Label();
        final Button validateBtn = new Button("Validiere Depot");
        validateBtn.addClickListener(e -> {
            final long depotCount = stockWithinDepotRepository.count();
            try {
                final Set<StockWithinCsv> stocksWithinCsv = csvReader.readPortfolioFile();
                final long stocksWithinCount = stocksWithinCsv.size();
                if (depotCount != stocksWithinCount) {
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

        addComponent(validateBtn);
        addComponent(validationMsg);
    }

}
