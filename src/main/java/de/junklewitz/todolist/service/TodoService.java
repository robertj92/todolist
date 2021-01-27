package de.junklewitz.todolist.service;

import de.junklewitz.todolist.entity.TodoEntity;
import de.junklewitz.todolist.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Iterable<TodoEntity> findAll() {
        return todoRepository.findAll();
    }

    public TodoEntity save(final TodoEntity todo) {
        return this.todoRepository.save(todo);
    }

    public Optional<TodoEntity> findById(final Long id) {
        return this.todoRepository.findById(id);
    }
}
