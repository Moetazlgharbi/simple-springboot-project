package com.moetazz.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.moetazz.springbootapp.RepositoryLayer.AlleinDataRepo;
import com.moetazz.springbootapp.Model.Alien;

@SpringBootApplication
public class SpringbootappApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootappApplication.class, args);

        Alien allein1 = new Alien();
        allein1.setId(111);
        allein1.setName("Tazz");
        allein1.setTech("Iphone 11 pro max");

        AlleinDataRepo alienRepo = context.getBean(AlleinDataRepo.class);

        alienRepo.save(allein1);

        System.out.println(alienRepo.findAll());
    }
}