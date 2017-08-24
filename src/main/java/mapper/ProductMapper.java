package mapper;

import java.util.List;

import pojo.Product;

public interface ProductMapper {
    public int addProduct(Product product);  
    
    public void deleteProduct(int id);  
        
    public Product getProduct(int id);  
        
    public List<Product> listProduct();
     
    public int count();  
}
