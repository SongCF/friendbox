package com.scys.friendbox.utils.context;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;

/**
 * @author dx
 * @version : AuthToken.java, v 0.1 2021年10月11日 4:13 下午 dx Exp $
 */
public class AuthToken implements Serializable {
    private OperatorDTO            loginUser;
    private Map<String, Set<Long>> optCodes;
    private String                 currentTntInstId;
    private String                 loginIP;

    public AuthToken() {
    }

    public boolean containsOptCodes(Set<String> optCodes) {
        Iterator var2 = optCodes.iterator();

        String optCode;
        do {
            if (!var2.hasNext()) {
                return true;
            }

            optCode = (String) var2.next();
        } while (this.containsOptCode(optCode));

        return false;
    }

    public boolean containsOptCode(String optCode) {
        return !CollectionUtils.isEmpty(this.optCodes) ? this.optCodes.containsKey(optCode) : false;
    }

    public Set<Long> getAuthedAppResIds() {
        Collection<Set<Long>> values = this.optCodes.values();
        Set<Long> authedAppResIds = new HashSet();
        Iterator var3 = values.iterator();

        while (var3.hasNext()) {
            Set<Long> set = (Set) var3.next();
            if (!CollectionUtils.isEmpty(set)) {
                authedAppResIds.addAll(set);
            }
        }

        return authedAppResIds;
    }

    public Set<Long> getAuthedAppResIdsByOptCode(String optCode) {
        return (Set) this.optCodes.get(optCode);
    }

    public String getLoginIP() {
        return this.loginIP;
    }

    public OperatorDTO getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(OperatorDTO loginUser) {
        this.loginUser = loginUser;
    }

    public Map<String, Set<Long>> getOptCodes() {
        return optCodes;
    }

    public void setOptCodes(Map<String, Set<Long>> optCodes) {
        this.optCodes = optCodes;
    }

    public String getCurrentTntInstId() {
        return currentTntInstId;
    }

    public void setCurrentTntInstId(String currentTntInstId) {
        this.currentTntInstId = currentTntInstId;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}