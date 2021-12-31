public class Main {
    public static void main(String[] args) {

        int count = 20;
        int countBalance = 0;
        for (int i = 0; i < count; i++) {
            MyTree<Integer, Integer> map = new MyTree<>();
            while (true) {
                int value = randomValue();
                int key = value;
                map.put(key, value);
                if (map.height() == 4) {
                    map.deleteToKey(key);
                    if (map.isBalance()) {
                        countBalance++;
                    }
                    break;
                }
            }
        }
        System.out.println("Сбалансированных деревьев: " + countBalance);
        System.out.println("Общее число деревьев: " + count);
        System.out.println("Процент сбалансированных деревьев: " + (int)((countBalance / (double) count * 100)) + " %");
    }

    public static int randomValue() {
        return (int) ((Math.random() * 51) - 26);
    }
}