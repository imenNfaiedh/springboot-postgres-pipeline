package com.example.tp3jenkins;

import com.example.tp3jenkins.entities.Etudiant;
import com.example.tp3jenkins.repo.EtudiantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Tp3JenkinsApplication {

    EtudiantRepository etdRepository;
    public Tp3JenkinsApplication(EtudiantRepository etdRepository) {
        super();
        this.etdRepository = etdRepository;
    }
    public static void main(String[] args) {
        SpringApplication.run(Tp3JenkinsApplication.class, args);
    }
    @Bean
    CommandLineRunner start() {
        return args -> {

            etdRepository.save(new Etudiant(1L,"Ali","Ali", new Date()));
            etdRepository.save(new Etudiant(2L,"Asma","Asma", new Date()));
            etdRepository.save(new Etudiant(3L,"Ahmed","Ahmed", new Date()));

            //customerRepository.findAll().forEach(System.out::println);
        };
    }
}


