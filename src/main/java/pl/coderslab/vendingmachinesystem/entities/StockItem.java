package pl.coderslab.vendingmachinesystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "stock_item")
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Integer quantity;

//    private Integer row;
//    private Integer column;

    private Integer noHorizontally;

    private Integer noVertically;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getNoHorizontally() {
        return noHorizontally;
    }

    public void setNoHorizontally(Integer noHorizontally) {
        this.noHorizontally = noHorizontally;
    }

    public Integer getNoVertically() {
        return noVertically;
    }

    public void setNoVertically(Integer noVertically) {
        this.noVertically = noVertically;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", noHorizontally=" + noHorizontally +
                ", noVertically=" + noVertically +
                ", product=" + product +
                '}';
    }
}