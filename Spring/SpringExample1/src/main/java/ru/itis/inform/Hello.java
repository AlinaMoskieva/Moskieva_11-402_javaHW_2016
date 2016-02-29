package ru.itis.inform;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by Moskieva on 29.02.16.
 */
public class Hello {
    private String s;
    private String who;
    private String ex;

    public String getS() {
        return s;
    }

    public String getWho() {
        return who;
    }
    public void setWho(String who) {
        this.who = who;
    }
    public Hello(String str, String ex){
        s = str;
        this.ex = ex;
    }

    public void sayHi(){
        System.out.println(s + " "+ ex + "  "+ who);
    }

    public static void main(String []args){
       // Hello h = new Hello("Hi!!!");
        //h.sayHi();

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(new String[] {"config.xml"});//показываем Spring где лежит файл конфигурации
        Hello h = (Hello) ac.getBean("hello");//указываем id нашего bean-а
        h.sayHi();
    }




}
