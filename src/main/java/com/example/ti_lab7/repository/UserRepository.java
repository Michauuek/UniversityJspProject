package com.example.ti_lab7.repository;

import com.example.ti_lab7.model.MrUser;

import java.util.HashMap;

public class UserRepository {

    private static UserRepository INSTANCE;
    private HashMap<String, MrUser> users = new HashMap<>();
    public static String backgroundAdminColor = null;

    private UserRepository() {
        users.put("admin", new MrUser("admin", "admin", 2));
        users.put("user1", new MrUser("user1", "pass1", 1));
        users.put("user2", new MrUser("user2", "pass2", 1));
        users.put("user3", new MrUser("user3", "pass3", 1));
        users.put("user4", new MrUser("user4", "pass4", 1));
        users.put("user5", new MrUser("user5", "pass5", 1));
    }

    public static UserRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository();
        }
        return INSTANCE;
    }

    public HashMap<String, MrUser> getUsers() {
        return users;
    }
}
