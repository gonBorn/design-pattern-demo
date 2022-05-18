package strategyPattern.demo3;

import lombok.Setter;

@Setter
public abstract class Duck {
    protected FlyBehavior flyBehavior;

    protected void quack() {
        System.out.println("quack");
    }

    public void swim() {
        System.out.println("swim");
    }

    abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }
}
