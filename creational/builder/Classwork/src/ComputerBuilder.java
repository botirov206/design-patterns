import enums.*;

public interface ComputerBuilder {
    void buildCpu();
    void buildOs();
    void buildRam(RAM ram);
    void buildStorage(storage storage);
    void buildMouse(mouse mouse);
    void buildKeyboard(keyboard keyboard);
    PC getPc();
}