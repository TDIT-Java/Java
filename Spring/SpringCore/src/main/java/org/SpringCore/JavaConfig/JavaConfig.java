package org.SpringCore.JavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.SpringCore.JavaConfig")
public class JavaConfig {

    @Bean
    public Samosa getSamosa(){
        return new Samosa();
    }

    @Bean(name = {"stu1", "stu2", "stu3"}) // we can set multiple names to single bean
    public Student getStudent(){
        return new Student(getSamosa());
    }
}
