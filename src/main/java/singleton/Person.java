package singleton;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Person {
    private boolean isA;

    private boolean hasA;

    private int B;

    public Person(boolean isA) {
        this.isA = isA;
    }

    public static void main(String[] args) {
        System.out.println(new Person(true).isA());
        System.out.println(new Person(true).isHasA());
        System.out.println(new Person(true).getB());
    }


}
