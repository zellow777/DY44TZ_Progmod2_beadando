package com.zellow777.beadando.model;

import com.zellow777.beadando.enums.ActivityTypeEnum;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Table(name = "activities")
@Entity(name = "Activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "activity_type", nullable = false, columnDefinition = "ENUM('LECTURE', 'LABORATORY', 'SPORTS', 'ARTS', 'MEETING')")
    @Enumerated(EnumType.STRING)
    private ActivityTypeEnum activityType;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "start_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp startDate;
    @Column(name = "end_date",  columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp endDate;

    public Activity(Integer id, ActivityTypeEnum activityType, String title, String description, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.activityType = activityType;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Activity() {

    }

    public String getTitle() {
        return title;
    }

    public ActivityTypeEnum getActivityType() {
        return activityType;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setActivityType(ActivityTypeEnum activityType) {
        this.activityType = activityType;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity that = (Activity) o;
        return title.equals(that.title) && activityType == that.activityType && id.equals(that.id) && description.equals(that.description) && startDate.equals(that.startDate) && endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, activityType, id, description, startDate, endDate);
    }

    @Override
    public String toString() {
        return "ImmutableActivity{" +
                "title='" + title + '\'' +
                ", activityType=" + activityType +
                ", id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

