package enums;

public enum RAM {
    RAM_8(8),
    RAM_16(16),
    RAM_24(24),
    RAM_32(32);

    private final int value;

    RAM(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
