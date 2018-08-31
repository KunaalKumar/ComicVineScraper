import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SearchResults {
    public static void main(String[] args) throws IOException {
        String BASE_URI = "https://comicvine.gamespot.com";
        String searchTerm = "Superman";
        int pageNumber = 1;
        Document doc = Jsoup.connect(BASE_URI + "/search/?i=&q=" +
                searchTerm + "&page=" + pageNumber).get();

        // Test to get just the first result
//        Element searchResult = doc.select("#js-sort-filter-results > li").first();
//
//        for (Node result : searchResult.children()) {
//            System.out.println(result.attr("href"));
//        }

        // Test to get all results from page 1
        Elements searchResults = doc.select("#js-sort-filter-results > li");

        for (Element result : searchResults) {
            // Result Image
            System.out.println(result.childNode(3).childNode(1).childNode(1).attr("src"));
            // Result Name
            System.out.println(result.childNode(3).childNode(3).childNode(0).toString().trim());
            // Result type
            // TODO: parse function to get result type, and additional information
            System.out.println(result.childNode(3).childNode(5).childNode(1).childNode(0).toString().trim());
            // Result link
            System.out.println(BASE_URI + result.children().attr("href"));
            System.out.println();
        }

    }
}
