package com.gg.user.security;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

/**
 * 用户对象
 *
 * @author Li Feixiang
 */
public class AuthenticatedUser implements UserDetails, CredentialsContainer {
  private static final long serialVersionUID = 1L;

  /** ID */
  private final Long id;

  /** 租户ID */
  private final Long tenantId;

  /** 租户名称 */
  private final String tenantName;

  /** 用户名 */
  private final String username;

  /** 用户全名 */
  private final String fullName;

  private final Collection<? extends GrantedAuthority> authorities;

  private String password;

  private boolean accountNonExpired;

  private boolean accountNonLocked;

  private boolean enabled;

  private boolean credentialsNonExpired;

  public AuthenticatedUser(
      Long id,
      Long tenantId,
      String tenantName,
      String username,
      String password,
      String fullName,
      boolean enabled,
      boolean accountNonExpired,
      boolean credentialsNonExpired,
      boolean accountNonLocked,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.tenantId = tenantId;
    this.tenantName = tenantName;
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.enabled = enabled;
    this.accountNonExpired = accountNonExpired;
    this.accountNonLocked = accountNonLocked;
    this.credentialsNonExpired = credentialsNonExpired;
    this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public Long getTenantId() {
    return tenantId;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public String getFullName() {
    return fullName;
  }

  public String getTenantName() {
    return tenantName;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public void eraseCredentials() {
    /** 清除用户密码 */
    password = null;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  private static SortedSet<GrantedAuthority> sortAuthorities(
      Collection<? extends GrantedAuthority> authorities) {
    // Ensure array iteration order is predictable (as per
    // UserDetails.getAuthorities() contract and SEC-717)
    SortedSet<GrantedAuthority> sortedAuthorities =
        new TreeSet<GrantedAuthority>(new AuthorityComparator());

    for (GrantedAuthority grantedAuthority : authorities) {
      sortedAuthorities.add(grantedAuthority);
    }

    return sortedAuthorities;
  }

  private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    @Override
    public int compare(GrantedAuthority g1, GrantedAuthority g2) {
      // Neither should ever be null as each entry is checked before
      // adding it to
      // the set.
      // If the authority is null, it is a custom authority and should
      // precede
      // others.
      if (g2.getAuthority() == null) {
        return -1;
      }

      if (g1.getAuthority() == null) {
        return 1;
      }

      return g1.getAuthority().compareTo(g2.getAuthority());
    }
  }
}
