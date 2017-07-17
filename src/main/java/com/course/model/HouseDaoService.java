package com.course.model;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kp6 on 10/9/2016.
 */

@Transactional
public interface HouseDaoService extends PagingAndSortingRepository<House, Long> {

    List<House> findByRoom(int room);

    @Query("select u from House u where  u.area <= :area")
    List<House>  findByArea(@Param("area") int area);

    @Query("select u from House u where  u.price <= :price")
    List<House>  findByPrice(@Param("price") long price);


}
