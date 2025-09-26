package org.example;

public class Table {

    private int width, length, height, currentHeight, numberOfLegs;
    private boolean isAdjustable;
    private String color;

    public Table(int width, int length, int height) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.isAdjustable = false;
        this.currentHeight = height;
    }

    public Table(int width, int length, int height, int currentHeight) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.isAdjustable = true;
        this.currentHeight = currentHeight;
    }

    public Table(int width, int length, int height, String color, int numberOfLegs) {
        this.width = width;
        this.length = length;
        this.height = height;
        this.color = color;
        this.numberOfLegs = numberOfLegs;
    }

    public int getWidth() { return width; }

    public int getLength() { return length; }

    public int getHeight() { return height; }

    public String getColor() { return color; }

    public boolean isAdjustable() { return isAdjustable; }

    public int getCurrentHeight() { return currentHeight; }

    public void setHeight(int newHeight) {
        if (!isAdjustable) {
            throw new UnsupportedOperationException();
        }
        if (newHeight < 200 && newHeight > 0) {
            currentHeight = newHeight;
        } else {
            throw new IllegalArgumentException();
        }
        //TODO
    }

    public int area() {
        return width * length;
    }
    
    public int getCapacity() {
        int peopleOnLength = length / 60;
        int peopleOnWidth = width / 60;
        return (peopleOnLength * 2) + (peopleOnWidth * 2);
    }

    public void repaint(String newColor) {
        color = newColor;
    }

    public boolean isStable() {
        return numberOfLegs >= 3;
    }

    public int getPerimeter() {
        return 2 * ( length + width);
    }
}
