package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.data.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Roboto on 16/03/16.
 */
public class InvoiceController {

    @FXML
    Button buttonSave, syncValue;
    @FXML
    TextField invoiceCustomerName, invoiceNumber, invoiceDate;
    @FXML
    TextField item1, item2, item3, item4, item5;
    @FXML
    TextField quantity1, quantity2, quantity3, quantity4, quantity5;
    @FXML
    TextField rate1, rate2, rate3, rate4, rate5;
    @FXML
    TextField amount1, amount2, amount3, amount4, amount5;
    @FXML
    TextField subTotal, taxRate, taxAmount, grossTotal, discountRate, discountAmount, shippingCharges, totalAmount;
    @FXML
    RadioButton radioCod, radioOnline, radioPaid;
    @FXML
    Label labelInvoice;


    private Customer customer = new Customer();
    private Item item = new Item();
    private Quantity quantity = new Quantity();
    private Rate rate = new Rate();
    private Amount amount = new Amount();

    private String resource = "layout/shipping.fxml";

    List<String> items = new ArrayList<>();

    double amountTotalBeforeDiscount = 0.0;
    double taxPercent;
    double taxApplied;
    double shippingRates;
    double discountRateApplied;
    double discountAmountApplied;
    double grossTotalResult;
    double netTotal;

    public String paymentOptionChosen;



    @FXML
    public void setShipping() throws IOException{
        startShippingActivity();
    }

    public void startShippingActivity() throws IOException{
        Stage stage = new Stage();
        stage.setTitle("Shop Management");
        Pane myPane;
        myPane = FXMLLoader.load(getClass().getResource(resource));
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Syncs the data on the input fields and shows it in the un-editable fields
     * This method is on-Action for the Button SYNC
     * @throws IOException
     */
    @FXML
    public void syncValue() throws IOException{
        setCustomerInfo();
        setItemList();
        setQuantity();
        setRate();
        setAmount();
        setTextValue();
        setSubTotal();
        setTaxRate();
        setTaxAmount();
        setGrossTotal();
        setDiscountRateApplied();
        setDiscountAmountApplied();
        setShippingRates();
        setNetTotal();
        paymentOptionChosen = getPaymentMode();

    }

    /*
    * Set the customer info from the text field and set it on the Customer Class
    * */
    public void setCustomerInfo(){
        try{
            customer.setCustomerName(invoiceCustomerName.getText());
            customer.setInvoiceNumber(invoiceNumber.getText());
            customer.setInvoiceData(invoiceDate.getText());
        } catch (NullPointerException e){
            labelInvoice.setText("Please Fill all the Fields!");
        }
    }
    /*
    * Set the Items from item text field
    public void setItems(){
        items = item.items(item1.getText(), item2.getText(), item3.getText(), item3.getText(), item4.getText(), item5.getText());
    }*/

    /**
     * Get the Items
     * @return
     */
    public List getItems(){
        return items;
    }

    /**
     * Set the quantitiy of the items
     */
    public void setQuantity(){
        try{
            quantity.setQuantity1(stringToInt(quantity1.getText()));
            quantity.setQuantity2(stringToInt(quantity2.getText()));
            quantity.setQuantity3(stringToInt(quantity3.getText()));
            quantity.setQuantity4(stringToInt(quantity4.getText()));
            quantity.setQuantity5(stringToInt(quantity5.getText()));
        }catch (NullPointerException e){
            labelInvoice.setText("Please Fill all the Fields!");
        }
    }

    /**
     * Set the Rate or Maximum Retail Price of each prodcuct
     */
    public void setRate(){
        try{
            rate.setRate1(stringToDouble(rate1.getText()));
            rate.setRate2(stringToDouble(rate2.getText()));
            rate.setRate3(stringToDouble(rate3.getText()));
            rate.setRate4(stringToDouble(rate4.getText()));
            rate.setRate5(stringToDouble(rate5.getText()));
        }catch (NullPointerException e){
            labelInvoice.setText("Please Fill all the Fields!");
        }
    }

    /**
     * set Amount which is equal to rate * quantity
     */
    public void setAmount(){
        try{
            amount.setAmount1(quantity.getQuantity1(), rate.getRate1());
            amount.setAmount2(quantity.getQuantity2(), rate.getRate2());
            amount.setAmount3(quantity.getQuantity3(), rate.getRate3());
            amount.setAmount4(quantity.getQuantity4(), rate.getRate4());
            amount.setAmount5(quantity.getQuantity5(), rate.getRate5());
        }catch (NullPointerException e){
            System.out.println("OOps AMount Not Set");
        }
    }

    /**
     * Show the output on the amount field
     */
    public void setTextValue(){
        amount1.setText(String.valueOf(amount.getAmount1()));
        amount2.setText(String.valueOf(amount.getAmount2()));
        amount3.setText(String.valueOf(amount.getAmount3()));
        amount4.setText(String.valueOf(amount.getAmount4()));
        amount5.setText(String.valueOf(amount.getAmount5()));
    }

    public void setSubTotal(){
        this.amountTotalBeforeDiscount = amount.getAmount1() + amount.getAmount2() + amount.getAmount3() + amount.getAmount4() + amount.getAmount5();
        subTotal.setText(String.valueOf(amountTotalBeforeDiscount));
    }

    public double getSubTotal(){
        return amountTotalBeforeDiscount;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxRate(){
        if(checkIfNull(taxRate.getText())){
            this.taxPercent = 0.0;
            taxRate.setText(String.valueOf(getTaxPercent()));
        } else
            taxPercent = Double.parseDouble(taxRate.getText());

    }

    public double getTaxApplied() {
        taxApplied = amountTotalBeforeDiscount * (getTaxPercent() / 100);
        return taxApplied;
    }

    public void setTaxAmount(){
        taxAmount.setText(String.valueOf(getTaxApplied()));
    }

    public void setGrossTotal(){
        this.grossTotalResult = taxApplied + amountTotalBeforeDiscount;
        grossTotal.setText(String.valueOf(Math.ceil(getGrossTotalResult())));
    }


    public double getDiscountRateApplied() {
        return discountRateApplied;
    }

    public void setDiscountRateApplied() {
        if (checkIfNull(discountRate.getText())){
            this.discountRateApplied = 0.0;
        }else this.discountRateApplied = Double.parseDouble(discountRate.getText());
    }

    public double getShippingRates() {
        return shippingRates;
    }

    public void setShippingRates() {
        if (checkIfNull(shippingCharges.getText())){
            this.shippingRates = 0.0;
        } else this.shippingRates = Double.parseDouble(shippingCharges.getText());
    }


    public double getDiscountAmountApplied() {
        return discountAmountApplied;
    }

    public void setDiscountAmountApplied() {
        this.discountAmountApplied = amountTotalBeforeDiscount * (getDiscountRateApplied() / 100);
        discountAmount.setText(String.valueOf(getDiscountAmountApplied()));
    }
    public double getGrossTotalResult() {
        return grossTotalResult;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal() {
        this.netTotal = getGrossTotalResult() - getDiscountAmountApplied() + getShippingRates();

        totalAmount.setText(String.valueOf(Math.ceil(getNetTotal())));
    }

    public String getPaymentMode(){
        if (radioCod.isSelected() && !radioOnline.isSelected() && !radioPaid.isSelected()){
            return "CASH ON DELIVERY";
        } else if (!radioCod.isSelected() && radioOnline.isSelected() && !radioPaid.isSelected()){
            return "ONLINE PAYEMENT";
        } else if (!radioCod.isSelected() && !radioOnline.isSelected() && radioPaid.isSelected()){
            return "PAID";
        }else return "Please choose a valid Mode of Payment";
    }

    public void setItemList(){
        item.setItemFirst(item1.getText());
        item.setItemSecond(item2.getText());
        item.setItemThird(item3.getText());
        item.setItemForth(item4.getText());
        item.setItemFifth(item5.getText());
    }


    private int stringToInt(String s){
        if (checkIfNull(s))
        return 0;
        return Integer.parseInt(s);
    }

    public String getPaymentOptionChosen() {
        return paymentOptionChosen;
    }


    private double stringToDouble(String s){
        if (checkIfNull(s))
        return 0.0;
        return Double.parseDouble(s);
    }

    private <T> boolean checkIfNull (T a){
        return a == null;
    }

}