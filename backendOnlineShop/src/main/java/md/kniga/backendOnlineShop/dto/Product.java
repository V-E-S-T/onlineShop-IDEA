package md.kniga.backendOnlineShop.dto;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String name;

    private String brand;

    private String description;

    @Column(name = "image_url")
    private String imgeUrl;

    private String size;

    private String weight;

    @Column(name = "unit_price")
    private String unitPrice;

    @Column(name = "is_active")
    private boolean active;

    private int purchases;

    private int views;

    //default constructor
    public Product(){
        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getImgeUrl() {
        return imgeUrl;
    }

    public String getSize() {
        return size;
    }

    public String getWeight() {
        return weight;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public boolean isActive() {
        return active;
    }

    public int getPurchases() {
        return purchases;
    }

    public int getViews() {
        return views;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgeUrl(String imgeUrl) {
        this.imgeUrl = imgeUrl;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", imgeUrl='" + imgeUrl + '\'' +
                ", size='" + size + '\'' +
                ", weight='" + weight + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", active=" + active +
                ", purchases=" + purchases +
                ", views=" + views +
                '}';
    }
}
