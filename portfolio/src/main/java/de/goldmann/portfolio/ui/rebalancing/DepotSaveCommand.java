package de.goldmann.portfolio.ui.rebalancing;

import java.util.Objects;

import de.goldmann.portfolio.domain.Depot;
import de.goldmann.portfolio.domain.repository.DepotRepository;

public abstract class DepotSaveCommand implements SaveCommand {

    protected final Depot         depot;
    private final DepotRepository depotRepository;

    public DepotSaveCommand(final Depot depot, final DepotRepository depotRepository) {
        this.depot = Objects.requireNonNull(depot, "depot");
        this.depotRepository = Objects.requireNonNull(depotRepository, "depotRepository");
    }
}
