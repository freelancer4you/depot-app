package de.goldmann.portfolio.ui.rebalancing;

public interface PositionSaveCommand extends SaveCommand {

    void updatePercentage(Double changedPercentage);
}
