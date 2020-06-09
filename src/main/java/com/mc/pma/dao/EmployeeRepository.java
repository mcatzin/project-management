package com.mc.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.mc.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{

}
