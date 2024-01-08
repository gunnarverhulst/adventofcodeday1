package org.example.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static utils.InputFileReader.INPUT_FILE_READER;

public class TrebuchetTest {

    private Trebuchet trebuchet;
    private final Stream<String> inputStream = INPUT_FILE_READER.readInputFromStream("input.txt");

    @BeforeEach
    public void setUp() {
        trebuchet = new Trebuchet();
    }

    @Test
    public void readInputFile() {

        long lineCount = inputStream.count();

        assert (lineCount == 1000);
    }

    @Test
    public void get_NumberKeyValuePairsForNumbers() {

        inputStream.forEach(line -> trebuchet.handle(line));

        int sum = trebuchet.getSum();
        System.out.println(sum);
        assert (sum == 53340);
    }

    @Test
    public void OnInputWith1Number_calculateSumOfDoubleNumber() {
        trebuchet.handle("qsfqsdf5qsdfqs");
        assert (trebuchet.getSum() == 55);
    }

    @Test
    public void OnInputWith1NumberAtEnd_calculateSumOfDoubleNumber() {
        trebuchet.handle("qsfqsdfqsdfqs4");
        assert (trebuchet.getSum() == 44);
    }

    @Test
    public void OnInputWith1NumberAtStart_calculateSumOfDoubleNumber() {
        trebuchet.handle("3qsfqsdfqsdfqs");
        assert (trebuchet.getSum() == 33);
    }

    @Test
    public void OnInputWith1TextNumber_calculateSumOfDoubleNumber() {
        trebuchet.handle("qsfqsdonefqsdfqs");
        assert (trebuchet.getSum() == 11);
    }

    @Test
    public void OnInputWith1TextNumberAtEnd_calculateSumOfDoubleNumber() {
        trebuchet.handle("qsfqsdonsqefqsdfqstwo");
        assert (trebuchet.getSum() == 22);
    }

    @Test
    public void OnInputWith1TextNumberAtStart_calculateSumOfDoubleNumber() {
        trebuchet.handle("fiveqsfqsdosefqsdfqs");
        assert (trebuchet.getSum() == 55);
    }

    @Test
    public void OnInputWith2TextNumber_calculateSum() {
        trebuchet.handle("qsfqsdofiveandthreesdfqs");
        assert (trebuchet.getSum() == 53);
    }

    @Test
    public void OnInputWith2TextNumberAtEnd_calculateSum() {
        trebuchet.handle("qsfqsdosqsdfqsfourseven");
        assert (trebuchet.getSum() == 47);
    }

    @Test
    public void OnInputWith2TextNumberAtStart_calculateSum() {
        trebuchet.handle("eighttwoqsfqsdozerqsdfqs");
        assert (trebuchet.getSum() == 82);
    }

    @Test
    public void OnInputWith2TextNumberAtStartAndEnd_calculateSum() {
        trebuchet.handle("qsfqsdopoisdfqszeronine");
        assert (trebuchet.getSum() == 9);
    }


    @Test
    public void OnInputWithNumberAndTextNumber_calculateSum() {
        trebuchet.handle("qsfqsdazpreight3fqs");
        assert (trebuchet.getSum() == 83);
    }

    @Test
    public void OnInputWithNumberAndTextNumberAtStartAndEnd_calculateSum() {
        trebuchet.handle("eightqsfqsdazpreight3fqsthree");
        assert (trebuchet.getSum() == 83);
    }

    @Test
    public void OnInputWithMultipleTextNumber_calculateSum() {
        trebuchet.handle("qsfqseveneighttwoqs");
        assert (trebuchet.getSum() == 72);
    }

    @Test
    public void OnInputWithOnlyNumber_calculateSum() {
        trebuchet.handle("7897546132");
        assert (trebuchet.getSum() == 72);
    }

    @Test
    public void OnInputWithOnlyTextNumber_calculateSum() {
        trebuchet.handle("fivesixseveneight");
        assert (trebuchet.getSum() == 58);
    }

    @Test
    public void OnInputWithOnlyTextNumberOverlappingLetter_calculateSum() {
        trebuchet.handle("azerseeightwo");
        assert (trebuchet.getSum() == 82);
    }

    @Test
    public void OnInputWithOnlyTextNumberOverlappingLetter_calculateSum2() {
        trebuchet.handle("eightwoneight");
        assert (trebuchet.getSum() == 88);
        trebuchet.resetSum();
        trebuchet.handle("oneightwo");
        assert (trebuchet.getSum() == 12);
        trebuchet.resetSum();
        trebuchet.handle("threeighthreeightwoneight");
        assert (trebuchet.getSum() == 38);

    }

    @Test
    public void OnInputWithOnlyNumberAndTextNumber_calculateSum() {
        trebuchet.handle("five65sixseven869eight");
        assert (trebuchet.getSum() == 58);
    }

    @Test
    public void OnInputWithNone_calculateSum() {
        trebuchet.handle("qazerqsdf");
        assert (trebuchet.getSum() == 0);
    }

    @Test
    public void OnRandomInputsFromInputFile_calculateSum() {
        //1
        trebuchet.handle("two934seven1");
        assert (trebuchet.getSum() == 21);
        trebuchet.resetSum();

        //2
        trebuchet.handle("8825eightknfv");
        assert (trebuchet.getSum() == 88);
        trebuchet.resetSum();

        //3
        trebuchet.handle("sevenoneqbfzntsix55");
        assert (trebuchet.getSum() == 75);
        trebuchet.resetSum();

        //4
        trebuchet.handle("foursqpqvv192rdrbtcccfourone");
        assert (trebuchet.getSum() == 41);
        trebuchet.resetSum();

        //5
        trebuchet.handle("9jpzhpxqthreelmrnlhfqmn4");
        assert (trebuchet.getSum() == 94);
        trebuchet.resetSum();


        //996
        trebuchet.handle("seightwoone8qxcfgszninesvfcnxc68");
        assert (trebuchet.getSum() == 88);
        trebuchet.resetSum();

        //997
        trebuchet.handle("strqnb5eightbpnkcjdz6");
        assert (trebuchet.getSum() == 56);
        trebuchet.resetSum();

        //998
        trebuchet.handle("fiveninebtpbpjqbgx2bmjrgmprnd");
        assert (trebuchet.getSum() == 52);
        trebuchet.resetSum();

        //999
        trebuchet.handle("sixgtxr2fourrdkjg");
        assert (trebuchet.getSum() == 64);
        trebuchet.resetSum();

        //1000
        trebuchet.handle("fivebxsevensixone872dlx");
        assert (trebuchet.getSum() == 52);
        trebuchet.resetSum();
    }

}
