package com.quocnguyen.giohang.service.impl;

import com.quocnguyen.giohang.model.Card;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CardManager {
    //tao 1 key
    private static final String SESSION_KEY_GIO_HANG = "gioHang";

    public Card getCard(HttpSession session) {
        Card card = (Card) session.getAttribute(SESSION_KEY_GIO_HANG);
        if (card == null) {
            card = new Card();
            setCard(session, card);
        }
        return card;
    }

    public void setCard(HttpSession session, Card card) {
        session.setAttribute(SESSION_KEY_GIO_HANG, card);
    }
    public void removeCard(HttpSession session){
        session.removeAttribute(SESSION_KEY_GIO_HANG);
    }
}


