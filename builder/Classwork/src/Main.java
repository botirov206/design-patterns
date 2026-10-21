
import enums.OS;

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        PC mac = director.constructPowerPC(new MacBuilder());
        PC windows = director.constructOfficePC(new WindowsLinuxBuilder(OS.WINDOWS));

        System.out.println(mac);
        System.out.println(windows);

        // PC MackBookAir = PC.builder()
        // .cpu(cpu.Apple_M1)
        // .ram(RAM.RAM_16)
        // .os(OS.MACOS)
        // .storage(storage.SSD_512)
        // .mouse(mouse.TOUCHPAD)
        // .keyboard(keyboard.MECHANIC)
        // .build();

        // PC Lenovo = PC.builder()
        // .cpu(cpu.Intel_Core_i5)
        // .ram(RAM.RAM_8)
        // .os(OS.WINDOWS)
        // .storage(storage.SSD_256)
        // .mouse(mouse.MOUSE)
        // .keyboard(keyboard.MECHANIC)
        // .build();

        // System.out.println(Lenovo);
        // System.out.println(MackBookAir);
    }
}