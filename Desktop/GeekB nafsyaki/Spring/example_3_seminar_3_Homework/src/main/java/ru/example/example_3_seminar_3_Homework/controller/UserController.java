package ru.example.example_3_seminar_3_Homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.example_3_seminar_3_Homework.domain.User;
import ru.example.example_3_seminar_3_Homework.services.RegisrtationService;
import ru.example.example_3_seminar_3_Homework.services.DataProcesingService;

import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegisrtationService service;

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRep().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRep().getUsers().add(user);
        return "User added from body!";
    }
}