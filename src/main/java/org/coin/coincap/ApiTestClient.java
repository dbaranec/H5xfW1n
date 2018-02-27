package org.coin.coincap;

import java.util.List;

import feign.Headers;
import feign.RequestLine;

@Headers("Accept: application/json")
public interface ApiTestClient {

    @RequestLine("GET /posts")
    List<BookResponse> getBooks();
}
