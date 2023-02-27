package tuple;

public class Tuple<F, S, T> {
    private F first;
    private S second;
    private T third;

    public Tuple(F first, S second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }

    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", first.toString(), second.toString(),third.toString());
    }
}
