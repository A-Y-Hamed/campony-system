package com.myproject.company.controller;

import com.myproject.company.entity.Department;
import com.myproject.company.repository.DepartmentRepository;
import com.myproject.company.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentData;


    @GetMapping
    public String showDepartmentPage(Model model) {
        model.addAttribute("departments", departmentData.findAll());
        return "frmDept";
    }

    @PostMapping("/save")
    public String saveDepartment(@RequestParam(value = "deptNumber", required = false) Long id,
                                 @RequestParam(value = "deptName", required = false) String name,
                                 @RequestParam(value = "deptLocation", required = false) String location) {
        if (id != null) {
            Department dept = new Department(id, name, location);
            departmentService.saveDepartment(dept);
        }
        return "redirect:/department";
    }

    @PostMapping("/update")
    public String updateDepartment(@RequestParam(value = "deptNumber", required = false) Long id,
                                   @RequestParam(value = "deptName", required = false) String name,
                                   @RequestParam(value = "deptLocation", required = false) String location) {
        if (id != null) {
            Department dept = new Department(id, name, location);
            departmentService.updateDepartment(dept);
        }
        return "redirect:/department";
    }

    @PostMapping("/delete")
    public String deleteDepartment(@RequestParam(value = "deptNumber", required = false) Long id) {
        if (id != null) {
            departmentService.deleteDepartmentById(id);
        }
        return "redirect:/department";
    }

    @GetMapping("/find")
    public String findDepartment(@RequestParam(value = "deptNumber", required = false) Long id, Model model) {
        if (id != null) {
            Department dept = departmentService.getDepartmentById(id);
            model.addAttribute("dept", dept);
        }
        model.addAttribute("departments", departmentService.getAllDepartments());
        return "frmDept";
    }

    @GetMapping("/search")
    public String searchDepartment(@RequestParam(value = "searchBy", defaultValue = "number") String searchBy,
                                   @RequestParam(value = "keyword", defaultValue = "") String keyword,
                                   Model model) {
        model.addAttribute("departments", departmentService.searchDepartments(searchBy, keyword));
        return "frmDept";
    }
}