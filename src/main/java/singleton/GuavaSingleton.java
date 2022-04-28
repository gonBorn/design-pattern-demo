package singleton;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

public class GuavaSingleton {
    //Depending on whether the method's return value exists in memory,
    // the get method will either return the in-memory value or execute the memoized method and pass the return value to the caller.
    public static void main(String[] args) {

        Supplier<Person> memoize = Suppliers.memoize(Person::new);

        for (int i = 0; i < 10; i++) {
            System.out.println(memoize.get());
        }
    }

}
