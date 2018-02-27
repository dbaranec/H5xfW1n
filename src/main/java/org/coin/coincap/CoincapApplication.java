package org.coin.coincap;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("org.coin.coincap")
public class CoincapApplication {

    @Autowired ApiTestClientImp apiTestClientImp;

    @RequestMapping("/")
    String home() {
        return "Hello World! ";
    }

    @RequestMapping("/api")
    BookResponse api() throws Exception{
        List<BookResponse> bookResponseList = apiTestClientImp.getBooks();

        return bookResponseList.get(0);
    }

    public static void main(String[] args) {
        SpringApplication.run(CoincapApplication.class, args);
    }
}
