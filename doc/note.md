Selenide assertions

$(".error");  // Wrong: doesn't check anything
$(".error").should(exist);  // checks that element exists in DOM (but may be hidden or visible)
$(".error").shouldBe(visible); // checks that element exists in DOM and is visible
$(".error").shouldNot(exist);  // checks that element is not found in DOM
$(".error").shouldNotBe(visible);  // checks that element is not visible (the element may be either hidden or absent)


Find element by id
WebElement customer = $("#customerContainer");
WebElement customer = $(By.id("customerContainer"));

Assert that element has a correct text
$("#customerContainer").shouldHave(text("Customer profile"));

Assert that element has a correct CSS class
$("#customerContainer").shouldHave(cssClass("errorField"));

Find element by text
WebElement customer = $(byText("Customer profile")); 

Assert that element text matches a regular expression
$("#customerContainer").should(matchText("profile"));

Assert that element does not exist
$("#customerContainer").shouldNot(exist);

Checks that element is moving
$("#loginLink").should(moveAround(300))

Check condition on child
$$("#multirowTable tr").filterBy(child("td:nth-child(2)", text("Norris")));

Check if element attribute contains given value. Case sensitive
$("#task").shouldHave(valueInAttribute("class", "done"));

Check input text lenght
$("#random-username").shouldHave(new TextOfLength(42));


Looking for element inside parent element
$("#customerContainer").find(".user_name");

Looking for Nth element
$("li", 5);

Click "Ok" in alert dialog
confirm("Are you sure to delete your profile?");
dismiss("Are you sure to delete your profile?");

Debugging info for elements
System.out.println($("#customerContainer"));
// output looks like this: "<option value=livemail.ru checked=true selected:true>@livemail.ru</option>"

Take a screenshot
takeScreenShot("my-test-case");
For JUnit users it's even more simpler:
public class MyTest {
@Rule // automatically takes screenshot of every failed test
public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
}

Select a radio button
selectRadio(By.name("sex"), "woman");

Reload current page
refresh();

Get the current page URL, title or source
url();
title();
source();

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
