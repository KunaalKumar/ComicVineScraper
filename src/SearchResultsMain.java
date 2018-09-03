import objects.SearchResult;
import objects.Superhero;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SearchResultsMain {

    private static ArrayList<SearchResult> resultObjs = new ArrayList<>();
    private static Superhero character;

    public static void main(String[] args) throws IOException {
        String searchTerm = "Superman";
        int pageNumber = 1;

        // Test to get all results from page 1
        Elements searchResults = ComicVineClient.getElements(searchTerm, pageNumber);

        // Add search results to arraylist
        for (Element result : searchResults) {
            resultObjs.add(new SearchResult(result));
        }

        Element result = ComicVineClient.getCharacter(resultObjs.get(0).getResultUri());

        // Test for character pojo
        if (result != null) {
            character = new Superhero(result);
            System.out.println("Superhero name: " + character.getSuperName());
            System.out.println();
            System.out.println("Real name: " + character.getRealName());
            System.out.println();
            System.out.println("Link: " + character.getRealName());
            System.out.println();
            System.out.println("Aliases");
            for (String alias : character.getAliases()
            ) {
                System.out.println(alias);
            }
            System.out.println();
            System.out.println("Publisher");
            System.out.println(character.getPublisher().getName());
            System.out.println(character.getPublisher().getLink());
            System.out.println(character.getPublisher().getTypeCode());
            System.out.println(character.getPublisher().getObjectCode());
            System.out.println();
        }

    }
}
