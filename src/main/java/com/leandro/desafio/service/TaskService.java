package com.leandro.desafio.service;

import com.leandro.desafio.dto.TaskDTO;
import com.leandro.desafio.exception.TaskNotFoundException;
import com.leandro.desafio.model.Task;
import com.leandro.desafio.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskDTO> getAllTasks() {
        List<TaskDTO> dtos = new ArrayList<>();
        Iterable<Task> all = repository.findAll();

        all.forEach(task -> dtos.add(new TaskDTO(task.getId(), task.getTitulo(), task.getStatus(), task.getDescricao())));

        return dtos;
    }

    public void saveTask(TaskDTO dto) {
        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setStatus(false);

        if (dto.getDescricao() != null) {
            task.setDescricao(dto.getDescricao());
        }

        repository.save(task);
    }

    public void modifyTask(TaskDTO dto) throws TaskNotFoundException {
        Optional<Task> byId = repository.findById(dto.getId());
        if (byId.isPresent()) {
            Task task = byId.get();
            task.setTitulo(dto.getTitulo());
            task.setStatus(dto.getStatus());

            if (dto.getDescricao() != null) {
                task.setDescricao(dto.getDescricao());
            }

            repository.save(task);
        } else {
            throw new TaskNotFoundException();
        }
    }

    public void removeTask(Long id) {
        repository.deleteById(id);
    }
}
