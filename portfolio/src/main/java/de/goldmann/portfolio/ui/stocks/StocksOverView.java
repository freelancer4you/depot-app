package de.goldmann.portfolio.ui.stocks;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.data.Item;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import de.goldmann.portfolio.domain.Industry;
import de.goldmann.portfolio.domain.repository.IndustryStatistics;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;
import de.goldmann.portfolio.ui.PieChart;
import de.goldmann.portfolio.ui.PieChartData;

@SuppressWarnings("serial")
public class StocksOverView extends VerticalLayout {

    public StocksOverView(final StockWithinDepotRepository stockWithinDepotRepository) {
        super();

        final Table industryTable = new Table();
        industryTable.setWidth("100%");
        industryTable.addContainerProperty("Branche", Industry.class, null);
        industryTable.addContainerProperty("Anzahl", Long.class, null);

        final List<IndustryStatistics> industryStatistics = stockWithinDepotRepository.findIndustryCount();
        final Set<PieChartData> chartDataSet = new HashSet<>();
        for (final IndustryStatistics industryStatistic : industryStatistics)
        {
            // chartDataSet.add(
            // new PieChartData(industryStatistic.getIndustry().name(),
            // String.valueOf(industryStatistic.getCount())));
            final Object newItemId = industryTable.addItem();
            final Item row1 = industryTable.getItem(newItemId);
            row1.getItemProperty("Branche").setValue(industryStatistic.getIndustry());
            row1.getItemProperty("Anzahl").setValue(industryStatistic.getCount());
        }

        industryTable.setPageLength(industryStatistics.size());
        addComponent(industryTable);

        chartDataSet.add(new PieChartData("Microsoft Internet Explorer", 56.33));
        chartDataSet.add(new PieChartData("Chrome", 24.03));
        chartDataSet.add(new PieChartData("Firefox", 10.38));
        chartDataSet.add(new PieChartData("Safari", 4.77));
        chartDataSet.add(new PieChartData("Opera", 0.91));
        chartDataSet.add(new PieChartData("Proprietary or Undetectable", 0.2));

        // final JsHighChart chart = new JsHighChart();
        // chart.setId("myJSComponent");
        // addComponent(chart);
        final String chartData = getChartData(chartDataSet);

        final PieChart pieChart = new PieChart(chartData);
        pieChart.setId("pieChart");
        addComponent(pieChart);
    }

    private String getChartData(final Set<PieChartData> chartDataSet) {
        final ObjectMapper mapper = new ObjectMapper();
        String chartData;
        try
        {
            chartData = mapper.writeValueAsString(chartDataSet);
            System.out.println(chartData);
            return chartData;
        }
        catch (final JsonProcessingException e)
        {
            throw new RuntimeException("Fehler beim Konvertieren in JSON.");
        }

    }

}
