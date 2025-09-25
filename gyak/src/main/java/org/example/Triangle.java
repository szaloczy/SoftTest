package org.example;

public class Triangle {
    private int a, b, c;

    public Triangle(int a, int b, int c){
        if ( ((a + b) > c ) && ((b + c) > a ) && ((a + c ) > b)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else{
            throw new ArithmeticException(
                    String.format("The triangle cannot be constructed from the the numbers %d, %d, %d.", a, b, c));
        }
    }

    public boolean isIsosceles(){
        return (a == b) || (b == c) || (a == c);
    }

    public boolean isEquilateral(){
        return (a == b) && (b == c);
    }

    public boolean isRightAngled(Triangle triangle){
        return Math.pow(triangle.a,2) + Math.pow(triangle.b,2) == Math.pow(triangle.c,2);
    }

    public int getPerimeter(){
        return a + b + c;
    }

    public double getArea() {
        double area = 0;
        double s = (double) (a + b + c) / 2;
        area = Math.sqrt(s * ( s - a) * ( s - b) * (s - c));

        return area;
    }
}
