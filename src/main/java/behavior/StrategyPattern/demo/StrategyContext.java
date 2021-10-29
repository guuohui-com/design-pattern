package behavior.StrategyPattern.demo;

/**
 * @功能职责: 策略模式上下文
 * @描述：
 * @author 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class StrategyContext {

    /**
     * 当前采用的策略对象
     */
    private IStrategy strategy;


    public Boolean calRecharge(String type) {
        strategy = StrategyFactory.getInstance().creator(type);
        return strategy.getValue(type);
    }

    public IStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }


}
