package myproject.myshop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Email {

    public Email(){

    }

    public Email(String email_id, String site) {
        this.email_id = email_id;
        this.site = site;
    }
    private String email_id;
    private String site;
}
