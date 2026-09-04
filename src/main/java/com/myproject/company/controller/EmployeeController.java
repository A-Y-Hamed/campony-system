package com.myproject.company.controller;

import com.myproject.company.entity.Department;
import com.myproject.company.entity.Employee;
import com.myproject.company.entity.EmployeePhone;
import com.myproject.company.entity.EmployeePhoneId;
import com.myproject.company.repository.DepartmentDataRepository;
import com.myproject.company.repository.DepartmentRepository;
import com.myproject.company.repository.EmployeeDataRepository;
import com.myproject.company.repository.EmployeePhoneRepository;
import com.myproject.company.services.EmployeePhoneService;
import com.myproject.company.services.EmployeeService;
import com.sun.jdi.IntegerValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeDataRepository employeeData;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentDataRepository deptData;
    @Autowired
    private EmployeePhoneRepository employeePhoneRepository;
    @Autowired
    private EmployeePhoneService employeePhoneService;

    @GetMapping
    public String showEmployeeForm(Model model)
    {
        model.addAttribute("employees",employeeData.findAll());
        model.addAttribute("departments",departmentRepository.findAll());
        model.addAttribute("phones",employeePhoneRepository.findAll());
        return "frmEmp";
    }

    @PostMapping("/phones/add")
    public String addPhone(@RequestParam(value = "id", required = false) Integer id,
                           @RequestParam(value = "phone", required = false) String phone) {


        if (id != null && employeeData.existsById(id) && phone != null && !phone.trim().isEmpty()) {
            EmployeePhone p = new EmployeePhone(id, phone);
            employeePhoneService.savePhone(p);
        }

        return "redirect:/employee";
    }

    @PostMapping("/phones/remove")
    public String deletePhone(@RequestParam(value = "id", required = false) Integer id,
                              @RequestParam(value = "phone", required = false) String phone)
    {
        if (id != null && employeeData.existsById(id) && phone != null && !phone.trim().isEmpty()) {
            EmployeePhoneId p = new EmployeePhoneId(id, phone);
            employeePhoneService.deletePhone(p);
        }
        return "redirect:/employee";
    }
    @PostMapping("/save")
    public String addEmployee(@RequestParam (value = "id" , required = false,defaultValue = "null") Integer id,
                            @RequestParam( value ="name" ,required =false) String name,
                            @RequestParam( value = "address", required = false) String address,
                            @RequestParam( value = "salary" ,required = false) Double salary,
                            @RequestParam(value = "hiringDate",required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hiringdate,
                            @RequestParam( value = "birthDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                            @RequestParam( value = "department.id",required = false) Long department_id)
    {
        Department dept = null;
        if(department_id != null)
        {
            dept=departmentRepository.findById(department_id).orElse(null);
            Employee emp =new Employee(null,name,address,salary,hiringdate,birthdate,dept);
            employeeService.saveEmployee(emp);
        }
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String updateEmployee(@RequestParam (value = "id" , required = false) Integer id,
                                 @RequestParam( value ="name" ,required =false) String name,
                                 @RequestParam( value = "address", required = false) String address,
                                 @RequestParam( value = "salary" ,required = false) Double salary,
                                 @RequestParam(value = "hiringDate",required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate hiringdate,
                                 @RequestParam( value = "birthDate",required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate,
                                 @RequestParam( value = "department.id",required = false) Long department_id)
    {

        Department dept = null;
        if(department_id != null)
        {
            dept=departmentRepository.findById(department_id).orElse(null);
            Employee emp =new Employee(id,name,address,salary,hiringdate,birthdate,dept);
            employeeService.saveEmployee(emp);
        }
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String deleteEmployee(Integer id)
    {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam (value = "id",required = false) Integer id,Model model)
    {
        if(id != null)
        {
           Employee emp= employeeService.getEmployeeById(id);
            model.addAttribute("emp",emp);
            model.addAttribute("phones",employeePhoneRepository.findById(id));
        }

            model.addAttribute("employees",employeeData.findAll());
            model.addAttribute("departments", departmentRepository.findAll());

        return "frmEmp";
    }
    @GetMapping("/search")
    public String searchEmployee(@RequestParam(value = "searchBy", defaultValue = "number") String searchBy,
                                 @RequestParam( value = "searchValue",defaultValue = "") String keyword,
                                 Model model)
    {
        model.addAttribute("employees",employeeService.searchEmployee(searchBy,keyword));
        return "frmEmp";
    }



}
