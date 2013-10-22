import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/21/13
 * Time: 7:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tests {
    Exercise1 exercise1 = new Exercise1();

    @Test
    public void testBadImput(){
        String[] args = new String[1];
        args[0] = "bad input";
        int result = exercise1.phoneNumber(args);
        Assert.assertEquals(result, -1);
    }
    @Test
    public void testCorrectInput(){
        String[] args = new String[1];
        args[0] = "110015020";
        int result = exercise1.phoneNumber(args);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testKeyboard(){
        List<String> key2 = exercise1.keyboard.get(2);
        Assert.assertEquals(key2.get(1), "B");

        List<String> key9 = exercise1.keyboard.get(9);
        Assert.assertEquals(key9.get(0), "W");

    }

    @Test
    public void testTransformArray(){
        String input = "123113398";
        Map<Integer, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put(1,2);
        expectedOutput.put(2,3);
        expectedOutput.put(5,3);
        expectedOutput.put(6,3);
        expectedOutput.put(7,9);
        expectedOutput.put(8,8);
        Map<Integer,Integer> result = exercise1.transformArray(input);
        Assert.assertEquals(expectedOutput, result);
    }

    @Test
    public void testSimpleCase(){
        String[] args = new String[1];
        args[0] = "110015010";
    }

    @Test
    public void createMask(){
        Map<Integer, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put(1,2);
        expectedOutput.put(8,5);
        Assert.assertEquals(exercise1.getDefaultMask(expectedOutput).size(),2);

    }

    @Test
    public void testIfMaskIsValid(){
         List<Integer> defaultMask = new LinkedList<>();
        defaultMask.add(1);
        defaultMask.add(2);
        Assert.assertEquals(exercise1.maskIsValid(defaultMask), true);
    }
    @Test
    public void testMaskShouldBeNotValid(){
        List<Integer> defaultMask = new LinkedList<>();
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        Assert.assertEquals(exercise1.maskIsValid(defaultMask), false);
    }
      /*
    @Test
    public void testIncrementMask(){
        List<Integer> defaultMask = new LinkedList<>();
        defaultMask.add(0);
        defaultMask.add(0);
        defaultMask.add(2);
        List<Integer> afterFirsIncrement = new LinkedList<>();
        afterFirsIncrement.add(0);
        afterFirsIncrement.add(1);
        afterFirsIncrement.add(0);
        exercise1.incrementMask(defaultMask);
        Assert.assertEquals(defaultMask, afterFirsIncrement);
    }
    @Test
    public void testIncrementMediumMask(){
        List<Integer> defaultMask = new LinkedList<>();
        defaultMask.add(0);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        List<Integer> afterFirsIncrement = new LinkedList<>();
        afterFirsIncrement.add(1);
        afterFirsIncrement.add(0);
        afterFirsIncrement.add(0);
        afterFirsIncrement.add(0);
        afterFirsIncrement.add(0);
        exercise1.incrementMask(defaultMask);
        Assert.assertEquals(afterFirsIncrement, defaultMask);
    }

    @Test
    public void testIncrementBigMask(){
        List<Integer> defaultMask = new LinkedList<>();
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(2);
        defaultMask.add(0);
        List<Integer> expectedResult = new LinkedList<>();
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(2);
        expectedResult.add(1);
        exercise1.incrementMask(defaultMask);
        Assert.assertEquals(expectedResult, defaultMask);


    }
           */

    @Test
    public void hexToBin(){
        for (int i = 0; i < 10; i++) {
            System.out.println(exercise1.decToThrinity(String.valueOf(i)));
        }
        System.out.println("----> " + exercise1.decToThrinity(String.valueOf(21)));
    }

    @Test
    public void testStringDefaultMask(){
        Map<Integer, Integer> expectedOutput = new HashMap<>();
        expectedOutput.put(1,2);
        expectedOutput.put(8,5);

       Assert.assertEquals(exercise1.getStringDefaultMask(expectedOutput), "00");

    }

    @Test
    public void testStringMaskIsNotValid(){
        String mask = "2222";
        Assert.assertEquals(exercise1.isStringMaskValid(mask), false);

    }

    @Test
    public void testStringMaskIsValid(){
        String mask =  "2111221";
        Assert.assertEquals(exercise1.isStringMaskValid(mask), true);
    }
                       /*
    @Test
    public void testIncrementStringMask(){
        String mask = "22221120";
        String expectedOutput = "22221121";
        Assert.assertEquals(expectedOutput, exercise1.IncrementStringMask(mask));
    }                    */

    @Test
    public void testMaskIsValid(){
        String mask = "22211";
        String defaultMask = "000000";






       Assert.assertEquals(true, exercise1.isMaskValid(defaultMask, mask));

        String mask2 = "22122222";
        String defaultMask2 = "00000000";
        Assert.assertEquals(true, exercise1.isMaskValid(defaultMask2, mask2));


    }

    @Test
    public void testMaskIsNotValid(){
       String mask = "22222";
        String defaultMask = "00000";
     Assert.assertEquals(false, exercise1.isMaskValid(defaultMask, mask));

    }

    @Test
    public void testGetIndexValueForMask(){
        String mask = "22120";
        Assert.assertEquals(2, exercise1.getMaskValueForIndex(3, mask));
        String mask2 = "211002001";
        Assert.assertEquals(0, exercise1.getMaskValueForIndex(4, mask2));
    }

    @Test
    public void testIntersectMask(){
        String currentMask = "1";
        String defaultMask = "000";
        Assert.assertEquals("001", exercise1.intersectMask(currentMask, defaultMask));

        String currentMask2 = "221122111";
        String defaultMask2 = "000000000";
        Assert.assertEquals("221122111", exercise1.intersectMask(currentMask2, defaultMask2));
    }


}