package com.support.pivotal.model;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GitStatus {

    @XmlElement @Value("${git.branch}")
    private String branch;
    @XmlElement @Value("${git.commit.id.describe}")
    private String describe;
    @XmlElement @Value("${git.commit.id}")
    private String commitId;
    @XmlElement @Value("${git.commit.id.abbrev}")
    private String commitIdAbbrev;
    @XmlElement @Value("${git.build.user.name}")
    private String buildUserName;
    @XmlElement @Value("${git.build.user.email}")
    private String buildUserEmail;
    @XmlElement @Value("${git.build.time}")
    private String buildTime;
    @XmlElement @Value("${git.commit.user.name}")
    private String commitUserName;
    @XmlElement @Value("${git.commit.user.email}")
    private String commitUserEmail;
    @XmlElement @Value("${git.commit.message.full}")
    private String commitMessageFull;
    @XmlElement @Value("${git.commit.message.short}")
    private String commitMessageShort;
    @XmlElement @Value("${git.commit.time}")
    private String commitTime;
}