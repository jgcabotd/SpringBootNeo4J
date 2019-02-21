package com.joanji.spring_boot_neo4j.repositories;

import com.joanji.spring_boot_neo4j.nodes.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    Teacher findByName(String name);
}
