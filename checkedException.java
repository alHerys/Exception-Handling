package exceptionHandling;

/**
 * Contoh penanganan checked exception (InterruptedException) dengan dua cara:
 * 1. 'throws' clause: Mendelegasikan penanganan ke pemanggil.
 * 2. try-catch block: Menangani exception secara internal.
 */
public class checkedException {

    /**
     * Simulasi loading, mendelegasikan InterruptedException ke pemanggil.
     * @param durasiDalamMilisekon Jeda per iterasi (ms).
     * @throws InterruptedException Jika thread diinterupsi saat sleep.
     */
    public static void LoadingTipe1(int durasiDalamMilisekon) throws InterruptedException {
        System.out.print("Tunggu sesaat");
        for (int i = 0; i < 5; i++) {
            Thread.sleep(durasiDalamMilisekon); // Potensi InterruptedException
            System.out.print(".");
        }
    }

    /**
     * Simulasi loading, menangani InterruptedException secara internal dengan try-catch.
     * Blok 'finally' memastikan pesan selesai selalu tampil.
     * @param durasiDalamMilisekon Jeda per iterasi (ms).
     */
    public static void LoadingTipe2(int durasiDalamMilisekon) {
        System.out.println("Tunggu sesaat");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(durasiDalamMilisekon); // Potensi InterruptedException
            }
        } catch (InterruptedException e) { // Menangkap jika terjadi interupsi
            System.out.println("Exception saat loading tipe 2: " + e.getMessage());
            Thread.currentThread().interrupt(); // Set ulang status interupsi
        } finally {
            // Dieksekusi terlepas dari ada atau tidaknya exception.
            System.out.println("Loading tipe 2 selesai");
        }
    }

    /**
     * Main method untuk demo kedua tipe loading.
     */
    public static void main(String[] args) {
        // Demo LoadingTipe1 (perlu try-catch karena throws InterruptedException)
        System.out.println("Mulai LoadingTipe1:");
        try {
            LoadingTipe1(600);
        } catch (InterruptedException e) {
            System.out.println("\nError di main (LoadingTipe1): " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            System.out.print("\nLoadingTipe1 selesai (dari main).\n\n");
        }

        // Demo LoadingTipe2 (tidak perlu try-catch di sini)
        System.out.println("Mulai LoadingTipe2:");
        LoadingTipe2(1000);
        System.out.println("LoadingTipe2 selesai (dari main).");
    }
}