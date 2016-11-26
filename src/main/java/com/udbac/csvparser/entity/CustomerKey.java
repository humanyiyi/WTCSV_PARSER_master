package com.udbac.csvparser.entity;


/**
 * Created by root on 2016/11/25.
 */

public class CustomerKey {
    private String mic;
    private String url;
    private String urll;
    private String classfy;


    public CustomerKey(String mic, String url, String urll, String classfy) {
        this.mic = mic;
        this.url = url;
        this.urll = urll;
        this.classfy = classfy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerKey that = (CustomerKey) o;

        if (mic != null ? !mic.equals(that.mic) : that.mic != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (urll != null ? !urll.equals(that.urll) : that.urll != null) return false;
        return classfy != null ? classfy.equals(that.classfy) : that.classfy == null;

    }

    @Override
    public int hashCode() {
        int result = mic != null ? mic.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (urll != null ? urll.hashCode() : 0);
        result = 31 * result + (classfy != null ? classfy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerKey{" +
                "mic='" + mic + '\'' +
                ", url='" + url + '\'' +
                ", urll='" + urll + '\'' +
                ", classfy='" + classfy + '\'' +
                '}';
    }

}