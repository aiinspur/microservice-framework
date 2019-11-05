package com.msf.msfmng.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
//import org.springframework.security.core.CredentialsContainer;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.SpringSecurityCoreVersion;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

/**
 * @author shihujiang
 * @date 2019-06-13
 */
@Data
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "idf_sys_user")
public class SysUser implements UserDetails, CredentialsContainer, Serializable {

    public SysUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SysUser(String username, String password,
                   Collection<? extends GrantedAuthority> authorities
    ) {
        this(username, password, true, true, true, true, authorities);

    }

    private SysUser(String username, String password, boolean enabled,
                    boolean accountNonExpired, boolean credentialsNonExpired,
                    boolean accountNonLocked,
                    Collection<? extends GrantedAuthority> authorities
    ) {


        if (checkConstructorParams(username, password)) {
            throw new IllegalArgumentException(
                    "Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    private String password;

    private String nickname;

    private String remarks;

    private String institutionId;

    private String email;

    private String phone;

    private String officePhone;

    private String employeeNumber;

    private String employeeName;

    private String job;

    private String englishName;

    @CreatedDate
    private Date gmtCreate;

    @LastModifiedDate
    private Date gmtModified;

    @Transient
    private List<SysRole> roles;

    @Transient
    private Set<GrantedAuthority> authorities;

    @Transient
    private boolean accountNonExpired;

    @Transient
    private boolean accountNonLocked;

    @Transient
    private boolean credentialsNonExpired;

    @Transient
    private boolean enabled;

    @Transient
    private Object menus;


    /**
     * check params.
     *
     * @param username username
     * @param password password.
     * @return return true if meet the conditions.
     */
    private boolean checkConstructorParams(String username, String password) {
        return (username == null || "".equals(username) || password == null);
    }


    @Override
    public void eraseCredentials() {
        password = null;
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(
            Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        // Ensure array iteration order is predictable (as per
        // UserDetails.getAuthorities() contract and SEC-717)
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(
                new SysUser.AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority,
                    "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>,
            Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        @Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to
            // the set.
            // If the authority is null, it is a custom authority and should precede
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
