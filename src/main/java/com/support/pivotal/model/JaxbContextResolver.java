package com.support.pivotal.model;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

@Provider
public class JaxbContextResolver implements ContextResolver<JAXBContext>
{
  private JAXBContext context;

  private Class<?>[] types =
  { Status.class };

  public JaxbContextResolver() throws Exception
  {
    this.context =
        new JSONJAXBContext(JSONConfiguration.natural().humanReadableFormatting(true)
            .rootUnwrapping(false).build(), types);
  }

  public JAXBContext getContext(Class<?> objectType)
  {
    for (Class<?> type : types)
    {
      if (type == objectType)
      {
        return context;
      }
    }
    return null;
  }
}
