package md.kniga.backendOnlineShop.dto;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private User user;

//    @Column(name = "user_id")
//    private int userId;

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

    private boolean isShippingAdress;

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

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

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

    public boolean isShippingAdress() {
        return isShippingAdress;
    }

    public void setShippingAdress(boolean shippingAdress) {
        isShippingAdress = shippingAdress;
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
                ", isShippingAdress=" + isShippingAdress +
                '}';
    }
}
