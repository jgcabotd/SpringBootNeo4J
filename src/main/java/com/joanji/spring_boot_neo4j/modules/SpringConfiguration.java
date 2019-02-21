package com.joanji.spring_boot_neo4j.modules;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories("com.joanji.spring_boot_neo4j.repository")
@EntityScan(basePackages = "com.joanji.spring_boot_neo4j.nodes")
public class SpringConfiguration {}
