package de.goldmann.portfolio.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.goldmann.portfolio.domain.StockType;
import de.goldmann.portfolio.domain.StockWithinDepot;

public interface StockWithinDepotRepository extends JpaRepository<StockWithinDepot, Long> {

    @Query("FROM StockWithinDepot p WHERE  p.stockData.isin = :isin ")
    Optional<StockWithinDepot> findByStockIsin(@Param("isin") String isin);

    @Query("select u.stockData.isin from StockWithinDepot u")
    Set<String> loadIsins();

    @Query("select u.stockData.searchKey from StockWithinDepot u")
    Set<String> loadSearchKeys();

    @Query("select u from StockWithinDepot u where u.stockData.stockType = :stockType")
    Set<StockWithinDepot> findByStockType(@Param("stockType") StockType stockType);

    @Query("select new de.goldmann.portfolio.domain.repository.IndustryStatistics(v.stockData.industry, count(v))"
            + " from StockWithinDepot v "
            + " where v.anzahl > 0"
            + " and v.stockData.stockType = 'AKTIE' "
            + " group by v.stockData.industry")
    List<IndustryStatistics> findIndustryCount();
}
