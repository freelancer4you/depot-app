package de.goldmann.portfolio.domain.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.goldmann.portfolio.domain.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

    @Query("FROM OrderHistory p WHERE  p.stock.isin = :isin ")
    Set<OrderHistory> findByStockIsin(@Param("isin") String isin);

}
