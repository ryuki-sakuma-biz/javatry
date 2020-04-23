package org.docksidestage.bizfw.basic.buyticket;

public class TwoDayPassport implements Ticket{
    private final int displayPrice;
    private boolean alreadyIn;
    private int countOfInPark = 0;

    public TwoDayPassport(int displayPrice) {
        this.displayPrice = displayPrice;
    }

    @Override
    public void doInPark() {
        if (alreadyIn) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        if (countOfInPark >= 2) {
            throw new IllegalStateException("you can't enter the park");
        }
        countOfInPark++;
        alreadyIn = true;
    }

    public void doGetOutPark() {
        if (!alreadyIn) {
            throw new IllegalStateException("Already got out the park");
        }
        alreadyIn = false;
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
