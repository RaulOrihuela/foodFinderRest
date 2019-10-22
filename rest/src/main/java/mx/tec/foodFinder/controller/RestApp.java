package mx.tec.foodFinder.controller;

import mx.tec.foodFinder.bean.Recipe;
import mx.tec.foodFinder.util.ServiceManager;

import javax.jws.WebParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/foodFinder")
public class RestApp {
    @GET
    @Path("/recipe")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> readRecipes() {
        return ServiceManager.getInstance().getRecipeService().recipe_RA();
    }

    @GET
    @Path("/recipe/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe readRecipe(@PathParam("id") int id) {
        return ServiceManager.getInstance().getRecipeService().recipe_R(id);
    }

    @GET
    @Path("/recipeFav/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> readRecipeFav(@PathParam("id") int id) {
        return ServiceManager.getInstance().getRecipeService().recipeFav_RA(id);
    }

    @POST
    @Path("/recipe")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createRecipe(@WebParam Recipe recipe) {
        return ServiceManager.getInstance().getRecipeService().recipe_C(recipe);
    }
}