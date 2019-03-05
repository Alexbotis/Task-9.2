package botis.itstep.by;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CompanyTest {

    private Company company;

    public CompanyTest() {

        company = new Company();
        //Recipients
        company.addRecipient(new Recipient("Rec1", "Sovetskaya 1"));
        company.addRecipient(new Recipient("Rec2", "Sovetskaya 2"));
        company.addRecipient(new Recipient("Sklad1", "Address sklad1"));
        //Suppliers
        company.addSupplier(new Supplier("Supp1", "Address 1"));
        company.addSupplier(new Supplier("Supp2", "Address 2"));
        company.addSupplier(new Supplier("Sklad1", "Address sklad1"));
        company.addSupplier(new Supplier("Sklad2", "Address sklad2"));
        //Sklad
        company.addSklad(new Sklad ("Sklad1", "Address sklad1"));
        company.addSklad(new Sklad ("Sklad2", "Address sklad2"));
    }


    @Test
    public void addRecipientTest() {

        company.addRecipient(new Recipient("r1", "rad1"));

        company.addRecipient(new Recipient("r2", "rad2"));
        company.addRecipient(new Recipient("r3", "rad3"));
        company.addRecipient(new Recipient("r4", "rad4"));

        Assert.assertTrue(company.getListRecipient().size() == 7);
    }

    @Test
    public void addSupplierTest() {

        company.addSupplier(new Supplier("sp1", "spad1"));

        company.addSupplier(new Supplier("sp2", "spad2"));
        company.addSupplier(new Supplier("sp3", "spad3"));
        company.addSupplier(new Supplier("sp4", "spad4"));

        Assert.assertTrue(company.getListSupplier().size() == 8);
    }

    @Test
    public void addSkladTest() {
       // company.addSklad(new Sklad("skl", "sklad1"));
       // company.addSklad(new Sklad("sk2", "sklad2"));
        Assert.assertTrue(company.getListSklady().size() == 2);
    }

    @Test
    public void createTtnTest() {

        Map<Towar, Integer> products = new HashMap<Towar, Integer>();

        products.put(new Towar("tov1", "measure", 3), 1);
        products.put(new Towar("tov2", "measure2", 4), 2);

        Supplier supplier = company.getSupplier(1);
        Recipient recipient = company.getRecipient(2);

        TTN ttn = company.createTTN(123, 111, supplier, recipient, products);

        Assert.assertTrue(ttn != null);

    }
    @Test
    public void useTTNTest(){

        Map<Towar, Integer> products = new HashMap<Towar, Integer>();

        products.put(new Towar("tov1", "measure", 3), 1);
        products.put(new Towar("tov2", "measure2", 4), 2);

        Supplier supplier = company.getSupplier(0);
        Recipient recipient = company.getRecipient(2);

        TTN ttn = company.createTTN(123, 111, supplier, recipient, products);
        company.useTTN(ttn);
        Assert.assertTrue(company.getListSklady().get(0).getTowarSklad()!= null);
        Towar towar=new Towar("tov2", "measure2", 4);
        Assert.assertTrue(company.getListSklady().get(0).getTowarSklad().entrySet().size()==2);
        Assert.assertFalse(company.getListSklady().get(0).getTowarSklad().containsKey(towar)==true);//???

    }


}
