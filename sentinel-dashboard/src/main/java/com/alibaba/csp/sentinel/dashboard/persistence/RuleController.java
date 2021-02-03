package com.alibaba.csp.sentinel.dashboard.persistence;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.repository.rule.InMemoryRuleRepositoryAdapter;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class RuleController<T extends RuleEntity> {

    @Autowired
    protected InMemoryRuleRepositoryAdapter<T> repository;
    @Autowired
    private DynamicRuleProvider<List<T>> ruleProvider;
    @Autowired
    private DynamicRulePublisher<List<T>> rulePublisher;

    protected List<T> fetchRules(/*@NonNull*/ String appName) {
        try{
            return ruleProvider.getRules(appName);
        }
        catch (Exception e){
            return new ArrayList<>();
        }

    }

    protected boolean publishRules(/*@NonNull*/ String app) {
        try{
            List<T> rules = repository.findAllByApp(app);
            rulePublisher.publish(app, rules);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
