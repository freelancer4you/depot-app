package de.goldmann.portfolio.domain.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.goldmann.portfolio.domain.MonitorEvent;

public interface MonitorEventRepository extends JpaRepository<MonitorEvent, Long> {

    @Query("FROM MonitorEvent p WHERE  p.stock.isin = :isin ")
    Set<MonitorEvent> findByStockIsin(@Param("isin") String isin);

    @Query("select u.stock.searchKey from MonitorEvent u")
    Set<String> loadSearchKeys();
}
