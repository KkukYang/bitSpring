package ex2.test;

public class EmpPay {
    Sawon sawon;
    int pay;

    public EmpPay(Sawon sawon) {
        this.sawon = sawon;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public void write() {
        System.out.println("** Sawon Info **");
        sawon.show();
        System.out.println("** Salary this Month **");
        System.out.println(pay);
    }
}
