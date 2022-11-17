package com.zellow777.beadando.controller;

import com.zellow777.beadando.enums.ActivityTypeEnum;
import com.zellow777.beadando.model.Activity;
import com.zellow777.beadando.service.ActivityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ActivityController {

    private static final Logger LOGGER = LogManager.getLogger(ActivityController.class);

    @Autowired
    ActivityService activityService;

    @GetMapping(value = "/")
    public ModelAndView defaultEndpoint(HttpServletRequest httpReq) {

        LOGGER.info("defaultEndpoint called");
        ModelAndView result = new ModelAndView("index");
        Map<String, Object> params = new HashMap<>();
        params.put("activities", activityService.getAllActivity());
        result.addAllObjects(params);
        return result;
    }

    @PostMapping("/saveActivity")
    public ModelAndView saveActivity(HttpServletRequest httpReq, Integer id, ActivityTypeEnum activityType, String title, String description, Timestamp startDate, Timestamp endDate)
    {
        LOGGER.info("saveActivity called");
        try{
            activityService.saveOrUpdate(new Activity(id, activityType, title, description, startDate, endDate));
        }
        catch (Exception e){
            LOGGER.error("Failed to Save/Update Activity", e);
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/deleteActivity")
    public ModelAndView deleteActivity(HttpServletRequest httpReq, Integer id)
    {
        LOGGER.info("deleteActivity called");
        try{
            activityService.delete(id);
        }
        catch (Exception e){
            LOGGER.error("Failed to Delete Activity", e);
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/searchActivity")
    public ModelAndView searchActivity(HttpServletRequest httpReq, Integer id)
    {
        LOGGER.info("Search Activity called");
        Activity activity;
        ModelAndView result = new ModelAndView("search");
        Map<String, Object> params = new HashMap<>();
        try{
            params.put("activity", activityService.getActivityById(id));
            params.put("activityLength", activityService.getActivityLengthById(id));
            result.addAllObjects(params);
        }
        catch (Exception e){
            LOGGER.error("Failed to Search Activity", e);
        }
        return result;
    }

    @GetMapping("/activities")
    public List<Activity> getAllActivity()
    {
        LOGGER.info("getAllActivity called");
        return activityService.getAllActivity();
    }

    @GetMapping("/activity/{id}")
    public Activity getActivity(@PathVariable("id") int id)
    {
        LOGGER.info("getActivityById called");
        return activityService.getActivityById(id);
    }

    @GetMapping("/activity/length/{id}")
    public String getActivityLength(@PathVariable("id") int id){
        LOGGER.info("getActivityLength called");
        return activityService.getActivityLengthById(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/activity/{id}")
    public void deleteActivity(@PathVariable("id") int id)
    {
        LOGGER.info("deleteActivity called");
        try{
            activityService.delete(id);
        }
        catch (Exception e){
            LOGGER.error("Failed to Delete Activity", e);
        }
    }
}

