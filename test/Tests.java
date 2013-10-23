import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
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
    private final Exercise1 exercise1 = new Exercise1();

    @Test
    public void testBadImput(){
        String[] args = new String[1];
        args[0] = "bad input";
        boolean result = exercise1.checkInputCorrectness(args[0]);
        Assert.assertEquals(result, false);
    }
    @Test
    public void testCorrectInput(){
        String[] args = new String[1];
        args[0] = "110015010";
        int result = exercise1.findAllNumberCombinations(args);
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
    public void hexToBin(){

        String result = exercise1.decToTrinary(String.valueOf(3));
        Assert.assertEquals(result, "10");
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

    @Test
    public void testSplitInput(){
        String input = "9876543219";
        String[] expected = new String[]{"9", "8", "7", "6", "5", "4", "3", "2", "1", "9"};

        Assert.assertArrayEquals(exercise1.splitInput(input), expected);
    }

    @Test
    public void testBigInput(){
         String[] args = new String[1];
         args[0] = "338356737";
         int result = exercise1.findAllNumberCombinations(args);
         Assert.assertEquals(result, 0);
    }

}