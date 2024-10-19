package com.baraa.runnerz;

import org.springframework.stereotype.Component;

// this @ mean this class available to Spring

@Component
public class WelcomeMessage {

    // method return string
    public String getWelcomeMessage(){
        return "Welcome to Spring Boot Application";
    }
}
