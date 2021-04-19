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
}
