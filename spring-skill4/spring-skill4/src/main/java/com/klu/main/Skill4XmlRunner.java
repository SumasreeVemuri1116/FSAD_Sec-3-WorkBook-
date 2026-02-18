package com.klu.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.klu.config.XmlImportConfig;
import com.klu.model.Student;

@Component
public class Skill4XmlRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(XmlImportConfig.class);

        Student s = ctx.getBean("xmlStudent", Student.class);


        System.out.println("=== SKILL-4 XML ===");
        s.display();
    }
}
