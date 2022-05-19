public abstract class Car {
    // 필드를 전부 private으로 제어하여 외부에서 필드 값을 바꾸지 못하게 막는다.
    // Getter Setter만 public으로 제공하여 접근 가능하게 한다!
    private int maxCnt;
    private int currentCnt;
    private long price;
    private String carNum;
    private long gasAmount;
    private long currentSpeed;
    private Status status;

    //Getter Setter 변경!


    public void setMaxCnt(int maxCnt) {
        this.maxCnt = maxCnt;
    }

    public int getCurrentCnt() {
        return currentCnt;
    }

    public void setCurrentCnt(int passengerCnt) {
        this.currentCnt += passengerCnt;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(long gasAmount) {
        this.gasAmount += gasAmount;
        if ( getGasAmount() <= 10){
            setStatus(Status.TOGARAGE);
            System.out.println("주유가 필요합니다.");
        }
    }

    public long getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(long changeSpeedAmount) {
        this.currentSpeed += changeSpeedAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMaxCnt() {
        return maxCnt;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public Car(int maxCnt, int currentCnt, long price, String carNum, long gasAmount, long currentSpeed, Status status) {
        setMaxCnt(maxCnt);
        setCurrentCnt(currentCnt);
        setPrice(price);
        setCarNum(carNum);
        setGasAmount(gasAmount);
        setCurrentSpeed(currentSpeed);
        setStatus(status);
    }

    public Car(String carNum, long gasAmount, long currentSpeed, Status status, int maxCnt){
        setCarNum(carNum);
        setGasAmount(gasAmount);
        setCurrentSpeed(currentSpeed);
        setStatus(status);
        setMaxCnt(maxCnt);
    }
}
