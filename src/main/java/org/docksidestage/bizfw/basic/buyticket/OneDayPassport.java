package org.docksidestage.bizfw.basic.buyticket;

public class OneDayPassport implements Ticket {
    private final int displayPrice;
    private boolean alreadyIn;
    public OneDayPassport(int displayPrice) {
        this.displayPrice = displayPrice;
    }

    @Override
    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        alreadyIn = true;
    }
    @Override
    public int getDisplayPrice() {
        return this.displayPrice;
    }

    @Override
    public boolean isAlreadyIn() {
        return this.alreadyIn;
    }
}
