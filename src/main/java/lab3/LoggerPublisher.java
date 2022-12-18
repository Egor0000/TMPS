package lab3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LoggerPublisher {
    private Set<MailWriter> mailWriters = new HashSet<>();

    public void subscribe(MailWriter mailWriter) {
        mailWriters.add(mailWriter);
    }

    public void unsubscribe(MailWriter mailWriter) {
        mailWriters.remove(mailWriter);
    }

    public void notify(String log) {
        MailWriterIterator mailWriterIterator = new MailWriterIterator();
        mailWriterIterator.setWriters(mailWriters);
        while (mailWriterIterator.hasMore()) {
            mailWriterIterator.getNext().log(log);
        }
    }
}
