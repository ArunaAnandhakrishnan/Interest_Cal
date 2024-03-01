package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Profiles;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {

	public Profiles findBySerno(Long serno);

	public Profiles findByDescription(String description);

}
