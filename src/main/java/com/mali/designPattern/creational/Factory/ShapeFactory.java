package com.mali.designPattern.creational.Factory;

public class ShapeFactory implements AbstractFactory<Shape> {
    public Shape getShape(int sides){
        switch (sides){
            case 3:
                return new Triangle();
            case 4:
                return new Square();
            default:
                return new Shape() {
                };
        }
    }
}
