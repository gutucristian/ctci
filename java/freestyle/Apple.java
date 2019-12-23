import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Apple implements Comparable<Apple> {
  String variety;
  String color;
  int weight;

  Apple(String variety, String color, int weight) {
    this.variety = variety;
    this.color = color;
    this.weight = weight;
  }

  public String toString() {
    return variety + " " + color + " " + weight;
  }

  public int compareTo(Apple other) {
    int result = this.variety.compareTo(other.variety);
    if (result != 0) {
      return result;
    }
    result = this.color.compareTo(other.color);
    if (result != 0) {
      return result;
    }
    result = Integer.compare(this.weight, other.weight);
    return result;
//    if (this.weight < other.weight) {
//      return -1;
//    } else if (this.weight > other.weight) {
//      return 1;
//    } else {
//      return 0;
//    }
  }
}

class Main {
  public static void main(String[] args) {
    List<Apple> apples = new ArrayList<Apple>();
    apples.add(new Apple("Fuji", "Red", 5));
    apples.add(new Apple("Granny Smith", "Dark Red", 8));
    apples.add(new Apple("Jonna Gold", "Gold", 7));
    apples.add(new Apple("Macoun", "Pink", 4));
    apples.add(new Apple("American", "Yellow", 4));
    apples.add(new Apple("American", "Blue", 4));
    apples.add(new Apple("American", "Blue", 6));
    System.out.println("Unsorted ArrayList: " + apples);
    Collections.sort(apples);
    System.out.println("Sorted ArrayList: " + apples);
  }
}