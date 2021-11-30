## Настройка конфигурации

### MainConfig.class:
    common/MainConfig

    Параметры конфигурации устанавливаются в классах данной дирректории src/test/java/common/
    В данных классах хранятся названия параметров


### MainConfig.properties:
    src/test/resources/MainConfig.properties

    Цель: 
    - хранение значений, независящих от среды выполнения

    Использование: 
    - в файле MainConfig.properties добавить имя и значение параметра с таким же именем как в классе MainConfig.class
    (ex. _allure_screenshots_folder_=build/reports/allure-screenshots)

    - Обьявить в классе, где необходимо использование параметра

    protected static MainConfig config = ConfigFactory.create(MainConfig.class);
    String **screenshotsFolder** = config._allure_screenshots_folder_();
    
    или добавить в класс

    private static DriverConfig getDriverConfig() {
        return ConfigFactory.newInstance().create(DriverConfig.class, System.getProperties());
    }

    - Подставить параметр
    Configuration.reportsFolder = **screenshotsFolder**;

    
    
    
    