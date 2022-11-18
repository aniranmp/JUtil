package ir.aliap1376ir.lib.jutil;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayAndCollectionUtil {

    public static List<Long> convertToList(long... items) {
        List<Long> list = new ArrayList<>();
        for (long item : items) {
            list.add(item);
        }
        return list;
    }

//    public static List<Object> convertToList(Object... items) {
//        List<Object> list = new ArrayList<>();
//        Collections.addAll(list, items);
//        return list;
//    }

    public static <T> List<T> convertToList(T... items) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, items);
        return list;
    }

    public static <T> Iterable<T> convertToIterable(T... items) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, items);
        return list;
    }

}
