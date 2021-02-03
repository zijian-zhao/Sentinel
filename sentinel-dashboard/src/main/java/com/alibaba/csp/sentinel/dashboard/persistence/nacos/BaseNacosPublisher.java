package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseNacosPublisher<T>  implements DynamicRulePublisher<List<T>> {

    @Autowired
    private ConfigService configService;
    @Autowired
    private Converter<List<T>, String> converter;

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(app + getNacosDataIdPostfix(),
                NacosConfigUtil.GROUP_ID, converter.convert(rules));
    }

    public abstract String getNacosDataIdPostfix();
}
