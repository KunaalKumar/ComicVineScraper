import objects.SearchResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SearchResults {

    public static final String BASE_URI = "https://comicvine.gamespot.com";

    public static ArrayList<SearchResult> resultObjs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String searchTerm = "Superman";
        int pageNumber = 1;
        Document doc = Jsoup.connect(BASE_URI + "/search/?i=&q=" +
                searchTerm + "&page=" + pageNumber).get();

        // Test to get all results from page 1
        Elements searchResults = doc.select("#js-sort-filter-results > li");

        // Add search results to arraylist
        for (Element result : searchResults) {
            resultObjs.add(new SearchResult(result));
        }

        // Print out info for debugging
        for (SearchResult result : resultObjs
        ) {
            System.out.println(result.getName());
            System.out.println(result.getType() + " --> " + result.getChipInfo());
            System.out.println();
        }

    }
}
