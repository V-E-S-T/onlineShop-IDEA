package md.kniga.backendOnlineShop.dto;

public class Category {

    private int id;
    private String name;
    private String description;
    private String imgeUrl;
    private boolean active = true;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgeUrl() {
        return imgeUrl;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgeUrl(String imgeUrl) {
        this.imgeUrl = imgeUrl;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
