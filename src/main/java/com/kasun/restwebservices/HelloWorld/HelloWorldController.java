package com.kasun.restwebservices.HelloWorld;


import com.kasun.restwebservices.HelloWorld.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping( "/hello-world")
    public String helloWorld(){
        return  "Hello guys ";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world bean");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean hellowWorldBeanPAthVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("hello mcn , %s",name));
    }
}
