package com.mc.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.mc.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
