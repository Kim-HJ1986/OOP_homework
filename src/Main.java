import java.util.UUID;

public class Main {
    public static void main(String[] args){
        Bus bus = new Bus();
        Bus bus2 = new Bus();
        Taxi taxi = new Taxi();
        Taxi taxi2 = new Taxi();

        System.out.println(bus);
        System.out.println(bus2);
        bus.passengerBoarding(2);
        bus.setGasAmount(-50);
        System.out.println(bus);
        bus.setStatus(Status.TOGARAGE);
        bus.setGasAmount(10);
        System.out.println(bus);
        bus.setStatus(Status.DRIVE);
        bus.passengerBoarding(45);
        bus.passengerBoarding(5);
        System.out.println(bus);
        // 주유량 -55 해야 10이하임
        bus.setGasAmount(-55);
        System.out.println(bus);
        System.out.println("============================================");

        System.out.println(taxi);
        System.out.println(taxi2);
        taxi.startDrive();
        taxi.passengerBoarding(2);
        taxi.setDestination("서울역");
        taxi.setToDestinationDistance(2);
        System.out.println(taxi);
        taxi.setGasAmount(-80);
        taxi.payFee();
        System.out.println(taxi);
        taxi.passengerBoarding(5);
        taxi.passengerBoarding(3);
        taxi.setDestination("구로디지털단지역");
        taxi.setToDestinationDistance(12);
        // 지불할 요금은 14000원 아닌가요??
        System.out.println(taxi);
        taxi.setGasAmount(-20);
        taxi.payFee();
        System.out.println(taxi);
    }
}
