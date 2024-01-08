package org.example.day1;

public record NumberKeyValuePair (int position, String number) {

    public boolean positionEquals(NumberKeyValuePair numberKeyValuePair) {
        return position == numberKeyValuePair.position();
    }
}
