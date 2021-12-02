import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public static void permute(List original,List result, int i, int k){
        if(k == i){
            List perm = new ArrayList(original.subList(0, k));
            result.add(perm);
            return;
        }
        for(int j=i; j<original.size(); j++)
        {
            Collections.swap(original, i, j);
            permute(original,result, i+1, k);
            Collections.swap(original, i, j);
        }
    }
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        permute(list,result,0,list.size());
        System.out.println(result);
        System.out.println(result.size());
    }
}
