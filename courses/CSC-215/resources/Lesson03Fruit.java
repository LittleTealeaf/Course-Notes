/***********
 * Author: Christian Duncan
 * Example Program to use the (Hash)Map ADT in Java
 *   Map replaced the deprecated Dictionary class in Java APIs
 ***********/
import java.util.HashMap;
import java.util.Map;

public class Lesson03Fruit {
    public static void main(String[] args) {
        Map<String,Double> fruit = new HashMap<String,Double>();  // Create Map (aka Dictionary)
        fruit.put("Apples", 1.29);   // Insertion
        fruit.put("Bananas", 0.49);
        fruit.put("Pears", 1.45);
        fruit.put("Kiwi", 3.45);
        Double pears = fruit.get("Pears");  // Searching
        System.out.println("Pears: " + pears);
        fruit.put("Oranges", 1.35); 
        fruit.put("Apples", 1.39);   // Replacing
        fruit.remove("Kiwi");        // Deletion

        // Iteration
        System.out.println("The full list");
        System.out.println("-------------");
        for (Map.Entry<String, Double> entry: fruit.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}