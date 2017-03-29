package org.woehlke.batch.conf;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tw on 29.03.17.
 */
@Component
@Validated
@ConfigurationProperties(prefix="foo")
public class Config {

    @NotNull
    private String remoteAddress;

    @NotNull
    private String thomas;

    @Valid
    @NotEmpty
    private List<String> willy = new ArrayList<>();

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getThomas() {
        return thomas;
    }

    public void setThomas(String thomas) {
        this.thomas = thomas;
    }

    public List<String> getWilly() {
        return willy;
    }

    public void setWilly(List<String> willy) {
        this.willy = willy;
    }

    @Valid
    private final Security security = new Security();

    public Security getSecurity() {
        return security;
    }

    public static class Security {

        @NotNull
        private String username;

        @Valid
        @NotEmpty
        private List<String> roles = new ArrayList<>();

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }

}
