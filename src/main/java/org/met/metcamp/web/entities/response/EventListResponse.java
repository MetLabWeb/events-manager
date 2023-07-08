package org.met.metcamp.web.entities.response;

import lombok.Getter;
import lombok.Setter;
import org.met.metcamp.web.entities.model.Event;

import java.util.ArrayList;

@Getter
@Setter
public class EventListResponse extends Response{
    private ArrayList<Event> events;

    public EventListResponse(int code, String message, ArrayList<Event> events) {
        super(code, message);
        this.events = events;
    }
}
