import greeting.GreetingWriter;
import greeting.message.impl.EnglishGreeting;
import greeting.message.impl.RussianGreeting;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    private static final String RUSSIAN_NIGHT_GREETING = "Доброй ночи, Мир!";
    GreetingWriter greetingWriter = new GreetingWriter();

    @Test
    public void testDetermineCountryWithUSLocaleShouldReturnEnglishGreeting(){
            assertTrue(greetingWriter.determineCountry(US_LOCALE) instanceof EnglishGreeting);
      }
    @Test
    public void testDetermineCountryWithEnglishLocaleShouldReturnEnglishGreeting(){
        assertTrue(greetingWriter.determineCountry(ENGLISH_LOCALE) instanceof EnglishGreeting);
    }
    @Test
    public void testDetermineCountryWithRussianLocaleShouldReturnRussianGreeting(){
        assertTrue(greetingWriter.determineCountry(RUSSIAN_LOCALE) instanceof RussianGreeting);
    }

    @Test
    public void testDetermineGreetingShouldReturnDayGreetingInEnglish(){
        LocalTime dayTime =LocalTime.of(12,0);
        assertEquals(greetingWriter.determineGreeting(dayTime, ENGLISH_LOCALE), ENGLISH_DAY_GREETING);
    }

    @Test
    public void testDetermineGreetingLimitValueShouldReturnDayGreetingInEnglish(){
        LocalTime limitDayTime =LocalTime.of(9,0);
        assertEquals(greetingWriter.determineGreeting(limitDayTime, ENGLISH_LOCALE), ENGLISH_DAY_GREETING);
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

}
