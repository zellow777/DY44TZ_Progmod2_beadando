package com.zellow777.beadando.POJO;

public class ActivityPOJO {
    private Integer id;
    private String activityTypeInput;
    private String title;
    private String description;
    private String startDateInput;
    private String endDateInput;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActivityTypeInput() {
        return activityTypeInput;
    }

    public void setActivityTypeInput(String activityTypeInput) {
        this.activityTypeInput = activityTypeInput;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDateInput() {
        return startDateInput;
    }

    public void setStartDateInput(String startDateInput) {
        this.startDateInput = startDateInput;
    }

    public String getEndDateInput() {
        return endDateInput;
    }

    public void setEndDateInput(String endDateInput) {
        this.endDateInput = endDateInput;
    }
}
