package create.FactoryPattern.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂方法模式接口
 * */
public interface Shape {
    void draw();
}

/**
 * 工厂方法模式接口的实现类
 * */
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }
}
/**
 * 工厂方法模式接口的实现类
 * */
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }
}
/**
 * 工厂方法模式接口的实现类
 * */
class Circle  implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle .draw");
    }
}

/**
 * 工厂方法模式的上下文对象
 * */
class ShapeFactory {
    /**
     * 这样子是有问题的，因为每次拿到的对象都是那一个，每次改变对象，对其它使用者有影响
     *
     * */
   /* private static Map<String,Shape> factoryCache = new HashMap<>();
    static {
        factoryCache.put("CIRCLE",new Circle());
        factoryCache.put("RECTANGLE", new Rectangle());
        factoryCache.put("SQUARE",new Square());
    }*/
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){

        /**
         * 这样子是有问题的，因为每次拿到的对象都是那一个，每次改变对象，对其它使用者有影响
         *  return factoryCache.get(shapeType) == null ? null:factoryCache.get(shapeType);
         * */
        if("CIRCLE".equals(shapeType)){
           return new Circle();
        }
        if("RECTANGLE".equals(shapeType)){
            return new Rectangle();
        }
        if("SQUARE".equals(shapeType)){
            return new Square();
        }
        System.out.println("条件穿透");
        return null;
    }
}

/**
 * 工厂方法模式的测试类
 * */
class TestFactoryPattern{
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
        shape = shapeFactory.getShape("RECTANGLE");
        shape.draw();
        shape = shapeFactory.getShape("SQUARE");
        shape.draw();

    }
}