package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import org.springframework.stereotype.Component;

@Component("systemRuleNacosProvider")
public class SystemRuleNacosProvider extends BaseNacosProvider<SystemRuleEntity> {

    @Override
    public String getNacosDataIdPostfix() {
        return NacosConfigUtil.SYSTEM_DATA_ID_POSTFIX;
    }
}
