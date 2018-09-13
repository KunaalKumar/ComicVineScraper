/**
 * Created for Ignis for Android
 * Version : 1.0
 * Created by Kunaal Kumar
 */

package objects;

public class Link {

    String name;
    String link;
    int typeCode;
    int objectCode;

    public Link(String name, String link) {
        this.name = name;
        this.link = SearchResult.BASE_URI + link;
        if (link == null) {
            typeCode = -1;
            objectCode = -1;
        } else {
            String codes = link.replaceAll("\\D", "");
            typeCode = Integer.parseInt(codes.substring(0, 4));
            objectCode = Integer.parseInt(codes.substring(4, codes.length()));
        }
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    // Returns -1 if no link exists
    public int getObjectCode() {
        return objectCode;
    }

    // Returns -1 if no link exists
    public int getTypeCode() {
        return typeCode;
    }
}
