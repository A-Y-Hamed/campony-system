package com.myproject.company.controller;

import com.myproject.company.entity.Department;
import com.myproject.company.entity.Project;
import com.myproject.company.repository.DepartmentRepository;
import com.myproject.company.repository.ProjectDataRepository;
import com.myproject.company.repository.ProjectRepository;
import com.myproject.company.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectDataRepository projectDataRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository projectRepository;


    @GetMapping
    public String showPageProject(Model model)
    {
        model.addAttribute("projects",projectDataRepository.findAll());
        model.addAttribute("departments",departmentRepository.findAll());
        return "frmProj";
    }

    @PostMapping("/save")
    public String addProject(@RequestParam( value = "projectNo",required = false) Integer id,
                           @RequestParam(value = "projectName",required = false) String name,
                           @RequestParam(value = "location",required = false) String location,
                           @RequestParam(value = "deptNo",required = false)Long dept)
    {
        if(dept !=  null && id != null)
        {
            Department d= departmentRepository.findById(dept).orElse(null);
            Project p=new Project(null,name,location,d);
            projectService.addProject(p);

        }
        return "redirect:/project";
    }

    @PostMapping("/update")
    public String updateProject(@RequestParam( value = "projectNo",required = false) Integer id,
                                @RequestParam(value = "projectName",required = false) String name,
                                @RequestParam(value = "location",required = false) String location,
                                @RequestParam(value = "deptNo",required = false)Long dept)
    {
        if(dept !=  null && id != null)
        {
            Department d= departmentRepository.findById(dept).orElse(null);
            Project p=new Project(id,name,location,d);
            projectService.addProject(p);

        }
        return "redirect:/project";
    }

    @PostMapping("/delete")
    public String deleteProject(@RequestParam(value = "projectNo",required = false) Integer id)
    {
        projectService.deleteProject(id);
        return "redirect:/project";
    }

    @GetMapping("/find")
    public String findProject(@RequestParam(value = "projectNo",required = false) Integer id,Model model) {
        if (id != null)
        {
            model.addAttribute("project",projectRepository.findById(id).orElse(null));
        }
        model.addAttribute("projects",projectService.getAllProjects());
        model.addAttribute("departments",departmentRepository.findAll());

        return "frmProj";
    }

    @GetMapping("/search")
    public String searchProject(@RequestParam(value = "searchBy",required = false) String searchBy,
                                @RequestParam(value = "keyword",required = false) String keyword,
                                Model model)
    {
        model.addAttribute("projects",projectService.searchProject(searchBy,keyword));
        return "frmProj";
    }
}
