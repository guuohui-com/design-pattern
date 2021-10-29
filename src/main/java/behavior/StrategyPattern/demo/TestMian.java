package behavior.StrategyPattern.demo;

import java.util.Scanner;

/**
 * @功能职责:
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class TestMian {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pam = sc.nextLine();
        StrategyContext context = new StrategyContext();
        System.out.println(context.calRecharge(pam));
    }
}
