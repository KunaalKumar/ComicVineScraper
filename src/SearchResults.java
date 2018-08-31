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
            System.out.println(BASE_URI + result.children().attr("href"));
        }

    }
}
