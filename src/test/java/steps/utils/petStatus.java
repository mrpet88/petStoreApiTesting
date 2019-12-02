package steps.utils;

public enum petStatus {
    Available("available"),
    Pending("pending"),
    Sold("sold");

    private final String status;

    petStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
