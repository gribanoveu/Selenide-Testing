Selenide + TestNG + Allure + Logback + Selenoid support

### Структура проекта:
    logs/DD.MM.YY
    src/
        | - main/resources/logback.xml - конфигурация логгера
        | - test/
                | java/
                    | - common/ - вспомогательные файлы проекта
                    | - pages/ - обьекты страницы с шагами тестового сценария
                    | - driver/ - настройка selenide
                    | - tests/
                        | - cases/ - тестовые сценарии
                        | - data/ - поставщик данных для тестовых сценариев
                | resources/
                        | - configs/ - конфигурация проекта
                        | - suites/ - наботы тестов testNG
                        
### Логи:
    *При каждом запуске тестов логи сохранятся в папку в корне проекта logs/ далее следует 
    дата запуска тестов в формате ДД.ММ.ГГ каждый запуск сохраняется в новый файл

    !!! При запуске maven clean предыдущие результаты тестов очищаются !!!

    При запуске тестов через maven test/clean test:
    * Allure сохраняет результаты тестов в папку target/allure-results
    * По завершению каждого теста сохраняется снимок экрана в папку target/selenide-screenshots/tests/cases
    Отключение находится в файле src/test/resources/configs/DriverConfig.properties -> captureSuccessfulTests

    Открытие дашбоарда allure происходит командой mvn allure:serve

### Запуск тестов:
    При запуске mvn clean test происходит запуск набора тестов TestNG указанный в pom.xml,
    по умолчанию это тесты указанные в файле src/test/resources/suites/ChromeTestSuite.xml
    
    Все тесты запускаются через maven для корректной работы

    Для запуска своего набора тестов нужно указать mvn clean test -DsuiteXml=НазваниеНабораТестов
    Указывать расширение .xml не нужно

### Конфигурация драйвера:
    Указание браузера для тестов происходит в тестовом наборе testNG, параметр name="browserName"
    поддерживается запуск тестов в браузерах Chrome, Firefox, MS Edge
    Если браузер не указан тесты запускаются в Chrome

    DriverConfig.properties
    В данном файле указывается:
    * размер окна при запуске тестов
    * режим headless
    * запуск selenoid (см. doc/SELENOID)

     