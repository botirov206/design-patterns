import enums.*;

public class PCBuilder {
    private cpu cpu;
    private RAM ram;
    private OS os;
    private storage storage;
    private mouse mouse;
    private keyboard keyboard;

    public PCBuilder cpu(cpu cpu) {
        this.cpu = cpu;
        return this;
    };

    public PCBuilder ram(RAM ram) {
        this.ram = ram;
        return this;
    };

    public PCBuilder os(OS os) {
        this.os = os;
        return this;
    };

    public PCBuilder storage(storage storage) {
        this.storage = storage;
        return this;
    };

    public PCBuilder mouse(mouse mouse) {
        this.mouse = mouse;
        return this;
    };

    public PCBuilder keyboard(keyboard keyboard) {
        this.keyboard = keyboard;
        return this;
    };

    public PC build() {
        if (cpu == null || ram == null || os == null || storage == null || mouse == null || keyboard == null) {
            throw new IllegalStateException("RAM, OS, Storage, mouse and keyboards are required to build a PC.");
        }
        return new PC(cpu, ram, os, storage, mouse, keyboard);
    };
}
