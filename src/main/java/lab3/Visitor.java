package lab3;

public interface Visitor {
    String visitGmail(Mail mail);
    String visitOutlook(Mail mail);
    String visitYahoo(Mail mail);
}
