package botis.itstep.by;

import java.util.*;

public class TTN {

    int number;
    int data;
    Supplier supplier;
    Recipient recipient;
    Map<Towar,Integer> towars;
    String  type;
    //static final String type1="приход";
    //static final String type2="расход";

 public TTN (int number,int data,Supplier supplier,Recipient recipient,Map<Towar,Integer> towars){


     this.number= number;
     this.data= data;
     this.supplier=supplier;
    this.recipient=recipient;
     this. towars =towars ;

 }

    public void setRecipient(ListRecipient listrecipient) {


        System.out.println("Выберете из списка индекс");
        listrecipient.toString();
        System.out.println("Введите индекс");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        this.recipient= listrecipient.getListRecipient().get(index);

    }

    public void set(ListSupplier listSupplier) {


        System.out.println("Выберете из списка индекс");
        listSupplier.toString();
        System.out.println("Введите индекс");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        this.supplier= listSupplier.getListSupplier().get(index);

    }



    public int getNumber() {
        return number;
    }

    public int getData() {
        return data;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public Map<Towar, Integer> getTowars() {
        return towars;
    }

    public void printTTN (){

     System.out.println("НАКЛАДНАЯ  №   "+ this.getNumber());
     System.out.println("Дата отгрузки  "+ this.getData());
     System.out.println("Грузоотправитель  "+this.getSupplier().getName()+
                         this.getSupplier().getAdress());

     System.out.println("Грузополучатель  "+this.getRecipient().getName()+
                         this.getRecipient().getAdress());

        Set<Map.Entry<Towar,Integer>> settowar=this.getTowars().entrySet();

        Iterator<Map.Entry<Towar,Integer>> i= settowar.iterator();
        int count=1;
        while (i.hasNext()){

            Map.Entry<Towar,Integer> mytowar=i.next();
            System.out.println(count+"   "+ mytowar.getKey().getName()
                    + "   " + mytowar.getKey().getMeasurement()+
                    "   "+ mytowar.getValue() + " " + mytowar.getKey().getCost()+ " "
                    + mytowar.getValue()*mytowar.getKey().getCost() );
            count=+1;
        }
 }

}
