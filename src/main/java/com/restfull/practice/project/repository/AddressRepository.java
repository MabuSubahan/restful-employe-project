package com.restfull.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restfull.practice.project.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
