public class Main {
    public static void main(String[] args) {

//        рекурсия
        System.out.println("5 ^ 5 = " + doPow(5, 5));
        System.out.println("5 ^ -5 = " + doPow(5, -5));

//        задача с рюкзаком
        System.out.println("=================================");
        Bag.packMyBag();
    }

    public static double doPow(int a, int pow) {
        if (pow == 0) {
            return 1;
        }

        if (pow == 1) {
            return a;
        }

        if (pow == -1) {
            return 1.0 / a;
        }

        if (pow < -1) {
            return 1.0 / (a * doPow(a, (pow + 1) * -1));
        }

        return a * doPow(a, pow - 1);
    }
}