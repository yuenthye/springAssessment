package com.springAssessment.springAssessment.service;

import com.springAssessment.springAssessment.repository.entity.toDolist;

import java.util.List;

public interface ToDoService {

    List<toDolist> all();

    toDolist save(toDolist toDolist);

    void delete(int toDoId);

    toDolist findById(int toDoId);


}
