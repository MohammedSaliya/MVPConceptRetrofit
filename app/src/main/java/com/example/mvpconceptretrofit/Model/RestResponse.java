package com.example.mvpconceptretrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestResponse {
    @SerializedName("messages")
    @Expose
    private List<String> messages = null;
    @SerializedName("result")
    @Expose
    private List<Country> result = null;

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public List<Country> getResult() {
        return result;
    }

    public void setResult(List<Country> result) {
        this.result = result;
    }
}
