package DefiningClassesExercises.SpeedRacing;

public class Car {
    private String name;
    private double fuelAmount;
    private double coastFuelPer1Km;
    private int distance;

    public Car(String name, double fuelAmount, double coastFuelPer1Km) {
        this.name = name;
        this.fuelAmount = fuelAmount;
        this.coastFuelPer1Km = coastFuelPer1Km;
        this.distance = 0;

    }

    public boolean drive(int kmDrive) {
        double needFuel = kmDrive * this.coastFuelPer1Km;
        if (needFuel <= this.fuelAmount) {
            this.fuelAmount -= needFuel;
            this.distance += kmDrive;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.name, this.fuelAmount, this.distance);

    }
}
