package objects;


import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class Superhero {

    String superName;
    String realName;
    String[] aliases;

    public Superhero(Element result) {
        // Table cells = result.childNode(2).childNode(1)
        superName = result.childNode(3).childNode(1).childNode(1).childNode(3).childNode(3).childNode(0).toString().trim();
        realName = result.childNode(3).childNode(1).childNode(3).childNode(3).childNode(1).childNode(1).childNode(0).toString().trim();
        TextNode al = (TextNode) result.childNode(3).childNode(1).childNode(5).childNode(3).childNode(1).childNode(1).childNode(0);
        this.aliases = al.getWholeText().split("\r\n");
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
}
