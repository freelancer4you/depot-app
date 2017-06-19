package de.goldmann.portfolio.csv;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.beans.factory.annotation.Autowired;

public class CsvReader {

    @Autowired
    private final FlatFileItemReader<StockWithinCsv> reader;

    public CsvReader(
            final FlatFileItemReader<StockWithinCsv> reader) {
        this.reader = Objects.requireNonNull(reader, "reader");
    }

    public Set<StockWithinCsv> readPortfolioFile() throws UnexpectedInputException, ParseException, Exception {
        final Set<StockWithinCsv> stocks = new HashSet<>();
        StockWithinCsv stock = null;
        reader.open(new ExecutionContext());
        do {

            stock = reader.read();

            if (stock != null) {
                stocks.add(stock);
            }

        }
        while (stock != null);

        return stocks;
    }

}
