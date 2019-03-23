package pl.sda.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Juliusz Mueller
 */
public class Person {
    private StringProperty name;
    private StringProperty lastname;
    private StringProperty adress;
    private StringProperty postelCode;
    private StringProperty city;
    private StringProperty tel;

    public Person() {
    }

    public Person(String name, String lastname, String adress, String postelCode, String city, String tel) {
       this.name = new SimpleStringProperty(name);
       this.lastname = new SimpleStringProperty(lastname);
       this.adress = new SimpleStringProperty(adress);
       this.postelCode = new SimpleStringProperty(postelCode);
       this.city = new SimpleStringProperty(city);
       this.tel = new SimpleStringProperty(tel);

    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastname() {
        return lastname.get();
    }

    public StringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getAdress() {
        return adress.get();
    }

    public StringProperty adressProperty() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public String getPostelCode() {
        return postelCode.get();
    }

    public StringProperty postelCodeProperty() {
        return postelCode;
    }

    public void setPostelCode(String postelCode) {
        this.postelCode.set(postelCode);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getTel() {
        return tel.get();
    }

    public StringProperty telProperty() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel.set(tel);
    }

    @Override
    public String toString() {
        return String.format("Person (name=%s, lastname=%s, adress=%s, postelCode=%s, city=%s, tel=%s)", this.name, this.lastname, this.adress, this.postelCode, this.city, this.tel);
    }
}
