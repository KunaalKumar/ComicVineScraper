/**
 * Created for Ignis for Android
 * Version : 1.0
 * Created by Kunaal Kumar
 */

package objects;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class Superhero {

    public static final int typeCode = 4005;

    String superName;
    String superheroUri;
    int objectCode;
    String realName;
    String[] aliases;
    Link publisher;
    Link[] creators;

    public Superhero(Element result) {
        // Table cells = result.childNode(2).childNode(1)
        String codes = result.baseUri().replaceAll("\\D", "");
        // Check for if object isn't character
        if (typeCode != Integer.parseInt(codes.substring(0, 4))) {
            return;
        }
        superheroUri = result.baseUri();
        objectCode = Integer.parseInt(codes.substring(4, codes.length()));
        superName = result.childNode(3).childNode(1).childNode(1).childNode(3).childNode(3).childNode(0).toString().trim();
        realName = result.childNode(3).childNode(1).childNode(3).childNode(3).childNode(1).childNode(1).childNode(0).toString().trim();
        TextNode al = (TextNode) result.childNode(3).childNode(1).childNode(5).childNode(3).childNode(1).childNode(1).childNode(0);
        this.aliases = al.getWholeText().split("\r\n");
        publisher = new Link(
                result.childNode(3).childNode(1).childNode(7).childNode(3).childNode(1).childNode(1).childNode(0).childNode(0).toString().trim(),
                result.childNode(3).childNode(1).childNode(7).childNode(3).childNode(1).childNode(1).childNode(0).attr("href")
        );

        int oddCreators = result.childNode(3).childNode(1).childNode(9).childNode(3).childNode(1).childNodes().size();
        if (oddCreators <= 1) {
            creators = new Link[1];
            creators[0] = new Link("None", null);
        } else {
            int creatorCounter = 0;
            creators = new Link[oddCreators / 2];
            for (int i = 1; i < oddCreators; i += 2) {
                creators[creatorCounter] = new Link(
                        result.childNode(3).childNode(1).childNode(9).childNode(3).childNode(1).childNode(i).childNode(0).childNode(0).toString().trim(),
                        result.childNode(3).childNode(1).childNode(9).childNode(3).childNode(1).childNode(i).childNode(0).attr("href")
                );
                creatorCounter++;
            }
        }

    }

    public String getRealName() {
        return realName;
    }

    public String getSuperName() {
        return superName;
    }

    public String[] getAliases() {
        return aliases;
    }

    public Link getPublisher() {
        return publisher;
    }

    public String getSuperheroUri() {
        return superheroUri;
    }

    public int getObjectCode() {
        return objectCode;
    }

    public Link[] getCreators() {
        return creators;
    }

    // For debugging
    @Override
    public String toString() {
        if (superheroUri == null) {
            return "Not a character";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("******************** ").append(getSuperName()).append(" ********************");
        stringBuilder.append("\n");
        stringBuilder.append("Real name: ").append(getRealName());
        stringBuilder.append("\n");
        stringBuilder.append("Link: ").append(getRealName());
        stringBuilder.append("\n");
        stringBuilder.append("-------Aliases-------\n");
        for (String alias : getAliases()
        ) {
            stringBuilder.append(alias).append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("-------Publisher-------\n");
        stringBuilder.append(getPublisher().getName()).append("\n");
        stringBuilder.append(getPublisher().getLink()).append("\n");
        stringBuilder.append("\n");
        stringBuilder.append("-------Creators-------\n");
        for (Link creator : getCreators()) {
            stringBuilder.append(creator.getName()).append("\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
