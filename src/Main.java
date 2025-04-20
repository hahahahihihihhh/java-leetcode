import javax.imageio.IIOException;
import java.io.*;
import java.sql.SQLOutput;

public class Main {

    static class MyClass implements Serializable {
        NestedClass nestedClass;

        MyClass(int x) {
            this.nestedClass = new NestedClass(x);
        }

        public void print() {
            System.out.println(nestedClass.nestedField);
        }

        public MyClass deepCopy() {
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(this);
                oos.flush();
                oos.close();

                ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bis);
                return (MyClass) ois.readObject();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

    }

    static class NestedClass implements Serializable {
        int nestedField;

        NestedClass(int x) {
            this.nestedField = x;
        }
    }

    public static void main(String[] args) {
        MyClass copy = new MyClass(2);
        copy.deepCopy().print();

    }

}