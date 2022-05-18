package strategyPattern.demo2;


public class RedHeadDuck extends Duck implements Flyable {
    @Override
    void display() {
        System.out.println("red head");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
