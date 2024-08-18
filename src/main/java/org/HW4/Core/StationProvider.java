package org.HW4.Core;

import org.HW4.Models.Ticket;

public class StationProvider {
    private final TicketProvider ticketProvider;

    public StationProvider(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    /**
     * Проверка билета ит пропуск в автобус
     * @param ticket билет
     * @return true - если билет действительный
     */
    public boolean checkTicket(Ticket ticket) {
        if (ticket.isValid()) {
            ticketProvider.updateTicketStatus(ticket);
            return true;
        } else
            throw new RuntimeException("Ticket is not valid");

    }

}
