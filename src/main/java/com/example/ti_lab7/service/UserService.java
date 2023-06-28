package com.example.ti_lab7.service;

import com.example.ti_lab7.model.MrUser;
import com.example.ti_lab7.repository.UserRepository;

public class UserService {

    private final UserRepository repository;

    public UserService() {
        this.repository = UserRepository.getInstance();
    }

    public MrUser userAuthorization(String login, String password) {

        var user = repository.getUsers().entrySet().stream()
                        .filter(u -> u.getKey().equals(login) &&
                                u.getValue().getPassword().equals(password))
                        .findFirst()
                        .orElse(null);

        if (user == null) {
            return new MrUser();
        }
        return user.getValue();
    }
}