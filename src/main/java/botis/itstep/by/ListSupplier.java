package botis.itstep.by;

import java.util.ArrayList;

public class ListSupplier {

    private ArrayList<Supplier> listSupplier;

    public ListSupplier (){};

    public ArrayList<Supplier> getListSupplier() {
        return listSupplier;
    }

    public void addRecipient ( Supplier obj) {
        listSupplier.add(obj);

    }

    public void listSupplierToString (){

        int size= this.listSupplier.size();

        for (int i=0;i<size;i++) {

            System.out.println(i+ " "+this.listSupplier.get(i).toString() );

        }

    }


}
