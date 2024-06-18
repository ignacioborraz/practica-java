package managers;

import entities.InvoicesDetail;
import entities.Client;
import entities.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class InvoicesDetailEntityManager {

    public void addToCart(int amount, Product product, Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            InvoicesDetail invoicesDetail = new InvoicesDetail();
            invoicesDetail.setAmount(amount);
            invoicesDetail.setPrice(product.getPrice());
            invoicesDetail.setClient(client);
            invoicesDetail.setProduct(product);
            entityManager.persist(invoicesDetail);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public void removeToCart(Product product, Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            InvoicesDetail invoiceDetail = entityManager
                    .createQuery("SELECT id FROM InvoicesDetail id WHERE id.product = :product AND id.client = :client", InvoicesDetail.class)
                    .setParameter("product", product)
                    .setParameter("client", client)
                    .getSingleResult();
            entityManager.remove(invoiceDetail);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public List<InvoicesDetail> readByClient(Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            List<InvoicesDetail> invoicesDetails = entityManager
                    .createQuery("SELECT id FROM InvoicesDetail id WHERE id.client = :client", InvoicesDetail.class)
                    .setParameter("client", client).getResultList();
            return invoicesDetails;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }

}
