package com.PeterPan.ActivtyTracker.controller;

import com.PeterPan.ActivtyTracker.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.PeterPan.ActivtyTracker.model.User;
import com.PeterPan.ActivtyTracker.serviceImpl.UserServiceImpl;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping(value = "/login")
    public String getUser(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session){
        UserDTO user =userServiceImpl.getUser(email, password,"login");
        session.setAttribute("user", user);
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String signUp(Model m){
        m.addAttribute("using", new User());
        return "signUp";
    }

    @PostMapping(value ="/registerU")
    public String signUpUser(@ModelAttribute("using") User user, HttpSession session, Model m){
        if(user.getPassword().equals(user.getPassConfirm())){
            userServiceImpl.validEmail(user.getEmail());
            UserDTO loggedIn = userServiceImpl.addUser(user, "signUp");
            session.setAttribute("user", loggedIn);
            return "redirect:/home";
        }else {
            m.addAttribute("error","passwords do not match");
        }
        return "signUp";
    }
}