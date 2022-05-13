public abstract class Car {
    int maxCnt;
    int currentCnt;
    long price;
    String carNum;
    long gasAmount;
    long currentSpeed;
    Status status;


    public Car(int maxCnt, int currentCnt, long price, String carNum, long gasAmount, long currentSpeed, Status status) {
        this.maxCnt = maxCnt;
        this.currentCnt = currentCnt;
        this.price = price;
        this.carNum = carNum;
        this.gasAmount = gasAmount;
        this.currentSpeed = currentSpeed;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car{" +
                "maxCnt=" + maxCnt +
                ", currentCnt=" + currentCnt +
                ", price=" + price +
                ", carNum='" + carNum + '\'' +
                ", gasAmount=" + gasAmount +
                ", currentSpeed=" + currentSpeed +
                ", status=" + status +
                '}';
    }
}
