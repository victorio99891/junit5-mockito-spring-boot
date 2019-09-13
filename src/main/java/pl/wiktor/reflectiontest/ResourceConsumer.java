package pl.wiktor.reflectiontest;


public class ResourceConsumer {


    private MyResource resource;


    public String obtainEnhancedLink() {
        String link = getResourceLink();
        StringBuilder builder = new StringBuilder();
        builder.append(link).append("/").append("enhanced");
        return builder.toString();
    }


    private String getResourceLink() {
        return this.resource.getResource();
    }

}
