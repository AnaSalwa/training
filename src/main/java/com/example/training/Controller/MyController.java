package com.example.training.Controller;

import com.example.training.Service.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    public MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/message")
    public String message(){
        return myService.sendMessage();
    }


}
