package domain;

public enum ApiDataFormat {
    CSV("csv");
    private String value;

    ApiDataFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
