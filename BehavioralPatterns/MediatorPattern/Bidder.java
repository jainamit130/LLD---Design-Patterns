package BehavioralPatterns.MediatorPattern;

public class Bidder {
    private Mediator auctionMediator;
    private Integer bidAmount;
    private String name;

    public Bidder(Mediator auctionMediator,String name) {
        this.bidAmount = 0;
        this.name = name;
        this.auctionMediator = auctionMediator;
        auctionMediator.addBidder(this);
    }

    public String getName() {
        return this.name;
    }

    public void placeBid(Integer bidAmount) {
        if(bidAmount<0 || bidAmount<5000) {
            System.out.println("Invalid Bid: "+bidAmount);
            return;
        }
        auctionMediator.placeBid(this,bidAmount);
    }

    public void receiveNotification(Integer currentBidAmount) {
        this.bidAmount = currentBidAmount;
        System.out.println("Bidder: "+this.name+" received notification of the updated current bit Amount as : "+bidAmount);
    }
}
