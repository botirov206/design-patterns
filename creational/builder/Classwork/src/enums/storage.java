package enums;

public enum storage {
    SSD_128(128),
    SSD_256(256),
    SSD_512(512),
    SSD_1024(1024);

    private final int value;

    storage(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
