import java.util.ArrayList;
import java.util.List;

public class Bag {

    public static int bagMaxWeight = 5;
    public static List<ItemForPack> insideBag = new ArrayList<>();
    public static int totalPrice = 0;

    public static void packMyBag() {

        ItemForPack itemForPack[] = new ItemForPack[4];
        itemForPack[0] = new ItemForPack("Ноутбук", 3, 4000);
        itemForPack[1] = new ItemForPack("Смартфон", 1, 3000);
        itemForPack[2] = new ItemForPack("Шкатулка", 4, 2500);
        itemForPack[3] = new ItemForPack("Планшет", 1, 2000);

        packToBag(sortBaggage(itemForPack), bagMaxWeight, totalPrice, insideBag);

        System.out.println("В рюкзаке: ");
        for (int i = 0; i < insideBag.size(); i++) {
            System.out.println(insideBag.get(i).getName() + " весом " + insideBag.get(i).getWeight() + " и ценностью " + insideBag.get(i).getPrice());
        }
    }

    public static int packToBag(ItemForPack itemForPack[], int bagMaxWeight, int totalPrice, List<ItemForPack> insideBag) {
        int i = itemForPack.length - 1;
        if (bagMaxWeight == 0) {
            return 0;
        }

        if ((bagMaxWeight - itemForPack[i].getWeight()) < 0) {
            packToBag(newItemForPack(itemForPack), bagMaxWeight, totalPrice, insideBag);
            return 0;
        }

        insideBag.add(itemForPack[i]);
        bagMaxWeight -= itemForPack[i].getWeight();
        totalPrice += itemForPack[i].getPrice();
        return packToBag(newItemForPack(itemForPack), bagMaxWeight, totalPrice, insideBag);
    }

    public static ItemForPack[] sortBaggage(ItemForPack itemForPack[]) {
        for (int i = 1; i < itemForPack.length; i++) {
            ItemForPack temp = itemForPack[i];
            int m = i;
            if (m > 0 && temp.weightUnitPrice() <= itemForPack[m - 1].weightUnitPrice()) {
                itemForPack[m] = itemForPack[m - 1];
                m--;
            }
            itemForPack[m] = temp;
        }
        return itemForPack;
    }

    public static ItemForPack[] newItemForPack(ItemForPack[] itemForPack) {
        int i = itemForPack.length;
        ItemForPack newItemForPack[] = new ItemForPack[i - 1];
        for (int j = 0; j < newItemForPack.length; j++) {
            newItemForPack[j] = itemForPack[j];
        }
        return newItemForPack;
    }
}
