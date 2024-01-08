package org.example.day1;

import java.util.Comparator;

public enum NumberKeyValuePairComparator implements Comparator<NumberKeyValuePair> {
    INSTANCE;

    public int compare(NumberKeyValuePair x, NumberKeyValuePair y) {
        if (x.position() == y.position())
            return 0;
        else
            return x.position() < y.position() ? -1 : 1;
    }
}
