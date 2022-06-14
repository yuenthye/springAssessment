package com.springAssessment.springAssessment.controller;


import com.springAssessment.springAssessment.controller.dto.ToDoDto;
import com.springAssessment.springAssessment.repository.entity.toDolist;
import com.springAssessment.springAssessment.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

@RestController
@RequestMapping("/todolist")
public class ToDoController {

    final ToDoService toDoService;

    public ToDoController(@Autowired ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<toDolist> gettoDolist(){
        return toDoService.all();
    }

    @CrossOrigin
    @GetMapping("/{toDoid}")
    public toDolist findByToDoId(@PathVariable Integer toDoid) {
        return toDoService.findById(toDoid);
    }


    @CrossOrigin
    @DeleteMapping("/{toDoid}")
    public void delete(@PathVariable Integer toDoid){
        toDoService.delete(toDoid);
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="targetDate", required = true) Date targetDate)
                        throws IOException

                       {


        ToDoDto toDoDto = new ToDoDto(title, description, targetDate);
        toDoService.save(new toDolist(toDoDto));
    }




}
