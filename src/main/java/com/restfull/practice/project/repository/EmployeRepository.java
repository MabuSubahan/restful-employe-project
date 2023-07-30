package com.restfull.practice.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restfull.practice.project.model.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer>{


	//@Query("select max(salary) as benefit from Employees" )
//
//	@Query("SELECT MAX(SALARY) FROM employe")
//	public Employe getTopSalaryEmploye(String salary);

}
