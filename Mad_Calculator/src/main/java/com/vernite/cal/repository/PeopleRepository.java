package com.vernite.cal.repository;

import java.util.List;

import com.vernite.cal.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    @Query(value = "SELECT * FROM PEOPLE WHERE CUSTIDNUMBER =:cusId", nativeQuery = true)
    People findValue(@Param("cusId") String cusId);

}
