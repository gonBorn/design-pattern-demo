package strategyPattern.demo2;

import java.io.Serializable;

public class GreenHeadDuck extends Duck implements Flyable, Serializable, Cloneable {
    @Override
    void display() {
        System.out.println("green head");
    }

    @Override
    public void fly() {
        // cannot be reused
        // probably need to be changed in many places, for example we want to change it to "fly fast"
        // many duplicated codes if many subclasses need to implement Flyable interface, and they have same behavior
        System.out.println("fly");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
