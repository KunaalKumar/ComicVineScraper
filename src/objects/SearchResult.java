package objects;

import org.jsoup.nodes.Element;

public class SearchResult {

    private final String BASE_URI = "https://comicvine.gamespot.com";

    String name;
    String imageUrl;
    String type;
    String chipInfo;
    String resultUri;

    public SearchResult(Element result) {
        name = result.childNode(3).childNode(3).childNode(0).toString().trim();
        imageUrl = result.childNode(3).childNode(1).childNode(1).attr("src");
        setType(result.childNode(3).childNode(5).childNode(1).childNode(0).toString().trim());
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

    private void setType(String type) {
        chipInfo = type;
        String[] arr = type.split(" ");
        this.type = arr[0];
    }

    // Character (14530 issues) (DC Comics)
    public String getType() {
        return type;
    }

    public String getResultUri() {
        return resultUri;
    }

    public String getChipInfo() {
        return chipInfo;
    }
}
