/*
package com.course.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.karyabi.com.course.model.Employee;
import com.karyabi.com.course.model.EmployeeDaoService;
import com.karyabi.com.course.model.RecruitmentDaoService;
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

*/
/**
 * Created by kp6 on 10/8/2016.
 *//*

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDaoService jobseeker;

    @Autowired
    private RecruitmentDaoService recruitmentDaoService;

    @RequestMapping(value = "/v1/message", method = RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String registerEmployer(@RequestBody Map<String, Object> payload) {
      //  System.out.println(payload.get("jig"));
//
Employee jobSeeker=jobseeker.findOne(7L);
        System.out.println(jobSeeker.getName());
        jobSeeker.setAddress("mnu");
        jobseeker.save(jobSeeker);

return "tr";

    }



     @RequestMapping(value = "/v1/registeJobSeeker", method = RequestMethod.POST,  consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String registerJobSeeker(@RequestBody Map<String, Object> payload) {
         JsonObject jsonObject=new JsonObject();
try {


    String name = (String) payload.get("name");
    String address = (String) payload.get("address");
    System.out.println("1");

    int  age = (int) payload.get("age");
    System.out.println("1"+age);
    int  experienceAge = (int) payload.get("experience_age");
    String linkedinAddress = (String) payload.get("linkedin_address");
    System.out.println("2");
    int skillScope = (int) payload.get("skill_scope");
    String profileImage = (String) payload.get("profile_image_address");
    String soldeingStatus = (String) payload.get("soldiering_status");
    double latitude = (double) payload.get("latitute");
    System.out.println("3");
    double longitude = (double) payload.get("longitude");
    Employee jobSeeker = new Employee();

    jobSeeker.setName(name);
    jobSeeker.setAge(age);
    jobSeeker.setExperienceAge(experienceAge);
    jobSeeker.setAddress(address);
    jobSeeker.setExperienceAge(experienceAge);
    jobSeeker.setLongitude(longitude);
    jobSeeker.setLatitute(latitude);
    jobSeeker.setProfileImageAddress(profileImage);
    jobSeeker.setSkillScope(skillScope);
    jobSeeker.setSoldieringStatus(soldeingStatus);
    jobSeeker.setLinkedinAddress(linkedinAddress);

    Calendar calendar = Calendar.getInstance();
    Date now = calendar.getTime();
    Timestamp timestamp=new Timestamp(now.getTime());
    System.out.println(timestamp);
    jobSeeker.setRegisterationDate(timestamp);

  Employee jobSeeker1=  jobseeker.save(jobSeeker);
    jsonObject.addProperty("reult", true);
    jsonObject.addProperty("id", jobSeeker1.getId());


         return new Gson().toJson(jsonObject);

}
catch (Exception ex){
    System.out.println(ex.toString());
    jsonObject.addProperty("reult",false);
    return new Gson().toJson(jsonObject);


}

    }


    @RequestMapping(value = "/v1/jobseeker/getAll", method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String allJobSeeker() {
        JsonObject jsonObject=new JsonObject();

        try {

            for (Employee customer : jobseeker.findAll()) {
                System.out.println(customer.getName());
            }
          List<Employee> jobSeekerList= (List<Employee>) jobseeker.findAll();
           // jsonObject.addProperty("reult", true);

            return new Gson().toJson(jobSeekerList);

        }
        catch (Exception ex){

            jsonObject.addProperty("reult",false);
            return new Gson().toJson(jsonObject);


        }

    }



   */
/* @RequestMapping(value = "/imageUpload/{desc}", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String registerEmployer2(@RequestParam("file") MultipartFile file,@RequestParam("desc") String desc) {
*//*

    @RequestMapping(value = "/v1/jobseeker/profileImageUpload/{id}", method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
    public String registerEmployer2(@RequestParam("file") MultipartFile file,@RequestParam("id") long id) {
        System.out.println(id);
        long current=System.currentTimeMillis();




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
             jobseeker.updateTitle(id,file2.getAbsolutePath());
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }

    }
}
*/
