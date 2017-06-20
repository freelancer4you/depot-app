package de.goldmann.portfolio.monitoring;

import java.util.ArrayList;
import java.util.List;

import org.jmock.auto.Mock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import de.goldmann.portfolio.domain.MonitorEvent;
import de.goldmann.portfolio.domain.PriceLimitDirection;
import de.goldmann.portfolio.domain.repository.MonitorEventRepository;
import de.goldmann.portfolio.services.MailService;
import de.goldmann.portfolio.services.YahooFinanceService;

public class StockMonitorTest {

    private StockMonitor           monitor;

    @Rule
    public MockitoRule             mockitoRule = MockitoJUnit.rule();

    @Mock
    private MonitorEventRepository monitorEventRepository;
    @Mock
    private YahooFinanceService    yahooFinanceService;
    @Mock
    private MailService            mailService;

    @Before
    public void setup() throws Exception {
        monitor = new StockMonitor(monitorEventRepository, yahooFinanceService, mailService);
    }

    @Test
    public void monitorStocksPreisWurdeUnterschritten() throws Exception {
        monitorStocksTest(10.5, PriceLimitDirection.UNDERCUTTED);
    }

    @Test
    public void monitorStocksPreisWurdeUeberschritten() throws Exception {
        monitorStocksTest(9.5, PriceLimitDirection.EXCEEDED);
    }

    private void monitorStocksTest(final double priceLimit,
            final PriceLimitDirection priceLimitDirection)
                    throws Exception {
        final List<MonitorEvent> monitorEvents = new ArrayList<>();

        // final StockWithinDepot stockWithinDepot = new StockWithinDepot();
        // stockWithinDepot.setSearchKey("searchKey");
        // final MonitorEvent monitorEvent = new MonitorEvent(
        // stockWithinDepot, "comment", priceLimit, priceLimitDirection);
        // monitorEvents.add(monitorEvent);
        // when(monitorEventRepository.count()).thenReturn((long)monitorEvents.size());
        // when(monitorEventRepository.findAll()).thenReturn(monitorEvents);
        // final Map<String, Stock> searchResult = new HashMap<>();
        // final Stock stock = new Stock(stockWithinDepot.getSearchKey());
        // final StockQuote quote = new
        // StockQuote(stockWithinDepot.getSearchKey());
        // final double actualPrice = 10.0;
        // quote.setPrice(new BigDecimal(actualPrice));
        // stock.setQuote(quote);
        // searchResult.put(stockWithinDepot.getSearchKey(), stock);
        // when(yahooFinanceService.requestStocks(aryEq(new String[] {
        // stockWithinDepot.getSearchKey() }))).thenReturn(searchResult);

        // Execute
        monitor.monitorStocks();

        // Verify
        // verify(mailService)
        // .sendMail(
        // "Der Preis von "
        // + stockWithinDepot
        // + " hat das Limit "
        // + monitorEvent.getPriceLimit()
        // + " "
        // + priceLimitDirection.getCaption()
        // + "Der aktuelle Preis beträgt '" + actualPrice + "'."
        // );
    }

}
