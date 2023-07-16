package com.mustafa.redistutorial.entity;

import com.mustafa.redistutorial.enm.EnmGender;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Student")
public class Student implements Serializable {

    private String id;
    private String name;
    private EnmGender gender;
    private Integer grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnmGender getGender() {
        return gender;
    }

    public void setGender(EnmGender gender) {
        this.gender = gender;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
