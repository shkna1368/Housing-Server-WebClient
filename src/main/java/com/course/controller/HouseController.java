package com.course.controller;

import com.course.model.House;
import com.course.model.HouseDaoService;
import com.course.model.User;
import com.course.model.UserDaoService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class HouseController {

    @Autowired
    private HouseDaoService houseDaoService;

    @RequestMapping(value = "/v1/addNewHouse", method = RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String addHouse(@RequestBody Map<String, Object> payload) {
        JsonObject jsonObject=new JsonObject();
        try {

            String  uId = (String) payload.get("userId");

            long userId = new Long(uId);
            System.out.println("1");
            String city = (String) payload.get("city");
            System.out.println("2");
            int age = (int) payload.get("home_age");
            System.out.println("3");
            int area = (int) payload.get("area");
            System.out.println("4");
            int room = (int) payload.get("room");
            System.out.println("5");
            double lat = (double) payload.get("lat");
            System.out.println("6");
            double lon = (double) payload.get("lon");
            System.out.println("7");
            String  prices = (String) payload.get("price");
            long price = new Long(prices);
            System.out.println("8");

            System.out.println("1");
            House house=new House();



            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            Timestamp timestamp=new Timestamp(now.getTime());

            house.setCreateDate(timestamp);
            house.setUserId(userId);
            house.setCity(city);
            house.setArea(area);
            house.setHomeAge(age);
            house.setRoom(room);
            house.setLat(lat);
            house.setLon(lon);
            house.setPrice(price);


        House savedHouse=   houseDaoService.save(house);
            System.out.println("3");
            jsonObject.addProperty("result", true);
            jsonObject.addProperty("action", "addNewHome");
            jsonObject.addProperty("id", savedHouse.getHouseId());


            return new Gson().toJson(jsonObject);

        }
        catch (Exception ex){

            System.out.println(ex.toString());
            jsonObject.addProperty("reult",false);
            return new Gson().toJson(jsonObject);


        }





    }


    @RequestMapping(value = "/v1/house/findByRoom/{room}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String findByRoom(@PathVariable("room") int room) {
        System.out.println("inh");
        System.out.println(room);
        JsonObject jsonObject = new JsonObject();


        try {
            //  List<House> recruitments = recruitmentDaoService.findByCompanyId(id);

            List<House> houses = houseDaoService.findByRoom(room);


            jsonObject.addProperty("result", true);

            jsonObject.addProperty("action", "getAllRecruitment");
            //jsonObject.add("recruitments", recruitments);


            JsonArray result = (JsonArray) new Gson().toJsonTree(houses,
                    new TypeToken<List<House>>() {
                    }.getType());

            jsonObject.add("list", result);


            return new Gson().toJson(jsonObject);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            jsonObject.addProperty("reult", false);
            jsonObject.addProperty("action", "getAllRecruitment");
            return new Gson().toJson(jsonObject);


        }
    }
    @RequestMapping(value = "/v1/house/findByArea/{area}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String findByArea(@PathVariable("area") int area) {

        System.out.println(area);
        JsonObject jsonObject = new JsonObject();


        try {
            //  List<House> recruitments = recruitmentDaoService.findByCompanyId(id);

            List<House> houses = houseDaoService.findByArea(area);


            jsonObject.addProperty("result", true);

            jsonObject.addProperty("action", "getAllRecruitment");
            //jsonObject.add("recruitments", recruitments);


            JsonArray result = (JsonArray) new Gson().toJsonTree(houses,
                    new TypeToken<List<House>>() {
                    }.getType());

            jsonObject.add("list", result);


            return new Gson().toJson(jsonObject);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            jsonObject.addProperty("reult", false);
            jsonObject.addProperty("action", "getAllRecruitment");
            return new Gson().toJson(jsonObject);


        }
    }

    @RequestMapping(value = "/v1/house/findByPrice/{price}", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String findByPrice(@PathVariable("price") long price) {

        System.out.println(price);
        JsonObject jsonObject = new JsonObject();
      //  String  uId = (String) payload.get("userId");

       // long userId = new Long(uId);

        try {
            //  List<House> recruitments = recruitmentDaoService.findByCompanyId(id);

            List<House> houses = houseDaoService.findByPrice(price);


            jsonObject.addProperty("result", true);

            jsonObject.addProperty("action", "findByPrice");
            //jsonObject.add("recruitments", recruitments);


            JsonArray result = (JsonArray) new Gson().toJsonTree(houses,
                    new TypeToken<List<House>>() {
                    }.getType());

            jsonObject.add("list", result);


            return new Gson().toJson(jsonObject);

        } catch (Exception ex) {
            System.out.println(ex.toString());
            jsonObject.addProperty("result", false);
            jsonObject.addProperty("action", "getAllRecruitment");
            return new Gson().toJson(jsonObject);


        }
    }



    @RequestMapping(value = "/v1/house/getAllHouse", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String getAllHouse() {
        JsonObject jsonObject=new JsonObject();

        try {


            List<House> houses= (List<House>) houseDaoService.findAll();
            // jsonObject.addProperty("reult", true);

            return new Gson().toJson(houses);

        }
        catch (Exception ex){

            jsonObject.addProperty("result",false);
            return new Gson().toJson(jsonObject);


        }

    }
}
