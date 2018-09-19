package md.kniga.onlineShop.exception;

public class ProductNotFoundException extends Exception{

    //TODO in this video https://www.youtube.com/watch?v=SsOEmclaJ3A&index=30&list=PLAXbOMavY3k1VJGqqhfqAn0tUSC14Qsvq
    //custom exception made with implementation Serializable interface and private final ID

    private String message;

    public ProductNotFoundException() {
        this("Product is not available!");
    }

    public ProductNotFoundException(String message) {
        this.message = System.currentTimeMillis() + " : " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
