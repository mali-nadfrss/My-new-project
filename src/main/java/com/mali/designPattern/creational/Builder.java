package com.mali.designPattern.creational;

public class Builder {
    int id;
    String name;
    int age;
    String address;

    public Builder(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Builder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "name:{} id:{} age:{} address:{}"+this.name+this.id+this.age+this.address;
    }
}
