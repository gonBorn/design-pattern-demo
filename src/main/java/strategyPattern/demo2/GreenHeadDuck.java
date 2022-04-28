package strategyPattern.demo2;

public class GreenHeadDuck extends Duck implements Flyable {
    @Override
    void display() {
        System.out.println("green head");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
