package lab2.main.java.serializer;

import lab2.main.java.user.User;
import org.json.JSONObject;

public class XmlAdapter {
    private final XmlSerializer xmlSerializer;

    public XmlAdapter(XmlSerializer xmlSerializer) {
        this.xmlSerializer = xmlSerializer;
    }

    public String userToXml(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put("id", user.getId());
        userJson.put("name", user.getName());
        userJson.put("surname", user.getSurname());
        userJson.put("uid", user.getUid());
        return xmlSerializer.jsonToXml(userJson.toString());
    }
}
