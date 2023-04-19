import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        for (int i = 0; i <10; i++) {
            new Thread(() -> {
                
                map.compute("key", (key, value) -> (value == null) ? 1 : value + 1);
                System.out.println("key 1 " + map.get("key"));
            }).start();

            new Thread(() -> {
                
                map.compute("key", (key, value) -> (value == null) ? 0 : 1000);
                System.out.println("key 2 " + map.get("key"));
            }).start();
        }

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Value for key 'key': " + map.get("key"));
    }
}

// public class ConcurrentHashMapDemo {

//     public static void main(String[] args) throws InterruptedException {

//         // Create a new ConcurrentHashMap
//         ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

//         // Create and start multiple threads to modify the map
//         Thread t1 = new Thread(new MapModifier(map, "apple", 1));
//         Thread t2 = new Thread(new MapModifier(map, "banana", 2));
//         Thread t3 = new Thread(new MapModifier(map, "cherry", 3));
//         t1.start();
//         t2.start();
//         t3.start();

//         // Wait for all threads to finish
//         // t1.join();
//         // t2.join();
//         // t3.join();

//         // Print the contents of the map
//         for (ConcurrentHashMap.Entry<String, Integer> entry : map.entrySet()) {
//             System.out.println(entry.getKey() + ": " + entry.getValue());
//         }
//     }
// }

// class MapModifier implements Runnable {

//     private final ConcurrentHashMap<String, Integer> map;
//     private final String key;
//     private final Integer value;

//     public MapModifier(ConcurrentHashMap<String, Integer> map, String key, Integer value) {
//         this.map = map;
//         this.key = key;
//         this.value = value;
//     }

//     @Override
//     public void run() {
//         // Modify the map by adding or replacing a key-value pair
//         map.put(key, value);
//         System.out.println("Added " + key + " with value " + value + " to map");
//     }
// }
