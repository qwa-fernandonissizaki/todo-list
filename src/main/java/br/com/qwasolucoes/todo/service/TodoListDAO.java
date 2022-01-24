package br.com.qwasolucoes.todo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.qwasolucoes.todo.domain.Todo;

@Repository
public interface TodoListDAO extends CrudRepository<Todo, Integer> {

}
