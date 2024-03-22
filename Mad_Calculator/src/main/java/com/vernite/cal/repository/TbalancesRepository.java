package com.vernite.cal.repository;

import com.vernite.cal.model.Cstatements;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Tbalances;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TbalancesRepository extends JpaRepository<Tbalances, Long> {
    @Query(value = "select * from tbalances where stmtserno  = :serno and outstandingamount < 0 and caccserno = :cserno",nativeQuery = true)
    Optional<List<Tbalances>> getTbalanceData(@Param("serno")Long serno, @Param("cserno") Long cserno);

   List<Tbalances> findByNextbalanceserno(Long serno);
    @Query(value = "select * from tbalances where stmtserno  = :serno and outstandingamount < 0 and caccserno = :cserno",nativeQuery = true)
    Optional<List<Tbalances>> getTbalance(@Param("serno")Long serno, @Param("cserno") Long cserno);

}
