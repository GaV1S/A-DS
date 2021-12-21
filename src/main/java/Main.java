public class Main {
    public static void main(String[] args) {

        SearchElem searchElem = new SearchElem();
        int[] array = searchElem.giveMeArray(100000000);
        searchElem.helpMeToFindLost(array);

    }
}
