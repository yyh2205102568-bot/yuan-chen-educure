public class Circle extends Shape {

    double radius;
    // radius = 半径

    public Circle(double radius) {
        this.radius = radius;
         
    }

    @Override
    public double getArea() {

        return radius * radius * 3.14;
    }
}