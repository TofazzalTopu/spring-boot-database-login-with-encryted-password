package com.info.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    /*This function will load home page*/
    @RequestMapping(value = "/")
    public ModelAndView viewHome(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        logger.info("Welcome to home page");
        return modelAndView;
    }
}
