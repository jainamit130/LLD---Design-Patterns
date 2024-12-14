package BehavioralPatterns.MediatorPattern;

public interface Mediator {
    void placeBid(Bidder bidder,Integer bidAmount);
    void addBidder(Bidder bidder);
    void removeBidder(Bidder bidder);
    void notifyBidders(Bidder currentBidder);
}
