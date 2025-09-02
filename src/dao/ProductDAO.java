package dao;

import entities.Product;

import java.util.List;

public interface ProductDAO {
void save(Product product);
Product findById(Integer id);
List<Product> findAll();
void delete(Integer id){
}
