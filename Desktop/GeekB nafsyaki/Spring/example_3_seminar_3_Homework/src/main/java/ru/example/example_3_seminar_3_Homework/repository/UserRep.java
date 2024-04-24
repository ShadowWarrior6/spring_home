package ru.example.example_3_seminar_3_Homework.repository;

import org.springframework.stereotype.Repository;
import ru.example.example_3_seminar_3_Homework.domain.User;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserRep {
    private List<User>users=new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public List<User> findAll() {
        return users ;
    }
}
