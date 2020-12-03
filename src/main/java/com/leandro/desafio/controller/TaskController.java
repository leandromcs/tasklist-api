package com.leandro.desafio.controller;

import com.leandro.desafio.dto.TaskDTO;
import com.leandro.desafio.exception.TaskNotFoundException;
import com.leandro.desafio.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping(value = "/getAll")
    public List<TaskDTO> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping(value = "/save")
    public void saveTask(@RequestBody TaskDTO dto) {
        service.saveTask(dto);
    }

    @PutMapping(value = "/modify")
    public void modifyTask(@RequestBody @Valid TaskDTO dto) throws TaskNotFoundException {
        service.modifyTask(dto);
    }

    @DeleteMapping(value = "/remove/{id}")
    public void removeTask(@PathVariable Long id) {
        service.removeTask(id);
    }

}
