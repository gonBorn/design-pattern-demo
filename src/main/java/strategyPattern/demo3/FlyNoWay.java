package strategyPattern.demo3;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("can not fly");
    }
}
