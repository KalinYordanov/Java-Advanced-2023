package Google;

public class Child {
    private String name;
    private String dataOfBirth;

    public Child(String name, String dataOfBirth) {
        this.name = name;
        this.dataOfBirth = dataOfBirth;

    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.dataOfBirth);
    }
}
