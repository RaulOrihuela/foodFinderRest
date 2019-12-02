package mx.tec.foodFinder.controller;

import mx.tec.foodFinder.bean.Recipe;
import mx.tec.foodFinder.bean.User;
import mx.tec.foodFinder.service.RecipeService;
import mx.tec.foodFinder.service.UserService;

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
        return RecipeService.getInstance().recipe_RA();
    }

    @GET
    @Path("/recipe/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Recipe readRecipe(@PathParam("id") int id) {
        return RecipeService.getInstance().recipe_R(id);
    }

    @GET
    @Path("/recipeFav/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Recipe> readRecipeFav(@PathParam("id") int id) {
        return RecipeService.getInstance().recipeFav_RA(id);
    }

    @POST
    @Path("/recipeFav/{id}/{idRecipe}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean updateRecipeFav(@PathParam("id") int id, @PathParam("idRecipe") int idRecipe) {
        return RecipeService.getInstance().recipeFav_U(id,idRecipe);
    }

    @POST
    @Path("/recipe")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean createRecipe(@WebParam Recipe recipe) {
        return RecipeService.getInstance().recipe_C(recipe);
    }

    @POST
    @Path("/userC")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(@WebParam User user) {
        return UserService.getInstance().User_C(user);
    }

    @POST
    @Path("/userV")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User validateUser(@WebParam User user) {
        return UserService.getInstance().User_V(user);
    }
}