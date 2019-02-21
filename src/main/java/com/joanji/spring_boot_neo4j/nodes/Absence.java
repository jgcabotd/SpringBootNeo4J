package com.joanji.spring_boot_neo4j.nodes;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.Date;

/**
 * Created by tanin on 20/02/2019.
 */
@NodeEntity
public class Absence {
    @Id @GeneratedValue private Long id;
    private Date date;
    private String subject;

    private Absence(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "absence{" +
                "id=" + id +
                ", date=" + date +
                ", subject='" + subject + '\'' +
                '}';
    }
}
