package create.PrototypePattern.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @功能职责:
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class PrototyPattern {
    public static void main(String[] args) {
        /*PrototyShap prototyshap = ProtoShapCache.getClone("CIRCLE");
        prototyshap.draw();
        prototyshap = ProtoShapCache.getClone("RECTANGLE");
        prototyshap.draw();
        prototyshap = ProtoShapCache.getClone("SQUARE");
        prototyshap.draw();*/
        PrototyShap prototyshap = ProtoShapCache.getClone("CIRCLE");
        prototyshap.draw();
        prototyshap.setId("100");
        System.out.println(prototyshap.getId());

        PrototyShap prototyShap = ProtoShapCache.getClone("CIRCLE");
        System.out.println(prototyShap.getId());
    }
}

/**
 * 原型模式接口
 * */
abstract class PrototyShap implements Cloneable{
    public String id;
    public String type;

    public abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object clone(){
        Object result = null;
        try {
            result = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}

/**
 * 原形接口的实现类 1
 * Circle
 * */
class Circle extends PrototyShap{

    public Circle(){
        this.type = "CIRCLE";
    }

    @Override
    public void draw() {
        System.out.println("CIRCLE");
    }
}
/**
 * 原形接口的实现类 2
 * Square
 * */
class Square extends PrototyShap{
    public Square(){
        this.type = "SQUARE";
    }
    @Override
    public void draw(){
        System.out.println("SQUARE");
    }
}
/**
 * 原形接口的实现类 3
 * Rectangle
 * */
class Rectangle extends PrototyShap{
    public Rectangle(){
        this.type = "RECTANGLE";
    }
    @Override
    public void draw() {
        System.out.println("RECTANGLE");
    }
}

/**
 * 原型模式
 * 类的获取接口
 * */
class ProtoShapCache{
   private static final Map<String,PrototyShap> prototyShapCache = new HashMap<String,PrototyShap>();
   /**
    * 静态块 缓存预热
    * */
   static {
       prototyShapCache.put("RECTANGLE", new Rectangle());
       prototyShapCache.put("SQUARE", new Square());
       prototyShapCache.put("CIRCLE", new Circle());
   }

   /**
    * 获取 PrototyShap 的接口
    * */
   public static PrototyShap getClone(String pam){
       return (PrototyShap)prototyShapCache.get(pam).clone();
   }
}

