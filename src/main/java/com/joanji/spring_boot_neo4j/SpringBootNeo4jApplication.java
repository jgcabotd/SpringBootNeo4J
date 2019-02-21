package com.joanji.spring_boot_neo4j;

import com.joanji.spring_boot_neo4j.nodes.Notification;
import com.joanji.spring_boot_neo4j.nodes.Teacher;
import com.joanji.spring_boot_neo4j.repository.NotificationRepository;
import com.joanji.spring_boot_neo4j.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
            notificationRepository.deleteAll();

            DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");

            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            Notification notification = new Notification();
            notification.setDate(date.format(dtfDate));
            notification.setTime(time.format(dtfTime));
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

            Notification notification1 = new Notification();
            notification1.setDate(date.format(dtfDate));
            notification1.setTime(time.format(dtfTime));
            notification1.setItWasSent(false);

            teacher.receiveNotifications(notification1);

            teacherRepository.save(teacher);

            Iterable<Notification> notifications = notificationRepository.findAll();

            System.out.println(teacher);

            for (Notification notify : notifications){
                System.out.println("Notificacion:");
                System.out.println(notify.toString());
            }
        };
    }

}
