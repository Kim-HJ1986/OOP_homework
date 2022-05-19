import java.util.UUID;

public class Taxi extends Car implements PassengerBording, ChangeSpeed{
    private String destination;
    private long defaultDistance;
    private long toDestinationDistance;
    private long defaultFee;
    private long perDistanceFee;

    private int onBoardCnt;
    private int leftOverCnt;
    private long accumulateFee;

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

    public long getAccumulateFee() {
        return accumulateFee;
    }

    public void setAccumulateFee(long accumulateFee) {
        this.accumulateFee = accumulateFee;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getDefaultDistance() {
        return defaultDistance;
    }

    public void setDefaultDistance(long defaultDistance) {
        this.defaultDistance = defaultDistance;
    }

    public long getToDestinationDistance() {
        return toDestinationDistance;
    }

    public void setToDestinationDistance(long toDestinationDistance) {
        this.toDestinationDistance = toDestinationDistance;
        if (getOnBoardCnt() != 0){
            addFee();
        }
    }

    public long getDefaultFee() {
        return defaultFee;
    }

    public void setDefaultFee(long defaultFee) {
        this.defaultFee = defaultFee;
    }

    public long getPerDistanceFee() {
        return perDistanceFee;
    }

    public void setPerDistanceFee(long perDistanceFee) {
        this.perDistanceFee = perDistanceFee;
    }

    public Taxi() {
        super(UUID.randomUUID().toString(), 100, 0, Status.NORMAL, 4);
        setDefaultFee(3000);
        setDefaultDistance(1);
        setPerDistanceFee(1000);
        setLeftOverCnt(4);
    }

    @Override
    public String toString() {
        if(getGasAmount() == 0){
            return "주유가 필요합니다." + "Taxi{" +
                    "택시번호=" + getCarNum() +
                    ", 탑승 승객 수=" + onBoardCnt +
                    ", 잔여 승객 수=" + leftOverCnt +
                    ", 기본요금 확인=" + defaultFee +
                    ", 목적지='" + destination + '\'' +
                    ", 목적지 까지 거리=" + toDestinationDistance +
                    ", 지불할 요금=" + getPrice() +
                    ", 상태=" + getStatus() +
                    ", 현재속도=" + getCurrentSpeed() +
                    ", 누적요금=" + getAccumulateFee() +
                    ", 주유량=" + getGasAmount() +
                    '}';
        }
        return "Taxi{" +
                "택시번호=" + getCarNum() +
                ", 탑승 승객 수=" + onBoardCnt +
                ", 잔여 승객 수=" + leftOverCnt +
                ", 기본요금 확인=" + defaultFee +
                ", 목적지='" + destination + '\'' +
                ", 목적지 까지 거리=" + toDestinationDistance +
                ", 지불할 요금=" + getPrice() +
                ", 상태=" + getStatus() +
                ", 현재속도=" + getCurrentSpeed() +
                ", 누적요금=" + getAccumulateFee() +
                ", 주유량=" + getGasAmount() +
                '}';
    }

    public void startDrive(){
        if(getGasAmount() < 10){
            System.out.println("주유량이 부족합니다. 주유해주세요.");
        }else {
            System.out.println("운행 가능합니다. 안전벨트를 매주세요");
        }
    }

    public void addFee(){
        if(getToDestinationDistance() < getDefaultDistance()){
            System.out.println("추가요금이 없습니다.");
        }else{
            setPrice(((getToDestinationDistance() - getDefaultDistance()) * getPerDistanceFee()) + getDefaultFee());

            System.out.println("추가 요금은 " + ((getToDestinationDistance() - getDefaultDistance()) * getPerDistanceFee()) +"원 입니다.");
        }
    }

    public void payFee(){
        setAccumulateFee(getAccumulateFee() + getPrice());
        setOnBoardCnt(0);
        setLeftOverCnt(4);
        setDestination(null);
        setToDestinationDistance(0);
        setPrice(0);
        setStatus(Status.NORMAL);
    }

    public void printFinalFee(){
        System.out.println("전체 요금은 "+ getPrice() + "원 입니다.");
    }

    @Override
    public void changeSpeed(long changeSpeedAmount) {
        setCurrentSpeed(changeSpeedAmount);
        System.out.println("현재 속도는" + getCurrentSpeed() + " 입니다.");
    }

    @Override
    public void passengerBoarding(int passengerCnt) {
        if(getStatus() != Status.NORMAL){
            System.out.println("탑승 가능한 상태가 아닙니다. 다음 택시를 이용하세요!");
        }else if(passengerCnt > getMaxCnt()){
            System.out.println("최대 승객 수 초과!!");
        }else{
            System.out.println(passengerCnt + "명의 손님이 탑승했습니다. 운행을 시작합니다.");
            setOnBoardCnt(passengerCnt);
            setLeftOverCnt(getMaxCnt() - getOnBoardCnt());
            setStatus(Status.DRIVE);
        }
    }
}
