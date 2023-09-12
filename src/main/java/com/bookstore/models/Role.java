package com.bookstore.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    ADMIN (
            Set.of(
                    Permission.ADMIN_CREATE,
                    Permission.ADMIN_DELETE,
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE
            )
    ),
    USER(
            Set.of(
                    Permission.USER_DELETE,
                    Permission.USER_CREATE,
                    Permission.USER_UPDATE,
                    Permission.USER_READ
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public List< SimpleGrantedAuthority > getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
