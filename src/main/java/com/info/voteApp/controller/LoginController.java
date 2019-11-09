package com.info.voteApp.controller;

import com.info.voteApp.model.ProcEmpOut;
import com.info.voteApp.model.Questions;
import com.info.voteApp.model.SessionInfo;
import com.info.voteApp.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class LoginController {
    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    QuestionsService questionsService;

    @Autowired
    AdmUserService admUserService;

    @Autowired
    VotingHistoryService votingHistoryService;

    @Autowired
    SessionInfoService sessionInfoService;

    @Autowired
    ProcEmpOutService procEmpOutService;

    @ResponseBody
    @RequestMapping(value = "/home")
    public ModelAndView viewHome(Model model) {
        List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();
        ModelAndView modelAndView = new ModelAndView();
        if(sessionInfoList.isEmpty()){
            model.addAttribute("msg", "Session is empty!");
            modelAndView.setViewName("errorPage");
            logger.info("Welcome to error page");
            return modelAndView;
        }else {
            model.addAttribute("sessionInfo", sessionInfoList.get(0));
            modelAndView.setViewName("login");
            logger.info("Welcome to login page");
            return modelAndView;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public String home(Model model) {
        List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();
        System.out.println("loginPage...");
        logger.info("home...." + sessionInfoList.get(0).getId());
        return "sessionInfo..............";
    }

    @ResponseBody
    @RequestMapping(value = "/success")
    public ModelAndView success(Model model, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();
        modelAndView.setViewName("success");
        logger.info("Success....");
        model.addAttribute("sessionInfo", sessionInfoList.get(0));
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/failed")
    public ModelAndView failed(Model model, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();

        modelAndView.setViewName("failed");
        model.addAttribute("sessionInfo", sessionInfoList.get(0));
        logger.info("Failed....");
        return modelAndView;
    }

    @RequestMapping(value = "/questions")
    @ResponseBody
    public ModelAndView loginPage(Model model, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();

            if(sessionInfoList.isEmpty()){
                model.addAttribute("msg", "Session is empty!");
                modelAndView.setViewName("errorPage");
                logger.info("Welcome to error page");
                return modelAndView;
            }

            boolean exists = true;
            ProcEmpOut procEmpOut = procEmpOutService.getByEmpCode(request.getParameter("empCode"));
            if (procEmpOut == null) {
                model.addAttribute("sessionInfo", sessionInfoList.get(0));
                model.addAttribute("msg", "Employee code not found!");
                modelAndView.setViewName("login");
                return modelAndView;
            }

            if (procEmpOut.getEmpType().equals("WORKER") || procEmpOut.getEmpType().equals("SUPPORT_STAFF")) {
                exists = true;
            } else {
                exists = false;
            }
            if (!exists) {
                model.addAttribute("sessionInfo", sessionInfoList.get(0));
                model.addAttribute("msg", "Employee code not found!");
                modelAndView.setViewName("login");
                return modelAndView;
            }

            long sessionId = sessionInfoList.get(0).getId();
            boolean isVoted = votingHistoryService.getByEmpCodeAndSessionId(procEmpOut.getEmpCode(), sessionId);

            if (isVoted) {
                model.addAttribute("sessionInfo", sessionInfoList.get(0));
                model.addAttribute("msg", "You have already voted!");
                modelAndView.setViewName("login");
                return modelAndView;
            }

            String question = "SELECT * FROM questions where ROWNUM <= 11";

            List<Questions> questionList = jdbcTemplate.query(question,
                    BeanPropertyRowMapper.newInstance(Questions.class));

            if(questionList.isEmpty()){
                model.addAttribute("msg", " No questions found in database!");
                modelAndView.setViewName("errorPage");
                logger.info("Welcome to error page");
                return modelAndView;
            }

            Questions main_q = new Questions();
            Questions first_q = new Questions();
            Questions second_q = new Questions();
            Questions third_q = new Questions();
            Questions fourth_q = new Questions();
            Questions fifth_q = new Questions();
            Questions sixth_q = new Questions();
            Questions seventh_q = new Questions();
            Questions eight_q = new Questions();
            Questions ninth_q = new Questions();
            Questions tenth_q = new Questions();

            for (Questions ques : questionList) {
                if (ques.getQuestionNo() == 0) {
                    main_q = ques;
                } else if (!ques.isMainQuestion()) {

                    if (ques.getQuestionNo() == 1) {
                        first_q = ques;
                    } else if (ques.getQuestionNo() == 2) {
                        second_q = ques;
                    } else if (ques.getQuestionNo() == 3) {
                        third_q = ques;
                    } else if (ques.getQuestionNo() == 4) {
                        fourth_q = ques;
                    } else if (ques.getQuestionNo() == 5) {
                        fifth_q = ques;
                    } else if (ques.getQuestionNo() == 6) {
                        sixth_q = ques;
                    } else if (ques.getQuestionNo() == 7) {
                        seventh_q = ques;
                    } else if (ques.getQuestionNo() == 8) {
                        eight_q = ques;
                    } else if (ques.getQuestionNo() == 9) {
                        ninth_q = ques;
                    } else {
                        tenth_q = ques;
                    }
                }
            }

            model.addAttribute("user", procEmpOut);
            model.addAttribute("sessionInfo", sessionInfoList.get(0));
            model.addAttribute("questionList", questionList);
            model.addAttribute("main_q", main_q);
            model.addAttribute("first_q", first_q);
            model.addAttribute("second_q", second_q);
            model.addAttribute("third_q", third_q);
            model.addAttribute("fourth_q", fourth_q);
            model.addAttribute("fifth_q", fifth_q);
            model.addAttribute("sixth_q", sixth_q);
            model.addAttribute("seventh_q", seventh_q);
            model.addAttribute("eight_q", eight_q);
            model.addAttribute("ninth_q", ninth_q);
            model.addAttribute("tenth_q", tenth_q);
            logger.info("Question page shown....");
            modelAndView.setViewName("questions");

            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("login");
            logger.info("Login failed....");
            model.addAttribute("msg", "Login failed!");
            return modelAndView;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/create")
    public ModelAndView showTenQuestion(Model model, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();
        ProcEmpOut procEmpOut = procEmpOutService.getByEmpCode(request.getParameter("empCode"));

        if(sessionInfoList.isEmpty()){
            model.addAttribute("msg", " Session is empty!");
            modelAndView.setViewName("errorPage");
            logger.info("Welcome to error page");
            return modelAndView;
        }
        try {
            votingHistoryService.save(
                    request.getParameter("empCode"),
                    sessionInfoList.get(0).getId(),
                    request.getParameter("main_q"),
                    request.getParameter("first_q"),
                    request.getParameter("second_q"),
                    request.getParameter("third_q"),
                    request.getParameter("fourth_q"),
                    request.getParameter("fifth_q"),
                    request.getParameter("sixth_q"),
                    request.getParameter("seventh_q"),
                    request.getParameter("eight_q"),
                    request.getParameter("ninth_q"),
                    request.getParameter("tenth_q"),
                    request.getParameter("notes")
            );

            model.addAttribute("sessionInfo", sessionInfoList.get(0));
            model.addAttribute("user", procEmpOut);
            model.addAttribute("msg", "Vote have done successfully!");
            logger.info("Vote have done successfully!...");
            modelAndView.setViewName("login");

            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", procEmpOut);
            model.addAttribute("sessionInfo", sessionInfoList.get(0));
            model.addAttribute("msg", "Vote casting failed!");
            modelAndView.setViewName("failed");
            logger.info("Vote casting failed!");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/question")
    @ResponseBody
    public ModelAndView questions(Model model, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<SessionInfo> sessionInfoList = sessionInfoService.getActiveSessionInfo();

            boolean exists = true;
            ProcEmpOut procEmpOut = procEmpOutService.getByEmpCode(request.getParameter("empCode"));
            if (procEmpOut == null) {
                model.addAttribute("sessionInfo", sessionInfoList.get(0));
                model.addAttribute("msg", "Employee code not found!");
                modelAndView.setViewName("login");
                return modelAndView;
            }

            if (procEmpOut.getEmpType().equals("WORKER") || procEmpOut.getEmpType().equals("SUPPORT_STAFF")) {
                exists = true;
            } else {
                exists = false;
            }
            if (!exists) {
                model.addAttribute("sessionInfo", sessionInfoList.get(0));
                model.addAttribute("msg", "Employee code not found!");
                modelAndView.setViewName("login");
                return modelAndView;
            }

            long sessionId = sessionInfoList.get(0).getId();
            boolean isVoted = votingHistoryService.getByEmpCodeAndSessionId(procEmpOut.getEmpCode(), sessionId);

            if (isVoted) {
                model.addAttribute("sessionInfo", sessionInfoList.get(0));
                model.addAttribute("msg", "You have already voted!");
                modelAndView.setViewName("login");
                return modelAndView;
            }

            String question = "SELECT * FROM questions where ROWNUM <= 11";

            List<Questions> questionList = jdbcTemplate.query(question,
                    BeanPropertyRowMapper.newInstance(Questions.class));


            model.addAttribute("user", procEmpOut);
            model.addAttribute("sessionInfo", sessionInfoList.get(0));
            model.addAttribute("questionList", questionList);

            logger.info("Question page shown....");
            modelAndView.setViewName("question_list");

            return modelAndView;
        } catch (Exception e) {
            e.printStackTrace();
            modelAndView.setViewName("login");
            logger.info("Login failed....");
            model.addAttribute("msg", "Login failed!");
            return modelAndView;
        }
    }

}
