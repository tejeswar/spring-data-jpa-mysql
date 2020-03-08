package com.mkyong;


//https://github.com/mkyong/spring-boot/tree/master/spring-data-jpa-mysql
//https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-mysql-example/   = hikaricp
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mkyong.springdatajpa.controller.UserService;


@SpringBootApplication
@EnableJpaRepositories   // bean not found
//@EnableTransactionManagement   //even if we disable is trn--- true inside the method..but rollback functioanality not working
public class StartApplication implements CommandLineRunner {
	
	
	
	@Autowired
	private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

   

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
        System.out.println("End of main appl..");
    }

    @Override
    public void run(String... args) {

        log.info("Starting the Application...");
      
        
        
        

//        repository.save(new Book("Java"));
//        repository.save(new Book("Node"));
//        repository.save(new Book("Python"));
//
//        System.out.println("\nfindAll()");
//        repository.findAll().forEach(x -> System.out.println(x));
//
//        System.out.println("\nfindById(1L)");
//        repository.findById(1l).ifPresent(x -> System.out.println(x));
//
//        System.out.println("\nfindByName('Node')");
//        repository.findByName("Node").forEach(x -> System.out.println(x));
        
        
        /////////////////////To test jpa related things////////////////
        
        //userService.insertDummyUsers();

    }

}