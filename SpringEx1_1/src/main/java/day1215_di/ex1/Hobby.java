package day1215_di.ex1;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    String name;
    List<String> list = new ArrayList<String>();

    public Hobby(String name, List<String> list) {
        this.name = name;
        this.list = list;
    }

    public void write() {
        System.out.println("name : " + name);
        System.out.println("** my hobbies **");

        for (String h : list) {
            System.out.println(h);
        }
//        list.forEach(h-> System.out.println(h));
    }
}
