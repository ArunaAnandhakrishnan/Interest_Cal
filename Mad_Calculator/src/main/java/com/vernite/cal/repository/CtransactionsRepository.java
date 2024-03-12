package com.vernite.cal.repository;

import com.vernite.cal.model.Caccounts;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Ctransactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CtransactionsRepository extends JpaRepository<Ctransactions, Long> {
    Optional<Ctransactions> findByCaccounts(Caccounts caccounts);

    @Query(value = "select ct.* from ctransactions ct join caccounts c on c.serno = ct.caccserno where c.serno = :serno", nativeQuery = true)
    Optional<Ctransactions>  findByCaccount(@Param("serno") Long serno);
}
