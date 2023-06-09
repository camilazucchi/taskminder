package model;

import java.util.Date;

public class Task {

    private int id;
    private int idProject;
    private String name;
    private String description;
    private boolean isCompleted;
    private String notes;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idProject, String name, String description, boolean isCompleted, String notes, Date deadline, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.isCompleted = isCompleted;
        this.notes = notes;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.deadline = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return new Date(deadline.getTime());
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return new Date(createdAt.getTime());
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return new Date(updatedAt.getTime());
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
