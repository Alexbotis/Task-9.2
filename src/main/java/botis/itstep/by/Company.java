package botis.itstep.by;

import java.util.*;

public class Company {

    private ArrayList<Recipient> listRecipient;
    private ArrayList<Supplier> listSupplier;
    private ArrayList<Towar> listTowary;
    private ArrayList<Sklad> listSklady;

    public Company() {
        this.listRecipient = new ArrayList<Recipient>();
        this.listSupplier = new ArrayList<Supplier>();
        this.listTowary = new ArrayList<Towar>();
        this.listSklady = new ArrayList<Sklad>();
    }

    public ArrayList<Recipient> getListRecipient() {
        return listRecipient;
    }

    public ArrayList<Supplier> getListSupplier() {
        return listSupplier;
    }

    public ArrayList<Sklad> getListSklady() {
        return listSklady;
    }

    public ArrayList<Towar> getListTowary() {
        return listTowary;
    }

    public void addRecipient(Recipient obj) {
        listRecipient.add(obj);

    }

    public void addSupplier(Supplier obj) {
        listSupplier.add(obj);
    }

    public void addSklad(Sklad obj) {
        listSklady.add(obj);
    }

    public void addTowar(Towar obj) {
        listTowary.add(obj);

    }

    public void arrayListToString(ArrayList<Object> list) {// ???????

        int size = list.size();

        for (int i = 0; i < size; i++) {

            System.out.println(i + " " + list.get(i).toString());

        }

    }


    public Recipient getRecipient(int index) {

        return this.listRecipient.get(index);

    }

    public Supplier getSupplier(int index) {

        return this.listSupplier.get(index);

    }

    public Map<Towar, Integer> createListTowary(Towar towar,int counttowar) {


        Map<Towar, Integer> mapTowary = new HashMap<Towar, Integer>();// создаем список товаров для накладной

        if (this.listTowary.contains(towar)){// выбираем товар из  списке товаров

            mapTowary.put(towar, counttowar);   // добавляем его в мапу

        }


        return mapTowary;
    }

    public ArrayList<Recipient> getExternalListRecipient(){ // список внешних поставщиков

       int countRecipient=listRecipient.size();
       int countSklady=    listSklady.size();
        ArrayList<Recipient> ExternalListRecipient= new  ArrayList<Recipient> ();

       for (int i=0;i<countRecipient;i++){

           boolean equals= false;

           for (int j=0;j<countSklady;j++) {

               if (this.listRecipient.get(i).equals(listSklady.get(j))){// если поставщик есть один из складов

                   equals=true;
                   break;

               }

            }

           if (equals==false){

               ExternalListRecipient.add(this.listRecipient.get(i));
           }
       }

return ExternalListRecipient;
    }


    public String toString() {

        return listRecipient.toString();
    }

    public TTN createTTN(int ttnNumber,int date, Supplier supplier,Recipient recipient,// создадим накладную
                         Map<Towar, Integer> products) {

        TTN currentTTN = new TTN(ttnNumber, date, supplier, recipient, products);// используя конструктор

        return currentTTN;
    }



    public void useTTN(TTN ttn) {

        int size = this.listSklady.size();

        for (int i = 0; i < size; i++) {

            if (this.listSklady.get(i).getName().equals(ttn.supplier.getName()) // если склад является отправителем
                    && this.listSklady.get(i).getAdress().equals(ttn.supplier.getAdress())) {

                this.listSklady.get(i).substractTowar(ttn);// отгружаем товар со склада

            } else {
                if (this.listSklady.get(i).getName().equals(ttn.recipient.getName()) && // если склад получатель
                        this.listSklady.get(i).getAdress().equals(ttn.recipient.getAdress())) {

                    this.listSklady.get(i).addTowar(ttn);// сгружаем товар на склад
                }

            }


        }


    }
}




