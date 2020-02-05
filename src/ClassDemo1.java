/**
 * 描述：获取类的类类型
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        //Foo的实例对象如何表示
        Foo fool1 = new Foo();
        //Foo这个类也是一个是对象，Class类的实例对象，如何表示呢
        //源码上Class类被private修饰，Class类只能被Java虚拟机所创建
        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式

        //第一种表示方式--->实际再告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;

        //第二种表示方式--->已经知道该类的对象通过getClass方法
        Class c2 = fool1.getClass();

    /*官网c1、c2表示了Foo类的类类型（class type）
    万事万物皆对象，
    类也是对象，是Class类的实例对象
    这个对象我们称为该类的类类型*/

        //不管c1或者c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);    //true

        //第三种表达方式--->
        Class c3 = null;
        try {
            c3 = Class.forName("Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);  //true

        //我们完全可以通过类的类类型创建该类的对象实例--->通过c1、c2、c3创建Foo的实例对象
        try {
            Foo foo = (Foo) c1.newInstance(); //需要有无参数的构造方法
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Foo{
    public void print(){
        System.out.println("这是新创建出来的对象");
    }
}