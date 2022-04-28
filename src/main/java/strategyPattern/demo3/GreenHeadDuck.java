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
}
