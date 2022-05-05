package com.game;

public class Square {
    private String content;

    /****GETTERS****/
    public String getContent() {
        return this.content;
    }


    /****SETTERS****/

    public void setContent(String content) {
        this.content = content;
    }


    /****TO STRING****/

    public String toString() {
        return getContent();
    }
}
