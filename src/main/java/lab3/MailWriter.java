package lab3;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

public abstract class MailWriter {
    abstract String sendMail(Mail mail);
    abstract String toXml(Mail mail, Visitor visitor);

    public String getHeader(Mail mail) {
        String headerLine = "<=====================================>\n";
        String headerFrom = String.format("From %s %s", mail.getFrom(), LocalDateTime.now());
        String headerTo = String.format("To %s", mail.getTo());

        return headerLine + headerFrom + "\n" + headerTo + "\n";
    }
    public String getBlankLine() {
        return "\n";
    }

    public String getFooter() {
        return "Written by mail writer";
    }

    abstract void log(String data);
}
