package de.goldmann.portfolio.domain.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.goldmann.portfolio.domain.AccountBooking;
import de.goldmann.portfolio.domain.AccountBookingId;

public interface AccountBookingRepository extends JpaRepository<AccountBooking, AccountBookingId> {

    @Query("FROM AccountBooking p WHERE  p.id.isin = :isin ")
    Set<AccountBooking> findByIdIsin(@Param("isin") String isin);

    int countByIdIsin(String isin);
}
