package greeting;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vika on 13.11.15.
 */
public class Dictionary {
    private static final String ENGLISH_GREETING_PROPERTIES = "english-dictionary";
    private static final String RUSSIAN_GREETING_PROPERTIES = "russian-dictionary";
    private static final Locale ENGLISH_LOCALE = Locale.ENGLISH;
    private static final Locale US_LOCALE = Locale.US;
    private static final Locale RUSSIAN_LOCALE = new Locale("ru");

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
        ResourceBundle dictionaryKeys =
                ResourceBundle.getBundle(propertiesLanguage);
        return dictionaryKeys.getString(greetingKey);
    }


}
