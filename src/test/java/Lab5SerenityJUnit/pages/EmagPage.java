package Lab5SerenityJUnit.pages;
import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.PageObject;
import java.util.List;
import static ch.lambdaj.Lambda.convert;
@DefaultUrl("https://www.emag.ro/")
public class EmagPage extends PageObject {

    @FindBy(name="query")
    private WebElementFacade searchTerms;
    @FindBy(className="searchbox-submit-button")
    private WebElementFacade lookupButton;
//    @FindBy(xpath="/*[ text() = ‘Sub 50’ ]")
    @FindBy(className="filter-body")
    private WebElementFacade filters;

    @FindBy(className="card-footer")
    private WebElementFacade divCos;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public void filter_by(String filter){
        filters.findElement(By.xpath("//a[@data-name = '" + filter + "' ]")).click();
    }

    public void add_to_cart(){
        divCos.findElement(By.xpath("//form[@data-id='69794459']")).submit();
    }


    public List<String> getResult() {
        WebElementFacade numberResults = find(By.tagName("h1"));
        List<WebElement> results = numberResults.findElements(By.tagName("span"));
        return convert(results, toStrings());
    }

    public String getResultAdd() {
        WebElement res = find(By.className("cart"));
        return res.getText();
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}
