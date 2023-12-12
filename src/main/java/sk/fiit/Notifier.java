package sk.fiit;

import org.springframework.stereotype.Component;

@Component
public abstract class Notifier {

    void notify(String message) {
        System.out.println(message);
    }
}

