import java.util.stream.IntStream;

public class SearchElem {
    private int counter;
    private int lostDigit;
    private int foundDigit;
    private long startTime;
    private long time;

    public SearchElem() {
        this.lostDigit = -1;
        this.foundDigit = -1;
        this.time = 0;
    }

    public void helpMeToFindLost(int[] array) {
        this.counter = 0;
        this.startTime = System.currentTimeMillis();
        int start = 0;
        int end = array.length - 1;
        int base;

        while (true) {
            this.counter++;
            base = start + (end - start) / 2;
            if (array[base] == base + 1) {
                if (array[base + 1] != base + 2) {
                    this.foundDigit = base + 2;
                    break;
                } else {
                    start = base + 2;
                    continue;
                }
            } else if (base == 0) {
                this.foundDigit = 1;
                break;
            } else if (array[base - 1] == base) {
                this.foundDigit = base + 1;
                break;
            } else {
                end = base - 2;
                continue;
            }
        }
        this.time = System.currentTimeMillis() - this.startTime;
        System.out.println("Метод 1");
        this.showResult();
    }

    public void helpMeToFindLost2(int[] array) {
        this.counter = 0;
        this.startTime = System.currentTimeMillis();
        int[] array2 = new int[array.length + 1];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
            this.counter++;
        }
        this.foundDigit = IntStream.of(array2).sum() - IntStream.of(array).sum();
        this.time = System.currentTimeMillis() - this.startTime;
        System.out.println("Метод 2");
        this.showResult();
    }

    /**
     * Поиск пропавшего элемента по методу_3 (исключительно для сравнения результатов с методом_1)
     */
    public void helpMeToFindLost3(int[] array) {
        this.counter = 0;
        this.startTime = System.currentTimeMillis();
        for (int i = 0; i < array.length - 2; i++) {
            this.counter++;
            if (array[i + 1] - array[i] != 1) {
                this.foundDigit = i + 2;
                break;
            }
        }
        this.time = System.currentTimeMillis() - this.startTime;
        System.out.println("Метод 3");
        this.showResult();
    }

    public int[] giveMeArray(int range) {
        int[] array = new int[range - 1];
        int lostIndex;
        lostIndex = (int) (Math.random() * (range - 1));

        this.lostDigit = lostIndex + 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = (i < lostIndex) ? (i + 1) : (i + 2);
        }
        return array;
    }

    /**
     * Вывод в консоль результатов поиска пропавшего элемента
     */
    public void showResult() {
        System.out.println((this.lostDigit == this.foundDigit) ? "Пропавшее число найдено!" : "------Пропавшее число НЕ найдено!------");
        System.out.println("Пропавшее число: " + this.lostDigit);
        System.out.println("Найденное число: " + this.foundDigit);
        System.out.println("Время: " + this.time);
        System.out.println("Количество итераций: " + this.counter);
        System.out.println("==================================");
    }
}
