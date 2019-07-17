import java.util.Arrays;
import java.util.Random;

/**
 * author: copypasteearth
 * date: 7/17/2019
 */
public class MergeSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void merge(int leftFirst, int leftLast, int rightFirst, int rightLast, T[] array){
        T[] tempArray = Arrays.copyOf(array,array.length);
        int index = leftFirst;
        int saveFirst = leftFirst;

        while((leftFirst <= leftLast) && (rightFirst <= rightLast)){
            if(array[leftFirst].compareTo(array[rightFirst]) < 0){
                tempArray[index] = array[leftFirst];
                leftFirst++;
            }else{
                tempArray[index] = array[rightFirst];
                rightFirst++;
            }
            index++;
        }
        while(leftFirst <= leftLast){
            tempArray[index] = array[leftFirst];
            leftFirst++;
            index++;
        }
        while(rightFirst <= rightLast){
            tempArray[index] = array[rightFirst];
            rightFirst++;
            index++;
        }
        for(index = saveFirst; index <= rightLast;index++){
            array[index] = tempArray[index];
        }
    }
    public static <T extends Comparable<T>> void mergeSort(int first, int last,T[] array){
        if(first < last){
            int middle = (first + last) / 2;
            mergeSort(first,middle,array);
            mergeSort(middle+1,last,array);
            merge(first,middle,middle+1,last,array);
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
        MergeSort<Circle> mscircle = new MergeSort<Circle>();
        mscircle.mergeSort( 0, circlearray.length-1,circlearray);
        System.out.println("Circle Array Sorted");
        for(Circle i: circlearray) {
            System.out.println(i);
        }
    }
}
