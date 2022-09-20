package com.PeterPan.ActivtyTracker.service;

import com.PeterPan.ActivtyTracker.DTO.ActivityDTO;
import com.PeterPan.ActivtyTracker.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;

import com.PeterPan.ActivtyTracker.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class ActivityService {

    public ActivityRepository  activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    public List<ActivityDTO> getActivities(Long id){
        return null;
    }

    public void Save(Activity activity){}

    public Activity getActivity(Long id){
        return null;
    }

    public void deleteActivity(Long id){}
    
}
