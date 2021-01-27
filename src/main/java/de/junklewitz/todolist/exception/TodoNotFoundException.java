package de.junklewitz.todolist.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(final Long id) {
        super(String.format("Could not found todo with id %s", id));
    }
}
