package com.myproject.company.controller;

import com.myproject.company.entity.WorkOn;
import com.myproject.company.entity.WorkOnId;
import com.myproject.company.repository.EmployeeRepository;
import com.myproject.company.repository.ProjectRepository;
import com.myproject.company.repository.WorkOnDataRepository;
import com.myproject.company.repository.WorkOnRepository;
import com.myproject.company.services.WorkOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/workon")
public class WorkOnController {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private WorkOnDataRepository workOnDataRepository;
    @Autowired
    private WorkOnRepository workOnRepository;
    @Autowired
    private WorkOnService workOnService;


    @GetMapping
    public String showWorkOnPage(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("workOnList", workOnDataRepository.findAll());
        //
        return "frmWorkOn";
    }

    @PostMapping("/add")
    public String saveWorkOn(@RequestParam(value = "empNo", required = false) Integer emp,
                             @RequestParam(value = "projectNo", required = false) Integer project)
    {
        if(emp!=null && project !=null)
        {
            WorkOn w=new WorkOn(emp,project);
            workOnService.saveWorkOn(w);
        }

        return "redirect:/workon";
    }

    @PostMapping("/delete")
    public String deleteWorkOn(@RequestParam(value = "empNo", required = false) Integer emp,
                               @RequestParam(value = "projectNo", required = false) Integer project)
    {
        if(emp!=null && project !=null)
        {
            WorkOnId id=new WorkOnId(emp,project);
            workOnService.deleteWorkOn(id);
        }

            return "redirect:/workon";
    }

   /* @GetMapping("/find")
    public String findWorkOn(@RequestParam(value = "empNo", required = false) Integer emp,
                             @RequestParam(value = "projectNo", required = false) Integer project,
                             Model model)

    {
        if(emp!=null && project !=null)
        {
            WorkOnId id=new WorkOnId(emp,project);

            model.addAttribute("workOn",workOnRepository.findById(id));
        }
            return "frmWorkOn";
    }*/
    @GetMapping("/search")
    public String searchWorkOn(@RequestParam(value = "searchBy",required = false) String searchBy,
                               @RequestParam(value = "keyword",required = false) String keyword,
                               Model model)
    {
        model.addAttribute("workOnList",workOnService.searchWorkOn(searchBy,keyword));
        return "frmWorkOn";
    }





}
