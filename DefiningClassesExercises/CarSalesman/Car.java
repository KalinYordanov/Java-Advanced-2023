package DefiningClassesExercises.CarSalesman;

public class Car {

    private String model;

    private Engine engine;

    private int weight;

    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //"{CarModel}:
        stringBuilder.append(this.model).append(":").append(System.lineSeparator());
        //{EngineModel}:
        stringBuilder.append(this.engine.getModel()).append(":").append(System.lineSeparator());
        //Power: {EnginePower}
        stringBuilder.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());
        //Displacement: {EngineDisplacement}
        stringBuilder.append("Displacement: ");
        if (this.engine.getDisplacement() == 0){
            stringBuilder.append("n/a").append(System.lineSeparator());
        }else {
            stringBuilder.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }
        //Efficiency: {EngineEfficiency}
        stringBuilder.append("Efficiency: ");
        if (this.engine.getEfficiency() == null){
            stringBuilder.append("n/a").append(System.lineSeparator());
        }else {
            stringBuilder.append(this.engine.getEfficiency()).append(System.lineSeparator());
        }
        //Weight: {CarWeight}
        stringBuilder.append("Weight: ");
        if (this.weight == 0){
            stringBuilder.append("n/a").append(System.lineSeparator());
        }else {
            stringBuilder.append(this.weight).append(System.lineSeparator());
        }
        //Color: {CarColor}"
        stringBuilder.append("Color: ");
        if (this.color == null){
            stringBuilder.append("n/a").append(System.lineSeparator());
        }else {
            stringBuilder.append(this.color).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
