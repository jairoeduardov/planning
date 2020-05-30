package com.loroko.planning.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loroko.planning.model.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
