package com.sgtpied.sgt.calandar.contoller;

import com.sgtpied.sgt.calandar.model.BadDateFormatException;
import com.sgtpied.sgt.calandar.model.Events;
import com.sgtpied.sgt.calandar.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
class EventController {

    @Autowired
    private EventsRepository eventRepository;

    @RequestMapping(value = "/allevents", method = RequestMethod.GET)
    public List<Events> allEvents() {
        return eventRepository.findAll();
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public Events addEvent(@RequestBody Events event) {
        Events created = (Events) eventRepository.save(event);
        return created;
    }

    @RequestMapping(value = "/Events", method = RequestMethod.PATCH)
    public Events updateEvent(@RequestBody Events event) {
        return (Events) eventRepository.save(event);
    }

    @RequestMapping(value = "/event", method = RequestMethod.DELETE)
    public void removeEvent(@RequestBody Events event) {
        eventRepository.delete(event);
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Events> getEventsInRange(@RequestParam(value = "start", required = true) String start,
                                                  @RequestParam(value = "end", required = true) String end) {
        Date startDate = null;
        Date endDate = null;
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDate = inputDateFormat.parse(start);
        } catch (ParseException e) {
            throw new BadDateFormatException("bad start date: " + start);
        }

        try {
            endDate = inputDateFormat.parse(end);
        } catch (ParseException e) {
            throw new BadDateFormatException("bad end date: " + end);
        }

        LocalDateTime startDateTime = LocalDateTime.ofInstant(startDate.toInstant(),
                ZoneId.systemDefault());

        LocalDateTime endDateTime = LocalDateTime.ofInstant(endDate.toInstant(),
                ZoneId.systemDefault());

        return eventRepository.findByDateBetween(startDateTime, endDateTime);
    }

}
