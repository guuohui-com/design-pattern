package create.SingletonPattern.demo;

/**
 * @功能职责: 单例模式 --- 恶汉模式
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class SingletonPatternEvil {
    //立即声明
    private static SingletonPatternEvil singleton = new SingletonPatternEvil();
    //私有化构造方法
    private SingletonPatternEvil(){}

    public static SingletonPatternEvil getInstance(){
        return singleton;
    }
}

class TestSingletonPatternEvile{
    public static void main(String[] args) {
        new Thread(()->System.out.println(SingletonPatternEvil.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternEvil.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternEvil.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternEvil.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternEvil.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternEvil.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternEvil.getInstance().hashCode())).start();
    }
}
