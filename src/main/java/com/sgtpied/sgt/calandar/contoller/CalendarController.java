package com.sgtpied.sgt.calandar.contoller;

import com.sgtpied.sgt.calandar.model.FullCalendarEvent;
import com.sgtpied.sgt.taches.models.Task;
import com.sgtpied.sgt.taches.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CalendarController {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/events", produces = "application/json")
    @ResponseBody
    public List<FullCalendarEvent> getEvents() {
        List<Task> tasks = taskService.getAllTasks();
        return convertTasksToFullCalendarEvents(tasks);
    }

    private List<FullCalendarEvent> convertTasksToFullCalendarEvents(List<Task> tasks) {
        List<FullCalendarEvent> events = new ArrayList<>();

        for (Task task : tasks) {
            FullCalendarEvent event = new FullCalendarEvent();
            event.setId(Long.valueOf(String.valueOf(task.getId())));
            event.setTitle(task.getTitle());
            event.setDescription(task.getDescription());

            // Convert LocalDate to LocalDateTime by adding a default time (e.g., midnight)
            LocalDateTime startDateTime = task.getStartDate().atStartOfDay();
            LocalDateTime endDateTime = task.getEndDate().atStartOfDay().plusDays(1); // Assuming the end date is inclusive

            event.setStart(startDateTime);
            event.setEnd(endDateTime);

            events.add(event);
        }

        return events;
    }

}
