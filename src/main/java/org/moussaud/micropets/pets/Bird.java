package org.moussaud.micropets.pets;

import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bird {
    @Id
    @JsonProperty(value = "Index")
    Integer index;

    @JsonProperty(value = "Name")
    String name;

    @JsonProperty(value = "Kind")
    String type;

    @JsonProperty(value = "Age")
    Integer age;

    @JsonProperty(value = "URL")
    String url;

    @JsonProperty(value = "Hostname")
    String hostname;

    @JsonProperty(value = "URI")
    String uri;

    @JsonProperty(value = "From")
    String source;

    public Bird() {

    }

    public Bird(String name, String type, Integer age, String url, String source) {

        this.name = name;
        this.age = age;
        this.url = url;
        this.type = type;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Bird [age=" + age + ", hostname=" + hostname + ", index=" + index + ", name=" + name + ", type=" + type
                + ", uri=" + uri + ", url=" + url + "]";
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
