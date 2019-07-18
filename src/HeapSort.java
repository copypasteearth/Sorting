import java.util.Random;

/**
 * author: copypasteearth
 * date: 7/17/2019
 * project: MergeSort
 */
public class HeapSort<T extends Comparable<T>> {

    /////////////////////////////////////////////////////////////////
    //
    //  Heap Sort

    static <T extends Comparable<T>>int newHole(int hole, int lastIndex, T item,T[] values)
    // If either child of hole is larger than item this returns the index
    // of the larger child; otherwise it returns the index of hole.
    {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;
        if (left > lastIndex)
            // hole has no children
            return hole;
        else
        if (left == lastIndex)
            // hole has left child only
            if (item.compareTo(values[left]) < 0)
                // item < left child
                return left;
            else
                // item >= left child
                return hole;
        else
            // hole has two children
            if (values[left].compareTo(values[right]) < 0)
                // left child < right child
                if (values[right].compareTo(item) <= 0)
                    // right child <= item
                    return hole;
                else
                    // item < right child
                    return right;
            else
                // left child >= right child
                if (values[left].compareTo(item) <= 0)
                    // left child <= item
                    return hole;
                else
                    // item < left child
                    return left;
    }
    static public <T extends Comparable<T>> void swap(int index1, int index2,T[] values)
    // Precondition: index1 and index2 are >= 0 and < SIZE.
    //
    // Swaps the integers at locations index1 and index2 of the values array.
    {
        T temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }

    static <T extends Comparable<T>> void reheapDown(T item, int root, int lastIndex,T[] values)
    // Precondition: Current root position is "empty".
    //
    // Inserts item into the tree and ensures shape and order properties.
    {
        int hole = root;   // current index of hole
        int newhole;       // index where hole should move to

        newhole = newHole(hole, lastIndex, item,values);   // find next hole
        while (newhole != hole)
        {
            values[hole] = values[newhole];      // move value up
            hole = newhole;                      // move hole down
            newhole = newHole(hole, lastIndex, item,values);     // find next hole
        }
        values[hole] = item;           // fill in the final hole
    }

    static <T extends Comparable<T>>void heapSort(T[] values)
    // Sorts the values array using the heap sort algorithm.
    {
        int index;
        // Convert the array of values into a heap.
        for (index = values.length/2 - 1; index >= 0; index--)
            reheapDown(values[index], index, values.length - 1,values);

        // Sort the array.
        for (index = values.length - 1; index >=1; index--)
        {
            swap(0, index,values);
            reheapDown(values[0], 0, index - 1,values);
        }
    }

    public static void main(String[] args){
        Circle[] circlearray = new Circle[20];
        Random rand = new Random();
        for (int index = 0; index < 20; index++)
        {
            circlearray[index] = new Circle();
            circlearray[index].xValue = Math.abs(rand.nextInt()) % 100;
            circlearray[index].yValue = Math.abs(rand.nextInt()) % 100;
            circlearray[index].radius = Math.abs(rand.nextInt()) % 100;
        }
        System.out.println("Circle Array Unsorted....");
        for(int i = 0;i < 20;i++){

            System.out.println(circlearray[i]);
        }
        heapSort(circlearray);
        System.out.println("Circle Array Sorted");
        for(Circle i: circlearray) {
            System.out.println(i);
        }
    }

}
