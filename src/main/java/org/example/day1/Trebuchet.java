package org.example.day1;

import com.codepoetics.protonpack.Indexed;
import com.codepoetics.protonpack.StreamUtils;

import java.util.*;
import java.util.stream.IntStream;

import static org.example.day1.TextNumberConverter.TEXT_NUMBER_CONVERTER;

public class Trebuchet {
    private int sum = 0;
    private static final List<String> VALUE_LIST = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static final List<String> TEXT_VALUE_LIST = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    private List<NumberKeyValuePair> numberKeyValuePairList = new ArrayList<>();


    public void handle(String line) {
        resetNumerKayValuePairList();

        findNumberInString(line);
        findTextNumbersInString(line);

        addValueAgainIfOnly1SpottedInLine();
        sortNumberKeyValuePairList();
        keepMinAndMaxPositionInList();

        handleSumIf2NumbersFound();

    }

    private void resetNumerKayValuePairList() {
        numberKeyValuePairList.clear();
    }

    private void findNumberInString(String line) {
        IntStream
                .range(0, line.length())
                .forEach(x ->
                        addNumberToList(""+line.charAt(x),x));
    }

    private void addNumberToList(String character, int characterPosition) {
        if (findCharacterInValueList(character)) {
            numberKeyValuePairList.add(new NumberKeyValuePair(characterPosition, character));
        }
    }

    private void findTextNumbersInString(String line) {
        startFindTextNumber(line);
    }

    private void startFindTextNumber(String line){
        TEXT_VALUE_LIST.stream()
                .forEach(x -> findTextNumberInString(line, x, 0));
    }

    private void findTextNumberInString(String line, String x, int indicesPassed) {
        if(line.contains(x)){
            numberKeyValuePairList.add(new NumberKeyValuePair(indicesPassed + line.indexOf(x), TEXT_NUMBER_CONVERTER.convertTextToNumber(x)));
            indicesPassed += calculateNewStartPointOfSubstring(line, x);
            findTextNumberInString(line.substring(calculateNewStartPointOfSubstring(line, x)), x, indicesPassed);
        }
    }

    private static int calculateNewStartPointOfSubstring(String line, String x) {
        return line.indexOf(x) + x.length() - 1;
    }

    private void addValueAgainIfOnly1SpottedInLine() {
        if (checkIfNumberKeyValuePairListIsOfExpectedSize()) {
            numberKeyValuePairList.add(numberKeyValuePairList.getFirst());
        }
    }

    private boolean checkIfNumberKeyValuePairListIsOfExpectedSize() {
        return numberKeyValuePairList.size() == 1;
    }

    private void sortNumberKeyValuePairList() {
        numberKeyValuePairList.sort(NumberKeyValuePairComparator.INSTANCE);
    }

    private boolean findCharacterInValueList(String character) {
        return VALUE_LIST.contains(character);
    }

    private void keepMinAndMaxPositionInList() {

        int lastIndex = numberKeyValuePairList.size() - 1;

        List<Indexed<NumberKeyValuePair>> list = StreamUtils
                .zipWithIndex(numberKeyValuePairList.stream())
                .filter(i -> i.getIndex() == 0 || i.getIndex() == lastIndex)
                .toList();
        resetNumerKayValuePairList();
        numberKeyValuePairList.addAll(list.stream().map(x -> x.getValue()).toList());

    }

    private void handleSumIf2NumbersFound() {
        if (!numberKeyValuePairList.isEmpty()) {
            sum += Integer.parseInt(getTwoFoundNumbers());
        } else {
            System.out.println("No Number Found");
        }
    }

    private String getTwoFoundNumbers() {
        return numberKeyValuePairList.get(0).number() + numberKeyValuePairList.get(1).number();
    }
    public void resetSum() {
        sum = 0;
    }

    public int getSum() {
        return sum;
    }

}
