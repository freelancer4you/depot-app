package de.goldmann.portfolio.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.goldmann.portfolio.domain.Depot;

public interface DepotRepository extends JpaRepository<Depot, Long> {

    Optional<Depot> findByName(String depotName);

}
