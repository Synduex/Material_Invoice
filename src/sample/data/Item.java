package sample.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roboto on 18/03/16.
 */
public class Item {
    //String itemFirst, itemSecond, itemThird, itemForth, itemFifth;
    List<String> itemList = new ArrayList<>();

    /**
     *
     public String getItemFirst() {
     return itemFirst;
     }

     public void setItemFirst(String itemFirst) {
     this.itemFirst = itemFirst;
     }

     public String getItemSecond() {
     return itemSecond;
     }

     public void setItemSecond(String itemSecond) {
     this.itemSecond = itemSecond;
     }

     public String getItemThird() {
     return itemThird;
     }

     public void setItemThid(String itemThid) {
     this.itemThird = itemThird;
     }

     public String getItemForth() {
     return itemForth;
     }

     public void setItemForth(String itemForth) {
     this.itemForth = itemForth;
     }

     public String getItemFifth() {
     return itemFifth;
     }

     public void setItemFifth(String itemFifth) {
     this.itemFifth = itemFifth;
     }
     * @param itemCollection
     * @return
     */

    public List<String> items(String... itemCollection){
        for (String item : itemCollection)
            if (null != item){
            itemList.add(item);
            }
        return itemList;
    }

}
