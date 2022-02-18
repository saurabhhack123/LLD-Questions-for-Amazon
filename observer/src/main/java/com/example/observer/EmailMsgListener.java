package com.example.observer;

import java.util.Objects;

public final class EmailMsgListener implements Listener {
    private final String email;

    EmailMsgListener(String email) {
        this.email = email;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        EmailMsgListener that = (EmailMsgListener) obj;
        return Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "EmailMsgListener[" +
                "email=" + email + ']';
    }

    @Override
    public void update(Event eventType) {
        // Actually send the mail
        System.out.println("Sending mail to " + email + " concerning " + eventType);
    }

}

