package create.SingletonPattern.demo;

/**
 * @功能职责: 单例模式 --- 懒汉模式
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class SingletonPatternLazy {
    private static SingletonPatternLazy singletonPatternLazy;

    //私有构造
    private SingletonPatternLazy(){}

    /**
     * 此方法可行，但是加了 synchronized 关键字，影响性能
     * */
    /*public synchronized static SingletonPatternLazy getInstance(){
        if (singletonPatternLazy == null){
            singletonPatternLazy = new SingletonPatternLazy();
        }
        return singletonPatternLazy;
    }*/

    /**
     * DCL 双重检查锁
     * */
    public static SingletonPatternLazy getInstance() {
        /**
         * 第一层判空 是为了提高性能，减小锁的粒度，只有需要new的时候加锁
         * */
        if (singletonPatternLazy == null) {
            /**
             * synchronized 此时将SingletonPatternLazy 类加锁,保证只有一个线程可以new
             * */
            synchronized (SingletonPatternLazy.class) {
                if (singletonPatternLazy == null){
                singletonPatternLazy = new SingletonPatternLazy();
                }
            }
        }
        return singletonPatternLazy;
    }
}

class TestSingletonPatternLazy{
    public static void main(String[] args) {
        new Thread(()->System.out.println(SingletonPatternLazy.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternLazy.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternLazy.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternLazy.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternLazy.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternLazy.getInstance().hashCode())).start();
        new Thread(()->System.out.println(SingletonPatternLazy.getInstance().hashCode())).start();
    }
}
