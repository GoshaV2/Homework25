import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Task {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(22);
        list.add(1233);
        list.add(43);
        list.add(5);
        list.add(22);
        list.add(11);
        list.add(411);
        list.add(5);
        list.add(6);

        findMinMax(list.stream(), Integer::compareTo,
                (min, max) -> System.out.println("Min: " + min + ", Max: " + max));
        System.out.println("Общее количество чётных: " + task2(list));

    }

    private static <T> void findMinMax(Stream<T> stream, Comparator<T> order, BiConsumer<T, T> minMaxConsumer) {
        AtomicReference<T> min = new AtomicReference<>();
        AtomicReference<T> max = new AtomicReference<>();
        stream.forEach(e->{
            if(min.get()==null || order.compare(min.get(),e)>0){
                min.set(e);
            }
            if(max.get()==null || order.compare(max.get(),e)<0){
                max.set(e);
            }
        });
        minMaxConsumer.accept(min.get(),max.get());
    }


    private static long task2(List<Integer> list) {
        return list.stream().filter(integer -> {
            if (integer % 2 == 0) {
                System.out.println(integer);
                return true;
            }
            return false;
        }).count();
    }
}