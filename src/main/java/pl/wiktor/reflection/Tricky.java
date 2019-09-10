package pl.wiktor.reflection;

public class Tricky {

    private String text = "Private";

    private Tricky(String text) {
        this.text = text;
    }

    void showText() {
        System.out.println(this.text);
    }

}
