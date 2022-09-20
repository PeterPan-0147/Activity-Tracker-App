package com.PeterPan.ActivtyTracker.controller;

import com.PeterPan.ActivtyTracker.exceptions.UserNotFoundException;
import com.PeterPan.ActivtyTracker.exceptions.ActivityNotFoundException;
import com.PeterPan.ActivtyTracker.exceptions.EmailInUseException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ActivityTrackerExceptions {

    @ExceptionHandler(ActivityNotFoundException.class)
    public String activityNotFound(ActivityNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException ex,  Model m){
        m.addAttribute("error", "invalid credentials provided try again");
        return ex.getWhere();
    }

    @ExceptionHandler(EmailInUseException.class)
    public String emailInUse(Model m){
        m.addAttribute("error", "Email already in use ");
        return "signUp";
    }

}
