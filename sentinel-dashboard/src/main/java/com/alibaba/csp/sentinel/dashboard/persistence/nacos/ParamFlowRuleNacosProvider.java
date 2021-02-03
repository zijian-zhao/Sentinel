package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import org.springframework.stereotype.Component;

@Component("paramFlowRuleNacosProvider")
public class ParamFlowRuleNacosProvider extends BaseNacosProvider<ParamFlowRuleEntity> {

    @Override
    public String getNacosDataIdPostfix() {
        return NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }
}