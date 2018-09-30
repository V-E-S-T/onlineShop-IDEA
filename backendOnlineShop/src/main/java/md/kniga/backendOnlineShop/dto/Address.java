package md.kniga.backendOnlineShop.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Address implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Please enter address (Line One)!")
    @Column(name = "address_line_one")
    private String addressLineOne;

    @NotBlank(message = "Please enter address (Line Two)!")
    @Column(name = "address_line_two")
    private String addressLineTwo;

    @NotBlank(message = "Please enter the city!")
    @Column
    private String city;

    @NotBlank(message = "Please enter the state!")
    @Column
    private String state;

    @NotBlank(message = "Please enter the country!")
    @Column
    private String country;

    @NotBlank(message = "Please enter the postal Code!")
    @Column(name = "postal_code")
    private String postalCode;

    @Column
    private boolean isBillingAddress;

    @Column(name = "user_id")
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
                ", addressLineOne='" + addressLineOne + '\'' +
                ", addressLineTwo='" + addressLineTwo + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", isBillingAddress=" + isBillingAddress +
                ", userId=" + userId +
                '}';
    }
}
