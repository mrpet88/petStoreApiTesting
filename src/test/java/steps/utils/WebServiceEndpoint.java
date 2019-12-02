package steps.utils;

public enum WebServiceEndpoint {
    petUrl("https://petstore.swagger.io/v2/pet/");


    private final String endpoint;

    WebServiceEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getUrl() {
        return endpoint;
    }
    }
