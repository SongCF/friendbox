package com.scys.friendbox.utils.context;

import com.scys.friendbox.session.OperatorDTO;
import com.scys.friendbox.session.RequestContextHolder;

public class LoginUserUtil {

    public static final String SYSTEM_USER_ID = "system";
    public static final String GATEWAY_USER_ID = "gateway";
    public static final String UNKNOWN_USER_ID = "unknown";

    /**
     * get user
     */
    public static OperatorDTO getLoginUser() {
        try {
            return RequestContextHolder.getCurrentRequestContext().getAuthToken().getLoginUser();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * is special
     * @return
     */
    public static boolean isSpecialUser(String userId) {
        return SYSTEM_USER_ID.equals(userId) || GATEWAY_USER_ID.equals(userId);
    }


}