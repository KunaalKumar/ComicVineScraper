import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class SearchResults {
    public static void main(String[] args) throws IOException {
        String searchTerm = "Superman";
        int pageNumber = 1;
        Document doc = Jsoup.connect("https://comicvine.gamespot.com/search/?i=&q=" +
                searchTerm + "&page=" + pageNumber).get();

        Elements searchResults = doc.select(".editorial .river .search-results");

        for (Element result : searchResults
        ) {

            result.text();

        }
    }
}
