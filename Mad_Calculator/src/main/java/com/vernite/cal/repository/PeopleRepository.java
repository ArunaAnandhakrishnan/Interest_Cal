package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.People;

public interface PeopleRepository extends JpaRepository<People, Long>{

}
