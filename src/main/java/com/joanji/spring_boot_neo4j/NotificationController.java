package com.joanji.spring_boot_neo4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @RequestMapping(value = "/receiveSigning", method = RequestMethod.POST)
    public void receiveSinging(){

    }
}
