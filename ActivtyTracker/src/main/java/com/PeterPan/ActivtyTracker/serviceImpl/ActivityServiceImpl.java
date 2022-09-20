package com.PeterPan.ActivtyTracker.serviceImpl;

import com.PeterPan.ActivtyTracker.DTO.ActivityDTO;
import com.PeterPan.ActivtyTracker.model.Activity;
import com.PeterPan.ActivtyTracker.service.ActivityService;
import com.PeterPan.ActivtyTracker.exceptions.ActivityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import com.PeterPan.ActivtyTracker.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl extends ActivityService {
    
    @Autowired
    public ActivityServiceImpl( ActivityRepository activityRepository){
        super(activityRepository);
    }

    @Override
    public List<ActivityDTO> getActivities(Long id) {
        List<Activity> list = activityRepository.findAllByUserId(id);
        List<ActivityDTO> ret =new ArrayList<>();
        for(Activity act: list){
            ret.add(new ActivityDTO(act.getActivityId(), act.getTitle(), act.getDescription(), act.getStatus()));
        }
        return ret;
    }

    public void deleteActivity(Long id){
        activityRepository.deleteById(id);
    }

    @Override
    public void Save(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public Activity getActivity(Long id) {
        return activityRepository.findByActivityId(id).orElseThrow(() -> new ActivityNotFoundException("Activity with id = "+id+" not found"));
    }
}
