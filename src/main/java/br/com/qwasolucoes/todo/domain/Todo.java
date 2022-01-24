package br.com.qwasolucoes.todo.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Todo {

	@Id
	private Integer id;
	
	private String summary;
	
	private String description;
	
	@Column("create_date")
	private LocalDate created;
	
	@Column("estimated_finish_date")
	private LocalDate estimatedFinishDate;
	
	private boolean done;
	
	public Todo() {
		super();
	}

	public Todo(Integer id, String summary, String description, LocalDate created, LocalDate estimatedFinishDate) {
		this(summary, description, created, estimatedFinishDate);
		this.id = id;
	}

	public Todo(String summary, String description, LocalDate created, LocalDate estimatedFinishDate) {
		this();
		this.summary = summary;
		this.description = description;
		this.created = created;
		this.estimatedFinishDate = estimatedFinishDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public LocalDate getEstimatedFinishDate() {
		return estimatedFinishDate;
	}

	public void setEstimatedFinishDate(LocalDate estimatedFinishDate) {
		this.estimatedFinishDate = estimatedFinishDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
