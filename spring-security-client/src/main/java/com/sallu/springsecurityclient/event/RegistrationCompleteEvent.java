package com.sallu.springsecurityclient.event;

import com.sallu.springsecurityclient.entity.User;
import org.springframework.context.ApplicationEvent;

public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String url;
    public RegistrationCompleteEvent(User user, String url) {
        super(user);
        this.user = user;
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
