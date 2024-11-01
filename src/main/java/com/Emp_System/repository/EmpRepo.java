package com.Emp_System.repository;

import com.Emp_System.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
    //this class for database,we know jpa repository for create,save,find from database.
}
