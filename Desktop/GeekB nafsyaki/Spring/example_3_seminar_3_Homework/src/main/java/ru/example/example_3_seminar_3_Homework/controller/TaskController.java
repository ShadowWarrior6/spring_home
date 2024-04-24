package ru.example.example_3_seminar_3_Homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.example.example_3_seminar_3_Homework.domain.User;
import ru.example.example_3_seminar_3_Homework.services.DataProcesingService;

import java.util.ArrayList;
import java.util.List;

@RestController("/tasks")
public class TaskController {

    @Autowired
    private DataProcesingService service;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRep().getUsers());
    }

    @GetMapping("/filter{age}")
  public List<User>filterUserByAge(@PathVariable int age){
        return filterUserByAge(age);
    }
    @GetMapping("/calc")
   public double calculateAverageAge(){
        return service.calculateAverageAge(service.getRep().findAll());
    }



}
