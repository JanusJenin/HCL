public class PlatformInfo {
    public static void main(String[] args) {

        System.out.println("Java Version: " +
                System.getProperty("java.version"));

        System.out.println("Operating System: " +
                System.getProperty("os.name"));

        System.out.println("Number of Processors: " +
                Runtime.getRuntime().availableProcessors());

        System.out.println("Maximum Heap Memory: " +
                Runtime.getRuntime().maxMemory());

        System.out.println("Free Heap Memory: " +
                Runtime.getRuntime().freeMemory());
    }
}