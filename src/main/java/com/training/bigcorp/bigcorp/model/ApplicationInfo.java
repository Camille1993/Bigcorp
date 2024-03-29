package com.training.bigcorp.bigcorp.model;

import java.util.Set;

public class ApplicationInfo {

    private String name;

    private Integer version;

    private Set<String> emails;

    private String webSiteUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVersion() {
        return version;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getWebSiteUrl() {
        return webSiteUrl;
    }

    public void setWebSiteUrl(String webSiteUrl) {
        this.webSiteUrl = webSiteUrl;
    }

    public ApplicationInfo(String name, Integer version, Set<String> emails, String webSiteUrl){
        this.name =name;
        this.version =version;
        this.emails =emails;
        this.webSiteUrl = webSiteUrl;



    }
}
