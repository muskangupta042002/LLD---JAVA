package org.muskan.accounts;

import lombok.Data;
import org.muskan.common.AccountStatus;

@Data
public class Account {
    private String username;
    private String password;
    private AccountStatus status;
    public Account(String username, String password, AccountStatus status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }


}
