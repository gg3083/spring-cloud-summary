package com.gg.user.security;

import net.minidev.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.*;

/**
 * Utility class for Spring Security.
 *
 * @author Li Feixiang
 */
public final class SecurityUtils {

  private static final Logger log = LoggerFactory.getLogger(SecurityUtils.class);

  private SecurityUtils() {}

  /**
   * Get the login of the current user.
   *
   * @return the login of the current user
   */
  public static Optional<String> getCurrentUserId() {
    Object principal = getCurrentPrincipal();

    if (principal instanceof Jwt) {
      Jwt jwt = (Jwt) principal;
      if (log.isTraceEnabled()) {
        log.trace(
            "subject={},issuedAt={},expiresAt={}",
            jwt.getSubject(),
            jwt.getIssuedAt(),
            jwt.getExpiresAt());
      }
      jwt.getExpiresAt();
      Map<String, Object> claims = jwt.getClaims();
      String userId = (String) claims.get("user_id");
      if (userId == null || userId.length() == 0) {
        return Optional.empty();
      }
      return Optional.of(userId);
    }
    return Optional.empty();
  }

  public static Optional<String> getCurrentTenantId() {
    Object principal = getCurrentPrincipal();
    if (principal instanceof Jwt) {
      Jwt jwt = (Jwt) principal;
      Map<String, Object> claims = jwt.getClaims();
      String tenantId = (String) claims.get("tenant_id");
      if (tenantId == null || tenantId.length() == 0) {
        return Optional.empty();
      }
      return Optional.of(tenantId);
    }
    return Optional.empty();
  }

  public static Optional<String> getCurrentUserName() {
    Object principal = getCurrentPrincipal();
    if (principal instanceof UserDetails) {
      String username = ((UserDetails) principal).getUsername();
      return Optional.of(username);
    } else if (principal instanceof Jwt) {
      Jwt jwt = (Jwt) principal;
      Map<String, Object> claims = jwt.getClaims();
      String username = (String) claims.get("username");
      if (username == null || username.length() == 0) {
        return Optional.empty();
      }
      return Optional.of(username);
    } else if (principal instanceof String) {
      return Optional.of((String) principal);
    }
    return Optional.empty();
  }

  private static Object getCurrentPrincipal() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    Authentication authentication = securityContext.getAuthentication();
    if (authentication == null) {
      return null;
    }
    return authentication.getPrincipal();
  }

  public static Collection<String> getAuthorities() {
    Object principal = getCurrentPrincipal();
    if (principal instanceof Jwt) {
      Jwt jwt = (Jwt) principal;
      Map<String, Object> claims = jwt.getClaims();
      ArrayList<String> authorities = (ArrayList<String>) claims.get("authorities");
      if (authorities == null) {
        return Collections.emptyList();
      }
      return authorities;
    }
    return Collections.emptyList();
  }

  public static boolean isSystemAdmin() {
    Object principal = getCurrentPrincipal();
    if (principal instanceof Jwt) {
      Jwt jwt = (Jwt) principal;
      Map<String, Object> claims = jwt.getClaims();
      JSONArray authorities = (JSONArray) claims.get("authorities");
      if (authorities == null) {
        return false;
      }
      return authorities.contains("ROLE_SYSTEM_ADMIN");
    }
    return false;
  }

  public static boolean isSecurityAdmin() {
    Object principal = getCurrentPrincipal();
    if (principal instanceof Jwt) {
      Jwt jwt = (Jwt) principal;
      Map<String, Object> claims = jwt.getClaims();
      JSONArray authorities = (JSONArray) claims.get("authorities");
      if (authorities == null) {
        return false;
      }
      return authorities.contains("ROLE_SECURITY_ADMIN");
    }
    return false;
  }

  public static boolean isAuditAdmin() {
    Object principal = getCurrentPrincipal();
    if (principal instanceof Jwt) {
      Jwt jwt = (Jwt) principal;
      Map<String, Object> claims = jwt.getClaims();
      JSONArray authorities = (JSONArray) claims.get("authorities");
      if (authorities == null) {
        return false;
      }
      return authorities.contains("ROLE_AUDIT_ADMIN");
    }
    return false;
  }

  /**
   * Check if a user is authenticated.
   *
   * @return true if the user is authenticated, false otherwise
   */
  public static boolean isAuthenticated() {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    return Optional.ofNullable(securityContext.getAuthentication())
        .map(
            authentication ->
                authentication.getAuthorities().stream()
                    .noneMatch(
                        grantedAuthority ->
                            grantedAuthority.getAuthority().equals(AuthoritiesConstants.ANONYMOUS)))
        .orElse(false);
  }

  /**
   * If the current user has a specific authority (security role).
   *
   * <p>The name of this method comes from the isUserInRole() method in the Servlet API
   *
   * @param authority the authority to check
   * @return true if the current user has the authority, false otherwise
   */
  public static boolean isCurrentUserInRole(String authority) {
    SecurityContext securityContext = SecurityContextHolder.getContext();
    return Optional.ofNullable(securityContext.getAuthentication())
        .map(
            authentication ->
                authentication.getAuthorities().stream()
                    .anyMatch(
                        grantedAuthority -> grantedAuthority.getAuthority().equals(authority)))
        .orElse(false);
  }
}
