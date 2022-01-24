package br.com.qwasolucoes.todo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qwasolucoes.todo.controller.model.TodoItem;
import br.com.qwasolucoes.todo.domain.Todo;

@Service
public class TodoListService {
	@Autowired
	private TodoListDAO todoListDAO;

	public TodoItem save(final TodoItem todoItem) {
		final Todo todo = new Todo(todoItem.getSummary(), todoItem.getDescription(), LocalDate.now(), todoItem.getEstimatedFinishDate());
		final Todo savedTodo = this.todoListDAO.save(todo);
		final TodoItem todoItemResult = new TodoItem(savedTodo.getId(), savedTodo.getSummary(), savedTodo.getDescription(), 
				savedTodo.getCreated(), savedTodo.getEstimatedFinishDate(), savedTodo.isDone());
		return todoItemResult;
	}
	

	public List<TodoItem> listAll() {
		final List<TodoItem> todolist = new ArrayList<>();
		this.todoListDAO.findAll().forEach(todo -> {
			todolist.add(new TodoItem(todo.getId(), todo.getSummary(), todo.getDescription(), todo.getCreated(), todo.getEstimatedFinishDate(), todo.isDone()));
		});
		return todolist;
	}
	
	public Optional<TodoItem> getById(Integer id) {
		Optional<Todo> dbTodo = this.todoListDAO.findById(id);
		Optional<TodoItem> todoItem = dbTodo.flatMap(todo -> {
			return Optional.of(new TodoItem(
					todo.getId(),
					todo.getSummary(),
					todo.getDescription(),
					todo.getCreated(),
					todo.getEstimatedFinishDate(),
					todo.isDone()
					));
		});
		return todoItem;
	}
	
	
	public TodoItem markAsDone(Integer id) {
		final Optional<Todo> todoOptional = todoListDAO.findById(id);
		final Todo todo = todoOptional.orElseThrow();
		todo.setDone(true);
		final Todo savedTodo = todoListDAO.save(todo);
		return new TodoItem(savedTodo.getId(), savedTodo.getSummary(), savedTodo.getDescription(), 
				savedTodo.getCreated(), savedTodo.getEstimatedFinishDate(), savedTodo.isDone());
	}
}
