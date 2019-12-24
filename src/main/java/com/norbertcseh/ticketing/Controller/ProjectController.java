package com.norbertcseh.ticketing.Controller;

import java.util.ArrayList;

import com.norbertcseh.ticketing.Entities.Project;
import com.norbertcseh.ticketing.Service.ProjectService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectController
 */
@RestController
@CrossOrigin
public class ProjectController {

    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/api/project/all")
    public ArrayList<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("api/project/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PostMapping("/api/project/createNewProject")
    public void createNewProject(@RequestBody Project project) {
        projectService.createNewProject(project);
    }

}