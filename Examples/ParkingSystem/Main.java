package Examples.ParkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Examples.ParkingSystem.AllocationProcessStrategies.PriorityQueueAllocationStrategy;
import Examples.ParkingSystem.AllocationProcessStrategies.AllocationStrategy;
import Examples.ParkingSystem.Exceptions.NoSpotAvailableException;
import Examples.ParkingSystem.PaymentStrategies.PaymentDetails;
import Examples.ParkingSystem.PaymentStrategies.UPITransaction;
import Examples.ParkingSystem.StatePattern.Bill.Bill;
import Examples.ParkingSystem.StatePattern.Payment.Payment;
import Examples.ParkingSystem.StatePattern.Payment.RefundPayment;

public class Main {
    public static void main(String[] args) {
        List<EntryGate> entryGates = new ArrayList<>();
        // 4 Entry
        EntryGate entryGate1 = new EntryGate("1");
        EntryGate entryGate2 = new EntryGate("2");
        EntryGate entryGate3 = new EntryGate("3");
        EntryGate entryGate4 = new EntryGate("4");

        entryGates.addAll(List.of(entryGate1,entryGate2,entryGate3,entryGate4));

        // 4 Exit
        ExitGate exitGate1 = new ExitGate("1",entryGate1);
        ExitGate exitGate2 = new ExitGate("2",entryGate2);
        ExitGate exitGate3 = new ExitGate("3",entryGate3);
        ExitGate exitGate4 = new ExitGate("4",entryGate4);

        List<ParkingSpot> parkingSpots = new ArrayList<>();

        // Parking Spot 1 (CAR type)
        ParkingSpot spot1 = new ParkingSpot("Spot1",ParkingType.CAR);
        Map<String, Integer> entryWeightMap1 = new HashMap<>();
        entryWeightMap1.put("1", 5);
        entryWeightMap1.put("2", 3);
        entryWeightMap1.put("3", 5);
        entryWeightMap1.put("4", 3);
        spot1.setEntryWeightMap(entryWeightMap1);

        // Parking Spot 2 (BIKE type)
        ParkingSpot spot2 = new ParkingSpot("Spot2",ParkingType.TWO_WHEELER);
        Map<String, Integer> entryWeightMap2 = new HashMap<>();
        entryWeightMap2.put("1", 2);
        entryWeightMap2.put("2", 3);
        entryWeightMap2.put("3", 8);
        entryWeightMap2.put("4", 2);
        spot2.setEntryWeightMap(entryWeightMap2);

        // Parking Spot 3 (TRUCK type)
        ParkingSpot spot3 = new ParkingSpot("Spot3",ParkingType.TRUCK);
        Map<String, Integer> entryWeightMap3 = new HashMap<>();
        entryWeightMap3.put("1", 7);
        entryWeightMap3.put("2", 4);
        entryWeightMap3.put("3", 7);
        entryWeightMap3.put("4", 4);
        spot3.setEntryWeightMap(entryWeightMap3);

        // Parking Spot 4 (CAR type)
        ParkingSpot spot4 = new ParkingSpot("Spot4",ParkingType.CAR);
        Map<String, Integer> entryWeightMap4 = new HashMap<>();
        entryWeightMap4.put("1", 6);
        entryWeightMap4.put("2", 5);
        entryWeightMap4.put("3", 10);
        entryWeightMap4.put("4", 9);
        spot4.setEntryWeightMap(entryWeightMap4);

        // Add parking spots to the list
        parkingSpots.addAll(List.of(spot1, spot2, spot3, spot4));

        AllocationStrategy allocationStrategy = new PriorityQueueAllocationStrategy(entryGates,parkingSpots);
        // Car 1 enters at entry gate 1 spot 1 and 2 of Car park type is present with spot 1 with smaller distance
        try {
            Token token = entryGate1.process(ParkingType.CAR, "WB-548123", new Parker("Car 1", "1234567891"));
            System.out.println(token.toString());
            Token token1 = entryGate1.process(ParkingType.CAR, "WB-548124", new Parker("Car 2", "1234567892"));
            System.out.println(token1.toString());
            Token token2 = entryGate1.process(ParkingType.CAR, "WB-548125", new Parker("Car 3", "1234567893"));
            System.out.println(token2.toString());
//            Token token3 = entryGate1.process(ParkingType.CAR, "WB-548126", new Parker("Car 4", "1234567894"));
//            System.out.println(token3.toString());
            Thread.sleep(2000);
            ExitGate exitGate = entryGate1.getCorrespondingExitGate();
            // Client makes bill Payment
            Bill bill = exitGate.process(token);
            System.out.println(bill);
            Payment payment = new Payment(new UPITransaction(new PaymentDetails()),1.0,bill);
            payment.getState().transact();
            System.out.println(bill);
            RefundPayment refundPayment = new RefundPayment(new UPITransaction(new PaymentDetails()),1.0,bill);
            refundPayment.getState().transact();
            System.out.println(bill);
            System.out.println(refundPayment);
            refundPayment.getState().transact();
//            Bill bill1 = exitGate.process(token1);
//            System.out.println(bill1);
//            Bill bill2 = exitGate.process(token2);
//            System.out.println(bill2);
//            Bill bill3 = exitGate.process(token3);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NoSpotAvailableException exception) {
            System.out.println("No More Spots Available!!");
        }

    }
}
