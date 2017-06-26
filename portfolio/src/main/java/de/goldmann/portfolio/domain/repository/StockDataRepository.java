package de.goldmann.portfolio.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.goldmann.portfolio.domain.StockData;

public interface StockDataRepository extends JpaRepository<StockData, String> {
    Optional<StockData> findByName(@Param("name") String name);

    Optional<StockData> findBySearchKey(@Param("key") String key);

    Optional<StockData> findByIsin(@Param("isin") String isin);

    @Query("from StockData c where c.isin like %:isin%")
    List<StockData> finByIsin(@Param("isin") String filterString);

}
