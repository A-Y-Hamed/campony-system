package com.myproject.company.services;

import com.myproject.company.entity.Project;
import com.myproject.company.entity.ProjectData;

import java.util.List;

public interface ProjectService {
    List<ProjectData> getAllProjects();
    void addProject(Project project);
    void updateProject(Project project);
    void deleteProject(Integer id);
    Project findProject(Integer id);
    List<ProjectData> searchProject(String searchBy,String keyword);
}
