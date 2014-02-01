package com.support.pivotal.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by pranayranga on 2/1/14.
 */
@XmlRootElement
public class Status
{
    private com.support.pivotal.model.GitStatus gitStatus;

    @XmlElement
    public com.support.pivotal.model.GitStatus getGitStatus()
    {
        return gitStatus;
    }

    public void setGitStatus(com.support.pivotal.model.GitStatus gitStatus)
    {
        this.gitStatus = gitStatus;
    }


}