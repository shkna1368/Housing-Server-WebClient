package com.course.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by kp6 on 10/9/2016.
 */

@Transactional
public interface UserDaoService extends PagingAndSortingRepository<User, Long> {
    @Modifying
    @Query("Update User u SET u.profileImageAddress=:address WHERE u.id=:id")
    public void updateProfile(@Param("id") long id, @Param("address") String address);

}
