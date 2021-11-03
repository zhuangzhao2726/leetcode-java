package com.zhuangzhao.leetcode.lixi.demo03;

import java.util.Objects;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-05-02 11:18
 */
public class Product {

    private String id;

    private String version;


    private String vialisName;

    public Product(String id, String version) {
        this.id = id;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getVersion(), product.getVersion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion());
    }
}
