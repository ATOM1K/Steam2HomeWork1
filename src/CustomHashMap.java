import java.util.LinkedList;

public class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    // Вложенный класс для хранения пар ключ-значение
    private static class Entry<K, V> {
        final K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = (LinkedList<Entry<K, V>>[]) new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    // Метод для вычисления хеш-кода и индекса в массиве buckets
    private int getBucketIndex(K key) {
        int hashCode = key != null ? key.hashCode() : 0;
        return Math.abs(hashCode) % buckets.length;
    }

    // Получение значения по ключу
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.key == null) ||
                    (key != null && key.equals(entry.key))) {
                return entry.value;
            }
        }
        return null;
    }

    // Добавление пары ключ-значение
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        // Проверяем, существует ли уже такой ключ — если да, обновляем значение
        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.key == null) ||
                    (key != null && key.equals(entry.key))) {
                entry.value = value;
                return;
            }
        }

        // Если ключа нет, добавляем новую запись
        bucket.add(new Entry<>(key, value));
        size++;
    }

    // Удаление пары по ключу
    public boolean remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if ((key == null && entry.key == null) ||
                    (key != null && key.equals(entry.key))) {
                bucket.remove(entry);
                size--;
                return true;
            }
        }
        return false;
    }

    // Вспомогательный метод для вывода содержимого карты (для демонстрации)
    public void printMap() {
        System.out.println("\n--- Содержимое HashMap ---");
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                System.out.println("Логин: " + entry.key + " -> ФИ: " + entry.value);
            }
        }
        System.out.println("Всего записей: " + size + "\n");
    }
}