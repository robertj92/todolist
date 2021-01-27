package de.junklewitz.todolist.repository;


import de.junklewitz.todolist.entity.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void shouldSaveTodo() {
        final TodoEntity todo = new TodoEntity();
        todo.setTitle("Write Tests");
        todo.setDescription("This is important! TDD rules");
        todo.setDone(false);

        final TodoEntity persistedTodo = todoRepository.save(todo);

        assertThat(todoRepository.getOne(persistedTodo.getId())).isEqualTo(persistedTodo);
    }
}
