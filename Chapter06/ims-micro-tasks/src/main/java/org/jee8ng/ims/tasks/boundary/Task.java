package org.jee8ng.ims.tasks.boundary;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Task {

    private Long id;
    @NotNull
    @Size(min = 1, max = 16, message = "name must be between 1 to 16 characters")
    private String name;
    private String description;
//	private Priority priority = Priority.Medium;

//	enum Priority { High, Medium }
    public Task() {
    }

    public Task(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

//	public Priority getPriority() {
//		return priority;
//	}
//
//	public void setPriority(Priority priority) {
//		this.priority = priority;
//	}
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", name=" + name + ", description=" + description + "]";
//				+ ", priority=" + priority + "]";
    }

}
