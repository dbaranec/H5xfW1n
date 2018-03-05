package org.coin.coincap;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Component
public class ApiTestClientImp {

    //private String URI = "https://jsonplaceholder.typicode.com/";
    @Value("${apiTest.url}")
    private String URI;

    public List<BookResponse> getBooks() throws Exception {
        ApiTestClient apiTestClient = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
                .target(ApiTestClient.class, URI);
        return apiTestClient.getBooks();
    }
}
