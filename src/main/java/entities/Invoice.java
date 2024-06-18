package entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column
    private double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Invoice() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Double.compare(total, invoice.total) == 0 && Objects.equals(id, invoice.id) && Objects.equals(createdAt, invoice.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, total);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", total=" + total +
                '}';
    }
}
