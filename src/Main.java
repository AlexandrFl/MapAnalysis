import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());

//        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        MapRealize mapRealize = new MapRealize(map);

        Thread add = new Thread(null, mapRealize::add, "Добавление");
        Thread read = new Thread(null, mapRealize::read, "Чтение");

        add.start();
        read.start();
    }
}

/*      ConcurrentHashMap       |       Collections.synchronizedMap
                          Кол-во эл.тов = 100_000
        Добавление - 62 мс.     |       Добавление - 16 мс.
        Чтение - 281 мс.        |       Чтение - 219 мс.

                          Кол-во эл.тов = 10_000

        Добавление - 0 мс.      |       Добавление - 0 мс.
        Чтение - 46 мс.         |       Чтение - 45 мс.

                          Кол-во эл.тов = 1_000_000

        Добавление - 266 мс.    |       Добавление - 234 мс.
        Чтение - 2052 мс.       |       Чтение - 2171 мс.

                          Кол-во эл.тов = 10_000_000

        Добавление - 2114 мс.   |       Добавление - 16536 мс.
        Чтение - 18210 мс.      |       Чтение - 1289 мс.
 */