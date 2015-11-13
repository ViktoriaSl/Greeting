package greeting.message.impl;

import greeting.message.Greeting;

/**
 * Created by vika on 13.11.15.
 */
public class RussianGreeting implements Greeting {

    @Override
    public String getMorningGreeting() {
        return "Доброе утро, Мир!";
    }

    @Override
    public String getDayGreeting() {
        return "Добрый день, Мир!";
    }

    @Override
    public String getEveningGreeting() {
        return "Добрый вечер, Мир!";
    }

    @Override
    public String getNightGreeting() {
        return "Доброй ночи, Мир!";
    }

}
