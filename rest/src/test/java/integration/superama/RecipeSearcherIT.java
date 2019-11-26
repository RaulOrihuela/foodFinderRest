package integration.superama;

import mx.tec.foodFinder.bean.Recipe;
import mx.tec.foodFinder.crawler.SuperamaRecipeSearcher;
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
        ArrayList<String> recipes = SuperamaRecipeSearcher.searchNewRecipes(driver);
        assertThat("The SuperamaRecipeSearcher did not find new recipes",
                recipes.size(),
                is(greaterThan(0))
        );
    }
    @Ignore
    public void RecipeSearcher_Should_AnalyzeNewRecipes() throws InterruptedException{
        System.out.println(
            SuperamaRecipeSearcher.analyzeNewRecipe(driver,"https://www.superama.com.mx/recetas/capirotada/2106").toString()
        );
        System.out.println(
            SuperamaRecipeSearcher.analyzeNewRecipe(driver,"https://www.superama.com.mx/recetas/pan-de-calabaza/2546").toString()
        );
    }

    @Ignore
    public void RecipeSearcher_Should_AddNewRecipes_Small() throws InterruptedException{
        ArrayList<String> recipeLinks = new ArrayList<>();
        recipeLinks.add("https://www.superama.com.mx/recetas/capirotada/2106");
        recipeLinks.add("https://www.superama.com.mx/recetas/pan-de-calabaza/2546");
        ArrayList<Recipe> recipes = SuperamaRecipeSearcher.learnNewRecipes(driver,recipeLinks);
        assertThat("The SuperamaRecipeSearcher did not add all recipes",
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

    @Test
    public void RecipeSearcher_Should_AddNewRecipes() throws InterruptedException{
        ArrayList<String> recipeLinks = SuperamaRecipeSearcher.searchNewRecipes(driver);
        assertThat("The SuperamaRecipeSearcher did not find new recipes",
                recipeLinks.size(),
                is(greaterThan(0))
        );
        ArrayList<Recipe> recipes = SuperamaRecipeSearcher.learnNewRecipes(driver,recipeLinks);
        assertThat("The SuperamaRecipeSearcher did not add all recipes",
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
