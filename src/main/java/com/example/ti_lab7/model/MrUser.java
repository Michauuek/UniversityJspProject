package com.example.ti_lab7.model;

public class MrUser {

    private String login;
    private String password;
    private int privileges;
    private String name;
    private String surname;
    private int age;


    public MrUser() {
        this.privileges = -1;
    }

    public MrUser(String login, String password, int privileges) {
        this.login = login;
        this.password = password;
        this.privileges = privileges;
    }


    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPrivileges() {
        return privileges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = filtruj(name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = filtruj(surname);
    }

    public String getStringAge() {
        if (age >= 0)
            return "" + age;
        return "";
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String filtruj(final String wejscie) {
        StringBuilder filtorwanie = new StringBuilder();
        char c;

        for (int i = 0; i < wejscie.length(); i++) {
            c = wejscie.charAt(i);
            switch (c) {
                case '<':
                    filtorwanie.append("&lt;");
                    break;
                case '>':
                    filtorwanie.append("&gt;");
                    break;
                case '&':
                    filtorwanie.append("&amp;");
                    break;
                case '"':
                    filtorwanie.append("&quot;");
                    break;
                default:
                    filtorwanie.append(c);
            }
        }
        return filtorwanie.toString();
    }

    @Override
    public String toString() {
        return "MRuzytkownik {login = " + login + ", uprawnienia =" + privileges + '}';
    }
}