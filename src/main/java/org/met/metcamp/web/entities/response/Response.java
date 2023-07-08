package org.met.metcamp.web.entities.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Response extends Object {
    private int code;
    private String message;

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("{\"code\": %s, \"message\": \"%s\"}", code, message);
    }
}
