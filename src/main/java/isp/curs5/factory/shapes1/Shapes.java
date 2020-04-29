package isp.curs5.factory.shapes1;

import java.util.*;

/**
 * Demostrat sablonul de proiectare Factory
 */
abstract class Shape {
    public abstract void draw();
    public abstract void erase();
    public static Shape factory(String type) {
        if(type.equals("Circle")) return new Circle();
        if(type.equals("Square")) return new Square();
        throw new RuntimeException(
                "Bad shape creation: " + type);
    }
}

class Circle extends Shape {
    Circle() {} // Package-access constructor
    public void draw() {
        System.out.println("Circle.draw");
    }
    public void erase() {
        System.out.println("Circle.erase");
    }
}

class Square extends Shape {
    Square() {} // Package-access constructor
    public void draw() {
        System.out.println("Square.draw");
    }
    public void erase() {
        System.out.println("Square.erase");
    }
}

public class Shapes {

    public static void main(String args[]) {
        String shlist[] = { "Circle", "Square",
                "Square", "Circle", "Circle", "Square" };
        Shape[] shapes = new Shape[6];

        Iterator it = Arrays.asList(shlist).iterator();

        for(int i=0; i<shlist.length; i++){
            shapes[i] = Shape.factory(shlist[i]);
        }


        //foreach
        for (Shape s: shapes) {
            s.draw();
            s.erase();
        }
    }
}
