import java.util.UUID;

public class Bus extends Car implements PassengerBording, ChangeSpeed{
    private int onBoardCnt;
    private int leftOverCnt;
    private long accumulateFee;

    public Bus(){
        super(30, 0, 1000, UUID.randomUUID().toString(), 100, 0, Status.DRIVE);
    }

    public long getAccumulateFee() {
        return accumulateFee;
    }

    public void setAccumulateFee(long accumulateFee) {
        this.accumulateFee = accumulateFee;
    }

    public int getOnBoardCnt() {
        return onBoardCnt;
    }

    public void setOnBoardCnt(int onBoardCnt) {
        this.onBoardCnt = onBoardCnt;
    }

    public int getLeftOverCnt() {
        return leftOverCnt;
    }

    public void setLeftOverCnt(int leftOverCnt) {
        this.leftOverCnt = leftOverCnt;
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
                setOnBoardCnt(passengerCnt);
                setLeftOverCnt(getMaxCnt() - getOnBoardCnt());
                setAccumulateFee(getAccumulateFee() + (getPrice()*passengerCnt));
                System.out.println(passengerCnt + "명이 탑승하여 현재 " + getOnBoardCnt() + "명 입니다.");
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

    @Override
    public String toString() {
        return "Bus{" +
                "최대 승객 수=" + getMaxCnt() +
                ", 탑승 승객 수=" + getOnBoardCnt() +
                ", 잔여 승객 수=" + getLeftOverCnt() +
                ", 누적 요금=" + getAccumulateFee() +
                ", 버스 번호='" + getCarNum() + '\'' +
                ", 주유량=" + getGasAmount() +
                ", 현재 속도=" + getCurrentSpeed() +
                ", 상태=" + getStatus() +
                '}';
    }
}
