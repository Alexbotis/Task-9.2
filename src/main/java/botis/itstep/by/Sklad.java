package botis.itstep.by;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sklad {

    private Map<Towar, Integer> towarSklad;
    private String name;
    private String adress;

    public Sklad() {
    }

    ;

    public Sklad(String name, String adress) {

        this.name = name;
        this.adress = adress;
        this.towarSklad = new HashMap<>();
    }

    public String getAdress() {
        return adress;
    }

    public String getName() {
        return name;
    }

    public Map<Towar, Integer> getTowarSklad() {
        return towarSklad;
    }

    public void addTowar(TTN ttn) {

        for (Towar towar : ttn.getTowars().keySet()) {// для всех товаров из накладной

            int value = ttn.getTowars().get(towar);// находим количество по ключу

            if (!this.getTowarSklad().containsKey(towar)) {// если товаров на складе нет

                this.getTowarSklad().put(towar, value);// добавляем товар из накладной

            } else {// в противном случае

                int value1 = this.getTowarSklad().get(towar);// находим кол-во товара на складе
                // по данной позиции
                this.getTowarSklad().put(towar, value + value1);// и добавляем количество из накладной

            }

        }


    }

    public void substractTowar(TTN ttn) {// отгрузка товара

        for (Towar towar : ttn.getTowars().keySet()) {// для каждой позиции из накладной

            int value = ttn.getTowars().get(towar);// берем коли-во


            if (this.getTowarSklad().containsKey(towar)) {// если данная позиция есть на складе

                int value1 = this.getTowarSklad().get(towar);// находим ее количество

                if (value1 - value > 0) {// если количество товара больше на складе

                    this.getTowarSklad().put(towar, value1 - value);// то в данную позицию помещаем разницу
                }
            } else {// иначе в обоих случаях исключения (позиции на складе нет или value - value1<0)

                this.getTowarSklad().put(towar, null);// обнуляем текущую позицию
            }
        }


    }


    public void caseOfOperation(TTN ttn) {// если в ТТН

        if (ttn.getRecipient().getName().equals(this.getName()) &&//имя и адрес получателя совпадает  со складским
                ttn.getRecipient().getAdress().equals(this.getAdress())) {
            this.addTowar(ttn);// то товар из накладной добавляем
        } else {

            this.substractTowar(ttn);// иначе отнимаем

        }

    }

    public void printSklad() {// печать

        System.out.println("Наименование  " + this.getName());// наименование
        System.out.println("Адрес  " + this.getAdress());// адреса

        Set<Map.Entry<Towar, Integer>> settowar = this.getTowarSklad().entrySet();
        // создаем Set<Map.Entry<Towar,Integer>>

        int count = 1;// номер по порядку позиций

        for (Map.Entry<Towar, Integer> towar : settowar) { // для каждой позиции из МАПЫ

            System.out.println(count + "  " + towar.getKey() + "  " + towar.getValue());
            // печать ключа и значения
            count = +1;


        }


    }

    public boolean seachTowarSklad(Towar towar) {

        Set<Map.Entry<Towar, Integer>> settowar = this.getTowarSklad().entrySet();

      boolean exist= false;

        for (Map.Entry<Towar, Integer> towars : settowar) {

           if (towar.equals(towars.getKey())){

               exist=true;
           }

        }

return exist;
    }
}


