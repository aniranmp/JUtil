package ir.aliap1376ir.lib.jutil.security;

import java.util.Random;


public class SlugGenerator {

    public enum Options {
        GENERATE_ONLY_FROM_NUMBERS,
        GENERATE_ONLY_FROM_LETTERS,
        GENERATE_FROM_NUMBERS_AND_LETTERS
    }

    static final byte LENGTH_MIN_LIMIT = 3;
    static final byte LENGTH_MAX_LIMIT = 127;

    private static final char[] numbers = "0123456789".toCharArray();
    private static final char[] letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();


    public static String generate(Options option, int length) {
        length = checkAndSetLength(length);
        char[] slug;

        switch (option) {
            case GENERATE_ONLY_FROM_NUMBERS:
                slug = generateFromSource(numbers, length);
                break;
            case GENERATE_ONLY_FROM_LETTERS:
                slug = generateFromSource(letters, length);
                break;
            case GENERATE_FROM_NUMBERS_AND_LETTERS:
                slug = generateFromSource(numbersAndLetters, length);
                break;
            default:
                slug = generateFromSource(numbersAndLetters, length);
                break;
        }
        return String.valueOf(slug);
    }

    /**
     * Method to avoid code duplication.
     * The generation will happen here.
     *
     * @author kivimango
     * @since 1.0
     */

    private static char[] generateFromSource(char[] source, int length) {
        char[] result = new char[length];
        Random randomizer = new Random();

        for (byte i = 0; i < length; i++) {
            result[i] = source[randomizer.nextInt(source.length)];
        }
        return result;
    }

    private static int checkAndSetLength(int lengthToCheck) {
        if (lengthToCheck < LENGTH_MIN_LIMIT) {
            lengthToCheck = LENGTH_MIN_LIMIT;
        } else if (lengthToCheck > LENGTH_MAX_LIMIT) {
            lengthToCheck = LENGTH_MAX_LIMIT;
        }
        return lengthToCheck;
    }
}

