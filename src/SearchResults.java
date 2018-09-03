import objects.SearchResult;
import objects.Superhero;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SearchResults {

    private static final String BASE_URI = "https://comicvine.gamespot.com";

    private static ArrayList<SearchResult> resultObjs = new ArrayList<>();
    private static Superhero character;

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

        doc = Jsoup.connect(resultObjs.get(0).getResultUri()).get();

        Element result = doc.select("#default-content > aside > div:nth-child(5)").first();

        // Test for character pojo
        character = new Superhero(result);
        System.out.println("Superhero name: " + character.getSuperName());
        System.out.println();
        System.out.println("Real name: " + character.getRealName());
        System.out.println();
        System.out.println("Aliases");
        for (String alias : character.getAliases()
        ) {
            System.out.println(alias);
        }
        System.out.println();
    }
}
