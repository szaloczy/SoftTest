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

    public boolean isRightAngled(){
        throw new UnsupportedOperationException("This function is not yet implemented");
    }

    public int getPerimeter(){
        return a + b + c;
    }

    public double getArea(){
        throw new UnsupportedOperationException("This function is not yet implemented");
    }
}
