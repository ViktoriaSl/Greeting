package greeting.message.impl;

import greeting.message.Greeting;

/**
 * Created by vika on 13.11.15.
 */
public class EnglishGreeting implements Greeting {

    @Override
    public String getMorningGreeting() {
        return "Good morning, World!";
    }

    @Override
    public String getDayGreeting() {
        return "Good day, World!";
    }

    @Override
    public String getEveningGreeting() {
        return "Good evening, World!";
    }

    @Override
    public String getNightGreeting() {
        return "Good night, World!";
    }
}
