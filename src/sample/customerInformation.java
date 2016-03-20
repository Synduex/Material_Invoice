package sample;

/**
 * Created by Roboto on 17/03/16.
 */
public class customerInformation {
    String name, email, phone, track, billingAdd, shippingAdd;


    /**Getters */
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTrack() {
        return track;
    }

    public String getBillingAdd() {
        return billingAdd;
    }

    public String getShippingAdd() {
        return shippingAdd;
    }
    /**Setters*/
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public void setBillingAdd(String billingAdd) {
        this.billingAdd = billingAdd;
    }

    public void setShippingAdd(String shippingAdd) {
        this.shippingAdd = shippingAdd;
    }
}
