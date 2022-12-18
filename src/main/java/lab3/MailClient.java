package lab3;

import lombok.Data;

@Data
public class MailClient {
    private MailWriter writer;

    public String sendMail(Mail mail) {
        if (writer == null) {
            System.out.println("Null writer. Cannot send mail");
            return null;
        }
        String resp = writer.sendMail(mail);
        System.out.println(resp);
        return resp;
    }
}
