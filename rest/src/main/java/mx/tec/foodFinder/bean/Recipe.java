package mx.tec.foodFinder.bean;

import java.util.ArrayList;

public class Recipe {
    private int idRecipe;
    private String name, difficulty, portions, preparationTime, procedure, imageLink;
    private ArrayList<String> ingredients;
    public Recipe() { }

    public Recipe(int idRecipe, String name, String difficulty, String portions, String preparationTime, String procedure, String imageLink, ArrayList<String> ingredients) {
        this.idRecipe = idRecipe;
        this.name = name;
        this.difficulty = difficulty;
        this.portions = portions;
        this.preparationTime = preparationTime;
        this.procedure = procedure;
        this.imageLink = imageLink;
        this.ingredients = ingredients;
    }

    public int getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(int idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getPortions() {
        return portions;
    }

    public void setPortions(String portions) {
        this.portions = portions;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "idRecipe=" + idRecipe +
                ", name='" + name + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", portions='" + portions + '\'' +
                ", preparationTime='" + preparationTime + '\'' +
                ", procedure='" + procedure + '\'' +
                ", imageLink='" + imageLink + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
