package daalab;

import java.util.Arrays;
import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] weightOfObj = {5,3,2,6,1};
        int[] costPerKg = {3,5,7,8,10};
        int[] val = new int[costPerKg.length];
        for(int i = 0; i < costPerKg.length; i++) {
            for(int j = 0; j < weightOfObj.length; j++) {
                if(i == j) {
                    val[i] = weightOfObj[i]*costPerKg[i];
                }
            }
        }
        int knapsackCapacity = 10;
        double maxValue = getMaxValue(weightOfObj, costPerKg, knapsackCapacity);
        System.out.println("Max valu we can obtain is " + maxValue);  
    }

    private static double getMaxValue(int[] wt, int[] val, int knapsackCapacity) {
        itemValue[] ival = new itemValue[wt.length];
        for(int i = 0; i < wt.length; i++) {
            ival[i] = new itemValue(wt[i], val[i], i);
        }

        // sorting items by value;
        Arrays.sort(ival, new Comparator<itemValue>() {
            @Override
            public int compare(itemValue o1, itemValue o2)
            {
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0d;
        for(itemValue i : ival) {
            int curWeight = (int)i.wt;
            int curVal = (int)i.val;
            if(knapsackCapacity - curWeight >= 0) {
                // this weight can be picked while
                knapsackCapacity = knapsackCapacity - curWeight;
                totalValue += curVal;
            } else {
                // item can't be picked while
                double fraction = ((double) knapsackCapacity / (double) curWeight);
                totalValue += (curVal * fraction);
                knapsackCapacity = (int) (knapsackCapacity - (curWeight * fraction));
                break;
            }
        }
        return totalValue;
    }

    // item value class
    static class itemValue {
        Double cost;
        double wt, val;
        int idx;

        // constructor for object class
        public itemValue(int wt, int val, int idx) {
            this.wt = wt;
            this.val = val;
            this.idx = idx;
            cost = ((double) val /(double) wt);
        }
    }
}
