package strategyPattern.demo3;

import java.util.ArrayList;
import java.util.List;

public class GreenHeadDuck extends Duck {
    @Override
    void display() {
        System.out.println("green head");
    }

    public GreenHeadDuck() {
        this.flyBehavior = new FlyWithWings();
    }

    public static void main(String[] args) {
        GreenHeadDuck greenHeadDuck = new GreenHeadDuck();
        System.out.println("### arg is " + args[0]);
        if (Integer.parseInt(args[0])%2 == 0) {
            // then we can change duck's behavior at runtime
            greenHeadDuck.setFlyBehavior(new FlyNoWay());
        }
        greenHeadDuck.performFly();
    }
}
