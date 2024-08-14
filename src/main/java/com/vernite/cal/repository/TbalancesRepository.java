package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Tbalances;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TbalancesRepository extends JpaRepository<Tbalances, Long> {
    @Query(value = "select * from tbalances where stmtserno  = :serno and caccserno = :cserno",nativeQuery = true)
    Optional<List<Tbalances>> getTbalanceData(@Param("serno")Long serno, @Param("cserno") Long cserno);
    @Query(value = "select sum(tb.amount) from tbalances tb where tb.caccserno=:cserno and tb.stmtserno =:serno and tb.amount<0 and tb.trxnserno is not null",nativeQuery = true)
    Double getTotalDebit(@Param("serno")Long serno, @Param("cserno") Long cserno);
    @Query(value = "select sum(tb.amount) from tbalances tb where tb.caccserno=:cserno and tb.stmtserno =:serno and tb.amount>0 and tb.trxnserno is not null",nativeQuery = true)
    Double getTotalCredit(@Param("serno")Long serno, @Param("cserno") Long cserno);
    @Query(value = "select sum(tb.outstandingamount) from tbalances tb where tb.caccserno=:cserno and tb.stmtserno =:serno",nativeQuery = true)
    Double getTadAmount(@Param("serno")Long serno, @Param("cserno") Long cserno);
    @Query(value = "SELECT sum(tb.outstandingamount) FROM tbalances tb where tb.caccserno=:cserno and tb.stmtserno =:serno and tb.trxnserno is not null and tb.transactiontype not in (:listSerno)",nativeQuery = true)
    Double getTbalanceData(@Param("cserno") Long cserno,@Param("serno")Long serno,@Param("listSerno") List<Long> listSerno);
    @Query(value = "SELECT * FROM tbalances tb where tb.caccserno=:cserno and tb.stmtserno =:serno and tb.trxnserno is not null and tb.transactiontype not in (:listSerno)",nativeQuery = true)
    Optional<List<Tbalances>> getTbalanceDatas(@Param("cserno") Long cserno,@Param("serno")Long serno,@Param("listSerno") List<Long> listSerno);
    @Query(value = "SELECT tb.trxnserno FROM tbalances tb where tb.caccserno=:cserno and tb.trxnserno is not null and tb.transactiontype not in (:listSerno) order by tb.serno",nativeQuery = true)
    List<Long> getTrxnSerno(@Param("cserno") Long cserno, @Param("listSerno") List<Long> listSerno);

    @Query(value = "SELECT tb.trxnserno,tx.rectype,tb.amount,tb.outstandingamount,tb.minpaypercentage\n" +
            "FROM tbalances tb \n" +
            "LEFT JOIN ctransactions ct\n" +
            "ON tb.trxnserno=ct.serno\n" +
            "LEFT JOIN trxntypes tx\n" +
            "ON ct.typeserno_gledger=tx.serno\n" +
            "where tb.caccserno=:cserno \n" +
            "and tb.stmtserno =:serno\n" +
            "and tb.trxnserno is not null\n" +
            "order by tb.serno", nativeQuery = true)
    Optional<List<Object[]>> getTbalanceDatas(@Param("serno") Long serno, @Param("cserno") Long cserno);
   List<Tbalances> findByNextbalanceserno(Long serno);
    @Query(value = "select * from tbalances where stmtserno  = :serno and outstandingamount < 0 and caccserno = :cserno",nativeQuery = true)
    Optional<List<Tbalances>> getTbalance(@Param("serno")Long serno, @Param("cserno") Long cserno);

}
