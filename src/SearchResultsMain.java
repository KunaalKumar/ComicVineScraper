import objects.SearchResult;
import objects.Superhero;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class SearchResultsMain {

    private static ArrayList<SearchResult> resultObjs = new ArrayList<>();
    private static Superhero character;

    public static void main(String[] args) {
        String searchTerm = "Superman";
        int pageNumber = 1;

        // Test to get all results from page 1
        Elements searchResults = ComicVineClient.getElements(searchTerm, pageNumber);

        // Add search results to arraylist
        for (Element result : searchResults) {
            resultObjs.add(new SearchResult(result));
        }

        for (SearchResult result : resultObjs
        ) {
            // Test for character pojo
            if (result != null) {
                System.out.println(new Superhero(ComicVineClient.getCharacter(result.getResultUrl())).toString());
            }
        }

    }
}
