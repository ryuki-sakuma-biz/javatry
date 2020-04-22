package org.docksidestage.bizfw.basic.buyticket;

public class TicketBuyResult {
    private final int change;
    private final Ticket ticket;

    public TicketBuyResult(int change, Ticket ticket) {
        this.change = change;
        this.ticket = ticket;
    }

    public int getChange() {
        return change;
    }

    public Ticket getTicket() {
        return ticket;
    }
}
