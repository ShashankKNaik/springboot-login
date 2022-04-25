package com.shashank.springbootlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class WebController {

    private static HashMap<String, User> userDataBase = new HashMap<>();

    static {
        User user1 = new User();
        user1.setUserName("shashank");
        user1.setPassword("shashank1");
        userDataBase.put(user1.getUserName(), user1);

        User user2 = new User();
        user2.setUserName("shashi");
        user2.setPassword("shashi1");
        userDataBase.put(user2.getUserName(), user2);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        if (!userDataBase.containsKey(user.getUserName()))
            return "<p class='warning'>Please Signup</p>";
        if (!userDataBase.get(user.getUserName()).getPassword().equals(user.getPassword()))
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
        if (userDataBase.containsKey(user.getUserName()))
            return "<p class='warning'>User already Exist</p>";
        userDataBase.put(user.getUserName(), user);
        return "<p class='success'>Signup successful</p>";
    }


}
