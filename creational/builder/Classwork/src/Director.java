import enums.*;

public class Director {
    public PC constructOfficePC(ComputerBuilder builder) {
        builder.buildCpu();
        builder.buildOs();
        builder.buildRam(RAM.RAM_8);
        builder.buildStorage(storage.SSD_256);
        builder.buildMouse(mouse.MOUSE);
        builder.buildKeyboard(keyboard.MECHANIC);
        return builder.getPc();
    }   
    
    public PC constructPowerPC(ComputerBuilder builder) {
        builder.buildCpu();
        builder.buildOs();
        builder.buildRam(RAM.RAM_16);
        builder.buildStorage(storage.SSD_512);
        builder.buildMouse(mouse.MOUSE);
        builder.buildKeyboard(keyboard.MECHANIC);
        return builder.getPc();
    }
}