package pl.wiktor.generics;

public class ChildRunner {


    public static void main(String[] args) {
        ChildOne one = new ChildOne();
        showText(one);
        ChildTwo two = new ChildTwo();
        showText(two);
    }


    private static <T extends Parent> void showText(T typeItem) {
        typeItem.showText();
    }

}
