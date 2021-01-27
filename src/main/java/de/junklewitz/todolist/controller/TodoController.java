package de.junklewitz.todolist.controller;

import de.junklewitz.todolist.dto.TodoCreateDTO;
import de.junklewitz.todolist.dto.TodoUpdateDTO;
import de.junklewitz.todolist.entity.TodoEntity;
import de.junklewitz.todolist.exception.TodoNotFoundException;
import de.junklewitz.todolist.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todos")
    public Iterable<TodoEntity> findAllTodos() {
        return todoService.findAll();
    }

    @GetMapping("/todos/{id}")
    public TodoEntity findTodoById(@PathVariable final Long id) {
        return todoService.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PostMapping("/todos")
    public TodoEntity createTodo(@RequestBody final TodoCreateDTO todoCreateDTO) {
        final TodoEntity todo = new TodoEntity();
        BeanUtils.copyProperties(todoCreateDTO, todo);

        return todoService.save(todo);
    }

    @PutMapping("/todos/{id}")
    public TodoEntity updateTodo(@PathVariable final Long id, @RequestBody final TodoUpdateDTO todoUpdateDTO)
            throws TodoNotFoundException {

        final TodoEntity todo = todoService.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
        BeanUtils.copyProperties(todoUpdateDTO, todo);

        return todoService.save(todo);
    }
}
