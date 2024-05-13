package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Caddresslinks;
import org.springframework.stereotype.Repository;

@Repository
public interface CaddresslinksRepository extends JpaRepository<Caddresslinks, Long> {

    Caddresslinks findByAddressserno(Long serno);
}
