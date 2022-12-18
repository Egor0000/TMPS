package lab3;

import java.util.HashSet;
import java.util.Set;

public class MailWriterIterator {
    private Set<MailWriter> mailWriters;
    private int current = 0;

    public MailWriter getNext() {
        if (hasMore()) {
            return mailWriters.stream().toList().get(current++);
        }
        return null;
    }

    public boolean hasMore() {
        init();
        return current < mailWriters.size();
    }

    public void init() {
        if (mailWriters == null) {
            mailWriters = new HashSet<>();
        }
    }

    public void setWriters(Set<MailWriter> mailWriters) {
        this.mailWriters = mailWriters;
    }
}
