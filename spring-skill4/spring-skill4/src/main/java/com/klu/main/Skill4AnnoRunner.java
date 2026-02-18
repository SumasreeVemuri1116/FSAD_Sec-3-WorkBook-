package com.klu.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.klu.config.JavaConfig;
import com.klu.model.Student;

//@Component
public class Skill4AnnoRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        var ctx =
                new AnnotationConfigApplicationContext(JavaConfig.class);

        Student s = ctx.getBean("javaStudent", Student.class);


        System.out.println("=== SKILL-4 ANNOTATION ===");
        s.display();
    }
}
