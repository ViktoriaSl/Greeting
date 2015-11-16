package greeting;

import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by vika on 13.11.15.
 */
public class Dictionary {
    private static final String ENGLISH_GREETING_PROPERTIES = "src/main/resources/english-dictionary.properties";
    private static final String RUSSIAN_GREETING_PROPERTIES = "src/main/resources/russian-dictionary.properties";
    private static final Locale ENGLISH_LOCALE = Locale.ENGLISH;
    private static final Locale US_LOCALE = Locale.US;
    private static final Locale RUSSIAN_LOCALE = new Locale("ru");
    private Logger logger = org.slf4j.LoggerFactory.getLogger(Dictionary.class);

    String getTranslationForKey(String greetingKey, Locale currentLocale) {
        String translation = null;
        if (currentLocale.equals(US_LOCALE) || currentLocale.equals(ENGLISH_LOCALE)) {
            translation = getGreeting(ENGLISH_GREETING_PROPERTIES, greetingKey);
        } else if (currentLocale.equals(RUSSIAN_LOCALE)) {
            translation = getGreeting(RUSSIAN_GREETING_PROPERTIES, greetingKey);
        }
        return translation;
    }

    private String getGreeting(String propertiesLanguage, String greetingKey) {
        Properties props = new Properties();
        try {

            props.load(new InputStreamReader(new FileInputStream(propertiesLanguage), "UTF-8"));
        } catch (IOException e) {
            logger.info("File with path "+propertiesLanguage +" not exists");
        }
        return props.getProperty(greetingKey);
    }


}
