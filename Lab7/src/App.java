import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class App {
    public int fractionalKnapsack(int[] w, int[] p, int n,int backpack) {
        int maxProfit = 0, current = 0;
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>();

        for(int i = 0; i < w.length; i++) {
            entryList.add(new AbstractMap.SimpleEntry<>(p[i], w[i]));
        }

        entryList.sort(Map.Entry.comparingByKey(Collections.reverseOrder()));

        int i = 0;
        while(current < backpack) {
            if(entryList.get(i).getValue() < (backpack - current)) {
                maxProfit += entryList.get(i).getKey();
                current += entryList.get(i).getValue();
            } else if ((backpack - current) != 0) {
                maxProfit += entryList.get(i).getKey() * (backpack - current)/entryList.get(i).getValue();
                return maxProfit;
            }
            i++;
        }
        return maxProfit;
    }
}

