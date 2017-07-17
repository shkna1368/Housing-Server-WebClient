package com.course.controller;

import com.course.model.HouseImage;
import com.course.model.HouseImageDaoService;
import com.course.model.User;
import com.course.model.UserDaoService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class HouseImageController {

    @Autowired
    private HouseImageDaoService houseImageDaoService;


    @RequestMapping(value = "/v1/findAllHouseImage/{houseId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String findImages(@PathVariable("houseId") long houseId) {
        JsonObject jsonObject = new JsonObject();

        try {


            List<HouseImage> houseImages = (List<HouseImage>) houseImageDaoService.findByHouseId(houseId);
            // jsonObject.addProperty("reult", true);
            System.out.println("findAhoudj");
            return new Gson().toJson(houseImages);

        } catch (Exception ex) {

            jsonObject.addProperty("result", false);
            return new Gson().toJson(jsonObject);


        }

    }


    @ResponseBody
    @RequestMapping(value = "/returnImage/{counter}/{imageId}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] testphoto(@PathVariable("counter") int counter,@PathVariable("imageId") long imageId) throws IOException {
        System.out.println("trrr"+imageId);
       // Long ids=new Long(imageId);
        //Long l=new Long(imageId);
        HouseImage houseImage = houseImageDaoService.findOne(imageId);
        System.out.println("path="+houseImage.getPath());
        File toServeUp = new File(houseImage.getPath());

        InputStream inputStream = null;


        inputStream = new FileInputStream(toServeUp);


        return IOUtils.toByteArray(inputStream);
    }

}