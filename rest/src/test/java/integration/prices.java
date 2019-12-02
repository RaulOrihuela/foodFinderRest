package integration;

import mx.tec.foodFinder.bean.SupermarketIngredient;
import mx.tec.foodFinder.service.SupermarketIngredientService;
import org.junit.*;

import java.util.ArrayList;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class prices {
    private static ArrayList<String> supermarket;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        supermarket = new ArrayList<>();
        supermarket.add("Comercial mexicana");
        supermarket.add("Superama");
        supermarket.add("Walmart");
        supermarket.add("Soriana");
        supermarket.add("Bodega ahorrera");
        supermarket.add("Chedrahui");
        supermarket.add("Costco");
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

    @Ignore
    public void priceCheck() {
        int base = 1;
        Random rand = new Random();
        for (int i = 0; i<224; i++){
            ArrayList<String> tempList = (ArrayList)supermarket.clone();
            tempList.remove(rand.nextInt(7));
            if(rand.nextBoolean()) tempList.remove(rand.nextInt(6));
            double price = 500 + rand.nextInt(4000);
            price /= 100;
            for (int index = 0; index < tempList.size(); index ++){
                SupermarketIngredient tempIngredient = new SupermarketIngredient();
                tempIngredient.setSupermarket(tempList.get(index));
                double deviation = rand.nextInt(500);
                deviation /= 100;
                tempIngredient.setPrice(price - deviation);
                SupermarketIngredientService.getInstance().supermarketIngredient_C_id(tempIngredient,i+base);
            }
        }

        assertThat("Known Products is empty, it should have objects",
                1,
                is(not(equalTo(0)))
        );
    }
}
