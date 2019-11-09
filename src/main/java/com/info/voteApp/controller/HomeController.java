package com.info.voteApp.controller;

import com.info.voteApp.model.SessionInfo;
import com.info.voteApp.service.SessionInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    ServletContext context;

    @Autowired
    SessionInfoService sessionInfoService;

    @RequestMapping(value = "/")
    public ModelAndView viewHome(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();
        if(sessionInfoList.isEmpty()){
            model.addAttribute("msg", "Session is empty!");
            modelAndView.setViewName("errorPage");
            return modelAndView;
        }else {
            model.addAttribute("sessionInfo", sessionInfoList.get(0));
            modelAndView.setViewName("login");
            logger.info("Welcome to login page");
            return modelAndView;
        }

    }
}
