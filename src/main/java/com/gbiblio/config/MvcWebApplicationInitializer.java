//package com.gbiblio.config;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	/* Le getRootConfigClasses()configurera le ContextLoaderListeneret est en fait facultatif 
//	   (vous pouvez retourner null ou un tableau vide). */
//   @Override
//   protected Class<?>[] getRootConfigClasses() {
//      return new Class<?>[] { CoreConfig.class };
////	      return null;
//   }
//
//   /* Le getServletConfigClasses()configurera le DispatcherServlet(et est obligatoire). */
//   @Override
//   protected Class<?>[] getServletConfigClasses() {
//      return new Class[] { MvcWebConfig.class };
//   }
//
//   @Override
//   protected String[] getServletMappings() {
//      return new String[] { "/" };
//   }
//
//}