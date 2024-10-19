package com.lease_master.repository;

import com.lease_master.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
