package pl.wiktor.reflectiontest;

public class MyResource {

    private String link;

    public MyResource(String resourceName) {
        this.link = "http://localhost:80/resource/" + resourceName;
    }

    public String getResource() {
        return this.link;
    }


}
