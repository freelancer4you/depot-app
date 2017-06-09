package de.goldmann.portfolio.domain.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.goldmann.portfolio.domain.HumanUser;

public interface HumanUserRepository extends JpaRepository<HumanUser, Serializable> {

    Optional<HumanUser> findByEmail(String email);
}
