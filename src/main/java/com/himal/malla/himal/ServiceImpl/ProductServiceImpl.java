package com.himal.malla.himal.ServiceImpl;

import com.himal.malla.himal.Enity.Product;
import com.himal.malla.himal.Repository.ProductRepo;
import com.himal.malla.himal.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;


    public Product save(Product product) {
        return productRepo.save(product);
    }

    public List<Product> saveAll(List<Product> productList) {
        return productRepo.saveAll(productList);
    }

    public List<Product> getProducts() {
        return  productRepo.findAll();
    }

    public Product getProductById(Integer productId) {

        return productRepo.findById(productId).orElse(null);
    }

    public Product updateProduct(Product man) {
        Product existingProduct = productRepo.findById(man.getProductId()).orElse(null);
        existingProduct.setName(man.getName());
        return productRepo.save(existingProduct);
    }

    public String deleteProduct(int productId) {

         productRepo.deleteById(productId);
        return " Product has been removed " + productId ;
    }
}
