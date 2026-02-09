package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private K[] keyArray = (K[]) new Object[MAX_CAPACITY];
    private V[] valueArray = (V[]) new Object[MAX_CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key == null ? keyArray[i] == null : key.equals(keyArray[i])) {
                valueArray[i] = value;
                return;
            }
        }
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == null && valueArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key == null ? keyArray[i] == null : key.equals(keyArray[i])) {
                return valueArray[i];
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
