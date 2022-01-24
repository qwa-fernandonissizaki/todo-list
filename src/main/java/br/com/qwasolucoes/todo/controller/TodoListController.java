package br.com.qwasolucoes.todo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.qwasolucoes.todo.controller.model.TodoItem;
import br.com.qwasolucoes.todo.service.TodoListService;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

@Controller
@RequestMapping("/todo")
public class TodoListController {
	private static final Logger logger = new LoggerContext().getLogger(TodoListController.class);
	
	@Autowired
	private TodoListService todoListService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TodoItem> add(@RequestBody TodoItem todo) {
		logger.info("Saving to-do item: {}", ToStringBuilder.reflectionToString(todo));
		try {
			final TodoItem savedTodo = todoListService.save(todo);
			return ResponseEntity.created(URI.create("/todo/"+savedTodo.getId())).body(savedTodo);
		} catch (final Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TodoItem>> listAll() {
		return ResponseEntity.ok(todoListService.listAll());
	}
	
	@GetMapping(path = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TodoItem> getOne(@PathVariable("id") Integer id) {
		return todoListService.getById(id)
				.flatMap(todoItem -> Optional.ofNullable(ResponseEntity.ok(todoItem)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PatchMapping(path = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TodoItem> maskAsDone(@PathVariable("id") Integer id) {
		try {
			return ResponseEntity.ok(todoListService.markAsDone(id));
		} catch (final Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
