package lesson_2;

import java.util.ArrayList;

public class Lesson_2 {
    public static void main(String[] args) {
        ArrayList<Notebook> notebookList = giveMeListOfNotebooks(5000);

        notebookListSort(notebookList);

//       showResultOfSort(notebookList);
    }

    public static ArrayList<Notebook> giveMeListOfNotebooks(int count) {
        ArrayList<Notebook> notebookList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            notebookList.add(new Notebook());
        }
        return notebookList;
    }

    public static void notebookListSort(ArrayList<Notebook> notebookList) {
        for (int i = 0; i < notebookList.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < notebookList.size(); j++) {
                if (notebookList.get(j).getPrice() < notebookList.get(min).getPrice()) {
                    min = j;
                } else if (notebookList.get(j).getPrice() == notebookList.get(min).getPrice()) {
                    if (notebookList.get(j).getRam() < notebookList.get(min).getRam()) {
                        min = j;
                    } else if (notebookList.get(j).getRam() == notebookList.get(min).getRam()) {
                        if (notebookList.get(j).getBrandIndex() < notebookList.get(min).getBrandIndex()) {
                            min = j;
                        }
                    }
                }
            }

            if (i == min) {
                continue;
            }

            Notebook temp = notebookList.get(i);
            notebookList.set(i, notebookList.get(min));
            notebookList.set(min, temp);
        }
    }

    public static void showResultOfSort(ArrayList<Notebook> notebookList) {
        for (int i = 0; i < 5000; i++) {
            System.out.printf("brand: %s, price: %s $, RAM: %s Gb\n", notebookList.get(i).getBrandName(), notebookList.get(i).getPrice(), notebookList.get(i).getRam());
        }
    }
}