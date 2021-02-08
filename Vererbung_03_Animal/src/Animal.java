public class Animal {
    private String name;
    private boolean vegetarian;
    private int noOfLegs;
    public Animal(String name, boolean vegetarian, int noOfLegs) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.noOfLegs = noOfLegs;
    }
    public String getName() {
        return name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public int getNoOfLegs() {
        return noOfLegs;
    }
}
