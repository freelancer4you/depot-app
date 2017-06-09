package de.goldmann.portfolio.config;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import de.goldmann.portfolio.PortfolioConstants;
import de.goldmann.portfolio.csv.CsvReader;
import de.goldmann.portfolio.csv.StockMapper;
import de.goldmann.portfolio.csv.StockWithinCsv;
import de.goldmann.portfolio.domain.repository.MonitorEventRepository;
import de.goldmann.portfolio.monitoring.StockMonitor;
import de.goldmann.portfolio.services.MailService;
import de.goldmann.portfolio.services.YahooFinanceService;

@Configuration
@EnableAsync
@EnableScheduling
public class AppConfig {

    private static final String STOCK_DATA_CSV = "Portfolio.csv";
    // final String[] NAMES = new String[] {
    // "Konto",
    // "Produkt",
    // "ISIN",
    // "Börse",
    // "Anzahl",
    // "Währung",
    // "Kurs",
    // "Zinsen",
    // "Gesamtwert",
    // "Wechselkurs",
    // "Gesamtwert (EUR)" };
//    final String[] NAMES = new String[] {
//                    "Produkt",
//                    "Isin",
//                    "Anzahl",
//                    "Schlußkurs",
//                    "Wert",
//                    "",
//    "Wert in EUR" };
    final String[] NAMES = new String[] {
                    "Produkt",
                    "Isin",
                    "Anzahl"};

    @Bean
    StockMapper stockMapper() {
        return new StockMapper();
    }

    @Bean
    FieldSetMapper<StockWithinCsv> fieldSetMapper() {
        final BeanWrapperFieldSetMapper<StockWithinCsv> studentInformationMapper = new BeanWrapperFieldSetMapper<>();
        studentInformationMapper.setTargetType(StockWithinCsv.class);
        return studentInformationMapper;
    }

    @Bean
    public FlatFileItemReader<StockWithinCsv> reader(final FieldSetMapper<StockWithinCsv> fieldSetMapper) {
        final FlatFileItemReader<StockWithinCsv> reader = new FlatFileItemReader<StockWithinCsv>();
        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource(STOCK_DATA_CSV));
        final DefaultLineMapper<StockWithinCsv> defaultLineMapper = new DefaultLineMapper<>();
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        final DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(PortfolioConstants.CSV_SEPERATOR);
        tokenizer.setNames(NAMES);
        defaultLineMapper.setLineTokenizer(tokenizer);
        reader.setLineMapper(defaultLineMapper);
        return reader;
    }

    @Bean
    CsvReader csvReader(final FlatFileItemReader<StockWithinCsv> reader) {
        return new CsvReader(reader);
    }

    @Bean
    StockMonitor stockMonitor(
            final MonitorEventRepository monitorEventRepository,
            final YahooFinanceService yahooFinanceService,
            final MailService mailService) {
        return new StockMonitor(monitorEventRepository, yahooFinanceService, mailService);
    }

}
