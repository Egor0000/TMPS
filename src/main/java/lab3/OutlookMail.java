package lab3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class OutlookMail extends MailWriter {
    @Override
    String sendMail(Mail mail) {
        System.out.println("Sending mail from Outlook mail writer");
        return getHeader(mail) + getBlankLine() + mail.getContent() + getFooter();
    }

    @Override
    String toXml(Mail mail, Visitor visitor) {
        return visitor.visitOutlook(mail);
    }

    @Override
    public String getFooter() {
        return "\n<=====================================>\n" + super.getFooter() + " Outlook";
    }

    public void log(String data) {
        try {
            File yourFile = new File("outlook_log.txt");
            yourFile.createNewFile(); // if file already exists will do nothing

            BufferedWriter writer = new BufferedWriter(new FileWriter("outlook_log.txt", true));
            writer.write("[" + LocalDateTime.now() + "] " + data);
            writer.newLine();
            writer.close();
        } catch (Exception ex) {
            System.out.println("Error writing to file");
        }

    }
}
