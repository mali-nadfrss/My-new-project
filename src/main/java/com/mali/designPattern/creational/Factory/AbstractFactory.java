package com.mali.designPattern.creational.Factory;

public interface AbstractFactory<T> {
    Shape getShape(int sides);
}
