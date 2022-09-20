package com.PeterPan.ActivtyTracker.repository;


import com.PeterPan.ActivtyTracker.model.Activity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends CrudRepository<Activity, Long>{
        List<Activity> findAllByUserId (Long id);

        Optional<Activity> findByActivityId(Long id);

}
