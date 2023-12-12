package sk.fiit;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SMSNotifier smsNotifier = new SMSNotifier();
        smsNotifier.notify("Hi, I will come at 7PM");
        SlackNotifier slackNotifier = new SlackNotifier();
        slackNotifier.notify("Hello, did you commit your changes?");
    }
}