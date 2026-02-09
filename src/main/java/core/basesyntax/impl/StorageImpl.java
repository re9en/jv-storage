package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keyArray;
    private V[] valueArray;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[MAX_CAPACITY];
        this.valueArray = (V[]) new Object[MAX_CAPACITY];
    }

    private int findKeyIndex(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key == null ? keyArray[i] == null : key.equals(keyArray[i])) {
                return i;
            }
        }
        return -1; // ключ не найден
    }

    @Override
    public void put(K key, V value) {
        int index = findKeyIndex(key);
        for (int i = 0; i < keyArray.length; i++) {
            if (index != -1) {
                valueArray[index] = value;
                return;
            }
        }
        for (int i = 0; i < keyArray.length; i++) {
            if (valueArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findKeyIndex(key);
        for (int i = 0; i < keyArray.length; i++) {
            if (index != -1) {
                return valueArray[index];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < keyArray.length; i++) {
            if (valueArray[i] != null) {
                counter++;
            }
        }
        return counter;
    }

}
