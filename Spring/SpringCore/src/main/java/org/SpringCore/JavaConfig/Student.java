package org.SpringCore.JavaConfig;

import org.springframework.stereotype.Component;

@Component("firstStudent")
public class Student {
    private Samosa samosa;

    public Student(Samosa samosa) {
        samosa.getSamosa();
        this.samosa = samosa;
    }

    public Samosa getSamosa() {
        return samosa;
    }

    public void setSamosa(Samosa samosa) {
        this.samosa = samosa;
    }

    public void isStudying(){
        System.out.println("Student is studying ");
    }
}
