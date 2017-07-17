package com.course.controller;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amirsedighi on 10/5/16.
 */

@RestController
public class HelloController {



    @RequestMapping("/")
    public String index() {
        System.out.println("injaaaaaaaaaaaaHellow");

        return "The first com.course.controller";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String index2() {
        System.out.println("in");


        return new Gson().toJson("Hellow");


    }

}