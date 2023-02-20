package kindergarten;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry = new ArrayList<>();
    }

    public boolean addChild(Child child) {
        if (registry.size() < capacity) {
            registry.add(child);
            return true;
        }
        return false;
    }

    public boolean removeChild(String firstName) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(firstName)) {
                this.registry.remove(child);
                return true;
            }
        }
        return false;
    }

    public int getChildrenCount() {
        return registry.size();
    }

    public Child getChild(String name) {
        for (Child child : this.registry) {
            if (child.getFirstName().equals(name)) {
                return child;
            }
        }
        return null;
    }

    public String registryReport() {
        Collections.sort(registry, Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));

        StringBuilder report = new StringBuilder();
        report.append("Registered children in ").append(this.name).append(":").append(System.lineSeparator());

        for (Child child : this.registry) {
            report.append("--").append(System.lineSeparator());
            report.append(child).append(System.lineSeparator());
        }
        // return the report string
        return report.toString();
    }
}

