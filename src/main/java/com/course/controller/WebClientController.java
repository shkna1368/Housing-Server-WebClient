package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Sh-Java on 11/19/2016.
 */

@Controller
public class WebClientController {

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
 @RequestMapping("/houseimage")
    public String houseimage(Model model, @RequestParam(value="houseId", required=false) int id) {
        model.addAttribute("houseId", id);
        return "house_images";
    }

}
