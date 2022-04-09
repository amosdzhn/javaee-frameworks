package com.amosdzhn.jacksonlib.bean;


public class User {
    private Integer id;
    private String username;
    private String password;

    public User() {
        System.out.println("无参构造器...");
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        System.out.println("有参构造器...");
    }

    public Integer getId() {
        System.out.println("getId");
        return id;
    }

    public void setId(Integer id) {
        System.out.println("setId");
        this.id = id;
    }

    public String getUsername() {
        System.out.println("getUsername");
        return username;
    }

    public void setUsername(String username) {
        System.out.println("setUsername");
        this.username = username;
    }

    public String getPassword() {
        System.out.println("getPassword");
        return password;
    }

    public void setPassword(String password) {
        System.out.println("setPassword");
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
