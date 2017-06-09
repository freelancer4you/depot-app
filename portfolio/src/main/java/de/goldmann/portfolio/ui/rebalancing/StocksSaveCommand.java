package de.goldmann.portfolio.ui.rebalancing;

import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.repository.DepotRepository;

public class StocksSaveCommand extends DepotSaveCommand {

    public StocksSaveCommand(final Depot depot, final DepotRepository depotRepository) {
        super(depot, depotRepository);
    }

    public void updateStocksPercentag(final double percentage) {
        depot.setStocksPercentage(percentage);
    }

    @Override
    public String getPercentage() {
        return String.valueOf(depot.getStocksPercentage());
    }

    @Override
    public String getIsin() {
        // TODO Auto-generated method stub
        return null;
    }
}
