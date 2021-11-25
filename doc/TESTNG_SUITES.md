## Тестовый набор 

### Тестовые наборы для запуска через mvn clean test указываюся в pom.xml
    все прописанные наборы запускаются вы вызове команды mvn test
    для запуска конкретного набора тестов используется команда mvn clean test -DsuiteXmlFile=НазваниеНабораТестов.xml
    наборы тестов располагаются в дирректории src/test/resources/testSuites

### Набор тестов выглядит следующим образом:

    !!! Параметр browser используется для указания запуска конкретного браузера
    данный параметр используется в BaseTest
    по умолчанию тесты запускаются в chrome (параметр @Optional в BaseTest)

    testng.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
    <suite name="Pool" parallel="tests">
        <test name="1" thread-count="3" parallel="methods">
            <parameter name="browser" value="edge"/> 
            <classes>
                <class name="tests.cases.FirstTest"/>
            </classes>
        </test>
    </suite>

### Атрибуты:
    @attr name              Название этого теста (как оно будет отображаться в отчетах)

    @attr junit             Запускать ли тест в режиме JUnit.

    @attr verbose           Насколько подробным будет вывод на консоль.
                            Эта настройка не влияет на HTML-отчеты.
                            Значение по умолчанию: verbose уровня набора.

    @attr parallel          Должен ли TestNG использовать разные потоки
                            для выполнения ваших тестов (это может ускорить процесс).
                            Не используйте значения "true" и "false", они устарели.

    @attr thread-count      Целое число, задающее размер пула потоков, который будет использоваться, если
                            используется параллельный режим. Переопределяет значение уровня набора.

    @attr annotations       Если "javadoc", TestNG будет искать
                            аннотации JavaDoc в ваших исходных текстах, в противном случае он будет
                            использовать аннотации JDK5.

    @attr time-out          время ожидания в миллисекундах перед прерыванием выполнения метода (если parallel="methods").
                            метода (если parallel="methods") или теста (если parallel="tests").

    @attr enabled           флаг для включения/выключения текущего теста. Значение по умолчанию: true

    @attr skipfailedinvocationcounts Нужно ли пропускать неудачные вызовы.

    @attr preserve-order    Если true, то классы в этом теге будут запускаться в том же порядке, в котором они расположены в XML-файле.
                            в XML-файле.

    @attr allow-return-values Если true, тесты, возвращающие значение, также будут выполняться.


### Включение и исключение тестов:
    Вы также можете указать группы и методы для включения и исключения
    <test name="Regression1">
    <groups>
        <run>
        <exclude name="brokenTests"  /> // выключены
        <include name="checkinTests"  /> // включены
        </run>
    </groups>

    <classes>
        <class name="test.IndividualMethodsTest">
        <methods>
            <include name="testMethod" />
        </methods>
        </class>
    </classes>
    </test>