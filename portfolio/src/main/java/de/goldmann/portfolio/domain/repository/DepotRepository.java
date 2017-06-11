package de.goldmann.portfolio.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import de.goldmann.portfolio.domain.Depot;

public interface DepotRepository extends JpaRepository<Depot, Long> {

    Optional<Depot> findByName(String depotName);

    @Query("from Depot as d right join d.user where d.name = :name")
    Depot findByNameWithUser(@Param("name") String depotName);

}
