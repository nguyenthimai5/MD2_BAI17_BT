import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Product {

    private String productId;
    private String productName;
    private float price;

    public Product() {
    }

    public Product(String productId, String productName, float price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void inputData(Scanner scanner, List<Product> productList){
        System.out.println("Ma sp:");
        this.productId=scanner.nextLine();
        System.out.println("Ten sp:");
        this.productName=scanner.nextLine();
        System.out.println("Gia sp");
        this.price=Float.parseFloat(scanner.nextLine());
    }
    public  void display() {
        System.out.printf("%-10s%-50s%-15s\n", this.productId,this.productName,this.price);

    }
    public void insertData(List<Product> productList) {
        File file = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            file = new File("product.txt");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject((List<Product>) productList);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }
    }

    public void getData( List<Product> productList) {
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
