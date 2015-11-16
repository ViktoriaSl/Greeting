package greeting;

import org.slf4j.Logger;

import java.time.LocalTime;
import java.util.Locale;

/**
 * Created by vika on 13.11.15.
 */
public class GreetingWriter {

    private static final LocalTime START_MORNING_TIME = LocalTime.of(6, 0);
    private static final LocalTime START_DAY_TIME = LocalTime.of(9, 0);
    private static final LocalTime START_EVENING_TIME = LocalTime.of(19, 0);
    private static final LocalTime START_NIGHT_TIME = LocalTime.of(23, 0);
    private static final String MORNING_GREETING_KEY = "morning.greeting";
    private static final String DAY_GREETING_KEY = "day.greeting";
    private static final String EVENING_GREETING_KEY = "evening.greeting";
    private static final String NIGHT_GREETING_KEY = "night.greeting";
    private Logger logger = org.slf4j.LoggerFactory.getLogger(GreetingWriter.class);


    String determineGreeting(LocalTime currentTime, Locale countryLocale) {
        String greetingString = null;
        LocalTime limitUpperValue = LocalTime.of(23, 59);
        LocalTime limitDownValue = LocalTime.of(0, 0);
        Dictionary dictionary = new Dictionary();
        if (currentTime.isBefore(START_MORNING_TIME) && currentTime.isAfter(limitDownValue) ||
                currentTime.isAfter(START_NIGHT_TIME) && currentTime.isBefore(limitUpperValue) || currentTime == START_NIGHT_TIME) {
            greetingString = dictionary.getTranslationForKey(NIGHT_GREETING_KEY,countryLocale);
        } else if (currentTime.isAfter(limitDownValue) && currentTime.isBefore(START_DAY_TIME) ||
                currentTime.isAfter(START_NIGHT_TIME) && currentTime.isBefore(limitUpperValue)) {
            greetingString = dictionary.getTranslationForKey(MORNING_GREETING_KEY,countryLocale);
        } else if (currentTime.isBefore(START_EVENING_TIME) && currentTime.isAfter(START_MORNING_TIME)) {
            greetingString = dictionary.getTranslationForKey(DAY_GREETING_KEY,countryLocale);
        } else if (currentTime.isBefore(START_NIGHT_TIME) && currentTime.isAfter(START_DAY_TIME)) {
            greetingString = dictionary.getTranslationForKey(EVENING_GREETING_KEY,countryLocale);
        }
        logger.info(greetingString);
        return greetingString;
    }


}
