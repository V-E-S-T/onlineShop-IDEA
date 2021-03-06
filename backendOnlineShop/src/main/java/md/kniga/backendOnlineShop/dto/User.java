package md.kniga.backendOnlineShop.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Pattern(regexp = "^[a-zA-Z]+${2,}", message = "First Name can contain only latin characters and can't be less than 2 symbols")
    @NotBlank(message = "")
    //@Size(min = 2, message = "")
    @Column(name = "first_name", nullable = false)
    private String first_name;

    @NotBlank(message = "")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name can contain only latin characters and can't be less than 2 symbols")
    @Size(min = 2, message = "")
    @Column(name = "last_name", nullable = false)
    private String last_name;

    @NotBlank(message = "Please enter email!")
    @Email(message = "")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

//    @Pattern(regexp = "^[a-z0-9]{6,10}$",
//             message = "Should contain 6-10 symbols (latin character and 1-9 numbers)")
    @NotNull
    @Size(min = 6, message = "Should contain 6 symbols")
    @Column(name = "password", nullable = false)
    private String password;

    @NotBlank(message = "")
    @Column(name = "contact_number", nullable = false, unique = true)
    //@Size(min = 4, max = 15, message = "")
    @Pattern(regexp = "\\d{4,15}", message = "Please enter correct telephone number! (4-15 numerals)")
    private String contact_number;

    @Column(name = "active")
    private boolean active = true;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //user - this is a field from Cart class which indicates that user - is a parent dependency for class Cart
    private Cart cart;           // and if we add new User we automatically add new Cart for this user - method addCart not needed

    @Transient
    private String confirmPassword;

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getContact_number() {
        return contact_number;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", active=" + active +
                '}';
    }
}
