import java.util.Map;

public class MapRealize {

    Map<Integer, String> map;
    private final int COUNT = 10_000_000;
    private final int SLEEP = 1000;
    private long add = 0;

    public MapRealize(Map<Integer, String> map) {
        this.map = map;
    }


    public void add() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            map.put(i, String.valueOf(i));
        }
        long finishTime = System.currentTimeMillis();
        add = finishTime - startTime;
    }

    public void read() {
        try {
            Thread.sleep(SLEEP);
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < COUNT; i++) {
                System.out.println(map.get(i));
            }
            long finishTime = System.currentTimeMillis();
            System.out.println("Чтение - " + (finishTime - startTime));
            System.out.println("Добавление - " + add);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
