package com.kasun.restwebservices.User;

import java.util.Date;



public class User {
    private Integer id;
    private String  name;
    private Date birthdate;

    public User(){};

    public User(Integer id , String name , Date bdate){
        super();
        this.birthdate =bdate;
        this.id =id;
        this.name =name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
