package behavior.StrategyPattern.demo;

/**
 * 平台协议枚举类
 * @author 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public enum AgreementEnum {

    /**
     * 平台协议
     * */
    PTXY("PTXY","平台协议",true),
    /**
     * 认养协议
     * */
    RYXY("RYXY","认养协议",true),
    /**
     * 退单协议
     * */
    TDXY("TDXY","退单协议",true)
    ;
    /**
     * 类型
     */
    private String type;
    /**
     * 描述
     */
    private String describe;
    /**
     * 键
     */
    private boolean key;

    AgreementEnum(String type, String describe, boolean key){
        this.type = type;
        this.describe = describe;
        this.key = key;
    }

    public Boolean getInstance(){
        return key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
}
