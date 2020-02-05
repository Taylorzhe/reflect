/**
 * 描述：通过反射获取类的成员变量信息
 */
public class ClassDemo4 {
    public static void main(String[] args) {
        ClassUtil.printFieldMessage("hello");
        System.out.println("==================");
        ClassUtil.printFieldMessage(1);
    }
}
