package ru.example.example_3_seminar_3_Homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.example_3_seminar_3_Homework.repository.UserRep;
import ru.example.example_3_seminar_3_Homework.domain.User;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcesingService {
    @Autowired
    private UserRep rep;
    public UserRep getRep(){
        return rep;
    }
    public void addUserToList(User user){
        rep.getUsers().add(user);
    }
    public List<User> sortUsersByAge(List<User> users) {

        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

}
