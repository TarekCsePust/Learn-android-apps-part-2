package com.example.hasantarek.insertdata_32;

/**
 * Created by Hasan Tarek on 7/14/2017.
 */
public class Dataprovider {
    String dname;
    String dmobile;
    String demail;

    public Dataprovider(String dname,String dmobile,String demail)
    {
        this.dname = dname;
        this.dmobile = dmobile;
        this.demail = demail;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDmobile() {
        return dmobile;
    }

    public void setDmobile(String dmobile) {
        this.dmobile = dmobile;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }
}
