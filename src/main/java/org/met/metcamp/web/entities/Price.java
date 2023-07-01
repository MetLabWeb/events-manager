package org.met.metcamp.web.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter @Setter
@ToString
@NoArgsConstructor
public class Price {
    private TicketType type;
    private Currency currency;
    private double value;
}
