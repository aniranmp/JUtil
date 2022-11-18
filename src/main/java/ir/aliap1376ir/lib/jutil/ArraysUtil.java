package ir.aliap1376ir.lib.jutil;

import java.util.ArrayList;
import java.util.List;

public class ArraysUtil {
    private ArraysUtil() {
    }

    public static <T> List<T> subtract(List<T> a1, List<T> a2) {
        List<T> sub = new ArrayList<>();
        for (T t : a2) {
            if (a1.contains(t) && !sub.contains(t)) {
                sub.add(t);
            }
        }
        for (T t : a1) {
            if (a2.contains(t) && !sub.contains(t)) {
                sub.add(t);
            }
        }
        for (T t : sub) {
            if (t == null)
                sub.remove(null);
        }
        return sub;
    }
}
