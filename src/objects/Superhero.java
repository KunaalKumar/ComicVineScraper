package objects;


import org.jsoup.nodes.Element;

public class Superhero {

    String superName;

    public Superhero(Element result) {
        // Table cells = result.childNode(2).childNode(1)
        superName = result.childNode(3).childNode(1).childNode(1).childNode(3).childNode(3).childNode(0).toString().trim();
    }

    public String getSuperName() {
        return superName;
    }
}
