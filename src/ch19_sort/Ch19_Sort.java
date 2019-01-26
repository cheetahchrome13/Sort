
package ch19_sort;

import java.util.ArrayList;
import java.util.Random;

/**
 * Project: Sort an ArrayList
 * @author Justin Mangan
 * Tasks: Creates, shuffles, and sorts an ArrayList
 * Date: 26 March 2018
 */
public class Ch19_Sort {

    public static void main(String[] args) {
        
        // Creates and initializes an ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            list.add(i + 1);
        }
        
        // Print ArrayList before and after method calls
        //System.out.println("Array Created:\n" + list);
        displayList(list, "Array Created:\n");
        shuffle(list);
        displayList(list, "Array Shuffled:\n");
        //System.out.println("Array Shuffled:\n" + list);
        sort(list);
        displayList(list, "Array Sorted:\n");
        //System.out.println("Array Sorted:\n" + list);
    }
    
    // Sorts ArrayList 
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            E current = list.get(i);
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(j).compareTo(current) < 0) {
                    current = list.get(j);
                    min = j;
                }
            }

            if (min != i) {
                list.set(min, list.get(i));
                list.set(i, current);
            }
        }
    }
    
    // Shuffles ArrayList
    public static <E> void shuffle(ArrayList<E> list) {
        
        Random random = new Random();
        
        for (int i = 0; i < list.size(); i++) {
            int value = random.nextInt(list.size());
            E temp = list.get(value);
            list.set(value, list.get(i));
            list.set(i, temp);
        }
    }
    
    // Prints and formats ArrayList
    public static <E> void displayList(ArrayList<E> list, String msg){
        System.out.println(msg + list + "\n");    
    }
}
