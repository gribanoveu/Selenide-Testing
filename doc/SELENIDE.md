## Основные команды селенида

### Основные проверки:
    $(".error");  // Wrong: doesn't check anything
    $(".error").should(exist);  // проверка что элемент существует в DOM (может быть скрыт или видимый)
    $(".error").shouldBe(visible); // проверка что элемент есть в DOM и он видимый
    $(".error").shouldNot(exist);  // проверка что элемента нет в DOM
    $(".error").shouldNotBe(visible);  // проверка что элемент невидим (элемент может быть либо скрыт, либо отсутствовать)

### Прочие проверки:
    **Assert that element has a correct text**
    $("#customerContainer").shouldHave(text("Customer profile"));

    **Assert that element has a correct CSS class**
    $("#customerContainer").shouldHave(cssClass("errorField"));

    


### Поиск элемента:
    **Find element by id**
    WebElement customer = $("#customerContainer");
    WebElement customer = $(By.id("customerContainer"));

    **Find element by text**
    WebElement customer = $(byText("Customer profile"));

    **Select a radio button**
    selectRadio(By.name("sex"), "woman");

    **Assert that element text matches a regular expression**
    $("#customerContainer").should(matchText("profile"));

    **Assert that element does not exist**
    $("#customerContainer").shouldNot(exist);

    **Checks that element is moving**
    $("#loginLink").should(moveAround(300))

    **Check condition on child**
    $$("#multirowTable tr").filterBy(child("td:nth-child(2)", text("Norris")));

    **Check if element attribute contains given value. Case sensitive**
    $("#task").shouldHave(valueInAttribute("class", "done"));

    **Check input text lenght**
    $("#random-username").shouldHave(new TextOfLength(42));

    **Looking for element inside parent element**
    $("#customerContainer").find(".user_name");

    **Looking for Nth element**
    $("li", 5);

### Действия над элементами:

    **Click "Ok" in alert dialog**
    confirm("Are you sure to delete your profile?");
    dismiss("Are you sure to delete your profile?");

    **Debugging info for elements**
    System.out.println($("#customerContainer"));
    // output looks like this: "<option value=livemail.ru checked=true selected:true>@livemail.ru</option>"

    **Take a screenshot**
    takeScreenShot("my-test-case");

    For JUnit users it's even more simpler:
    `public class MyTest {
    @Rule // automatically takes screenshot of every failed test
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
    }`

    **Reload current page**
    refresh();

    **Get the current page URL, title or source**
    url();
    title();
    source();

### Импорты:
    import static com.codeborne.selenide.Selenide.*;
    import static com.codeborne.selenide.Selectors.*;
    import static com.codeborne.selenide.Condition.*;
    import static com.codeborne.selenide.CollectionCondition.*;
