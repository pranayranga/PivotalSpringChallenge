package com.support.pivotal.smoketest;

import com.support.pivotal.AbstractIntegrationTest;
import com.support.pivotal.model.Status;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@ContextConfiguration(locations =
{ "classpath:applicationContextTest.xml" })
public class StatusTest extends AbstractIntegrationTest
{
  private Status status;

  @Test
  public void checkStatus()
  {
    whenStatusRequestIsPosted();
    thenExpectedStatusResponseReceived();
  }

  private void thenExpectedStatusResponseReceived()
  {
    assertThat(status, is(notNullValue()));
    assertThat(status.getGitStatus(), is(notNullValue()));
  }

  private void whenStatusRequestIsPosted()
  {
    status = getJsonWebResource("status").header("Cache-Control", "max-age=0").get(Status.class);
  }
}