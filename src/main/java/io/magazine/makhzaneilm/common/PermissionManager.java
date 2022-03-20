package io.magazine.makhzaneilm.common;

import org.springframework.security.access.prepost.PreAuthorize;

/**
 * {@link PreAuthorize} expression language constants declared here
 **/
public final class PermissionManager {

    private PermissionManager() {
        throw new UnsupportedOperationException("Instantiation not allowed");
    }
    
    // For Admin Admin
    public static final String ADMIN_ROLE = "hasRole('ROLE_ADMIN')";


}

