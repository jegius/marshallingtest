import javax.xml.bind.annotation.XmlElement;

public class Product {
    private String name;
    private int price;
    private Adress adress;
    private String description;

    public Product() {

    }

    public Product(String name, int price, Adress adress, String description) {
        this.name = name;
        this.price = price;
        this.adress = adress;
        this.description = description;
    }

    public Adress getAdress() {
        return adress;
    }
    @XmlElement
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
    @XmlElement
    public void setPrice(int price) {
        this.price = price;
    }
}
