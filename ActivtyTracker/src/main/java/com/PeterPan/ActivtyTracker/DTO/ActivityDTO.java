package com.PeterPan.ActivtyTracker.DTO;

import com.PeterPan.ActivtyTracker.enums.Status;
import com.PeterPan.ActivtyTracker.model.Activity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor @Data
public class ActivityDTO extends Activity {

    public ActivityDTO(long activityId, String title, String description, Status status){
        super(activityId, title, description,status);
    }
}
