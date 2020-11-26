package com.gutucristian.Misc;

import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {
  String firstName;
  String lastName;

  Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String toString() {
    return firstName + " " + lastName;
  }

  // sort by last name then by first name
  public int compareTo(Person PersonToCompareTo) {
    int result = this.lastName.compareTo(PersonToCompareTo.getLastName());
    if (result == 0) {
      result = this.firstName.compareTo(PersonToCompareTo.getFirstName());
    }
    return result;
  }
}

/*
  class Main {
    public static void main(String[] args) {
      Person p1 = new Person("John", "Smith");
      Person p2 = new Person("Joe", "Snowman");
      Person p3 = new Person("Cristian", "Gutu");
      Person p4 = new Person("Charlotte", "Andren");
      Person p5 = new Person("Iura", "Smith");
      Person p6 = new Person("Ion", "Snowman");
      Person p7 = new Person("Joe", "Snowman");
      ArrayList<Person> people = new ArrayList<Person>();
      people.add(p1);
      people.add(p2);
      people.add(p3);
      people.add(p4);
      people.add(p5);
      people.add(p6);
      people.add(p7);
      System.out.println("Unsorted ArrayList: " + people);
      Collections.sort(people);
      System.out.println("Sorted ArrayList: " + people);
    }
  }
 */
