package com.joanji.spring_boot_neo4j;

import com.joanji.spring_boot_neo4j.nodes.Notification;
import com.joanji.spring_boot_neo4j.nodes.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class NotificationController {
    @RequestMapping("/getSigning")
    public void receiveSinging(){
        /*teacherRepository.deleteAll();
        notificationRepository.deleteAll();

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

        teacher.receiveNotifications(notification);

        teacherRepository.save(teacher);

        Iterable<Notification> notifications = notificationRepository.findAll();

        System.out.println(teacher);

        for (Notification notify : notifications){
            System.out.println("Notificacion:");
            System.out.println(notify.toString());
        }*/
    }
}
