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
            return "????????? ???????????????." + "Taxi{" +
                    "????????????=" + getCarNum() +
                    ", ?????? ?????? ???=" + onBoardCnt +
                    ", ?????? ?????? ???=" + leftOverCnt +
                    ", ???????????? ??????=" + defaultFee +
                    ", ?????????='" + destination + '\'' +
                    ", ????????? ?????? ??????=" + toDestinationDistance +
                    ", ????????? ??????=" + getPrice() +
                    ", ??????=" + getStatus() +
                    ", ????????????=" + getCurrentSpeed() +
                    ", ????????????=" + getAccumulateFee() +
                    ", ?????????=" + getGasAmount() +
                    '}';
        }
        return "Taxi{" +
                "????????????=" + getCarNum() +
                ", ?????? ?????? ???=" + onBoardCnt +
                ", ?????? ?????? ???=" + leftOverCnt +
                ", ???????????? ??????=" + defaultFee +
                ", ?????????='" + destination + '\'' +
                ", ????????? ?????? ??????=" + toDestinationDistance +
                ", ????????? ??????=" + getPrice() +
                ", ??????=" + getStatus() +
                ", ????????????=" + getCurrentSpeed() +
                ", ????????????=" + getAccumulateFee() +
                ", ?????????=" + getGasAmount() +
                '}';
    }

    public void startDrive(){
        if(getGasAmount() < 10){
            System.out.println("???????????? ???????????????. ??????????????????.");
        }else {
            System.out.println("?????? ???????????????. ??????????????? ????????????");
        }
    }

    public void addFee(){
        if(getToDestinationDistance() < getDefaultDistance()){
            System.out.println("??????????????? ????????????.");
        }else{
            setPrice(((getToDestinationDistance() - getDefaultDistance()) * getPerDistanceFee()) + getDefaultFee());

            System.out.println("?????? ????????? " + ((getToDestinationDistance() - getDefaultDistance()) * getPerDistanceFee()) +"??? ?????????.");
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
        System.out.println("?????? ????????? "+ getPrice() + "??? ?????????.");
    }

    @Override
    public void changeSpeed(long changeSpeedAmount) {
        setCurrentSpeed(changeSpeedAmount);
        System.out.println("?????? ?????????" + getCurrentSpeed() + " ?????????.");
    }

    @Override
    public void passengerBoarding(int passengerCnt) {
        if(getStatus() != Status.NORMAL){
            System.out.println("?????? ????????? ????????? ????????????. ?????? ????????? ???????????????!");
        }else if(passengerCnt > getMaxCnt()){
            System.out.println("?????? ?????? ??? ??????!!");
        }else{
            System.out.println(passengerCnt + "?????? ????????? ??????????????????. ????????? ???????????????.");
            setOnBoardCnt(passengerCnt);
            setLeftOverCnt(getMaxCnt() - getOnBoardCnt());
            setStatus(Status.DRIVE);
        }
    }
}
