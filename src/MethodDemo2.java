import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 */
public class MethodDemo2 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("hello");

        Class c1 = list.getClass();
        Class c2 = list1.getClass();

        System.out.println(c1 == c2);
        //反射后的操作都是编译之后的操作

        /*
         * 若c1 == c2结果返回true说明编译之后集合的泛型是去泛型化的
         * java中集合的泛型，是防止错误输入的，只在编译阶段有效，
         * 绕过编译就无效了
         * 验证：我们可以通过方法的反射来操作，绕过编译
         */

        try {
            Method m= c2.getMethod("add", Object.class);
            m.invoke(list1, 100);   //绕过编译操作就饶过了泛型
            System.out.println(list1.size());
            System.out.println(list1);
            //不能用foreach来编译，否则会出现类型转换异常
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
