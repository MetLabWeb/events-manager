package org.met.metcamp.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.met.metcamp.web.entities.model.Event;
import org.met.metcamp.web.entities.response.EventResponse;
import org.met.metcamp.web.entities.response.Response;

import java.util.ArrayList;
import java.util.Optional;

public class EventService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final ArrayList<Event> events;

    public EventService() {
        this.events = new ArrayList<>();
    }

    private Optional<Event> findEventById(int id) {
        Optional<Event> result = Optional.empty();
        for (Event e: events) {
            if (e.getId() == id) {
               result = Optional.of(e);
            }
        }
        return result;
    }

    //Arreglaremos este método en la próxima clase
    public void createEvent(String json) throws JsonProcessingException {
        Event event = MAPPER.readValue(json, Event.class);
        events.add(event);
    }

    public ArrayList<Event> getAllEvents() {
        return events;
    }

    //este métiodo ya quedó alineado a la nueva estructura
    public Response getEventById(int id) {
        Optional<Event> foundEvent = findEventById(id);
        return foundEvent.isPresent()
                ? new EventResponse(200, "OK", foundEvent.get())
                : new Response(404, "Event Not Found");
    }

    //Arreglaremos este método en la próxima clase
    public void updateEvent(int id, String json) throws JsonProcessingException {
        Event newEventData = MAPPER.readValue(json, Event.class);
        Optional<Event> foundEvent = findEventById(id);
        if (foundEvent.isPresent()) {
            foundEvent.get().update(newEventData);
        }
        //otra forma de hacer lo mismo: foundEvent.ifPresent(event -> event.update(newEventData));
    }

    //Arreglaremos este método en la próxima clase
    public void deleteEvent(int id) {
        Optional<Event> foundEvent = findEventById(id);
        if (foundEvent.isPresent()) {
            events.remove(foundEvent.get());
        }
        //otr forma de hacer lo mismo: foundEvent.ifPresent(events::remove);
    }
}
