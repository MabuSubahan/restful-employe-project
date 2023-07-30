package com.restfull.practice.project.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.comparator.Comparators;

import com.restfull.practice.project.exception.ResourceNotFoundException;
import com.restfull.practice.project.model.Employe;
import com.restfull.practice.project.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements EmployeService{

	@Autowired
	private EmployeRepository employeRepo;
	@Override
	public Employe saveEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return employeRepo.save(employe);
	}
	@Override
	public List<Employe> getAllEmployes() {
		// TODO Auto-generated method stub
		return employeRepo.findAll();
	}
	@Override
	public Employe getEmployeById(int id) {
		// TODO Auto-generated method stub
		return employeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employe","id",id));
	}
	@Override
	public Employe updateEmployeById(int id, Employe employe) {
		// TODO Auto-generated method stub
		Employe existingEmploye= employeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employe", "id", id));
		existingEmploye.setName(employe.getName());
		existingEmploye.setEmail(employe.getEmail());
		existingEmploye.setAge(employe.getAge());
		existingEmploye.setCompanyName(employe.getCompanyName());
		existingEmploye.setSalary(employe.getSalary());
		existingEmploye.setPassword(employe.getPassword());
		
		employeRepo.save(existingEmploye);
		return existingEmploye; 
	}
	@Override
	
	public void deleteEmployeById(int id) {
		employeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employe", "id", id));
		employeRepo.deleteById(id);
	}
	@Override
	public List<Employe> saveMultipleEmployees(List<Employe> employees) {
		
		return employeRepo.saveAll(employees);
	}
	@Override
	public Employe getTopSalaryEmploye(double salary) {
		// TODO Auto-generated method stub
	List<Employe>	employes= employeRepo.findAll();
	//Employe emp=employes.stream().sorted((e1,e2) -> (int) e2.getSalary()-(int)e1.getSalary()).findFirst().get();

	Optional<Employe> salary1=Optional.ofNullable(employes.stream().sorted((e1,e2) -> (int) e2.getSalary()-(int)e1.getSalary()).findFirst().get());
	
	return salary1.get();
	}
	

}
