package com.course.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by kp6 on 10/8/2016.
 */

@Entity
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "name")
    @NotNull
    private String name;

     @Column(name = "image_counter")
    private int imageCounter;

@Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Temporal(TemporalType.DATE)
 @Column(name = "registeration_date")
    private Date    registerationDate;



    @Column(name = "profile_image_address")
    private String profileImageAddress;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageCounter() {
        return imageCounter;
    }

    public void setImageCounter(int imageCounter) {
        this.imageCounter = imageCounter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRegisterationDate() {
        return registerationDate;
    }

    public void setRegisterationDate(Date registerationDate) {
        this.registerationDate = registerationDate;
    }

    public String getProfileImageAddress() {
        return profileImageAddress;
    }

    public void setProfileImageAddress(String profileImageAddress) {
        this.profileImageAddress = profileImageAddress;
    }
}
