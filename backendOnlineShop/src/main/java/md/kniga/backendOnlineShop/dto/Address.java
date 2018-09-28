package md.kniga.backendOnlineShop.dto;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "adress_line_one")
    private String adressLineOne;

    @Column(name = "adress_line_two")
    private String adressLineTwo;

    @Column
    private String sity;

    @Column
    private String state;

    @Column
    private String country;

    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private boolean isBillingAddress;

    @ManyToOne
    private User user;

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

    public String getAdressLineOne() {
        return adressLineOne;
    }

    public void setAdressLineOne(String adressLineOne) {
        this.adressLineOne = adressLineOne;
    }

    public String getAdressLineTwo() {
        return adressLineTwo;
    }

    public void setAdressLineTwo(String adressLineTwo) {
        this.adressLineTwo = adressLineTwo;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isBillingAddress() {
        return isBillingAddress;
    }

    public void setBillingAddress(boolean billingAddress) {
        isBillingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                //", userId=" + userId +
                ", adressLineOne='" + adressLineOne + '\'' +
                ", adressLineTwo='" + adressLineTwo + '\'' +
                ", sity='" + sity + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", isBillingAddress=" + isBillingAddress +
                '}';
    }
}
