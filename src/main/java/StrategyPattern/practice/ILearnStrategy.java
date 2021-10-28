package StrategyPattern.practice;

/**
 * 策略模式接口
 * */
public interface ILearnStrategy {
    Integer operation(int pam1,int pam2);
}

/**
 * 策略---ADD
 * */
class AddStrategy implements ILearnStrategy{
    @Override
    public Integer operation(int pam1, int pam2) {
        return pam1 + pam2;
    }
}


/**
 * 策略---MIN
 * */
class MinStrategy implements ILearnStrategy{
    @Override
    public Integer operation(int pam1, int pam2) {
        return pam1 - pam2;
    }
}

/**
 * 策略---MUL
 * */
class MultiStrategy implements ILearnStrategy{
    @Override
    public Integer operation(int pam1, int pam2) {
        return pam1 * pam2;
    }
}

/**
 * 策略---DIV
 * */
class DivisionStrategy implements ILearnStrategy{
    @Override
    public Integer operation(int pam1, int pam2) {
        return pam1/pam2;
    }
}

/**
 * 策略模式上下文，
 * 核心思想：面向接口编程
 * 将策略的顶层接口作为私有属性，提供一个公共方法，可以根据实现类选择不同策略
 * */
class StrategyContext{

    private  ILearnStrategy iLearnStrategy;

    public StrategyContext(ILearnStrategy iLearnStrategy) {
        this.iLearnStrategy = iLearnStrategy;
    }

    public Integer strategy(int pam1, int pam2){
        return iLearnStrategy.operation(pam1,pam2);
    }
}

class Test{
    public static void main(String[] args) {
        int pam1 = 10, pam2 = 5;
        StrategyContext strategyContextAdd = new StrategyContext(new AddStrategy());
        System.out.println(strategyContextAdd.strategy(pam1, pam2));

        StrategyContext strategyContextMin = new StrategyContext(new MinStrategy());
        System.out.println(strategyContextMin.strategy(pam1, pam2));

        StrategyContext strategyContextMulti = new StrategyContext(new MultiStrategy());
        System.out.println(strategyContextMulti.strategy(pam1, pam2));

        StrategyContext strategyContextDivision = new StrategyContext(new DivisionStrategy());
        System.out.println(strategyContextDivision.strategy(pam1, pam2));

        System.out.println(new StrategyContext(new ILearnStrategy() {
            @Override
            public Integer operation(int pam1, int pam2) {
                return pam1 % pam2;
            }
        }).strategy(pam1, pam2));

        System.out.println(new StrategyContext((num1, num2)-> {return num1 % num2;}).strategy(pam1, pam2));
    }
}