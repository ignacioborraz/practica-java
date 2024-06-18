package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column
    private int stock;

    @Column
    private double price;

    @Column
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoicesDetail> invoicesDetails;

    public Product() {}

    public Product(String code, int stock, double price, String description) {
        this.code = code;
        this.stock = stock;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InvoicesDetail> getInvoicesDetails() {
        return invoicesDetails;
    }

    public void setInvoicesDetails(List<InvoicesDetail> invoicesDetails) {
        this.invoicesDetails = invoicesDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stock == product.stock && Double.compare(price, product.price) == 0 && Objects.equals(id, product.id) && Objects.equals(code, product.code) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, stock, price, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
