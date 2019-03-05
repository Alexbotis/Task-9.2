package botis.itstep.by;

public class Towar {

   private String name;
   private Integer cost;
   private String measurement;

    public Towar (String name,String measurement,Integer cost){

        this.name= name;
        this.cost=cost;
        this.measurement=measurement;


    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    public String getMeasurement() {
        return measurement;
    }
}
