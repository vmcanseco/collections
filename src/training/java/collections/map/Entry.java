package training.java.collections.map;

 public final class Entry<K,V> {

     private final K key;
     private final V value;

      Entry(K key, V value) {
         this.key = key;
         this.value = value;
     }

     public K getKey() {
         return key;
     }

     public V getValue() {
         return value;
     }

     @Override
     public boolean equals(Object obj) {
         Entry<K,V> tmp = (Entry<K,V>) obj;
         return tmp.key.equals(key);
     }
 }
