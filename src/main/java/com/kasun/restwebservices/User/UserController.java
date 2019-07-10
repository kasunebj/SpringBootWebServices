package com.kasun.restwebservices.User;


import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import static javafx.scene.input.KeyCode.R;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/users")
    public List<User> getAll(){
        return userDao.findAll();
    }

    @GetMapping("/users/{id}")
    public  Resource<User> retrieveUser(@PathVariable Integer id){
        User user = userDao.findOne(id);
        if (user == null){
            throw new UserNotFoundException("id - "+ id);
        }
        Resource<User> resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAll());
        resource.add(linkTo.withRel("all-users"));
        return resource;

    }

    @PostMapping("/users")
    public ResponseEntity<Object> insert(@Valid @RequestBody User user){
             userDao.addUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void remove( @PathVariable Integer id){
        User user = userDao.DeleteByID(id);

        if (user == null){
            throw new UserNotFoundException("id - "+ id);
        }
    }
    @GetMapping("/users-intern")
    public String helloWorldInternationalization(@RequestHeader(name="Accept-Language",required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }
}
