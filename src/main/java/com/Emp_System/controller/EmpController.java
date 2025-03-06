package com.Emp_System.controller;

import com.Emp_System.entity.Employee;
import com.Emp_System.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //This annotation allows the class to handle HTTP requests.Return views or data to client.
public class EmpController {
    @Autowired
    //this annotation is used for automatic dependency injection,this annotation automatically inject a required bean.

    private EmpService empService; //we create a private object from EmpService class.
    // Inject an instance of EmpService into this class also EmpService can be easily accessed.

    @GetMapping("/") //This annotation is used to map HTTP GET requests.This annotation is part of controller.
    public String home(Model model) {                     // home page method.Model object to pass data to the view.
        List<Employee> empList = empService.getAllEmp();  //Calls getAllEmp()from the EmpService class to retrieve a list of all Employee objects, which is stored in empList object.
        model.addAttribute("emp", empList);  //emp is attribute name,emplist is a object added in model.
        return "index";                                  //this return index called from html file.
    }

    @GetMapping("/addEmp") //get from /addEmp Method
    public String addEmpForm() {
        return "add_emp"; //this return add_emp.this name is also same as html file name.this html file,we called it from html add_emp url.
    }

    @PostMapping("/register") //HTTP POST requests to register a new employee.
    public String empRegister(@ModelAttribute Employee e, HttpSession session) {
        System.out.println(e);
        empService.addEmp(e);
        session.setAttribute("Message", "emp added successfully"); //Allows access to the HTTP session to store attributes,
                                                                     // often used for passing messages or other data between requests.
        return "redirect:/";     //back to the home page after successful registration.
    }

    @GetMapping("/edit/{id}") //GET requests with the URL pattern /edit/{id} and {id} is a path variable representing the ID of the employee to be edited.
    public String editForm(@PathVariable("id") int id, Model model) {//("id") is from url id.model-Used to pass data to the view.
        Employee emp = empService.getEmpById(id); //call get emp by id is specific employee edited by id.
        model.addAttribute("emp", emp); //its makes empoyee data edit view
        return "edit"; //this edit is view html edit file.
    }

    @GetMapping("/delete/{id}")//delete url
    public String deleteEmp(@PathVariable("id") int id, HttpSession session) {
        empService.deleteEmpById(id); // deleted by id from empservice
        session.setAttribute("Message", "emp deleted successfully"); // same as previous
        return "redirect:/";
    }

    @PostMapping("/update") //update method
    public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
        empService.addEmp(e);
        session.setAttribute("Message", "emp updated successfully");
        return "redirect:/";
    }

}
