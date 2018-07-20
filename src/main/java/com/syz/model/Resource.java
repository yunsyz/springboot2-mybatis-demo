package com.syz.model;

public class Resource {
    private Integer resourceId;

    private String resourceName;

    private Integer resourceCrud;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public Integer getResourceCrud() {
        return resourceCrud;
    }

    public void setResourceCrud(Integer resourceCrud) {
        this.resourceCrud = resourceCrud;
    }
}