package md.kniga.backendOnlineShop.dto;

import javax.persistence.*;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", nullable = false)
    private String code;

    @NotBlank(message = "Please enter the product name!")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Please enter the product brand!")
    private String brand;

    @NotBlank(message = "Please enter the product description!")
    private String description;

    //TODO delete this field - it would not be stored into database
    @Column(name = "image_url")
    private String imageUrl;

    @NotBlank(message = "Please enter the product size!")
    private String size;

    @NotBlank(message = "Please enter the product weight!")
    private String weight;

    @Min(value = 1, message="The price can not be less than 1!")
    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "active")
    private boolean active;

    @Column(name = "category_id", nullable = false)
    private int categoryID;

    private int purchases;

    private int views;

    @Transient
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

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

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSize() {
        return size;
    }

    public String getWeight() {
        return weight;
    }

    public double getUnitPrice() {
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setUnitPrice(double unitPrice) {
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
                ", imageUrl='" + imageUrl + '\'' +
                ", size='" + size + '\'' +
                ", weight='" + weight + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", active=" + active +
                ", categoryID=" + categoryID +
                ", purchases=" + purchases +
                ", views=" + views +
                '}';
    }
}
