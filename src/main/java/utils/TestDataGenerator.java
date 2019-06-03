package utils;

public class TestDataGenerator {

    /**
     * Returns a random number between min (inclusive) and max (exclusive)
     * 
     * @param minOffsetValue : the minimum value this method should return
     * @param maxOffsetValue : the maximum value this method should return
     */
    public double getRandomValueBetweenMaxAndMin(int minOffsetValue, int maxOffsetValue) {
        return Math.random() * (maxOffsetValue - minOffsetValue) + minOffsetValue;
    }

    /**
     * Returns a random number 0 to maxOffsetValue (inclusive)
     * 
     * @param text : if you pass -5 you will get back a value between 0-5
     */
    public double getRandomNumber(int maxOffsetValue) {
        return (int) (Math.random() * maxOffsetValue + 1);
    }

    /**
     * Pass a string and the function will append and return it with a random
     * integer
     * 
     * @param text : if you pass -test you will get back something like "test4981"
     */
    public String getCharacterNumericString(String text) { /* TO-DO */
        String finalText = text + "_" + getRandomValueBetweenMaxAndMin(10000000, 99999999);
        return finalText;
    }

}