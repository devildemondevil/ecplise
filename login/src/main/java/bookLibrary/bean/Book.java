package bookLibrary.bean;


public class Book {

    private String ISN;
    private String name;
    private String pub;
    private float price;
    private Integer count;

    public String getISN() {
        return ISN;
    }

    public Book(String ISN, String name, String pub, float price, Integer count) {
        this.ISN = ISN;
        this.name = name;
        this.pub = pub;
        this.price = price;
        this.count = count;
    }

    public void setISN(String ISN) {
        this.ISN = ISN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
