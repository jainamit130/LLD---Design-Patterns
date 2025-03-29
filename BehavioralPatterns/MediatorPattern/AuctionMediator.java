package BehavioralPatterns.MediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements Mediator {
    private Integer bidAmount;
    private List<IBidder> bidderList;

    public AuctionMediator(List<Bidder> bidderList) {
        this.bidAmount = 0;
        this.bidderList = new ArrayList<>();
        this.bidderList.addAll(bidderList);
    }

    public void addBidder(Bidder bidder) {
        if(!bidderList.contains(bidder)) {
            bidderList.add(bidder);
        }
    }

    public void removeBidder(Bidder bidder) {
        if(bidderList.contains(bidder)) {
            bidderList.remove(bidder);
        }
    }

    @Override
    public void placeBid(Bidder bidder,Integer bidAmount) {
        this.bidAmount+=bidAmount;
        notifyBidders(bidder);
    }

    @Override
    public void notifyBidders(Bidder currentBidder) {
        for(IBidder bidder: this.bidderList) {
            if(!bidder.equals(currentBidder)) {
                bidder.receiveNotification(bidAmount);
            }
        }
    }
}
