package com.kasun.restwebservices.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


@ApiModel(description = "this includes all the info about the user")
public class User {

    private Integer id;

    @Size(min = 2 , message = "name should contain atleast 2 characters")
    @ApiModelProperty(notes = "name should have atleast 2 characters")
    private String  name;

    @Past
    @ApiModelProperty(notes = "birthdate shouls be in past")
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
