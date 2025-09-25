package Pradeep.OOPS;

public class encapsulationBank {
    private long accNo;
    private String Name;
    private String pass;

    encapsulationBank() {}

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public String getPass()
    {
        return pass;
    }

    public void setAccNo(long accNo)
    {
        this.accNo = accNo;
    }

    public long getAccNo()
    {
        return accNo;
    }

    public void setName(String Name)
    {
        this.Name = Name;
    }

    public String getName()
    {
        return Name;
    }

    public static void main(String[] args) {
        encapsulationBank b1 = new encapsulationBank();
        encapsulationBank b2 = new encapsulationBank();
        encapsulationBank b3 = new encapsulationBank();

        b1.setAccNo(123);
        b1.setPass("abc123");
        b1.setName("abc");
        System.out.println("\n-------------Getting details of b1-------------");
        System.out.println("Account Number : " + b1.getAccNo());
        System.out.println("Password : " + b1.getPass());
        System.out.println("Name : " + b1.getName());

        b2.setAccNo(456);
        b2.setPass("pqr456");
        b2.setName("pqr");
        System.out.println("\n-------------Getting details of b2-------------");
        System.out.println("Account Number : " + b2.getAccNo());
        System.out.println("Password : " + b2.getPass());
        System.out.println("Name : " + b2.getName());

        b3.setAccNo(789);
        b3.setPass("xyz789");
        b3.setName("xyz");
        System.out.println("\n-------------Getting details of b3-------------");
        System.out.println("Account Number : " + b3.getAccNo());
        System.out.println("Password : " + b3.getPass());
        System.out.println("Name : " + b3.getName());
    }
}
