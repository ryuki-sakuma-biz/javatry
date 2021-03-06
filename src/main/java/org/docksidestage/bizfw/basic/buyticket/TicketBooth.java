/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

// TODO sakuma javadocにauthorをお願いしますー by jflute (2020/04/23)
/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    public static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    // TODO sakuma 細かいけど、空白が多い？？？ by jflute (2020/04/23)
    public static final int TWO_DAY_PRICE =  13200;
    public static final int FOUR_DAY_PRICE =  22400;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    // TODO sakuma このコメントアウトはなんでしょう？ (残すコメントアウトにはコメントを) by jflute (2020/04/23)
//    public void buyOneDayPassport(int handedMoney) {
//        int change = buyPassport(handedMoney, ONE_DAY_PRICE);
//    }

    public TicketBuyResult buyOneDayPassport(int handedMoney) {
        return new TicketBuyResult(buyPassport(handedMoney, ONE_DAY_PRICE), new OneDayPassport(ONE_DAY_PRICE));
    }

    public TicketBuyResult buyTwoDayPassport(int handedMoney) {
        return new TicketBuyResult(buyPassport(handedMoney, TWO_DAY_PRICE), new TwoDayPassport(TWO_DAY_PRICE));
    }

    public TicketBuyResult buyFourDayPassport(int handedMoney) {
        return new TicketBuyResult(buyPassport(handedMoney, FOUR_DAY_PRICE), new FourDayPassport(FOUR_DAY_PRICE));
    }

    // TODO sakuma privateメソッドの方は、doBuy というように名前を変える習慣があります。(doじゃないときもあるけど) by jflute (2020/04/23)
    // publicのbuyとprivateのbuyでメソッド補完で紛らわしかったりするってのもあるし、「実処理だよ」って意味合いで doBuy とか。
    private int buyPassport(int handedMoney, int passportPrice) {
        if (quantity < 1) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < passportPrice) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        --quantity;
        if (salesProceeds != null) {
            salesProceeds += passportPrice;
        } else {
            salesProceeds = passportPrice;
        }
        return handedMoney - passportPrice;
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
