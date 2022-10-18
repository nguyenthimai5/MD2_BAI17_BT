import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Product> productList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
do {
    System.out.println("*************Menu************");
    System.out.println("1.Nhap sp");
    System.out.println("2.Hien sp");
    System.out.println("3.ghi sp");
    System.out.println("4.thoat");
    System.out.println("Su lua chon cua ban:");
    int choice=Integer.parseInt(scanner.nextLine());
    switch (choice){
        case 1:
            Main.inputListAuthor(scanner);
            break;
        case 2:
            Main.displayListAuthor();
            break;
        case 3:
            Main.getData(productList);
            break;
        case 4:
            System.exit(0);
        default:
            System.err.println("Vui long nhap tu 1-3!");
    }
}while (true);

    }


    public static void displayListAuthor() {
        System.out.printf("%-10s%-50s%-15s\n", "Ma tac gia", "Ten tac gia", "Trang thai");
        for (Product pro:productList) {
         pro.display();
        }
    }

    public static void inputListAuthor(Scanner scanner) {
        System.out.println("Vui long nhap vao so tac gia can nhap thong tin: ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.inputData(scanner, productList);
            productList.add(product);
            product.insertData(productList);
        }
    }
    public static void getData( List<Product> productList) {
        File file = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            file = new File("product.txt");
            if (file.exists()) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                productList.addAll((List<Product>) ois.readObject());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
    }
}
