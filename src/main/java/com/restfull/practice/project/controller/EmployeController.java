package com.restfull.practice.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.restfull.practice.project.model.Employe;
import com.restfull.practice.project.service.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeController {

	@Autowired
	private EmployeService employeService;
	
	@PostMapping("/saveEmploye")
	public ResponseEntity<Employe> saveEmploye(@RequestBody Employe employe){
		return new ResponseEntity<Employe>(employeService.saveEmploye(employe), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getEmployes")
	public List<Employe> getAllEmployes(){
		return  employeService.getAllEmployes();
		
	}
	
	@GetMapping("/getEmploye/{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable int id){
		return new ResponseEntity<Employe>(employeService.getEmployeById(id),HttpStatus.FOUND);
		
	}
	
	@PutMapping("/updateEmploye/{id}")
	public ResponseEntity<Employe> updateEmployeDetails(@PathVariable int id,@RequestBody Employe employe){
		return new ResponseEntity<Employe>(employeService.updateEmployeById(id, employe), HttpStatus.OK);
				
	}
	
	@DeleteMapping("/deleteEmploye/{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable int id){
		employeService.deleteEmployeById(id);
		return new ResponseEntity<String>("Employe deleted successfully",HttpStatus.OK);
		
	}
	
	@PostMapping("/saveEmployees")
	public List<Employe> saveMultipleEmployees(@RequestBody List<Employe> employees){
		return employeService.saveMultipleEmployees(employees);
		
	}
	
	@GetMapping("/getHishestSalaryEmploye")
	public Employe getTopSalaryEmploye(@Param("salary") double salary) {
		return employeService.getTopSalaryEmploye(salary);
		
	}
}
