package com.joanji.spring_boot_neo4j;

import com.joanji.spring_boot_neo4j.nodes.Notification;
import com.joanji.spring_boot_neo4j.nodes.Teacher;
import com.joanji.spring_boot_neo4j.repositories.NotificationRepository;
import com.joanji.spring_boot_neo4j.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
public class NotificationController {

    private TeacherRepository teacherRepository;
    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationController(TeacherRepository teacherRepository, NotificationRepository notificationRepository) {
        this.teacherRepository = teacherRepository;
        this.notificationRepository = notificationRepository;
    }

    @RequestMapping("/getTeacher")
    public Teacher getTeacher(){

        teacherRepository.deleteAll();
        notificationRepository.deleteAll();

        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        Notification notification1 = new Notification();
        notification1.setDate(date.format(dtfDate));
        notification1.setTime(time.format(dtfTime));
        notification1.setItWasSent(false);

        Notification notification2 = new Notification();
        notification2.setDate(date.format(dtfDate));
        notification2.setTime(time.format(dtfTime));
        notification2.setItWasSent(true);

        Teacher teacher = new Teacher();
        teacher.setDNI("45646969P");
        teacher.setMail("jgcabotd@gmail.com");
        teacher.setName("Joan Guillem");
        teacher.setSurname("Cabot Dols");
        teacher.setPhoneNum("86598948");

        teacher.receiveNotifications(notification1);

        teacherRepository.save(teacher);

        teacher = teacherRepository.findByName("Joan Guillem");

        teacher.receiveNotifications(notification2);

        //The method save() also update nodes and create nodes.
        teacherRepository.save(teacher);

        return teacher;
    }
}
