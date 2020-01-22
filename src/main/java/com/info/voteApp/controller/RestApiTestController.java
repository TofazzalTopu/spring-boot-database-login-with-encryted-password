package com.info.voteApp.controller;

import com.info.voteApp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class RestApiTestController {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @RequestMapping(value = "/getList", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public List<Questions> getQuestionsAsList() {
        String question = "SELECT * FROM questions where ROWNUM <= 11";

        List<Questions> questionList = jdbcTemplate.query(question,
                BeanPropertyRowMapper.newInstance(Questions.class));
        return questionList;
    }

    @RequestMapping(value = "/getMap", method = RequestMethod.GET)
    public Map<String, Object> getQuestionsAsMap() {
        Map<String, Object> map = new HashMap<>();
        String question = "SELECT * FROM questions where ROWNUM <= 11";

        List<Questions> questionList = jdbcTemplate.query(question,
                BeanPropertyRowMapper.newInstance(Questions.class));
        map.put("questionList", questionList);
        return map;
    }

    @RequestMapping(value = "/user")
    public ModelAndView user(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        Map<String, Object> map = new HashMap<>();
        String question = "SELECT * FROM questions where ROWNUM <= 11";

        List<Questions> questionList = jdbcTemplate.query(question,
                BeanPropertyRowMapper.newInstance(Questions.class));
        map.put("questionList", questionList);
        model.addAttribute("questionList", questionList);
        modelAndView.setViewName("userManagement");
        return modelAndView;
    }

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET)
    public List<Questions> getQuestions() {
        Map<String, Object> map = new HashMap<>();
        String question = "SELECT * FROM questions where ROWNUM <= 11";

        List<Questions> questionList = jdbcTemplate.query(question,
                BeanPropertyRowMapper.newInstance(Questions.class));
        map.put("questionList", questionList);
        return questionList;
    }
    @RequestMapping(value = "/show")
    public ModelAndView viewHome(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("restApi");
        return modelAndView;
    }

    public void testGetEmployeeListSuccessWithHeaders() throws URISyntaxException
    {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "https://gturnquist-quoters.cfapps.io/api/random";

        URI uri = new URI(baseUrl);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.set("X-COM-LOCATION", "USA");

        HttpEntity<Questions> requestEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);

        //Verify request succeed
//        Assert.assertEquals(200, result.getStatusCodeValue());
//        Assert.assertEquals(true, result.getBody().contains("employeeList"));
    }
}
