package BehavioralPatterns.MediatorPattern;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Mediator auctionMediator = new AuctionMediator(new ArrayList<>());
        Bidder bidder1 = new Bidder(auctionMediator,"bidder1");
        Bidder bidder2 = new Bidder(auctionMediator,"bidder2");
        Bidder bidder3 = new Bidder(auctionMediator,"bidder3");
        bidder1.placeBid(200000);
        bidder2.placeBid(5000);
        bidder3.placeBid(4000);
    }
}
