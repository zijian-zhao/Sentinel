package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import org.springframework.stereotype.Component;

@Component("authorityRuleNacosPublisher")
public class AuthorityRuleNacosPublisher extends BaseNacosPublisher<AuthorityRuleEntity> {

    @Override
    public String getNacosDataIdPostfix() {
        return NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX;
    }
}