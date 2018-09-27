package md.kniga.backendOnlineShop.dto;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name = "user_id")
//    private int userId;

    @OneToOne
    private User user;

    @Column(name = "grand_total")
    private double grandTotal;

    @Column(name = "cart_lines")
    private int cartLines;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public int getCartLines() {
        return cartLines;
    }

    public void setCartLines(int cartLines) {
        this.cartLines = cartLines;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + user +
                ", grandTotal=" + grandTotal +
                ", cartLines=" + cartLines +
                '}';
    }
}