package Office;

/**
 * 描述：动态加载类
 */
class Office {
    public static void main(String[] args) {
        //new创建对象是静态加载类，在编译时可就需要加载所有的可能是用到的类
        String[] arr = new String[]{"Word", "Excel"};
        if ("Word".equals(arr[0])) {
            Word w = new Word();
            w.start();
        }
        if ("Excel".equals(arr[1])) {
            Excel e = new Excel();
            e.start();
        }
    }
}
