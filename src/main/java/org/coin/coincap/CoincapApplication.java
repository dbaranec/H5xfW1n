package org.coin.coincap;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CoincapApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/api")
    BookResponse api() throws Exception{
        ApiTestClientImp apiTestClientImp = new ApiTestClientImp();
        List<BookResponse> bookResponseList = apiTestClientImp.getBooks();

        return bookResponseList.get(0);
    }

    public static void main(String[] args) {
        SpringApplication.run(CoincapApplication.class, args);
    }
}
