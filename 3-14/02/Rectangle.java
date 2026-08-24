public class Rectangle extends Shape {

    double width;
    double height;
    // width = 宽
    // height = 高

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {

        return width * height;
    }
}