package br.com.qwasolucoes.todo.controller.model;

import java.time.LocalDate;

public class TodoItem {

	private Integer id;
	private String summary;
	private String description;
	private LocalDate created;
	private LocalDate estimatedFinishDate;
	private boolean done;
	
	public TodoItem() {
		super();
	}

	public TodoItem(Integer id, String summary, String description, LocalDate created, LocalDate estimatedFinishDate, boolean done) {
		this(summary, description, created, estimatedFinishDate, done);
		this.id = id;
	}

	public TodoItem(String summary, String description, LocalDate created, LocalDate estimatedFinishDate, boolean done) {
		super();
		this.summary = summary;
		this.description = description;
		this.created = created;
		this.estimatedFinishDate = estimatedFinishDate;
		this.done = done;
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
