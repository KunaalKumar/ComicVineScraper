/**
 * Created for Ignis for Android
 * Version : 1.0
 * Created by Kunaal Kumar
 */

package objects;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class Superhero {

    String superName;
    String realName;
    String[] aliases;
    Link publisher;

    public Superhero(Element result) {
        // Table cells = result.childNode(2).childNode(1)
        superName = result.childNode(3).childNode(1).childNode(1).childNode(3).childNode(3).childNode(0).toString().trim();
        realName = result.childNode(3).childNode(1).childNode(3).childNode(3).childNode(1).childNode(1).childNode(0).toString().trim();
        TextNode al = (TextNode) result.childNode(3).childNode(1).childNode(5).childNode(3).childNode(1).childNode(1).childNode(0);
        this.aliases = al.getWholeText().split("\r\n");
        publisher = new Link(
                result.childNode(3).childNode(1).childNode(7).childNode(3).childNode(1).childNode(1).childNode(0).childNode(0).toString().trim(),
                result.childNode(3).childNode(1).childNode(7).childNode(3).childNode(1).childNode(1).childNode(0).attr("href")
        );
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
}
