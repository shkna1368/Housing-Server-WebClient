package com.course.controller;

import com.course.model.User;
import com.course.model.UserDaoService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @RequestMapping(value = "/v1/registerUser", method = RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String registerJobSeeker(@RequestBody Map<String, Object> payload) {
        JsonObject jsonObject=new JsonObject();
        try {


            String name = (String) payload.get("name");
            String city = (String) payload.get("city");
            String phone = (String) payload.get("phone");


            System.out.println("1");
            User user=new User();
            user.setName(name);
            user.setCity(city);
            user.setPhone(phone);


            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            Timestamp timestamp=new Timestamp(now.getTime());
            System.out.println(timestamp);
            user.setRegisterationDate(timestamp);
            System.out.println("2");
            User savedUsaer=  userDaoService.save(user);
            System.out.println("3");
            jsonObject.addProperty("result", true);
            jsonObject.addProperty("id", savedUsaer.getId());



            return new Gson().toJson(jsonObject);

        }
        catch (Exception ex){

            System.out.println(ex.toString());
            jsonObject.addProperty("reult",false);
            return new Gson().toJson(jsonObject);


        }





    }

    @RequestMapping(value = "/v1/user/profileImageUpload/{id}", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String registerEmployer2(@RequestParam("file") MultipartFile file, @RequestParam("id") long id) {
        System.out.println(id);
        long current=System.currentTimeMillis();
        JsonObject jsonObject=new JsonObject();
     User u=userDaoService.findOne(id);


        String fileName = null;
        if (!file.isEmpty()) {
            try {
                fileName = current+"_"+file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                File file2=new File("D:/cp/" + fileName);
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(file2));
                buffStream.write(bytes);
                buffStream.close();

                u.setImageCounter(u.getImageCounter()+1);
u.setProfileImageAddress(file2.getAbsolutePath());
               // userDaoService.save(u);
                User updatedUser= userDaoService.save(u);

               // userDaoService.updateProfile(id,file2.getAbsolutePath());
                String message= "You have successfully uploaded " + fileName;




                jsonObject.addProperty("result", true);
                jsonObject.addProperty("action", "updateProfileImage");
                jsonObject.addProperty("id", updatedUser.getId());
                jsonObject.addProperty("message", message);



                return new Gson().toJson(jsonObject);
            } catch (Exception e) {
                System.out.println(e.toString());
                jsonObject.addProperty("result", false);
                jsonObject.addProperty("action", "updateProfileImage");


                String message= "You failed to upload " + fileName + ": " + e.getMessage();
                jsonObject.addProperty("message", message);
                return new Gson().toJson(jsonObject);
            }
        } else {
            return "Unable to upload. File is empty.";
        }

    }
    @RequestMapping(value = "/v1/user/getAll", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String allJobSeeker() {
        JsonObject jsonObject=new JsonObject();

        try {


            List<User> jobSeekerList= (List<User>) userDaoService.findAll();
            // jsonObject.addProperty("reult", true);

            return new Gson().toJson(jobSeekerList);

        }
        catch (Exception ex){

            jsonObject.addProperty("result",false);
            return new Gson().toJson(jsonObject);


        }

    }
}
