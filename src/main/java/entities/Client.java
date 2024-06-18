package entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column(name = "doc_number")
    private Integer docNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoicesDetail> invoicesDetails;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;

    public Client() {}

    public Client(String name, String lastname, Integer docNumber) {
        this.name = name;
        this.lastname = lastname;
        this.docNumber = docNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Integer docNumber) {
        this.docNumber = docNumber;
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
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(lastname, client.lastname) && Objects.equals(docNumber, client.docNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, docNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docNumber='" + docNumber + '\'' +
                '}';
    }
}
