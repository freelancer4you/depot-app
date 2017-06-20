package de.goldmann.portfolio.ui.booking;

import org.vaadin.addons.lazyquerycontainer.NestingBeanItem;

import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;

import de.goldmann.portfolio.Utils;
import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.AccountBookingId;

@SuppressWarnings("serial")
public class AmountColumnGenerator implements ColumnGenerator {

    @Override
    public Object generateCell(final Table source, final Object itemId, final Object columnId) {

        final NestingBeanItem<AccountBooking> bean = (NestingBeanItem<AccountBooking>) source.getContainerDataSource()
                .getItem(itemId);
        final AccountBooking accountBooking = bean.getBean();
        final AccountBookingId accountBookingId = accountBooking.getId();

        if (accountBooking.isNecessaryForCalculation()) {
            // System.out.println(description + " " +
            // accountBookingId.getAmount().doubleValue());
            //
            // System.out
            // .println(String.valueOf(Utils.round(tmpQuantity +
            // accountBookingId.getAmount().doubleValue(), 2)));
            // System.out.println("########");
            final double tmpQuantity = valueOfAmountColumn(source);
            source.setColumnFooter(AccountBookingTable.AMOUNT_COLUMN_NAME,
                                   String.valueOf(Utils.round(tmpQuantity + accountBookingId.getAmount().doubleValue(),
                                                              2)));
        }

        return accountBookingId.getAmount();
    }

    private double valueOfAmountColumn(final Table source) {
        final String quantityValue = source.getColumnFooter(AccountBookingTable.AMOUNT_COLUMN_NAME);
        double tmpQuantity = 0;
        if (quantityValue != null) {
            tmpQuantity = Double.parseDouble(quantityValue);
        }
        return tmpQuantity;
    }

}
