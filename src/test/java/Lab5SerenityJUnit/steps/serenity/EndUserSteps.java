package Lab5SerenityJUnit.steps.serenity;

import Lab5SerenityJUnit.pages.DictionaryPage;
import Lab5SerenityJUnit.pages.EmagPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
public class EndUserSteps {

    DictionaryPage dictionaryPage;
    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }


    EmagPage emagPage;
    @Step
    public void entersEmag(String keyword) {
        emagPage.enter_keywords(keyword);
    }

    @Step
    public void starts_searchEmag() {
        emagPage.lookup_terms();
    }

    @Step
    public void enters_filterEmag(String keyword) {
        emagPage.filter_by(keyword);
    }

    @Step
    public void add_productEmag() {
        emagPage.add_to_cart();
    }

    @Step
    public void should_see_resultsEmag(String result) {
        assertThat(emagPage.getResult(), hasItem(containsString(result)));
    }

    @Step
    public void should_see_results_AddEmag(String result) {
        assertThat(emagPage.getResultAdd(),containsString(result));
    }

    @Step
    public void is_the_home_pageEmag() {
        emagPage.open();
    }

    @Step
    public void looks_forEmag(String term) {
        entersEmag(term);
        starts_searchEmag();
    }
}


