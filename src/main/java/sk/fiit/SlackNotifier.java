package sk.fiit;

import org.springframework.stereotype.Component;

@Component
public class SlackNotifier extends Notifier {

    @Override
    void notify(String message) {
        super.notify(message);
    }
}
