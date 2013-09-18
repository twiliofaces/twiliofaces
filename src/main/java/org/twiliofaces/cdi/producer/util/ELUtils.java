package org.twiliofaces.cdi.producer.util;

import java.util.logging.Logger;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public class ELUtils
{
   static Logger logger = Logger.getLogger(ELUtils.class.getName());

   public static boolean isElExpression(String elExpression)
   {
      if (elExpression != null && elExpression.trim().startsWith("#{") && elExpression.trim().endsWith("}"))
         return true;
      return false;
   }

   public static String resolveElExpression(String elExpression, FacesContext facesContext)
   {
      Application app = facesContext.getApplication();
      ELContext elContext = facesContext.getELContext();
      logger.info("BEFORE: " + elExpression);
      ExpressionFactory exprFactory = app.getExpressionFactory();
      ValueExpression valExpr = exprFactory.createValueExpression(
               elContext, elExpression, Object.class);
      String resolved = (String) valExpr.getValue(elContext);
      logger.info("AFTER: " + resolved);
      return resolved;
   }
}
