package de.junklewitz.todolist.repository;

import de.junklewitz.todolist.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
