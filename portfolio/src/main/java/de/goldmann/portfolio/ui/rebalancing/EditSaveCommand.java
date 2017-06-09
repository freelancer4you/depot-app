package de.goldmann.portfolio.ui.rebalancing;

import java.util.Objects;

import de.goldmann.portfolio.domain.RebalancingDetails;
import de.goldmann.portfolio.domain.StockWithinDepot;
import de.goldmann.portfolio.domain.repository.StockWithinDepotRepository;

public class EditSaveCommand {

    private final StockWithinDepot           stock;
    private final StockWithinDepotRepository stockWithinDepotRepository;

    public EditSaveCommand(final StockWithinDepot stock, final StockWithinDepotRepository stockWithinDepotRepository) {
        this.stock = Objects.requireNonNull(stock, "stock");
        this.stockWithinDepotRepository = Objects
                .requireNonNull(stockWithinDepotRepository, "stockWithinDepotRepository");
    }

    public void updatePercentage(final double percentage) {
        final RebalancingDetails rebalancingDetails = stock.getRebalancingDetails();
        System.out.println("chang percentage from " + rebalancingDetails.getPercentage() + " to " + percentage);
        rebalancingDetails.setPercentage(percentage);
        stockWithinDepotRepository.save(stock);
    }

    public StockWithinDepot getStock() {
        return stock;
    }

}
