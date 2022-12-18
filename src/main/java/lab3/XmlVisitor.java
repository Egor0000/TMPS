package lab3;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlVisitor implements Visitor {
    public String visitGmail(Mail mail) {
        System.out.println("Exporting Gmail mail to xml format ... ");
        MailXml mailXml = new MailXml("Gmail", mail);
        marshall(mailXml);
        System.out.println("Exporting Gmail mail  finished successfully ");
        return "";
    }

    public String visitYahoo(Mail mail) {
        System.out.println("Exporting Yahoo mail to xml format ... ");
        MailXml mailXml = new MailXml("Yahoo", mail);
        marshall(mailXml);
        System.out.println("Exporting Yahoo mail  finished successfully ");
        return "";
    }

    public String visitOutlook(Mail mail) {
        System.out.println("Exporting Outlook mail to xml format ... ");
        MailXml mailXml = new MailXml("Outlook", mail);
        marshall(mailXml);
        System.out.println("Exporting Outlook mail  finished successfully ");
        return "";
    }

    private void marshall(MailXml mailXml) {
        try {
            JAXBContext context = JAXBContext.newInstance(MailXml.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(mailXml, new File("./" + mailXml.getProvider() + "mailXml.xml"));


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
