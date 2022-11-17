package com.zellow777.beadando.service;

import com.zellow777.beadando.model.Activity;
import com.zellow777.beadando.repository.ActivityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ActivityService {

    private static final Logger LOGGER = LogManager.getLogger(ActivityService.class);
    @Autowired
    ActivityRepository activityRepository;

    public List<Activity> getAllActivity()
    {
        List<Activity> activities = new ArrayList<Activity>();
        activityRepository.findAll().forEach(activity -> activities.add(activity));
        return activities;
    }

    public Activity getActivityById(int id)
    {
        return activityRepository.findById(id).get();
    }
    public void saveOrUpdate(Activity activity)
    {
        activityRepository.save(activity);
    }

    public  void delete(int id)
    {
        activityRepository.deleteById(id);
    }

    public String getActivityLengthById(int id) {
        try{
            Activity activity = activityRepository.findById(id).get();

            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
                    = activity.getEndDate().getTime() - activity.getStartDate().getTime();

            // Calucalte time difference in seconds,
            // minutes, hours, years, and days
            long difference_In_Seconds
                    = TimeUnit.MILLISECONDS
                    .toSeconds(difference_In_Time)
                    % 60;

            long difference_In_Minutes
                    = TimeUnit
                    .MILLISECONDS
                    .toMinutes(difference_In_Time)
                    % 60;

            long difference_In_Hours
                    = TimeUnit
                    .MILLISECONDS
                    .toHours(difference_In_Time)
                    % 24;

            long difference_In_Days
                    = TimeUnit
                    .MILLISECONDS
                    .toDays(difference_In_Time)
                    % 365;

            long difference_In_Years
                    = TimeUnit
                    .MILLISECONDS
                    .toDays(difference_In_Time)
                    / 365l;

            // Return result
            return (difference_In_Years
                    + " years, "
                    + difference_In_Days
                    + " days, "
                    + difference_In_Hours
                    + " hours, "
                    + difference_In_Minutes
                    + " minutes, "
                    + difference_In_Seconds
                    + " seconds");
        }
        catch(Exception e){
            LOGGER.error("Failed to Calculate ActivityLength", e);
        }
        return "error";
        }
}
