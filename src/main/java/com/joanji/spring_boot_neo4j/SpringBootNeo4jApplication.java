package com.joanji.spring_boot_neo4j;

import com.joanji.spring_boot_neo4j.nodes.Notification;
import com.joanji.spring_boot_neo4j.nodes.Teacher;
import com.joanji.spring_boot_neo4j.repository.NotificationRepository;
import com.joanji.spring_boot_neo4j.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootNeo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNeo4jApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(TeacherRepository teacherRepository, NotificationRepository notificationRepository) {
        return args -> {
            teacherRepository.deleteAll();
            Iterable<Notification> notifications = notificationRepository.findAll();

            Notification notification = new Notification();
            notification.setDate(new Date());
            notification.setItWasSent(false);

            Teacher teacher = new Teacher();
            teacher.setDNI("45646969P");
            teacher.setMail("jgcabotd@gmail.com");
            teacher.setName("Joan Guillem");
            teacher.setSurname("Cabot Dols");
            teacher.setPhoneNum("86598948");

            teacher.receiveNotifications(notification);

            teacherRepository.save(teacher);

            teacher = teacherRepository.findByName("Joan Guillem");

            System.out.println(teacher);
        };
    }

}
