package com.restfull.practice.project.service;

import java.util.List;

import com.restfull.practice.project.model.Employe;

public interface EmployeService {

	
	public Employe saveEmploye(Employe employe);
	public List<Employe> getAllEmployes();
	public Employe getEmployeById(int id);
	public Employe updateEmployeById(int id,Employe employe);
	public void deleteEmployeById(int id);
	public List<Employe> saveMultipleEmployees(List<Employe> employees);
	public Employe getTopSalaryEmploye(double salary);

	
}
