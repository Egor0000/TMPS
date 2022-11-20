package lab2.main.java.serializer;


import org.json.JSONObject;
import org.json.XML;

public class XmlSerializer {
    public String jsonToXml(String json) {
        JSONObject jsonObj = new JSONObject(json);
        String xml = XML.toString(jsonObj);

        return xml;
    }
}
