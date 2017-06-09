package de.goldmann.portfolio.ui.rebalancing;

import java.util.Objects;

import de.goldmann.portfolio.domain.RebalancingDetails;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;

public class PositionSaveCommandImpl implements PositionSaveCommand {

    private final StockWithinDepot           stock;
    private final StockWithinDepotRepository stockWithinDepotRepository;

    public PositionSaveCommandImpl(final StockWithinDepot stock, final StockWithinDepotRepository stockWithinDepotRepository) {
        this.stock = Objects.requireNonNull(stock, "stock");
        this.stockWithinDepotRepository = Objects
                .requireNonNull(stockWithinDepotRepository, "stockWithinDepotRepository");
    }

    @Override
    public void updatePercentage(final Double percentage) {
        final RebalancingDetails rebalancingDetails = stock.getRebalancingDetails();
        System.out.println("chang percentage from " + rebalancingDetails.getPercentage() + " to " + percentage);
        rebalancingDetails.setPercentage(percentage);
        stockWithinDepotRepository.save(stock);
    }

    @Override
    public String getPercentage() {
        return String.valueOf(stock.getRebalancingDetails().getPercentage());
    }

    @Override
    public String getIsin() {
        return stock.getStockData().getIsin();
    }

}
