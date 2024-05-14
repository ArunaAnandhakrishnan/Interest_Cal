package com.vernite.cal.repository;

import com.vernite.cal.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People,Long> {

    People findByCustIdNumber(String cusId);
}
