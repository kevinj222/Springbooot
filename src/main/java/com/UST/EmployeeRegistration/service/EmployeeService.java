package com.UST.EmployeeRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.UST.EmployeeRegistration.model.Employee;
import com.UST.EmployeeRegistration.repository.EmployeeRepo;

@Service
public class EmployeeService 

{ 
	@Autowired
	private EmployeeRepo repo;

	public Employee createEmployee(Employee employee)
	{
		return repo.save(employee);
	}




	public Employee getEmployeeById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Employee> getEmployee()
	{
		return repo.findAll();
	}

	public Employee updateEmployee(Employee employee) 
	{
		Employee oldemp=null;
		Optional<Employee>optionalemployee=repo.findById(employee.getId());
		if(optionalemployee.isPresent())
		{
			oldemp=optionalemployee.get();
			oldemp.setEmpname(employee.getEmpname());
			oldemp.setAddress(employee.getAddress());
			repo.save(oldemp);
		}
		else
		{
			return new Employee();
		}
		return oldemp;
		}

	public String deleteEmployeeById(int id) 
	{
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return"The employee info is deleted";
	}
	}
 


