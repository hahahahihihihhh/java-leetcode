package Problem;

import java.util.*;

public class T380 {

    Map<Integer, Integer> mp;
    int len = 0;
    int[] a;
    Random random;

    public T380() {
        mp = new HashMap<>();
        a = new int[200005];
        len = 0;
        random = new Random();
    }

    public boolean insert(int val) {
        if (mp.containsKey(val))    return false;
        mp.put(val, len);
        a[len++] = val;
        return true;
    }

    public boolean remove(int val) {
        if (!mp.containsKey(val))   return false;
        int pos = mp.get(val);
        int tmp = a[pos];
        a[pos] = a[-- len];
        mp.put(a[pos], pos);
        mp.remove(val);
        return true;
    }

    public int getRandom() {
        return a[random.nextInt(len)];
    }

}
