package com.Emp_System.service;

import com.Emp_System.entity.Employee;
import com.Emp_System.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired     //this annotation is used for automatic dependency injection,this annotation automatically inject a required bean.

    private EmpRepo empRepo; //create empRepo object from EmpRepo class.we used autowired for dependency injection.

    public void addEmp(Employee e) {
        empRepo.save(e); //we know repository jpa auto generated save,delete,find etc.here we database repo te empoloyee object e save kore rakhchi,

    }
//    public List<Employee> getAllEmps() {
//        Employee emp1 = new Employee();
//        emp1.setId(1);
//        emp1.setName("Nipa");
//
//
//        Employee emp2 = new Employee();
//        emp2.setId(4);
//        emp2.setName("Nipal");
//
//
//        Employee emp3 = new Employee();
//        emp3.setId(7);
//        emp3.setName("Nipu");
//
//        List<Employee> employees = new ArrayList<Employee>();
//        employees.add(emp1);
//        employees.add(emp2);
//        employees.add(emp3);
//        return employees;
//
//    }

    public List<Employee> getAllEmp() { //list of employee r jonno controller a method create korchi setai db theke khjbo find all diye.

        return empRepo.findAll();
    }

    public Employee getEmpById(int id) { //employee id follow kore employee get korchi
        Optional<Employee> emp = empRepo.findById(id); // optional type jonno optional of employee thn emprepo theke id onujay khujbo
        if (emp.isPresent()) { //if contiodion ta  hochhe emp jodi present thake tahole get emp korbe otherwise null dibe.
            return emp.get();
        }
        return null;
    }

    public void deleteEmpById(int id) { //emp delete kortechi id diye,emprepo te giye id onushare dlt korbe thn controller methhod call hobe.
        empRepo.deleteById(id);

    }
}
