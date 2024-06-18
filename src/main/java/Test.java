import entities.Client;
import entities.Product;
import managers.*;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ClientEntityManager client = new ClientEntityManager();
        //client.create("igna","borraz",35249);
        //client.create("fran","fernandez",40258);
        //client.create("felipe","ramos",38536);
        List<Client> all = client.readAll();
        //System.out.println(all);
        Client oneClient = client.readOne(1);
        //System.out.println(oneClient);
        ProductEntityManager product = new ProductEntityManager();
        //product.create("123456",1000,10,"campera roja");
        //product.create("123457",1000,10,"campera azul");
        //product.create("123458",1000,20,"campera verde");
        //product.create("123459",1000,20,"campera naranja");
        //product.create("123460",1000,15,"campera blanca");
        //product.create("123459",1000,15,"campera negra");
        Product oneProduct = product.readOne(1);
        //System.out.println(oneProduct);
        List<Product> products = product.readAll();
        //System.out.println(products);
        //InvoiceEntityManager invoice = new InvoiceEntityManager();
        //invoice.create(oneClient);
        //invoice.create((client.readOne(1)));
        //invoice.create((client.readOne(2)));
        //invoice.create((client.readOne(3)));
        //Invoice oneInvoice = invoice.readOne(1);
        //System.out.println(oneInvoice);
        InvoicesDetailEntityManager invoicesDetails = new InvoicesDetailEntityManager();
        //invoicesDetails.addToCart(10,product.readOne(2),oneClient);
        //invoicesDetails.addToCart(6,product.readOne(3),oneClient);
        //invoicesDetails.addToCart(1,product.readOne(1),client.readOne(2));
        //invoicesDetails.addToCart(2,product.readOne(4),client.readOne(2));
        //invoicesDetails.addToCart(1,product.readOne(5),client.readOne(2));
        //invoicesDetails.addToCart(3,product.readOne(2),client.readOne(3));
        System.out.println(invoicesDetails.readByClient(oneClient));
        System.out.println(invoicesDetails.readByClient(client.readOne(2)));
        System.out.println(invoicesDetails.readByClient(client.readOne(3)));
        //invoicesDetails.removeToCart(product.readOne(2),oneClient);
        EntityProvider.close();
    }
}
