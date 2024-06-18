package managers;

import entities.Product;
import jakarta.persistence.*;

import java.util.List;

public class ProductEntityManager {
    public void create(String code, int stock, double price, String description) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Product product = new Product(code,stock,price,description);
            entityManager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public List<Product> readAll() {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            List<Product> products = entityManager.createQuery("FROM Product", Product.class).getResultList();
            return products;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public Product readOne(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            Product product = entityManager.find(Product.class, id);
            return product;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }

}
