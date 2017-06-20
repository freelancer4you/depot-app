package de.goldmann.portfolio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.core.env.Environment;

public final class Utils {

    private Utils() {}

    public static double round(final double value, final int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static double getRandomPrice() {
        final int rangeMin = 1;
        final int rangeMax = 100;
        return ThreadLocalRandom.current().nextDouble(rangeMin, rangeMax);
    }

    public static boolean isDevMode(final Environment env) {
        final String activeProfile = env.getActiveProfiles()[0];
        return "development".equals(activeProfile);
    }

    public static double round(final BigDecimal value, final int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        final BigDecimal scaledValue = value.setScale(places, RoundingMode.HALF_UP);
        return scaledValue.doubleValue();
    }

    public static BigDecimal roundBigDecimal(final BigDecimal value, final int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        return value.setScale(places, RoundingMode.HALF_UP);
    }
}
