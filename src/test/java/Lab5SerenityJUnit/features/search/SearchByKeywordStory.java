package Lab5SerenityJUnit.features.search;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Lab5SerenityJUnit.steps.serenity.EndUserSteps;
@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;
    @Steps
    public EndUserSteps anna;
    @Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        // GIVEN
        anna.is_the_home_page();
        // WHEN
        anna.looks_for("apple");
        // THEN
        anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");
    }

    @Test
    public void searching_by_keyword_banana_should_display_the_corresponding_article() {
        // GIVEN
        anna.is_the_home_page();
        // WHEN
        anna.looks_for("pear");
        // THEN
        anna.should_see_definition("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem.");
    }

    @Test
    public void searching_by_keyword_pineapple_should_display_the_corresponding_article() {
        // GIVEN
        anna.is_the_home_page();
        // WHEN
        anna.looks_for("pineapple");
        // THEN
        anna.should_see_definition("A tropical plant, Ananas comosus, native to South America, having thirty or more long, spined and pointed leaves surrounding a thick stem.");
    }

    @Test
    public void searching_by_keyword_kiwi_should_display_the_corresponding_article() {
        // GIVEN
        anna.is_the_home_page();
        // WHEN
        anna.looks_for("kiwi");
        // THEN
        anna.should_see_definition("A flightless bird of the genus Apteryx native to New Zealand.");
    }

    @Pending @Test
    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
    }

    //Testing search functionality - valid search
    @Test
    public void searching_by_keyword_pancakes_should_display_some_results() {
        // GIVEN
        anna.is_the_home_pageEmag();
        // WHEN
        anna.looks_forEmag("pancakes");
        // THEN
        anna.should_see_resultsEmag("22 de rezultate pentru:");
    }

    //Testing search functionality - invalid search
    @Test
    public void searching_by_keyword_askjbfslg_should_display_some_results() {
        // GIVEN
        anna.is_the_home_pageEmag();
        // WHEN
        anna.looks_forEmag("askjbfslg");
        // THEN
        anna.should_see_resultsEmag("0 rezultate pentru:");
    }

    //Testing add functionality - valid add
    @Test
    public void adding_by_keyword_pancakes_should_display_some_results() {
        // GIVEN
        anna.is_the_home_pageEmag();
        anna.looks_forEmag("pancakes");
        // WHEN
        anna.add_productEmag();
        // THEN
        anna.should_see_results_AddEmag("Cosul meu");
    }

    // does ot work yet :D
//    @Test
//    public void adding_by_keyword_askjbfslg_should_display_some_results() {
//        // GIVEN
//        anna.is_the_home_pageEmag();
//        anna.looks_forEmag("Delight Your Customers: 7 Simple Ways to Raise Your Customer Service from");
//        // WHEN
//        anna.add_productEmag();
//        // THEN
//        anna.should_see_results_AddEmag("Favorite");
//    }

//    @Test
//    public void filterring_by_keyword_sub50_should_display_some_results() {
//        // GIVEN
//        anna.is_the_home_pageEmag();
//        anna.looks_forEmag("pancakes");
//        // WHEN
//        anna.enters_filterEmag("Sub 50");
//        // THEN
//        anna.should_see_results_AddEmag("5 rezultate pentru:");
//    }

}
