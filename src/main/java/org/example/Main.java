package org.example;

import org.example.services.BankService;
import org.example.services.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Main {

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        PersonService personService = context.getBean(PersonService.class);
        BankService bankService = context.getBean(BankService.class);

        bankService.setBanksName(personService, "4");
        bankService.printBanks(bankService.getBanks());
    }
}