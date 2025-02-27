package app;
import java.util.ArrayList;
import java.util.List;
public class Subcategory {
 private String name;
 private List<Product> products;

 public Subcategory(String name) {
     this.name = name;
     this.products = new ArrayList<>();
 }

 public String getName() {
     return name;
 }

 public void addProduct(Product product) {
     products.add(product);
 }

 public List<Product> getProducts() {
     return products;
 }
}