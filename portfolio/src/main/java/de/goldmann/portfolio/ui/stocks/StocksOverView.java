package de.goldmann.portfolio.ui.stocks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.domain.repository.IndustryStatistics;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.ui.PieChart;
import de.goldmann.portfolio.ui.PieChartData;

@SuppressWarnings("serial")
public class StocksOverView extends VerticalLayout {

    public StocksOverView(final StockWithinDepotRepository stockWithinDepotRepository) {
        super();

        final List<IndustryStatistics> industryStatistics = stockWithinDepotRepository.findIndustryCount();
        final Set<PieChartData> chartDataSet = new HashSet<>();
        for (final IndustryStatistics industryStatistic : industryStatistics)
        {
            chartDataSet.add(
                    new PieChartData(industryStatistic.getIndustry().name(),
                            industryStatistic.getCount()));
        }

        final String chartData = getChartData(chartDataSet);

        final PieChart pieChart = new PieChart(chartData, "Aktuelle Verteilung");
        pieChart.setId("pieChart");
        addComponent(pieChart);
    }

    private String getChartData(final Set<PieChartData> chartDataSet) {
        final ObjectMapper mapper = new ObjectMapper();
        String chartData;
        try
        {
            chartData = mapper.writeValueAsString(chartDataSet);
            return chartData;
        }
        catch (final JsonProcessingException e)
        {
            throw new RuntimeException("Fehler beim Konvertieren in JSON.");
        }
    }

}
