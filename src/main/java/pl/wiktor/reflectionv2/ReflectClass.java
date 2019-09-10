package pl.wiktor.reflectionv2;

public class ReflectClass {

    private String text;
    private int number;

    private ReflectClass() {

    }

    private ReflectClass(String text) {
        this.text = text;
    }

    private ReflectClass(int number) {
        this.number = number;
    }


    public void printText() {
        System.out.println("Hello World!");
    }


    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ReflectClass{" +
                "text='" + text + '\'' +
                ", number=" + number +
                '}';
    }
}
