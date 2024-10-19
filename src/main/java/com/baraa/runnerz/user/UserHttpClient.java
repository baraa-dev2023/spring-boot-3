package com.baraa.runnerz.user;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserHttpClient {

    @GetExchange("/users")
    public List<User> findAll() ;
    @GetExchange("/users/{id}")
    User findById(@PathVariable Integer id);

}