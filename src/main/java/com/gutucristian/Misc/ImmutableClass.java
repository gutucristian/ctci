package com.gutucristian.Misc;

final class Student {
  final String name;
  final int regNo;

  public Student(String name, int regNo) {
    this.name = name;
    this.regNo = regNo;
  }

  public String getName() {
    return name;
  }

  public int getRegNo() {
    return regNo;
  }
}

//class Main {
//  public static void main(String[] args) {
//    Student bob = new Student("Bob", 1);
//    System.out.println(bob.getName());
//  }
//}
