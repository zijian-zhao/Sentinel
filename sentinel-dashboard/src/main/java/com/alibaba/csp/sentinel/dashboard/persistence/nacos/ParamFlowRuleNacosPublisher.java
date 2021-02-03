package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import org.springframework.stereotype.Component;

@Component("paramFlowRuleNacosPublisher")
public class ParamFlowRuleNacosPublisher extends BaseNacosPublisher<ParamFlowRuleEntity> {

    @Override
    public String getNacosDataIdPostfix() {
        return NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }
}