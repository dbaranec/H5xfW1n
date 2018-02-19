package org.coin.coincap;

import java.util.List;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

public class ApiTestClientImp {

    private static final String URI = "https://jsonplaceholder.typicode.com/";

    public List<BookResponse> getBooks() throws Exception {
        ApiTestClient apiTestClient = Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
                .target(ApiTestClient.class, URI);
        return apiTestClient.getBooks();
    }
}
