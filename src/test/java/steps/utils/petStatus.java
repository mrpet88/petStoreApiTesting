package steps.utils;

import java.util.Random;

public enum petStatus {
    available,
    pending,
    sold;

    private static final Random random = new Random();

    public static <T extends Enum<?>> T randomStatus(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
