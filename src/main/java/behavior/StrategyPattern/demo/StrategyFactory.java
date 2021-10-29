package behavior.StrategyPattern.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @功能职责: 策略工厂
 * @描述：
 * @author 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class StrategyFactory {

    /**
     * 策略模式工厂
     * */
    private static StrategyFactory factory = new StrategyFactory();

    /**
     * 策略接口Map
     * */
    private static Map<String,IStrategy> strategyMap = new HashMap<>();

    static{
        strategyMap.put(AgreementEnum.PTXY.getType(), new StrategyPTXY());
        strategyMap.put(AgreementEnum.RYXY.getType(), new StrategyRYXY());
        strategyMap.put(AgreementEnum.TDXY.getType(), new StrategyRYXY());
    }

    private StrategyFactory(){
    }

    /**
     * 不同策略拿到不同接口的实现类
     * */
    public IStrategy creator(String type){
        return strategyMap.get(type);
    }

    public static StrategyFactory getInstance(){
        return factory;
    }
}
