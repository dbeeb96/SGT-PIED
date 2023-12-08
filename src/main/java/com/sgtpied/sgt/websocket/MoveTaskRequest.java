package com.sgtpied.sgt.taches.websocket;

public class MoveTaskRequest {
    private Long taskId;
    private String newStatus;

    // Constructors, getters, and setters

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
}
