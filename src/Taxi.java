import java.util.UUID;

public class Taxi extends Car implements PassengerBording, ChangeSpeed{
    private String destination;
    private long defaultDistance;
    private long toDestinationDistance;
    private long defaultFee;
    private long perDistanceFee;

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

    public Taxi(long gasAmount) {
        super(UUID.randomUUID().toString(), gasAmount, 0, Status.NORMAL);
        setDefaultFee(3200);
        setDefaultDistance(100);
        setPerDistanceFee(200);
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "destination='" + destination + '\'' +
                ", defaultDistance=" + defaultDistance +
                ", toDestinationDistance=" + toDestinationDistance +
                ", defaultFee=" + defaultFee +
                ", perDistanceFee=" + perDistanceFee +
                ", price=" + getPrice() +
                ", carNum=" + getCarNum() +
                ", status=" + getStatus() +
                ", curSpeed=" + getCurrentSpeed() +
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
            setPrice((getToDestinationDistance() - getDefaultDistance()) * getPerDistanceFee());
            System.out.println("추가 요금은 " + (getPrice() - getDefaultFee()) +"원 입니다.");
        }
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
        }else{
            System.out.println(passengerCnt + "명의 손님이 탑승했습니다. 운행을 시작합니다.");
            setStatus(Status.DRIVE);
        }
    }
}
