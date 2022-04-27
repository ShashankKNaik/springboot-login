package com.shashank.springbootlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class WebController {

    @Autowired
    UserRepo repo;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        if (!repo.existsById(user.getUserName()))
            return "<p class='warning'>Please Signup</p>";
        if (!repo.getById(user.getUserName()).getPassword().equals(user.getPassword()))
            return "<p class='error'>Invalid Password</p>";
        return "welcome.html";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup.html";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome.html";
    }

    @PostMapping("/signup")
    @ResponseBody
    public String addUser(@RequestBody User user) {
        if (repo.existsById(user.getUserName()))
            return "<p class='warning'>User already Exist</p>";
        repo.save(user);
        return "<p class='success'>Signup successful</p>";
    }
}
