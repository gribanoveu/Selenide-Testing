package util;

import java.util.Random;

public class StringUtils {
    private static final String ALL_NUMERICAL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random random = new Random();

    public static String getRandomString(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALL_NUMERICAL.charAt(random.nextInt(ALL_NUMERICAL.length())));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomRepositoryNameWithPostfixLength(int postfixLength){
        return "testRepo_".concat(getRandomString(postfixLength));
    }
}
