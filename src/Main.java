import java.util.UUID;

public class Main {
    public static void main(String[] args){
        Bus bus = new Bus(20, 1250, UUID.randomUUID().toString(), 30, 0);

        //((PassengerBording) bus).passengerBoarding(10);
        bus.passengerBoarding(10);
        bus.changeSpeed(10);
        bus.changeBusStatus(false);
        bus.reduceGasAmount(15);
        bus.passengerBoarding(10);
        bus.passengerBoarding(1);
        bus.reduceGasAmount(15);
        bus.changeBusStatus(false);
        System.out.println(bus.toString());

//        출력 결과!
//        10명이 탑승하여 현재 10명 입니다.
//        Car{maxCnt=20, currentCnt=10, price=1250, carNum='d1da6703-3547-4c7b-afde-e7d5bbcf0f75', gasAmount=30, currentSpeed=0, status=DRIVE}
//        현재 속도는 10
//        현재 주유량은: 15
//        10명이 탑승하여 현재 20명 입니다.
//        정원 초과입니다. 다음 버스를 탑승하세요
//        현재 주유량은: 0
//        주유량이 부족하여 차고지행으로 변경됩니다.
//        Car{maxCnt=20, currentCnt=20, price=1250, carNum='d1da6703-3547-4c7b-afde-e7d5bbcf0f75', gasAmount=0, currentSpeed=10, status=TOGARAGE}

    }
}
