package org.met.metcamp.web.entities.response;

import lombok.Getter;
import lombok.Setter;
import org.met.metcamp.web.entities.model.Event;

@Getter
@Setter
public class EventResponse extends Response {
    private Event event;

    public EventResponse(int code, String message, Event event) {
        super(code, message);
        this.event = event;
    }
}
