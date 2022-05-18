import java.util.UUID;

public class Main {
    public static void main(String[] args){
        Bus bus = new Bus();
        Taxi taxi = new Taxi();
        Taxi taxi2 = new Taxi();

        //((PassengerBording) bus).passengerBoarding(10);
        bus.passengerBoarding(10);
        bus.changeSpeed(10);
        bus.changeBusStatus(false);
        bus.reduceGasAmount(15);
        bus.passengerBoarding(10);
        bus.passengerBoarding(1);
        bus.reduceGasAmount(15);
        bus.changeBusStatus(false);
        bus.passengerBoarding(1);
        System.out.println(bus.toString());
        System.out.println("============================================");

        System.out.println(taxi.toString());
        taxi.startDrive();
        taxi.passengerBoarding(2);
        taxi.setDestination("구디");
        taxi.setToDestinationDistance(128);
        taxi.changeSpeed(60);
        taxi.addFee();
        taxi.printFinalFee();
        System.out.println(taxi.toString());
        System.out.println("============================================");

        System.out.println(taxi2.toString());
        //
        taxi2.startDrive();
    }
}
