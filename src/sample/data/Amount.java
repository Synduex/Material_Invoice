package sample.data;

import javafx.beans.property.DoubleProperty;

/**
 * Created by Roboto on 18/03/16.
 */
public class Amount {
    Quantity quantity = new Quantity();
    Rate rate = new Rate();

    double amount1, amount2, amount3, amount4, amount5;

    public double getAmount1() {
        return amount1;
    }

    public void setAmount1(int quantity, double rate) {
        this.amount1 = quantity * rate;
    }

    public double getAmount2() {
        return amount2;
    }

    public void setAmount2(int quantity, double rate) {
        this.amount2 = quantity * rate;
    }

    public double getAmount3() {
        return amount3;
    }

    public void setAmount3(int quantity, double rate) {
        this.amount3 = quantity * rate;
    }

    public double getAmount4() {
        return amount4;
    }

    public void setAmount4(int quantity, double rate) {
        this.amount4 = quantity * rate;
    }

    public double getAmount5() {
        return amount5;
    }

    public void setAmount5(int quantity, double rate) {
        this.amount5 = quantity * rate;
    }
}
