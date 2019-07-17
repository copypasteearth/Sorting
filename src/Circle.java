/**
 * author: copypasteearth
 * date: 7/17/2019
 */
public class Circle implements Comparable<Circle> {
    public int xValue;
    public int yValue;
    public int radius;

    @Override
    public int compareTo(Circle o) {
        return (this.radius - o.radius);
    }
    @Override
    public String toString() {
        return "x: " + xValue + " ---y: " + yValue + " ---radius: " + radius;
    }
}
