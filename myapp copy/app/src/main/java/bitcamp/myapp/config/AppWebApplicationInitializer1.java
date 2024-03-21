package bitcamp.myapp.config;



public class AppWebApplicationInitializer1 extends AbstractContextLoaderInitializer {


    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        rootContext.setServletContext(servletContext);


        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setParent(rootContext);
        appContext.refresh();

        ServletRegistration.Dynamic registration = servletContext.addServlet("app", new DispatcherServlet(appContext));
        registration.addMapping("/app/*");
        registration.setLoadOnStartup(1);
        registration.setMultipartConfig(new MultipartConfigElement(
                new File("./temp").getAbsolutePath(),
//                        new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
                1024 * 1024 * 10,
                1024 * 1024 * 100,
                1024 * 1024 * 1));


        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForServletNames(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),
                false,
                new String[]{"app"}
        );
    }
}


 