package de.goldmann.portfolio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.goldmann.portfolio.domain.LeadingIndex;

public interface LeadingIndexRepository extends JpaRepository<LeadingIndex, Long> {

}
