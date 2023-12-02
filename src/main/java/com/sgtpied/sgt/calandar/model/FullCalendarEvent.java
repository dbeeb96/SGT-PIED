package com.sgtpied.sgt.calandar.model;

import java.time.LocalDateTime;

public class FullCalendarEvent {
    private Long id;
    private String title;

    private String description;

    private LocalDateTime start;
    private LocalDateTime end;

    // Constructors, getters, and setters

    // Constructors
    public FullCalendarEvent() {
    }

    public FullCalendarEvent(Long id, String title, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }


    // ...
}
