package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

/**
 * Created by Roboto on 17/03/16.
 */
public class shippingController {
    @FXML private TextField shippingName, shippingEmail, shippingPhone, shippingTrack;
    @FXML private ToggleButton toggleShipIsBill;
    @FXML private TextArea billingAddress, shippingAddress;
    @FXML private Button print;
    customerInformation customerInformation = new customerInformation();

    public void handleOnPrint(){
        setShippingInfo(customerInformation);
        System.out.println(customerInformation.getName() + "\n" + customerInformation.getShippingAdd());
    }

    public void setShippingInfo(customerInformation customerInformation){
        customerInformation.setName(shippingName.getText());
        customerInformation.setEmail(shippingEmail.getText());
        customerInformation.setPhone(shippingPhone.getText());
        customerInformation.setTrack(shippingTrack.getText());
        customerInformation.setBillingAdd(billingAddress.getText());
        if (toggleShipIsBill.isSelected())
            customerInformation.setShippingAdd(customerInformation.getBillingAdd());
        else customerInformation.setShippingAdd(shippingAddress.getText());
    }
}
