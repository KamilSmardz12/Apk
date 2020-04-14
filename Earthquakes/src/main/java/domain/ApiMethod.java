package domain;

public enum ApiMethod {
    COUNT("count"),
    QUERY("query");

    private String value;

    ApiMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
