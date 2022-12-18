package lab3;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@Data
@NoArgsConstructor
public class Mail {
    private Long id;
    private String from;
    private String to;
    private String content;
}
