package objects;

import org.jsoup.nodes.Element;

public class SearchResult {

    private final String BASE_URI = "https://comicvine.gamespot.com";

    String name;
    String imageUrl;
    String type;
    String resultUri;

    public SearchResult(Element result) {
        name = result.childNode(3).childNode(3).childNode(0).toString().trim();
        imageUrl = result.childNode(3).childNode(1).childNode(1).attr("src");
        // TODO: parse function to get result type, and additional information
        type = result.childNode(3).childNode(5).childNode(1).childNode(0).toString().trim();
        resultUri = BASE_URI + result.children().attr("href");
    }

    public String getBASE_URI() {
        return BASE_URI;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getType() {
        return type;
    }

    public String getResultUri() {
        return resultUri;
    }
}
