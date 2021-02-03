package com.alibaba.csp.sentinel.dashboard.persistence.nacos;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import org.springframework.stereotype.Component;


@Component("authorityRuleNacosProvider")
public class AuthorityRuleNacosProvider extends BaseNacosProvider<AuthorityRuleEntity> {

    @Override
    public String getNacosDataIdPostfix() {
        return NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX;
    }
}