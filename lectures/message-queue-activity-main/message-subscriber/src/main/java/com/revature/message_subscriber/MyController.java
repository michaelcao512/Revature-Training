package com.revature.message_subscriber;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/processMessage")
    public void processMessage(@RequestBody String message) {
        System.out.println("Incoming message: \n================================");
        System.out.println(message);
        System.out.println("================================\n");
    }
    
}
