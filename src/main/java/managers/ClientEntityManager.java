package managers;

import entities.Client;
import jakarta.persistence.*;

import java.util.List;

public class ClientEntityManager {

    public void create(String name, String lastname, Integer docnumber) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Client client = new Client(name,lastname,docnumber);
            entityManager.persist(client);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public List<Client> readAll() {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            List<Client> clients = entityManager.createQuery("FROM Client", Client.class).getResultList();
            return clients;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }
    public Client readOne(Integer id) {
        EntityManager entityManager = null;
        EntityTransaction transaction;
        try {
            entityManager = EntityProvider.get();
            Client client = entityManager.find(Client.class, id);
            return client;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            EntityProvider.closeEntity(entityManager);
        }
    }

}
