import enums.OS;
import enums.RAM;
import enums.cpu;
import enums.keyboard;
import enums.mouse;
import enums.storage;

public class WindowsLinuxBuilder implements ComputerBuilder {
    private cpu cpu;
    private RAM ram;
    private OS os;
    private storage storage;
    private mouse mouse;
    private keyboard keyboard;

    @Override
    public void buildCpu() {
        this.cpu = enums.cpu.Intel_Core_i7;
    }

    @Override
    public void buildOs() {
    }

    @Override
    public void buildRam(RAM ram) {
        this.ram = ram;
    }

    @Override
    public void buildStorage(storage storage) {
        this.storage = storage;
    }

    @Override
    public void buildMouse(mouse mouse) {
        this.mouse = mouse;
    }

    @Override
    public void buildKeyboard(keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public PC getPc() {
        if (cpu == null || ram == null || os == null || storage == null || mouse == null || keyboard == null) {
            throw new IllegalStateException("All parts are required to build a Windows/Linux PC.");
        }
        return new PC(cpu, ram, os, storage, mouse, keyboard);
    }

    public WindowsLinuxBuilder(OS os) {
        if (os == OS.MACOS) {
            throw new IllegalArgumentException("Use MacBuilder for macOS.");
        }
        this.os = os;
    }
}
