import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Laptop implements Comparable<Laptop> {
  public String brand;
  public int ram;
  public int price;
  Laptop(String brand, int ram, int price) {
    this.brand = brand;
    this.ram = ram;
    this.price = price;
  }
  public int compareTo(Laptop other) {
    //if (this.ram > other.ram)
    //  return 1;
    //else
    //  return -1;
    int result;

    if (this.price > other.price)
      result = 1;
    else if (this.price == other.price)
      result = 0;
    else
      result = -1;

    if (result == 0) {
      if (this.ram > other.ram)
        result = 1;
      else if (this.ram == other.ram)
        result = 0;
      else
        result = -1;
    }

    return result;
  }
  public String toString() {
    return "[" + brand + ", " + "$" + price + ", " + ram + "]"; 
  }
}

class Main {
  public static void main(String[] args) {
    List<Laptop> laptops = new ArrayList<Laptop>();

    Comparator<Laptop> com = new Comparator<Laptop>() {
      public int compare(Laptop l1, Laptop l2) {
        return l1.brand.compareTo(l2.brand);
      }
    };

    laptops.add(new Laptop("Dell", 8, 700));
    laptops.add(new Laptop("Dell", 6, 700));
    laptops.add(new Laptop("HP", 6, 500));
    laptops.add(new Laptop("Apple", 8, 1200));
    System.out.println("Unsorted: " + laptops);
    Collections.sort(laptops, com);  
    System.out.println("Sorted: " + laptops);
  }
}
