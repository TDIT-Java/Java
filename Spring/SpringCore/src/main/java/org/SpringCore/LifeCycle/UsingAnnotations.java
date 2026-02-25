package org.SpringCore.LifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class UsingAnnotations {
    private String subject;

    UsingAnnotations() {}

    public UsingAnnotations(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        System.out.println("getting subject");
        return subject;
    }

    public void setSubject(String subject) {
        System.out.println("setting subject");
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "UsingAnnotations{" +
                "subject='" + subject + '\'' +
                '}';
    }

    @PostConstruct
    public void start(){
        System.out.println("Initializing annotation bean");
    }

    @PreDestroy
    public void end(){
        System.out.println("Ending annotation bean");
    }
}
