package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PreventFromSerializationSingleton implements Serializable {
    private PreventFromSerializationSingleton() {
    }

    private static final PreventFromSerializationSingleton instance = new PreventFromSerializationSingleton();

    public static PreventFromSerializationSingleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }

    public static void main(String[] args) {
        PreventFromSerializationSingleton instance = PreventFromSerializationSingleton.getInstance();
        PreventFromSerializationSingleton instance2 = null;

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("PreventFromSerialization.obj"))) {
            outputStream.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("PreventFromSerialization.obj"))) {
            instance2 = (PreventFromSerializationSingleton) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(instance);
        System.out.println(instance2);
    }
}
