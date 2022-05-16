import java.util.UUID;

public class Bus extends Car implements PassengerBording, ChangeSpeed{

    public Bus(int maxCnt, long price, long gasAmount, long currentSpeed){
        super(maxCnt, 0, price, UUID.randomUUID().toString(), gasAmount, currentSpeed, Status.DRIVE);
    }

    public void reduceGasAmount(int amount){
        setGasAmount(-amount);
        System.out.println("현재 주유량은: " + getGasAmount());
    }

    public void changeBusStatus(boolean EndDrive) {
        if( getGasAmount() <= 0 ){
            setStatus(Status.TOGARAGE);
            setCurrentSpeed(-getCurrentSpeed());
            System.out.println("주유량이 부족하여 차고지행으로 변경됩니다.");
        }else if ( getGasAmount()< 10 ){
            System.out.println("주유가 필요합니다!!!");
        }

        if (EndDrive){
            setStatus(Status.TOGARAGE);
            System.out.println("차고지행으로 변경되었습니다.");
        }
    }

    public void passengerBoarding(int passengerCnt){
        if (getStatus() == Status.TOGARAGE){
            System.out.println("현재 버스는 운행중이 아닙니다.");
        }else{
            if (getMaxCnt() < getCurrentCnt() + passengerCnt) {
                System.out.println("정원 초과입니다. 다음 버스를 탑승하세요");
            }else{
                setCurrentCnt(passengerCnt);
                System.out.println(passengerCnt + "명이 탑승하여 현재 " + getCurrentCnt() + "명 입니다.");
            }
        }
    }

    public void changeSpeed(long changeSpeedAmount){
        System.out.println(this.toString());

        if( getGasAmount() <10){
            System.out.println("쥬유량을 확인해주세요.");
        }else{
            setCurrentSpeed(changeSpeedAmount);
            System.out.println("현재 속도는 " + getCurrentSpeed());
        }
    }


}
