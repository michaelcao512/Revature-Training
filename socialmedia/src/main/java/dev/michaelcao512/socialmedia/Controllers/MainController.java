package dev.michaelcao512.socialmedia.Controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MainController {
    @GetMapping("test")
    public String helloWorld() {
        return "Hello World";
    }
}
