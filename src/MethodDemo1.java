import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 描述：通过反射来调用方法
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        //要获取print(int a, int b)方法
        //1.要获取一个方法就是获取类的信息，获取类的信息首先要获取类的类类型
        A a1 = new A();
        Class c = a1.getClass();
        /*
         * 2.获取方法，名称和参数列表来决定
         * getMethod获取的是public的方法
         * getDeclaredMethods()自己声明的方法
         */

        try {
            Method m = c.getMethod("print", int.class, int.class);

            //方法的反射操作
            //a1.print(10, 20); 方法的反射操作使用m对象来进行方法调用和a1.print调用的效果相同
            //方法如果没有返回值返回null，有返回值返回具体的返回值
            //Object o = m.invoke(a1, new Object[]{10, 20});
            Object o = m.invoke(a1, 10, 20);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
class A{
    public void print(int a, int b){
        System.out.println(a + b);
    }

    public void print(String a, String b){
        System.out.println(a.toUpperCase() + "," + b.toUpperCase());
    }
}