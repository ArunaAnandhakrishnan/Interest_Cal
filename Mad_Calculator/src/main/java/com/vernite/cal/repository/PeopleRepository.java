package com.vernite.cal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vernite.cal.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

	People findByCustidnumber(String cusId);

}
