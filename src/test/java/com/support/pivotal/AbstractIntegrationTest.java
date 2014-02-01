package com.support.pivotal;

import com.support.pivotal.model.JaxbContextResolver;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.ws.rs.core.MediaType;

public abstract class AbstractIntegrationTest extends AbstractJUnit4SpringContextTests
{
  private Client client;
  
  private static final Logger LOGGER = LoggerFactory.getLogger(AbstractIntegrationTest.class);
  private final String serviceUrl = "http://" + HOST + (PORT != null ? ":" + PORT : "");
  
  protected static final String HOST = System.getProperty("integration.test.host", "localhost");
  protected static final String PORT = System.getProperty("integration.test.port", "8082");
  
  
  public AbstractIntegrationTest()
  { 
    ClientConfig config = new DefaultClientConfig();
    config.getClasses().add(JaxbContextResolver.class);
    client = Client.create(config);
  }
  
  public WebResource.Builder getJsonWebResource(String resourceName)
  {
    return getWebResource(resourceName)
            .accept(MediaType.APPLICATION_JSON)
            .type(MediaType.APPLICATION_JSON);
  }
  
  public WebResource getWebResource(final String resourceName)
  {
    return client.resource(serviceUrl + "/" + resourceName);
  }
  
  public WebResource.Builder getJsonWebResourceFullPath(String fullPath)
  {
    return getWebResourceFullPath(fullPath)
            .accept(MediaType.APPLICATION_JSON)
            .type(MediaType.APPLICATION_JSON);
  }

  public WebResource getWebResourceFullPath(String fullPath)
  {
    return client.resource(fullPath);
  }
}
