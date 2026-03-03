package org.example;

/**
 * This class will manage all different type of DesignPattern used for Object Creation
 * Singleton - Always create one instance throughout the context
 * Prototype - Create new instance by cloning exiting instance instead of new instantiation
 * Factory - Defines an interface for creating objects but lets subclasses decide which class to instantiate.
 * AbstractFactory - Provides an interface to create families of related objects without specifying their concrete classes.
 * Builder - Separates the construction of a complex object from its representation, allowing step-by-step creation.
 */
public class JavaDesignPattern {


}

class Employee {
    private String name;
    private int ID;
    private int age;
    private Department department;
}

class Department {
    private String departmentName;
    private int departmentId;
    private double salary;
}
