package com.springAssessment.springAssessment.service;


import com.springAssessment.springAssessment.repository.entity.ToDoRepository;
import com.springAssessment.springAssessment.repository.entity.toDolist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceMySQL implements ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoServiceMySQL(@Autowired ToDoRepository toDoRepository){
        this.toDoRepository = toDoRepository;
    }

    @Override
    public toDolist save(toDolist toDolist){
        return toDoRepository.save(toDolist);
    }

    @Override
    public void delete(int toDoId){
        toDoRepository.deleteById(toDoId);
    }


    @Override
    public List<toDolist> all(){
        List<toDolist> result = new ArrayList<>();
        toDoRepository.findAll().forEach(result :: add);
        return result;
    }


    @Override
    public toDolist findById(int toDoId){

        Optional<toDolist> toDolist = toDoRepository.findById(toDoId);
        toDolist toDoResponse = toDolist.get();
        return toDoResponse;
    }



}
