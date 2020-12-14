package ex2.test;

public class Sawon {
    String name, hp, addr;

    public Sawon(String name) {

        this.name = name;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void show() {
        System.out.println("name : " + name);
        System.out.println("hp : " + hp);
        System.out.println("addr : " + addr);
    }

}
