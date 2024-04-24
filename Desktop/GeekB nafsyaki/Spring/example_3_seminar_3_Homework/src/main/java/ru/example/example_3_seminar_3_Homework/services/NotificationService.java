package ru.example.example_3_seminar_3_Homework.services;

import org.springframework.stereotype.Service;
import ru.example.example_3_seminar_3_Homework.domain.User;

@Service
public class NotificationService {
    public String notifyUser(User user){
        System.out.println("New user created  " + user.getName());
        return null;
    }
    public void sendNorification(String s){
        System.out.println(s);
    }

}
