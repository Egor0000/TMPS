package lab3;

public class Main {
    public static void main(String[] args) {
        MailClient mailClient = new MailClient();

        // Init new strategy
        MailWriter gmailWriter = new GmailMail();

        // Set this strategy to the context
        mailClient.setWriter(gmailWriter);
        Mail mail =  new Mail();
        mail.setTo("John Dow");
        mail.setFrom("From");
        mail.setContent("Hello");

        // Use strategy in a method
        String resp = mailClient.sendMail(mail);

        // Use visitor for xml parsing
        Visitor visitor = new XmlVisitor();
        gmailWriter.toXml(mail, visitor);

        // Use observer
        LoggerPublisher loggerPublisher = new LoggerPublisher();
        loggerPublisher.subscribe(gmailWriter);

        // add new mailWriter
        MailWriter outlookWriter = new OutlookMail();
        loggerPublisher.subscribe(outlookWriter);

        loggerPublisher.notify("Start logging for all ...");
    }
}
