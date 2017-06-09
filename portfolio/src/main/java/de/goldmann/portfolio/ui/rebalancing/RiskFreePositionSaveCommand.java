package de.goldmann.portfolio.ui.rebalancing;

import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.repository.DepotRepository;

public class RiskFreePositionSaveCommand extends DepotSaveCommand {

    public RiskFreePositionSaveCommand(final Depot depot, final DepotRepository depotRepository) {
        super(depot, depotRepository);
    }

    public void updateCashPercentage(final double percentage) {
        depot.setCashPercentage(percentage);
    }

    @Override
    public String getPercentage() {
        return String.valueOf(depot.getCashPercentage());
    }

    @Override
    public String getIsin() {
        // TODO Auto-generated method stub
        return null;
    }
}
