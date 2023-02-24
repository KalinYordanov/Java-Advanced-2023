package RawData;

public class Engine {
    private int speed;
    private int power;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }
}
