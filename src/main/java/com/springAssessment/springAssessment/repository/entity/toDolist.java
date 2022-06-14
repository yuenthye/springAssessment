package com.springAssessment.springAssessment.repository.entity;

import com.springAssessment.springAssessment.controller.dto.ToDoDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class toDolist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int toDoid;
    private String title;
    private String description;
    private Date targetDate;

    public toDolist() {}


    public toDolist(ToDoDto toDoDto){
        this.title = toDoDto.getTitle();
        this.description = toDoDto.getDescription();
        this.targetDate = toDoDto.getTargetDate();
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

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public int getToDoListid() {
        return toDoid;
    }

    public void setToDoListid(int toDoListid) {
        this.toDoid = toDoListid;
    }

    @Override
    public String toString()
    {
        return "List{" + "title=" + title + ", description='" + description + '\'' + ", targetDate='"
                + targetDate + '\'' + '}';
    }

}


