public class ItemForPack {
    private String name;
    private int weight;
    private int price;

    public ItemForPack(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int weightUnitPrice() {
        return (this.price / this.weight);
    }
}
