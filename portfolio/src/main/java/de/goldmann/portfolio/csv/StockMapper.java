package de.goldmann.portfolio.csv;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import de.goldmann.portfolio.domain.StockWithinDepot;

public class StockMapper implements FieldSetMapper<StockWithinDepot> {

    private static final String ANZAHL_FIELD  = "Anzahl";
    private static final String PRODUKT_FIELD = "Produkt";
    private static final String ISIN_FIELD    = "ISIN";

    @Override
    public StockWithinDepot mapFieldSet(final FieldSet fieldSet) throws BindException {
        final String isin = fieldSet.readString(ISIN_FIELD);

        // if (isin != null && isin.length() > 0) {
        // // final StockWithinDepot stock = new StockWithinDepot();
        // // stock.setProdukt(fieldSet.readString(PRODUKT_FIELD));
        // // stock.setIsin(isin);
        // try {
        // stock.setAnzahl(Integer.parseInt(fieldSet.readString(ANZAHL_FIELD)));
        // }
        // catch (final Exception e) {}
        // return stock;
        // }
        return null;
    }

}
