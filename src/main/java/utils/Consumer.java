package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumer {
    private String name;
    private String vatId;
    private Date date;
    private String address;
    SimpleDateFormat formatter;

    public Consumer(String name, String vatId, String address) {
        this.name = name;
        this.vatId = vatId;
        this.date = new Date(System.currentTimeMillis());
        this.address = address;
        formatter= new SimpleDateFormat("yyyy-MM-dd");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVatId() {
        return vatId;
    }

    public void setVatId(String vatId) {
        this.vatId = vatId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
//        return String.format("Name: %s " +
//                            "VatId: %s " +
//                            "Date: " + formatter.format(date) +
//                            "Address: %s", name, vatId, address);
        return String.format("%s %s %s %s", name, vatId, formatter.format(date), address);
    }

}
