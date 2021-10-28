package create.FactoryPattern.practice;

public interface Shape {
    void draw();
}


class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }
}

class Circle  implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle .draw");
    }
}

class ShapeFactory {
    //使用 getShape 方法获取形状类型的对象
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}

class TestFactoryPattern{
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("CIRCLE");
        shape.draw();

        shape = shapeFactory.getShape("RECTANGLE");
        shape.draw();

        shape = shapeFactory.getShape("SQUARE");
        shape.draw();

        shape = shapeFactory.getShape("CIRCLE");
        shape.draw();
    }
}