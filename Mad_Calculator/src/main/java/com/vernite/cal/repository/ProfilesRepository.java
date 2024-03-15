package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Profiles;

import java.util.Optional;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {

	public Profiles findBySerno(Long serno);

	public Profiles findByDescription(String description);

	Optional<Profiles> findByStmtserno();
}
