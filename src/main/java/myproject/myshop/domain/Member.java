package myproject.myshop.domain;


import lombok.Getter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Member {

    protected Member(){

    }

    public Member(String userId, String password, String username) {
        this.userId = userId;
        this.password = password;
        this.username = username;

    }

    public Member(String userId, String password, String username, String phone, Email email, myproject.myshop.domain.Address address) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.Address = address;
    }

    @Id
    private String userId;

    private String password;
    private String username;
    private String phone;

    @Embedded
    private Email email;
    @Embedded
    private Address Address;

}
