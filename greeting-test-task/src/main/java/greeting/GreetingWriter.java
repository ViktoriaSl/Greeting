package greeting;

import greeting.message.Greeting;
import greeting.message.impl.EnglishGreeting;
import greeting.message.impl.RussianGreeting;
import org.slf4j.Logger;

import java.time.LocalTime;
import java.util.Locale;

/**
 * Created by vika on 13.11.15.
 */
public class GreetingWriter {
    Logger logger = org.slf4j.LoggerFactory.getLogger(GreetingWriter.class);
    private static final Locale ENGLISH_LOCALE = Locale.ENGLISH;
    private static final Locale US_LOCALE = Locale.US;
    private static final Locale RUSSIAN_LOCALE = new Locale("ru");
    private static final LocalTime START_MORNING_TIME = LocalTime.of(6, 0);
    private static final LocalTime START_DAY_TIME = LocalTime.of(9, 0);
    private static final LocalTime START_EVENING_TIME = LocalTime.of(19, 0);
    private static final LocalTime START_NIGHT_TIME = LocalTime.of(23, 0);

    public Greeting determineCountry(Locale countryLocale) {
        Greeting userGreeting = null;
        if (countryLocale.equals(ENGLISH_LOCALE) || countryLocale.equals(US_LOCALE)) {
            userGreeting = new EnglishGreeting();
        } else if (countryLocale.equals(RUSSIAN_LOCALE)) {
            userGreeting = new RussianGreeting();
        }
        return userGreeting;
    }


    public String determineGreeting(LocalTime currentTime, Locale countryLocale) {
        String greetingString = null;
        LocalTime limitUpperValue = LocalTime.of(23, 59);
        LocalTime limitDownValue = LocalTime.of(0, 0);
        Greeting currentUserGreeting = determineCountry(countryLocale);
        if (currentTime.isBefore(START_MORNING_TIME) && currentTime.isAfter(limitDownValue) ||
                currentTime.isAfter(START_NIGHT_TIME) && currentTime.isBefore(limitUpperValue) || currentTime == START_NIGHT_TIME) {
            greetingString = currentUserGreeting.getNightGreeting();
        } else if (currentTime.isAfter(limitDownValue) && currentTime.isBefore(START_DAY_TIME) ||
                currentTime.isAfter(START_NIGHT_TIME) && currentTime.isBefore(limitUpperValue)) {
            greetingString = currentUserGreeting.getMorningGreeting();
        } else if (currentTime.isBefore(START_EVENING_TIME) && currentTime.isAfter(START_MORNING_TIME)) {
            greetingString = currentUserGreeting.getDayGreeting();
        } else if (currentTime.isBefore(START_NIGHT_TIME) && currentTime.isAfter(START_DAY_TIME)) {
            greetingString = currentUserGreeting.getEveningGreeting();
        }
        logger.info(greetingString);
        return greetingString;
    }

}
