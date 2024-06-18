package managers;

import entities.Client;
import entities.Invoice;
import entities.InvoicesDetail;
import jakarta.persistence.*;

import java.util.List;

public class InvoiceEntityManager {
    public void create(Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Invoice invoice = new Invoice();
            //invoice.getClients().add(client);
            entityManager.persist(invoice);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public List<Invoice> readAll() {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            List<Invoice> invoices = entityManager.createQuery("FROM Invoice", Invoice.class).getResultList();
            return invoices;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public Invoice readByUser(Client client) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            Invoice invoice = entityManager.find(Invoice.class, client);
            List<InvoicesDetail> invoicesDetails = entityManager
                    .createQuery("SELECT id FROM InvoicesDetail id WHERE id.client = :client", InvoicesDetail.class)
                    .setParameter("client", client).getResultList();
            return invoice;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }

}

