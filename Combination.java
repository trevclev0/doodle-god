public class Combination {
	private String ingredientA;
	private String ingredientB;
	private String creation;
	public Combination(String ingredientA, String ingredientB, String creation) {
		this.ingredientA = ingredientA;
		this.ingredientB = ingredientB;
		this.creation = creation;
	}
	public Combination(String ingredientA, String ingredientB) {
		this.ingredientA = ingredientA;
		this.ingredientB = ingredientB;
	}
	public String getIngredientA() {
		return ingredientA;
	}
	public String getIngredientB() {
		return ingredientB;
	}
	public String getCreation() {
		return creation;
	}
	public boolean equals(Combination a) {
		return (a.getIngredientA().equals(getIngredientA()) && a.getIngredientB().equals(getIngredientB())) ||
			(a.getIngredientB().equals(getIngredientA()) && a.getIngredientA().equals(getIngredientB()));
	}
	public String toString() {
		return ingredientA + " + " + ingredientB + " = " + creation;
	}
}
