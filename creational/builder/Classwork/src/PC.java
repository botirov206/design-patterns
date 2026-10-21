import enums.*;

public class PC {
    private final cpu cpu;
    private final RAM ram;
    private final OS os;
    private final storage storage;
    private final mouse mouse;
    private final keyboard keyboard;

    PC(cpu cpu, RAM RAM, OS OS, storage storage, mouse mouse, keyboard keyboard) {
        this.cpu = cpu; 
        this.ram = RAM;
        this.os = OS;
        this.storage = storage;
        this.mouse = mouse;
        this.keyboard = keyboard;
    };

    public static PCBuilder builder() {
        return new PCBuilder();
    };


    @Override
    public String toString() {
        return """
            ======== PC Specifications ========
            CPU      : %s
            RAM      : %s
            OS       : %s
            Storage  : %s
            Mouse    : %s
            Keyboard : %s
            ===================================
            """.formatted(
                cpu,
                ram != null ? ram.getValue() + " GB" : "Not selected",
                os,
                storage != null ? storage.getValue() + "GB SSD" : "Not selected",
                mouse,
                keyboard
        );
    }


}
