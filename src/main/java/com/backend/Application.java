package com.backend;

import com.backend.domain.User;
import com.backend.services.AppDemoService;
import com.backend.services.UserService;
import com.backend.services.UserServiceImpl;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.sql.SQLException;

@SpringBootApplication
public class Application {


    public static void main(String[] args) throws SQLException {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Console.main(args);



    }
}
