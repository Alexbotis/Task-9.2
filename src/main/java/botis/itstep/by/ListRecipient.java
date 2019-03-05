package botis.itstep.by;

import java.util.ArrayList;
import java.util.List;

public class ListRecipient {

    private ArrayList<Recipient> listRecipient;

    public ListRecipient (){
       this. listRecipient=new  ArrayList<Recipient>();

    }

    public ArrayList<Recipient> getListRecipient() {
        return listRecipient;
    }

    public void addRecipient (Recipient obj) {
        listRecipient.add(obj);

     }
     public void recipientToString (){

        int size= this.listRecipient.size();

        for (int i=0;i<size;i++) {

            System.out.println(i+ " "+this.listRecipient.get(i).toString() );

        }

     }

}
