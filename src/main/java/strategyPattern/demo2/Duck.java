package strategyPattern.demo2;

public abstract class Duck {
    public void quack() {
        System.out.println("quack");
    }

    public void swim() {
        System.out.println("swim");
    }

    abstract void display();
}
