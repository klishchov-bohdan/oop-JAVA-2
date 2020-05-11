import java.util.Date;

public class Client{
    private int id;
    private Date dateOfReg;
    private String name;
    private String address;
    private String req;

    public String getName() {
        return name;
    }

    public Date getDateOfReg() {
        return dateOfReg;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getReq() {
        return req;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfReg(Date dateOfReg) {
        this.dateOfReg = dateOfReg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setReq(String req) {
        this.req = req;
    }
}