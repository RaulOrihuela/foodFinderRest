package java.integration.crawler;

import mx.tec.foodFinder.bean.Recipe;
import mx.tec.foodFinder.crawler.RecipeSearcher;
import mx.tec.foodFinder.util.drivers.*;
import org.hamcrest.Matchers;
import org.junit.*;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RecipeSearcherIT {
    private static EnhancedWebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        driver = new EnhancedWebDriver(BrowserDriver.getDriver(BrowserOption.Chrome));
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        //Thread.sleep(5000);
    }
    @Ignore
    public void RecipeSearcher_Should_SearchNewRecipes() throws InterruptedException {
        ArrayList<String> recipes = RecipeSearcher.searchNewRecipes(driver);
        assertThat("The RecipeSearcher did not find new recipes",
                recipes.size(),
                is(greaterThan(0))
        );
    }
    @Test
    public void RecipeSearcher_Should_AnalyzeNewRecipes() throws InterruptedException{
        System.out.println(
            RecipeSearcher.analyzeNewRecipe(driver,"https://www.superama.com.mx/recetas/capirotada/2106").toString()
        );
        System.out.println(
            RecipeSearcher.analyzeNewRecipe(driver,"https://www.superama.com.mx/recetas/pan-de-calabaza/2546").toString()
        );
    }
    @Ignore
    public void RecipeSearcher_Should_AddNewRecipes() throws InterruptedException{
        ArrayList<String> recipeLinks = RecipeSearcher.searchNewRecipes(driver);
        assertThat("The RecipeSearcher did not find new recipes",
                recipeLinks.size(),
                is(greaterThan(0))
        );
        ArrayList<Recipe> recipes = RecipeSearcher.learnNewRecipes(driver,recipeLinks);
        assertThat("The RecipeSearcher did not add all recipes",
                recipes.size(),
                is(equalTo(recipeLinks.size()))
        );
        assertThat("The recipes did not contain Capirotadas",
                recipes,
                hasItem(Matchers.<Recipe>allOf(
                        hasProperty("name", equalTo("Capirotada")),
                        hasProperty("preparationTime", equalTo("30 min")),
                        hasProperty("portions", equalTo("4 personas")),
                        hasProperty("difficulty", equalTo("Media"))
                ))
        );
    }
}
