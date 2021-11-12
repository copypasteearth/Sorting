import java.util.HashMap;

public class AwesomeFibonacci {
    public HashMap<Integer,Long> memo;
    public AwesomeFibonacci(){
        memo = new HashMap<>();
        memo.put(0,0L);
        memo.put(1,1L);
    }
    public long fibonacciNumber(int x){
        return memo.computeIfAbsent(x, y -> fibonacciNumber(x-1) + fibonacciNumber(x-2));
    }
    public static void main(String[] args){
        AwesomeFibonacci fib = new AwesomeFibonacci();
        for(int i = 0; i < 10;i++){
            long fibonacci = fib.fibonacciNumber(i);
            System.out.println(fibonacci);
        }
    }
}
