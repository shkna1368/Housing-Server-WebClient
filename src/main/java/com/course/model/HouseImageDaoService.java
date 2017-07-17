package com.course.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kp6 on 10/9/2016.
 */

@Transactional
public interface HouseImageDaoService extends PagingAndSortingRepository<HouseImage, Long> {

    List<HouseImage> findByHouseId( long houeId);
    //HouseImage findByImageId(long imageId);




}
