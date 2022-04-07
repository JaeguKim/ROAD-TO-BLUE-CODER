package privateTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Display {

    private class InnerDisplay implements Printable, Comparator<InnerDisplay> {
        private void display() {
            System.out.println("Private inner class method called");
        }

        @Override
        public void print() {
            System.out.println("print is called!");
        }

        @Override
        public int compare(InnerDisplay o1, InnerDisplay o2) {
            return 0;
        }
    }

    public InnerDisplay getInnerDisplay() {
        return new InnerDisplay();
    }

    void display() {
        getInnerDisplay().print();
    }
}

public class Main {

    public static void main(String args[]) {
        // Create object of the outer class (Display)
        Display object = new Display();
        ((Printable)object.getInnerDisplay()).print();
        ((Comparator)object.getInnerDisplay()).compare(null,null);
    }
}
