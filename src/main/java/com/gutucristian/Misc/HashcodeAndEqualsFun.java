package com.gutucristian.Misc;

//import java.util.List;
//import java.util.ArrayList;
//
//interface MainInterface {
//  abstract void print();
//}
//
//class TypeTester {
//  void printType(int x) {
//    System.out.println(x + " is an int");
//  }
//
//  void printType(short x) {
//    System.out.println(x + " is a short");
//  }
//}
//
//class Main {
//  public static void main(String[] args) {
//    TypeTester t = new TypeTester();
//    short s1=42, s2=24;
//    int sum=0;
//    t.printType(s2);
//    int total = 0;
//    sum = s1 + s2;
//    try {
//      System.out.println("Hello World");
//    } catch (ArithmeticException e) {
//      System.out.println("e");
//    } catch (Exception e) {
//      System.out.println("e");
//    } finally {
//      System.out.println("!");
//    }
//    System.out.println("axxxxx".compareTo("b"));
//    for (int i=0; i<10; i=i++) {
//      i+=1;
//      System.out.println("Hello World");
//    }
//    List<Object> list = new ArrayList<Object>();
//    list.add("Hello");
//    list.add(2);
//    System.out.print(list.get(0) instanceof Object);
//    System.out.print(list.get(1) instanceof Integer);
//  }
//}

//package mypackage;
//class Math {
//  public static int abs(int num) {
//    return num < 0 ? -num : num;
//  }
//}
//
//package mypackage.elementary;
//class Math {
//  public static int abs(int num) {
//    return -num;
//  }
//}
//
//class Main {
//  public static void main(String[] args) {
//    System.out.println(Math.abs(123));
//  }
//}

class Car {
  public final int id;
  public final String modelName;
  public final int numOfDoors;
  public final int horsePower;

  Car(int id) {
    this.id = id;
    this.modelName = null;
    this.numOfDoors = 0;
    this.horsePower = 0;
    System.out.println("Car constructor!");
  }

  Car(int id, String modelName, int numOfDoors, int horsePower) {
    this.id = id;
    this.modelName = modelName;
    this.numOfDoors = numOfDoors;
    this.horsePower = horsePower;
  }
}

class Audi extends Car {
  Audi(int id) {
    super(id);
    System.out.println("Audi constructor!");
  }

  Audi(int id, String modelName, int numOfDoors, int horsePower) {
    super(id, modelName, numOfDoors, horsePower);
  }

  public boolean equals(Object obj) {
    // if both point to same memory address
    // they are equal by definition
    if (this == obj) return true;

    if (obj == null || obj.getClass() != this.getClass())
      return false;

    Audi audi = (Audi) obj;

    return ((this.id == audi.id) &&
        (this.modelName.equals(audi.modelName)) &&
        (this.numOfDoors == audi.numOfDoors) &&
        (this.horsePower == audi.horsePower));
  }

  public int hashCode() {
    int prime = 31;
    int result = 1;
    result = prime * result + this.id;
    result = prime * result + ((this.modelName == null) ? 0 : this.modelName.hashCode());
    result = prime * result + this.numOfDoors;
    result = prime * result + this.horsePower;
    return result;
  }
}

//class FooBar extends Bar {
//  FooBar() {
//    System.out.println("FooBar constructor!");
//  }
//}

//class Main {
//  public static void main(String[] args) {
//    Audi a = new Audi(1, "A4", 4, 180);
//    Audi b = new Audi(1, "A4", 4, 180);
//    System.out.println(a.equals(b));
//    System.out.println(a.hashCode());
//    System.out.println(b.hashCode());
//  }
//}
