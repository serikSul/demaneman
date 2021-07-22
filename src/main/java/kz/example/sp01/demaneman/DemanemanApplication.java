package kz.example.sp01.demaneman;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.Arrays;

@SpringBootApplication
public class DemanemanApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemanemanApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext context){
//        return args -> {
//            System.out.println("Some spring beans");
//            Arrays.stream(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);
//        };
//    }

}
