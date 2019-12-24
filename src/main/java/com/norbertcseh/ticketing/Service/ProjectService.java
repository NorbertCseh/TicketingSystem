package com.norbertcseh.ticketing.Service;

import java.util.ArrayList;

import com.norbertcseh.ticketing.Entities.Project;
import com.norbertcseh.ticketing.Repositories.ProjectRepository;

import org.springframework.stereotype.Service;

/**
 * ProjectService
 */
@Service
public class ProjectService {

    ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ArrayList<Project> getAllProjects() {
        return (ArrayList<Project>) projectRepository.findAll();
    }

    public Project getProjectById(Long id) {
        // TODO handle if there is no Project with this id
        return projectRepository.findById(id).get();
    }

    public void createNewProject(Project project) {
        projectRepository.save(project);
    }

}