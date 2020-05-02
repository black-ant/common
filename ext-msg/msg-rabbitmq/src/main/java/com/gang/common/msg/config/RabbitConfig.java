package com.gang.common.msg.config;

import com.gang.common.msg.to.BaseMsgConfigTO;
import org.springframework.stereotype.Component;

/**
 * @Classname RabbitConfig
 * @Description TODO
 * @Date 2020/2/29 17:12
 * @Created by zengzg
 */
@Component
public class RabbitConfig extends BaseMsgConfig<RabbitConfig> {

    private String host;
    private String port;
    private String username;
    private String password;


    @Override
    public void setMsgConfig(BaseMsgConfigTO baseMsgConfigTO) {

    }

    @Override
    public RabbitConfig getMsgConfig() {
        return null;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
