package java.integration.util;

import mx.tec.foodFinder.bean.Recipe;
import mx.tec.foodFinder.util.RecipeSearcherMemory;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class RecipeSearcherMemoryTest {
    private static HashMap<String, Recipe> KnownProducts;
    private static ArrayList<Recipe> NewProducts;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        KnownProducts = RecipeSearcherMemory.getInstance().getKnownRecipes();
        NewProducts = RecipeSearcherMemory.getInstance().getNewRecipes();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void KP_has_objects() {
        assertThat("Known Products is empty, it should have objects",
                KnownProducts,
                is(not(anEmptyMap()))
        );
    }
    @Test
    public void NP_is_empty() {
        assertThat("New Products contains an object, it should be empty",
                NewProducts,
                is(empty())
        );
    }
}
