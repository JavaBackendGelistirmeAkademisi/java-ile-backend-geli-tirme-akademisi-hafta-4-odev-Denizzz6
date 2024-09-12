
public class Product {
    String productName;
    double price;
    int stock;

    public Product(String productName, double price,int stock){
        this.productName=productName;
        this.price=price;
        this.stock=stock;
    }


    public static void productInfo(String productName,double price,int stock) {
        System.out.println("Product name:"+productName+" "+"Price:"+price+"$"+"stock:"+stock);
    }

   public static void updateInfo(String productName,double price,int stock){
       System.out.println("Güncellenen ürünün adı:"+productName+"Güncellenen ürünün fiyatı:"+price+"Güncellenen ürünün stoğu"+stock);
   }



    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName=productName;
    }
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public int getStock(){
        return stock;
    }

    public  void setStock(int stock){
        this.stock=stock;
    }

}

