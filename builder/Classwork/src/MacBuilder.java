import enums.*;

public class MacBuilder implements ComputerBuilder {

    private cpu cpu;
    private RAM ram;
    private OS os;
    private storage storage;
    private mouse mouse;
    private keyboard keyboard;

    @Override 
    public void buildCpu() {
        this.cpu = enums.cpu.Apple_M4;
    }

    @Override
    public void buildOs(){
        this.os = OS.MACOS;
    }

    @Override
    public void buildRam(RAM ram){
        this.ram = ram;
    }

    @Override
    public void buildStorage(storage storage){
        this.storage = storage;
    }
    
    @Override
    public void buildMouse(mouse mouse){
        this.mouse = mouse;
    }

    @Override
    public void buildKeyboard(keyboard keyboard){
        this.keyboard = keyboard;
    }

    @Override
    public PC getPc() {
        if (cpu == null || ram == null || os == null || storage == null || mouse == null || keyboard == null) {
            throw new IllegalStateException("All parts are required to build a Mac.");
        }
        return new PC(cpu, ram, os, storage, mouse, keyboard);
    }
}
