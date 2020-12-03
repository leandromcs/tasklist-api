package com.leandro.desafio.repository;

import com.leandro.desafio.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
