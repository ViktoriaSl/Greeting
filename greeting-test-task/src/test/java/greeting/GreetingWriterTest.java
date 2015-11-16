package greeting;

import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by vika on 13.11.15.
 */
public class GreetingWriterTest {

    private static final Locale ENGLISH_LOCALE = Locale.ENGLISH;
    private static final Locale US_LOCALE = Locale.US;
    private static final Locale RUSSIAN_LOCALE = new Locale("ru");

    private static final String ENGLISH_MORNING_GREETING = "Good morning, World!";
    private static final String ENGLISH_DAY_GREETING = "Good day, World!";
    private static final String ENGLISH_EVENING_GREETING = "Good evening, World!";
    private static final String ENGLISH_NIGHT_GREETING = "Good night, World!";

    private static final String RUSSIAN_MORNING_GREETING = "Доброе утро, Мир!";
    private static final String RUSSIAN_DAY_GREETING = "Добрый день, Мир!";
    private static final String RUSSIAN_EVENING_GREETING = "Добрый вечер, Мир!";
    private static final String RUSSIAN_NIGHT_GREETING = "Добрoй ночи, Мир!";
    private static final String NIGHT_GREETING_KEY = "night.greeting";
    private static final String DAY_GREETING_KEY = "day.greeting";
    private static final String EVENING_GREETING_KEY = "evening.greeting";
    private static final String MORNING_GREETING_KEY = "morning.greeting";

    GreetingWriter greetingWriter = new GreetingWriter();
    Dictionary dictionary = new Dictionary();

    @Test
    public void testDetermineGreetingShouldReturnDayGreetingInEnglish(){
        LocalTime dayTime =LocalTime.of(12,0);
        assertEquals(greetingWriter.determineGreeting(dayTime, ENGLISH_LOCALE), ENGLISH_DAY_GREETING);
    }

    @Test
    public void testDetermineGreetingLimitValueShouldReturnDayGreetingInEnglish(){
        LocalTime limitDayTime =LocalTime.of(9,0);
        assertEquals(greetingWriter.determineGreeting(limitDayTime, ENGLISH_LOCALE), ENGLISH_DAY_GREETING);
        assertEquals(greetingWriter.determineGreeting(limitDayTime, US_LOCALE), ENGLISH_DAY_GREETING);

    }


    @Test
    public void testDetermineGreetingLimitValueShouldReturnEveningGreetingInEnglish(){
        LocalTime limitEveningTime =LocalTime.of(19,0);
        assertEquals(greetingWriter.determineGreeting(limitEveningTime, ENGLISH_LOCALE), ENGLISH_EVENING_GREETING);
    }

    @Test
    public void testDetermineGreetingValueShouldReturnEveningGreetingInEnglish(){
        LocalTime eveningTime =LocalTime.of(22,0);
        assertEquals(greetingWriter.determineGreeting(eveningTime, ENGLISH_LOCALE), ENGLISH_EVENING_GREETING);
    }

    @Test
    public void testDetermineGreetingLimitValueShouldReturnNightGreetingInEnglish(){
        LocalTime nightTime =LocalTime.of(1,0);
        assertEquals(greetingWriter.determineGreeting(nightTime, ENGLISH_LOCALE), ENGLISH_NIGHT_GREETING);
    }

    @Test
    public void testDetermineGreetingLimitValueShouldReturnMorningGreetingInEnglish(){
        LocalTime limitMorningTime =LocalTime.of(6,0);
        assertEquals(greetingWriter.determineGreeting(limitMorningTime, ENGLISH_LOCALE), ENGLISH_MORNING_GREETING);
    }
    @Test
    public void testDetermineGreetingShouldReturnNightGreetingInEnglish(){
        LocalTime limitNightTime =LocalTime.of(23,0);
        assertEquals(ENGLISH_NIGHT_GREETING,greetingWriter.determineGreeting(limitNightTime, ENGLISH_LOCALE));
    }

    @Test
    public void testDetermineGreetingShouldReturnMorningGreetingInEnglish(){
        LocalTime morningTime =LocalTime.of(7,0);
        assertEquals(ENGLISH_MORNING_GREETING,greetingWriter.determineGreeting(morningTime, ENGLISH_LOCALE));
    }

    @Test
    public void testDetermineGreetingShouldReturnDayGreetingInRussian(){
        LocalTime dayTime =LocalTime.of(12,0);
        assertEquals(RUSSIAN_DAY_GREETING,greetingWriter.determineGreeting(dayTime, RUSSIAN_LOCALE));
    }

    @Test
    public void testDetermineGreetingLimitValueShouldReturnDayGreetingInRussian(){
        LocalTime limitDayTime =LocalTime.of(9,0);
        assertEquals(RUSSIAN_DAY_GREETING,greetingWriter.determineGreeting(limitDayTime, RUSSIAN_LOCALE));
    }


    @Test
    public void testDetermineGreetingLimitValueShouldReturnEveningGreetingInRussian(){
        LocalTime limitEveningTime =LocalTime.of(19,0);
        assertEquals(RUSSIAN_EVENING_GREETING,greetingWriter.determineGreeting(limitEveningTime, RUSSIAN_LOCALE));
    }

    @Test
    public void testDetermineGreetingValueShouldReturnEveningGreetingInRussian(){
        LocalTime eveningTime =LocalTime.of(22,0);
        assertEquals(RUSSIAN_EVENING_GREETING,greetingWriter.determineGreeting(eveningTime, RUSSIAN_LOCALE));
    }

    @Test
    public void testDetermineGreetingLimitValueShouldReturnNightGreetingInRussian(){
        LocalTime nightTime =LocalTime.of(1,0);
        assertEquals(RUSSIAN_NIGHT_GREETING,greetingWriter.determineGreeting(nightTime, RUSSIAN_LOCALE));
    }

    @Test
    public void testDetermineGreetingLimitValueShouldReturnMorningGreetingInRussian(){
        LocalTime limitMorningTime =LocalTime.of(6,0);
        assertEquals(RUSSIAN_MORNING_GREETING, greetingWriter.determineGreeting(limitMorningTime, RUSSIAN_LOCALE));
    }
    @Test
    public void testDetermineGreetingShouldReturnNightGreetingInRussian(){
        LocalTime limitNightTime =LocalTime.of(23,0);
        assertEquals(RUSSIAN_NIGHT_GREETING,greetingWriter.determineGreeting(limitNightTime, RUSSIAN_LOCALE));
    }

    @Test
    public void testDetermineGreetingShouldReturnMorningGreetingInRussian(){
        LocalTime morningTime =LocalTime.of(7,0);
        assertEquals(RUSSIAN_MORNING_GREETING,greetingWriter.determineGreeting(morningTime, RUSSIAN_LOCALE));
    }


    @Test
    public void testGetTranslationShouldReturnMorningGreetingInEnglish(){
       assertEquals(ENGLISH_MORNING_GREETING,dictionary.getTranslationForKey(MORNING_GREETING_KEY,ENGLISH_LOCALE));
    }
    @Test
    public void testGetTranslationShouldReturnDAYGreetingInEnglish(){
        assertEquals(ENGLISH_DAY_GREETING,dictionary.getTranslationForKey(DAY_GREETING_KEY,ENGLISH_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnEveningGreetingInEnglish(){
        assertEquals(ENGLISH_EVENING_GREETING,dictionary.getTranslationForKey(EVENING_GREETING_KEY,ENGLISH_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnNightGreetingInEnglish(){
        assertEquals(ENGLISH_NIGHT_GREETING,dictionary.getTranslationForKey(NIGHT_GREETING_KEY,ENGLISH_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnNightGreetingInUS(){
        assertEquals(ENGLISH_NIGHT_GREETING,dictionary.getTranslationForKey(NIGHT_GREETING_KEY,US_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnMorningGreetingInUS(){
        assertEquals(ENGLISH_MORNING_GREETING,dictionary.getTranslationForKey(MORNING_GREETING_KEY,US_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnDayGreetingInUS(){
        assertEquals(ENGLISH_DAY_GREETING,dictionary.getTranslationForKey(DAY_GREETING_KEY,US_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnEveningGreetingInUS(){
        assertEquals(ENGLISH_EVENING_GREETING,dictionary.getTranslationForKey(EVENING_GREETING_KEY,US_LOCALE));
    }


    @Test
    public void testGetTranslationShouldReturnNightGreetingInRussian(){
        assertEquals(RUSSIAN_NIGHT_GREETING,dictionary.getTranslationForKey(NIGHT_GREETING_KEY,RUSSIAN_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnMorningGreetingInRussian(){
        assertEquals(RUSSIAN_MORNING_GREETING,dictionary.getTranslationForKey(MORNING_GREETING_KEY,RUSSIAN_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnDayGreetingInRussian(){
        assertEquals(RUSSIAN_DAY_GREETING,dictionary.getTranslationForKey(DAY_GREETING_KEY,RUSSIAN_LOCALE));
    }

    @Test
    public void testGetTranslationShouldReturnEveningGreetingInRussian(){
        assertEquals(RUSSIAN_EVENING_GREETING,dictionary.getTranslationForKey(EVENING_GREETING_KEY,RUSSIAN_LOCALE));
    }


}
