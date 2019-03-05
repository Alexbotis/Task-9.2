package botis.itstep.by;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ListRecipientTest {
      ListRecipient lr= new ListRecipient ();
   // ArrayList<Recipient> listRecipient= new ArrayList<Recipient> ();

@Test
   public void  addRecipientTest(){

   lr.addRecipient(new Recipient("n1","ad1"));

    lr.addRecipient(new Recipient("n2","ad2"));
    lr.addRecipient(new Recipient("n3","ad3"));
    lr.addRecipient(new Recipient("n4","ad4"));
     String s=lr.toString();
    Assert.assertTrue(lr.getListRecipient().size()==4);
}

}
