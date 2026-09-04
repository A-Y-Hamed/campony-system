package com.myproject.company.service_impl;

import com.myproject.company.entity.Project;
import com.myproject.company.entity.ProjectData;
import com.myproject.company.repository.ProjectDataRepository;
import com.myproject.company.repository.ProjectRepository;
import com.myproject.company.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectDataRepository projectDataRepository;

    @Override
    public List<ProjectData> getAllProjects() {
        return projectDataRepository.findAll();
    }

    @Override
    public void addProject(Project project) {
        if(project != null)
        {
            projectRepository.save(project);
        }

    }

    @Override
    public void updateProject(Project project) {
        if(project != null)
        {
            projectRepository.save(project);
        }

    }

    @Override
    public void deleteProject(Integer id) {
        if(id != null)
        {
            projectRepository.deleteById(id);
        }

    }

    @Override
    public Project findProject(Integer id) {
            return projectRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProjectData> searchProject(String searchBy, String keyword) {
        if(keyword ==null || keyword.trim().isEmpty())
        {
            return getAllProjects();
        }

        switch (searchBy)
        {
            case "ProjectNo":
            {
                Integer id=Integer.parseInt(keyword.trim());
                return projectDataRepository.findByNumber(id);
            }
            case "name":return projectDataRepository.findByNameContainingIgnoreCase(keyword.trim());
            case "location":return projectDataRepository.findByLocationContainingIgnoreCase(keyword.trim());
            case "department": return projectDataRepository.findByDepartmentContainingIgnoreCase(keyword.trim());
            default:getAllProjects();
        }
        return List.of();
    }
}
