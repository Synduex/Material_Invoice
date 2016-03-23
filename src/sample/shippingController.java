package sample;

import com.aspose.words.Document;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import sample.data.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Roboto on 17/03/16.
 */
public class shippingController {
    @FXML private TextField shippingName, shippingEmail, shippingPhone, shippingTrack;
    @FXML private ToggleButton toggleShipIsBill;
    @FXML private TextArea billingAddress, shippingAddress;
    @FXML private Button print;
    customerInformation customerInformation = new customerInformation();

    Customer customer = new Customer();
    Amount amount = new Amount();
    Item item = new Item();
    Quantity quantity = new Quantity();
    Rate rate = new Rate();
    InvoiceController invoice = new InvoiceController();
    Utils utils = new Utils();


    //String customerName, customerEmail, customerPhone, customerTrack, customerBillingAddress, customerShippingAddress;


    public void handleOnPrint() throws Exception {
        setShippingInfo(customerInformation);

        //The path to the documents directory
        //String dataDir = Utils.getDataDir(shippingController.class);

        String dataDir = "/Users/Roboto/IdeaProjects/Invoice/src/resources/";
        // Load the template
        Document doc = new Document(dataDir + "invoice.dotx");

        //Setup Mail merge
        String[] fieldNames = new String[]
                {"InvoiceNumber","AWP","InvoiceDate","CustomerName","BillingAddress",
                        "CustomerPhone","CustomerName","ShippingAddress","CustomerPhone",
                        "itemOne","itemTwo","itemThree","itemFour","itemFive",
                        "quantityone","quantitytwo","quantitythree","quantityfour","quantityfive",
                        "rateone","ratetwo","ratethree","ratefour","ratefive",
                        "amountone","amounttwo","amountthree","amountfour","amountfive",
                        "subtotal","taxrate","taxamount","grosstotal","shipping","discountrate","discountamount","nettotal",
                        "NetTotalPayable","PaymentMode"};


        String[] check = new String[] {
                customer.getInvoiceNumber(),customerInformation.getTrack(),customer.getInvoiceData(),customer.getCustomerName(),customerInformation.getBillingAdd(),
                customerInformation.getPhone(),customerInformation.getName() ,customerInformation.getShippingAdd(),customerInformation.getPhone(),
                item.getItemFirst(),item.getItemSecond(),item.getItemThird(),item.getItemForth() ,item.getItemFifth(),
                String.valueOf(quantity.getQuantity1()),String.valueOf(quantity.getQuantity2()) ,String.valueOf(quantity.getQuantity3()) ,String.valueOf(quantity.getQuantity4()) ,String.valueOf(quantity.getQuantity5()),
                String.valueOf(rate.getRate1()),String.valueOf(rate.getRate2()) ,String.valueOf(rate.getRate3()),String.valueOf(rate.getRate4()) ,String.valueOf(rate.getRate5()),
                String.valueOf(amount.getAmount1()),String.valueOf(amount.getAmount2()),String.valueOf(amount.getAmount3()),String.valueOf(amount.getAmount4()),String.valueOf(amount.getAmount5()),
                String.valueOf(invoice.getSubTotal()),String.valueOf(invoice.getTaxPercent()),String.valueOf(invoice.getTaxApplied()),String.valueOf(invoice.getGrossTotalResult()),
                String.valueOf(invoice.getShippingRates()),String.valueOf(invoice.getDiscountRateApplied()),
                String.valueOf(invoice.getDiscountAmountApplied()),String.valueOf(invoice.getNetTotal()),String.valueOf(invoice.getNetTotal()),invoice.getPaymentOptionChosen()};

        for (String a : check){
            System.out.print(a);
        }



        Object[] fieldValues = new java.lang.Object[]{
                customer.getInvoiceNumber(),customerInformation.getTrack(),customer.getInvoiceData(),customer.getCustomerName(),customerInformation.getBillingAdd(),
                customerInformation.getPhone(),customerInformation.getName() ,customerInformation.getShippingAdd(),customerInformation.getPhone(),
                item.getItemFirst(),item.getItemSecond(),item.getItemThird(),item.getItemForth() ,item.getItemFifth(),
                String.valueOf(quantity.getQuantity1()),String.valueOf(quantity.getQuantity2()) ,String.valueOf(quantity.getQuantity3()) ,String.valueOf(quantity.getQuantity4()) ,String.valueOf(quantity.getQuantity5()),
                String.valueOf(rate.getRate1()),String.valueOf(rate.getRate2()) ,String.valueOf(rate.getRate3()),String.valueOf(rate.getRate4()) ,String.valueOf(rate.getRate5()),
                String.valueOf(amount.getAmount1()),String.valueOf(amount.getAmount2()),String.valueOf(amount.getAmount3()),String.valueOf(amount.getAmount4()),String.valueOf(amount.getAmount5()),
                String.valueOf(invoice.getSubTotal()),String.valueOf(invoice.getTaxPercent()),String.valueOf(invoice.getTaxApplied()),String.valueOf(invoice.getGrossTotalResult()),
                String.valueOf(invoice.getShippingRates()),String.valueOf(invoice.getDiscountRateApplied()),
                String.valueOf(invoice.getDiscountAmountApplied()),String.valueOf(invoice.getNetTotal()),String.valueOf(invoice.getNetTotal()),invoice.getPaymentOptionChosen()};

                System.out.println(fieldNames.length + " " + fieldValues.length);

        //Execute the mail merge

        doc.getMailMerge().execute(fieldNames,new Object[]{"InvoiceNumber","AWP","InvoiceDate","CustomerName","BillingAddress",
                "CustomerPhone","CustomerName","ShippingAddress","CustomerPhone",
                "itemOne","itemTwo","itemThree","itemFour","itemFive",
                "quantityone","quantitytwo","quantitythree","quantityfour","quantityfive",
                "rateone","ratetwo","ratethree","ratefour","ratefive",
                "amountone","amounttwo","amountthree","amountfour","amountfive",
                "subtotal","taxrate","taxamount","grosstotal","shipping","discountrate","discountamount","nettotal",
                "NetTotalPayable","PaymentMode"});

        //Save the finished document
        doc.save(dataDir + "invoice_out.doc");

        System.out.println("Mail merge performed successfully");
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
