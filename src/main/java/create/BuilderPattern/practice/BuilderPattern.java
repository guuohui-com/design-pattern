package create.BuilderPattern.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @功能职责: 建造者模式
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class BuilderPattern {
    public static void main(String[] args) {
        MealBuilder.prepareChickenMeal().showItems();
        System.out.println("=================================");
        MealBuilder.prepareVegMeal().showItems();
    }
}


/**
 * 固定组合封装
 * */
class MealBuilder{
    /**
     * 固定组合一
     * */
    public static Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    /**
     * 固定组合二
     * */
    public static Meal prepareChickenMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Coke());
        return meal;
    }
}


/**
 * 提供提成对象的组合接口
 * */
class Meal{
    private List<Item> list = new ArrayList<>();
    public void addItem(Item item){
        list.add(item);
    }

    public float getCost(){
        Float result = 0f;
        for (Item item : list) {
            result+=item.price();
        }
        return result;
    }

    public void showItems(){
        list.stream().forEach((item)->{
            System.out.println(item.name()+"  "+ item.packing() +"  "+ item.price());
        });
    }

}

interface Item{
    public String name();
    public Packing packing();
    public float price();
}

interface Packing{
    public String pack();
}

class Wrapper implements Packing{

    @Override
    public String pack() {
        return "袋子";
    }
}
class Bottle implements Packing{
    @Override
    public String pack() {
        return "瓶子";
    }
}

abstract class Burger implements Item{
    @Override
    public Packing packing(){
        return new Wrapper();
    }
}

abstract class ColdDrink implements Item{
    @Override
    public Packing packing(){
        return new Bottle();
    }
}

class VegBurger extends Burger{

    @Override
    public String name() {
        return "蔬菜汉堡";
    }

    @Override
    public float price() {
        return 5.5f;
    }
}

class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "麦辣鸡腿堡";
    }

    @Override
    public float price() {
        return 12.5f;
    }
}

class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "百事可乐";
    }

    @Override
    public float price() {
        return 3f;
    }
}

class Coke extends ColdDrink{
    @Override
    public String name() {
        return "可口可乐";
    }

    @Override
    public float price() {
        return 3f;
    }
}

