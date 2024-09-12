import java.io.*;
import java.util.Scanner;

public class Main {

    public static final String FILE_NAME = "tasks.txt";

    static class InvalidException extends Exception {
        public InvalidException(String message) {
            super(message);
        }
    }

        public static void main(String[] args) {

            System.out.println("E ticaret platformuna hoş geldiniz.");
            System.out.println("Lütfen giriş yapınız.Kullanıcı Adı:");
            Scanner scanner = new Scanner(System.in);
            String kullanici = scanner.nextLine();
            try {
                useUser(kullanici);
                System.out.println("Kullanıcı adı doğru");

            } catch (InvalidException e) {
                System.out.println("Hata: Kullanıcı adı uzunluğu hatalı." + e.getMessage());
            }

            System.out.println("Şifrenizi giriniz.");
            String sifre = scanner.nextLine();

            boolean running=true;
            while (running){
                System.out.println("Sisteme Hoş geldiniz.Yapmak istediğiniz işlemi seçiniz.");
                System.out.println("1-Ürün bilgileri");
                System.out.println("2-Ürün güncelleme");
                System.out.println("3-Stok bilgileri");
                System.out.println("4-Müşteri bilgileri");
                System.out.println("5-Sipariş oluşturma");
                System.out.println("6-Çıkış");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addProduct();
                        break;

                    case 2:
                        updateProduct();
                        break;

                    case 3:
                        try {
                            stockInfo("Laptop", 80);
                            stockInfo("Bag",20);
                        } catch (OutOfStockException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        showCustomer();
                        break;

                    case 5:
                        try {
                            orderProduct();
                            System.out.println("Siparişleriniz oluşturulmuştur. En kısa sürede teslim edilecektir.");

                        } catch (InvalidException e) {
                            System.out.println("Sipariş oluşturulurken hata meydana geldi.");
                        }
                        break;
                    case 6:
                        System.out.println("Çıkış yapılıyor...");
                        running = false;
                        break;

                    default:
                        System.out.println("Hatalı işlem. Lütfen tekrar deneyiniz.");
                        break;
                }

            }
            }


        public static void showCustomer() {
            Customer customer = new Customer("ffgfg\n", "fgfg\n", "hdhdh@gmail.com\n", 25);
            Customer customer1 = new Customer("ghgh\n", "fgfg\n", "hdhdh@gmail.com\n", 26);
            customer.customerInfo();
            customer1.customerInfo();
        }

        public static void useUser(String kullanici) throws InvalidException {
            if (kullanici.length() < 5) {
                throw new InvalidException("Kullanıcı adı 5 karakterden fazla olmalıdır.");
            }
        }

        public static void addProduct() {
            Product.productInfo("laptop", 58.20, 15);
            Product.productInfo("bag", 64.80, 10);
        }

        public static void updateProduct() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Mevcut Ürünler:");
            Product.productInfo("laptop", 58.20, 15);
            Product.productInfo("bag", 64.80, 10);

            System.out.println("Lütfen güncellemek istediğiniz ürünü seçin.");
            System.out.println("1-Laptop,2-Bag");
            int choice1 = scanner.nextInt();
            scanner.nextLine();
            if (choice1 == 1) {
                System.out.println("Ürünün güncellenmiş hali:");
                Product.updateInfo("Laptop", 50.30, 80);
            } else if (choice1 == 2) {
                System.out.println("Ürünün güncellenmiş hali:");
                Product.updateInfo("Bag", 58.36, 20);
            } else {
                System.out.println("Hatalı giriş.");
            }

        }

        public static void stockInfo(String productName, int stock) throws OutOfStockException {
            if (stock == 0) {
                throw new OutOfStockException("Hata: " + productName + "stokta yok.");
            } else {
                System.out.println(productName + " için stok durumu:" + stock);
            }
        }

        public static void orderProduct() throws InvalidException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Sipariş oluşturuluyor. Lütfen ürün adını giriniz:");
            String productName = scanner.nextLine();

            System.out.println("Lütfen ürün fiyatını giriniz:");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Lütfen ürün miktarını giriniz:");
            int stock = scanner.nextInt();
            scanner.nextLine();

            double totalPrice = price * stock;


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                try {
                    writer.write("ürün adı: " + productName);
                    writer.newLine();
                    writer.write("Ürün fiyatı: " + price);
                    writer.newLine();
                    writer.write("Ürün stoğu: " + stock);
                    writer.newLine();
                } catch (IOException e) {
                    throw new InvalidException("Dosya yazma hatası: " + e.getMessage());
                }

                System.out.println("Sipariş başarıyla kaydedildi. Toplam fiyat: " + totalPrice);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

