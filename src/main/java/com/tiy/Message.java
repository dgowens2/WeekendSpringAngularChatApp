package com.tiy;

import javax.persistence.*;

/**
 * Created by DTG2 on 09/24/16.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    @ManyToOne
    User user;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
