package StrategyPattern.demo;

/**
 *
 * @功能职责 退订协议
 * @描述
 * @author 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class StrategyTDXY implements IStrategy {
    @Override
    public Boolean getValue(String pam) {
        return true;
    }
}
