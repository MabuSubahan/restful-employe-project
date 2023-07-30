package com.restfull.practice.project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	private String name;
	private int age;
	private String email;
	private String password;
	private String companyName;
	private double salary;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn (name="fk_adr_id")
	private Address address;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="frk_emp_id", referencedColumnName = "emp_id")
//	private List<Address> address;
//	
	public Employe() {
		super();
	}
	
	
	public Employe(int empId, String name, int age, String email, String password, String companyName, double salary,
			Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.email = email;
		this.password = password;
		this.companyName = companyName;
		this.salary = salary;
		this.address = address;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Employe [empId=" + empId + ", name=" + name + ", age=" + age + ", email=" + email + ", password="
				+ password + ", companyName=" + companyName + ", salary=" + salary + ", address=" + address + "]";
	}




}
