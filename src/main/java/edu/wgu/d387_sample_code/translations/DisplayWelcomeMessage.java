package edu.wgu.d387_sample_code.translations;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;

public class DisplayWelcomeMessage implements Callable<String> {
    private final Locale locale;

    public DisplayWelcomeMessage(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String call() {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        return bundle.getString("welcome.message");
    }
}
