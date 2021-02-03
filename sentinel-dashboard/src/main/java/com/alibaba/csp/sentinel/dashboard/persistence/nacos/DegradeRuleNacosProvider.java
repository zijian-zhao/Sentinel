package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import org.springframework.stereotype.Component;

@Component("degradeRuleNacosProvider")
public class DegradeRuleNacosProvider extends BaseNacosProvider<DegradeRuleEntity> {

    @Override
    public String getNacosDataIdPostfix() {
        return NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX;
    }
}
