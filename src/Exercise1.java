import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: tomaszlelek
 * Date: 10/21/13
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Exercise1 {
    Map<Integer, List<String>> keyboard = new HashMap<>();

    public Exercise1() {
        List<String> nr0 = new LinkedList<>();

        List<String> nr2 = new LinkedList<>();
        List<String> nr3 = new LinkedList<>();
        List<String> nr4 = new LinkedList<>();
        List<String> nr5 = new LinkedList<>();
        List<String> nr6 = new LinkedList<>();
        List<String> nr7 = new LinkedList<>();
        List<String> nr8 = new LinkedList<>();
        List<String> nr9 = new LinkedList<>();
        nr2.add("A");
        nr2.add("B");
        nr2.add("C");
        nr3.add("D");
        nr3.add("E");
        nr3.add("F");
        nr4.add("G");
        nr4.add("H");
        nr4.add("I");
        nr5.add("J");
        nr5.add("K");
        nr5.add("L");
        nr6.add("M");
        nr6.add("N");
        nr6.add("O");
        nr7.add("P");
        nr7.add("R");
        nr7.add("S");
        nr8.add("T");
        nr8.add("U");
        nr8.add("V");
        nr9.add("W");
        nr9.add("X");
        nr9.add("Y");
        keyboard.put(2, nr2);
        keyboard.put(3, nr3);
        keyboard.put(4, nr4);
        keyboard.put(5, nr5);
        keyboard.put(6, nr6);
        keyboard.put(7, nr7);
        keyboard.put(8, nr8);
        keyboard.put(9, nr9);
    }


    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        exercise1.phoneNumber(args);

    }

    public int phoneNumber(String[] input){
        String[] inputArray = splitInput(input[0]);

        String regex = "[0-9]{9}";
        if( ! input[0].matches(regex)){
            System.out.println("ERROR");
            return -1;
        }

        Map<Integer, String> mapping = new LinkedHashMap<>();

        Map<Integer,Integer> toTransform = transformArray(input[0]);
        String defaultStringMask = getStringDefaultMask(toTransform);


            //Integer first = toTransform.get(5);
            //Integer second = toTransform.get(7);
            List<Integer> keys = new LinkedList<>();

            for(Integer i : toTransform.values()){
                keys.add(i);
            }

            int numberOfKeys = keys.size();
            int i = 0;
            int counter = 0;
            String mask = "";
            while(isMaskValid(defaultStringMask, mask)){
                mask = decToThrinity(String.valueOf(i));
                String correctMask = intersectMask(mask, defaultStringMask);

                    mapping.put(counter, "");
                    for (int j = 0; j < numberOfKeys; j++) {

                        String v = keyboard.get(keys.get(j)).get(getMaskValueForIndex(j,correctMask));
                        String current = mapping.get(counter);
                        current += v;
                        mapping.put(counter, current);
                    }
                counter++;

                i++;

            }
        System.out.println(mapping);
        printResult(mapping, toTransform, inputArray);

        return 0;
    }

    public void printResult(Map<Integer, String> mapping, Map<Integer,Integer> toTransform, String[] inputArray){
        System.out.println(mapping + "  " + toTransform + " "  + inputArray);
        for(String map : mapping.values() ){
            String[] mapArray = splitInput(map);
            int mappingIndex = 0;
            for (int i = 0; i < inputArray.length ; i++) {



                for(Integer toTransformCur : toTransform.keySet()){
                    if(toTransformCur.equals(i)){
                        System.out.print(mapArray[mappingIndex]);
                        i++;
                        mappingIndex++;
                    }
                }

                if(i < inputArray.length)
                    System.out.print(inputArray[i]);
            }
            System.out.println();
        }


    }

    public String[] splitInput(String input) {
        return Arrays.copyOfRange(input.split(""), 1, input.length() + 1);

    }

    public String intersectMask(String mask, String defaultStringMask) {
       int numberToFillWithZero = defaultStringMask.length() - mask.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberToFillWithZero; i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(mask);
        return stringBuilder.toString();

    }

    public int getMaskValueForIndex(int index, String mask){
        return Character.getNumericValue(mask.charAt(index));

    }
    public String IncrementStringMask(String defaultStringMask) {
        Integer mask = Integer.parseInt(thrinityToDec(defaultStringMask));
        mask++;
        defaultStringMask =  decToThrinity(String.valueOf(mask));
        return defaultStringMask;
    }

    //TODO incrementsMask, fix BigInteger issue
    public void incrementMask(List<Integer> defaultMask) {
        ListIterator<Integer> li = defaultMask.listIterator(defaultMask.size());

        int sum = 0;
        int j = 1;
        while(li.hasPrevious()){
            sum += li.previous() * j;
            j *= 10;
        }
        System.out.println(sum);
        sum+=1;
        String result = decToThrinity(String.valueOf(sum));
        char[] chars = result.toCharArray();

        int defaultMaskLastIndex = defaultMask.size() - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            defaultMask.set(defaultMaskLastIndex, Character.getNumericValue(chars[i]));
            defaultMaskLastIndex--;
        }
    }

    public String decToThrinity(String s) {
        return new BigInteger(s).toString(3);
    }

    public String thrinityToDec(String s){
        return new BigInteger(s).toString(10);
    }

    public boolean maskIsValid(List<Integer> defaultMask) {
        for(Integer i : defaultMask){
            if(i == 2)
                continue;
            else if(i != 2)
                return true;
            else
                return false;
        }
        return false;
    }

    public List<Integer> getDefaultMask(Map<Integer, Integer> toTransform) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < toTransform.size(); i++) {
            result.add(0);
        }
        return result;

    }
    public boolean isMaskValid(String defaultMask, String currentMask){
        if(defaultMask.length() != currentMask.length())
            return true;
        return isStringMaskValid(currentMask);

    }

    public String getStringDefaultMask(Map<Integer, Integer> toTransform){
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < toTransform.size(); i++) {
            buffer.append("0");
        }
        return buffer.toString();
    }

    public boolean isStringMaskValid(String mask){


        for (int i = 0; i < mask.length(); i++) {
            if(mask.charAt(i) == '2')
                continue;
            else if(mask.charAt(i) != '2')
                return true;
            else
                return false;
        }
        return false;
    }




    public Map<Integer,Integer> transformArray(String number){
        char[] numberArray = number.toCharArray();
        int fromBounds = 2;
        int toBounds = 9;
        Map<Integer,Integer> transformed = new HashMap<Integer,Integer>();

        for (int i = 0; i < numberArray.length; i++) {
            if(Character.getNumericValue(numberArray[i]) >= fromBounds && Character.getNumericValue(numberArray[i]) <= toBounds){
                transformed.put(i, Character.getNumericValue(numberArray[i]));
            }
        }
        return transformed;

    }
}
