package com.kasun.restwebservices.User;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDao {

    private static List<User> users = new ArrayList<>();
    private static  Integer userCount = 3;

    static{
        users.add(new User(1,"kasun",new Date()));
        users.add(new User(2,"eranga",new Date()));
        users.add(new User(3,"bandara",new Date()));
    }

    public List<User> findAll(){
        return users;
    }
    public void addUser(User user){
        if (user.getId()==null){
            user.setId(++userCount);
        }
        users.add(user);
    }
    public User findOne (Integer id) {
        Iterator<User> it = users.iterator();
//        if (users.stream().anyMatch(u->u.getId()==id)){
////            User user =(User) users.stream().filter( (u)-> u.getId()==id);
//            return user;
//        }
        while (it.hasNext()){
//            if(it.next().getId()==id){
//                return it.next();
//            }
            User customer = it.next();
            if (customer.getId().equals(id)) {
                return customer;
            }else{
                throw new UserNotFoundException("id - " + id);
            }
        }
        return null;
    }
}