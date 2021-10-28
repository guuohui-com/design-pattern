package create.AbstractFactoryPattern.practice;


/**
 * @功能职责: 抽象工厂模式
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象工厂
 * */
public abstract class AbstractFactoryPattern {
    public abstract Book getBook(String book);
    public abstract Computer getComputer(String computer);
}
/**
 * 实例工厂BookFactory
 * */
class BookFactory extends AbstractFactoryPattern{

    @Override
    public Book getBook(String book) {
        switch(book){
            case "ThinkingInJava":
                return new ThinkingInJava();
            case "Net":
                return new Net();
            default:
                return null;
        }
    }

    @Override
    public Computer getComputer(String computer) {
        switch(computer){
            case "ThinkPad":
                return new ThinkPad();
            case "Apple":
                return new Apple();
            default:
                return null;
        }
    }
}

/**
 * 实例工厂ComputerFactory
 * */
class ComputerFactory extends AbstractFactoryPattern{

    @Override
    public Book getBook(String book) {
        switch(book){
            case "Restructure":
                return new Restructure();
            case "ThinkingInJava":
                return new ThinkingInJava();
            default:
                return null;
        }
    }

    @Override
    public Computer getComputer(String computer) {
        switch(computer){
            case "Leveno":
                return new Leveno();
            case "ThinkPad":
                return new ThinkPad();
            default:
                return null;
        }
    }
}

/**
 * 抽象工厂上下文
 * */
class FactoryContext{

    private static Map<String,AbstractFactoryPattern> factoryPatternMap = new HashMap<>();
    static {
        factoryPatternMap.put("BOOKFACTORY",new BookFactory());
        factoryPatternMap.put("COMPUTERFACTORY",new ComputerFactory());
    }

    public static AbstractFactoryPattern getFactory(String factoryName){
        if ("BOOKFACTORY".equalsIgnoreCase(factoryName)){
            return factoryPatternMap.get(factoryName);
        }else if ("COMPUTERFACTORY".equalsIgnoreCase(factoryName)){
            return factoryPatternMap.get(factoryName);
        }else {
            return null;
        }
    }
}

class Test{
    public static void main(String[] args) {
        AbstractFactoryPattern factoryPattern = FactoryContext.getFactory("bookFactory".toUpperCase());
        System.out.println(factoryPattern.getBook("Net").getTitle());
        System.out.println(factoryPattern.getBook("ThinkingInJava").getTitle());
        System.out.println(factoryPattern.getComputer("Apple").getComputer());
        System.out.println(factoryPattern.getComputer("ThinkPad").getComputer());

        factoryPattern = FactoryContext.getFactory("computerFactory".toUpperCase());
        System.out.println(factoryPattern.getBook("ThinkingInJava").getTitle());
        System.out.println(factoryPattern.getBook("Restructure").getTitle());
        System.out.println(factoryPattern.getComputer("Leveno").getComputer());
        System.out.println(factoryPattern.getComputer("ThinkPad").getComputer());
    }
}

/**
 *======================================= 以下是抽象商品和实例商品类，以上是差偶像工厂和实例工厂类 =======================================================
 * */

/**
 * 抽象商品
 * */
interface Book{
    String getTitle();
}
/**
 * 实例商品
 * */
class Restructure implements Book{

    @Override
    public String getTitle() {
        return "<重构>";
    }
}
/**
 * 实例商品
 * */
class ThinkingInJava implements Book{

    @Override
    public String getTitle() {
        return "<java编程思想>";
    }
}
/**
 * 实例商品
 * */
class Net implements Book{

    @Override
    public String getTitle() {
        return "<网络是怎样连接的>";
    }
}

/**
 * 抽象商品
 * */
interface Computer{
    String getComputer();
}

/**
 * 实例商品
 * */
class Leveno implements Computer{

    @Override
    public String getComputer() {
        return "联想";
    }
}

/**
 * 实例商品
 * */
class ThinkPad implements Computer{

    @Override
    public String getComputer() {
        return "ThinkPad";
    }
}

/**
 * 实例商品
 * */
class Apple implements Computer{
    @Override
    public String getComputer() {
        return "苹果";
    }
}
