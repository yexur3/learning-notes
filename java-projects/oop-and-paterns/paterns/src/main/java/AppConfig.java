public class AppConfig {
    private static AppConfig instance;
    private String appName;

    private AppConfig(String appName){
        this.appName = appName;
    }

    public static AppConfig getInstance(String appName){
        if(instance == null){
            instance = new AppConfig(appName);
        }
        return instance;
    }
}
