package lab3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class GmailMail extends MailWriter {
    @Override
    String sendMail(Mail mail) {
        System.out.println("Sending mail from gmail mail writer");
        return getHeader(mail) + getBlankLine() + mail.getContent() + getFooter();
    }

    @Override
    String toXml(Mail mail, Visitor visitor) {
        return visitor.visitGmail(mail);
    }

    @Override
    public String getFooter() {
        return  "\n<=====================================>\n" + super.getFooter() + " Gmail";
    }

    public void log(String data) {
        try {
            File yourFile = new File("gmail_log.txt");
            yourFile.createNewFile(); // if file already exists will do nothing

            BufferedWriter writer = new BufferedWriter(new FileWriter("gmail_log.txt", true));
            writer.write("[" + LocalDateTime.now() + "] " + data);
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error writing to file");
        }

    }

}
