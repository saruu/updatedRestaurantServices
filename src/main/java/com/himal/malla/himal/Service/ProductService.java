package com.himal.malla.himal.Service;

import com.himal.malla.himal.Enity.Product;

import java.util.List;

public interface ProductService {


    public Product save(Product product);

    public List<Product> saveAll(List<Product> productList);

    public List<Product> getProducts();

    public Product getProductById(Integer productId) ;

    public Product updateProduct(Product man) ;

    public String deleteProduct(int productId) ;
}
