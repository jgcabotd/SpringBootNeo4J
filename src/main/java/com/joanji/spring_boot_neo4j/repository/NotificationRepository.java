package com.joanji.spring_boot_neo4j.repository;

import com.joanji.spring_boot_neo4j.nodes.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

}
