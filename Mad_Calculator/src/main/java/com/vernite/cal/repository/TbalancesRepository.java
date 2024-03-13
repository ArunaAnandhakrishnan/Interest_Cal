package com.vernite.cal.repository;

import com.vernite.cal.model.Cstatements;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Tbalances;

import java.util.List;
import java.util.Optional;

public interface TbalancesRepository extends JpaRepository<Tbalances, Long> {
    Optional<List<Tbalances>> findByCstatements(Cstatements cstatements);
    Optional<Tbalances> findByTrxnserno(Long trxnserno);
}
