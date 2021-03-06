/**
 * Created for Ignis for Android
 * Version : 1.1
 * Created by Kunaal Kumar
 */

package objects;

import org.jsoup.nodes.Element;

public class SearchResult {

    public static final String BASE_URI = "https://comicvine.gamespot.com";

    String name;
    String imageUrl;
    String type;
    int typeCode;
    int objectCode;
    String chipInfo;
    String resultUrl;

    public SearchResult(Element result) {
        name = result.childNode(3).childNode(3).childNode(0).toString().trim();
        setImageUri(result.childNode(3).childNode(1).childNode(1).attr("src"));
        setType(result.childNode(3).childNode(5).childNode(1).childNode(0).toString().trim());
        resultUrl = BASE_URI + result.children().attr("href");
        String codes = resultUrl.replaceAll("\\D", "");
        typeCode = Integer.parseInt(codes.substring(0, 4));
        objectCode = Integer.parseInt(codes.substring(4, codes.length()));
    }

    private void setType(String type) {
        chipInfo = type;
        String[] arr = type.split(" ");
        this.type = arr[0];
    }

    // Replace low res image with high res image
    private void setImageUri(String image) {
        this.imageUrl = image.replaceAll("square_small", "original");
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

    public String getResultUrl() {
        return resultUrl;
    }

    public String getChipInfo() {
        return chipInfo;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public int getObjectCode() {
        return objectCode;
    }
}
