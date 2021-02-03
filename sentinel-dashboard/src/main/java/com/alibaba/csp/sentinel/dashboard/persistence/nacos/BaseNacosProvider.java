package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseNacosProvider<T> implements DynamicRuleProvider<List<T>>  {

    @Autowired
    private ConfigService configService;
    @Autowired
    private Converter<String, List<T>> converter;

    @Override
    public List<T> getRules(String appName) throws Exception {
        String rules = configService.getConfig(appName + getNacosDataIdPostfix(),
                NacosConfigUtil.GROUP_ID, 3000);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return converter.convert(rules);
    }

    public abstract String getNacosDataIdPostfix();
}
