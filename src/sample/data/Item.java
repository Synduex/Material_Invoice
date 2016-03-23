package sample.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roboto on 18/03/16.
 */
public class Item {
    String itemFirst, itemSecond, itemThird, itemForth, itemFifth;
    List<String> itemList = new ArrayList<>();


     public String getItemFirst() {
     return itemFirst;
     }

     public void setItemFirst(String itemFirst) {
         if (itemFirst != null)
             this.itemFirst = itemFirst;
         else this.itemFirst = "";
     }

     public String getItemSecond() {
     return itemSecond;
     }

     public void setItemSecond(String itemSecond) {
         if (itemSecond != null)
             this.itemSecond = itemSecond;
         else this.itemSecond = "";
     }

     public String getItemThird() {
     return itemThird;
     }

     public void setItemThird(String itemThird) {
         if (itemThird != null)
             this.itemThird = itemThird;
         else this.itemThird = "";
     }

     public String getItemForth() {
     return itemForth;
     }

     public void setItemForth(String itemForth) {
         if (itemForth != null)
             this.itemForth = itemForth;
         else this.itemForth = "";
     }

     public String getItemFifth() {
     return itemFifth;
     }

     public void setItemFifth(String itemFifth) {
         if (itemFifth != null)
             this.itemFifth = itemFifth;
         else this.itemFifth = "";
     }


    public List<String> items(String... itemCollection){
        for (String item : itemCollection)
            if (null != item){
            itemList.add(item);
            } else itemList.add(" ");
        return itemList;
    }

}
