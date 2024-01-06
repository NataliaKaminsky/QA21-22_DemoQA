package manager;

import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface HelperStudent extends HelperBase {
    By buttonElements = By.xpath("//div[@class='card mt-4 top-card']");
    By buttonForms = By.xpath("//div[@class='category-cards']/div[2]");
    By buttonPracticeForm = By.xpath("//span[text()='Practice Form']");

    By fieldFirstName = By.id("firstName");
    By fieldLastName = By.id("lastName");
    By fieldEmail = By.id("userEmail");

    By fieldMobile = By.id("userNumber");

    By fieldBday = By.id("dateOfBirthInput");

    By fieldSubjects = By.id("subjectsInput");
    By checkBoxSports = By.xpath("//label[@for='hobbies-checkbox-1']");
    By checkBoxReading = By.xpath("//label[@for='hobbies-checkbox-2']");
    By checkBoxMusic = By.xpath("//label[@for='hobbies-checkbox-3']");

    By currentAddress = By.id("currentAddress");
    By buttonSelectState = By.id("react-select-3-input");
    By buttonSelectCity = By.id("react-select-4-input");
    By text_thanks_for = By.id("example-modal-sizes-title-lg");
By buttonSubmit=By.id("submit");
    By buttonCloseModal=By.id("closeLargeModal");


    default void selectPracticeForm() {
//        clickBase(buttonElements);
//        pause(5);
        hideFooter();
        clickBase(buttonForms);
        hideFooter();
        pause(2);
        clickBase(buttonPracticeForm);
    }

    default void fillStudentForm(StudentDTO student) {
        typeBase(fieldFirstName, student.getFirstName());
        typeBase(fieldLastName, student.getLastName());
        typeBase(fieldEmail, student.getEmail());
        selectGender(student.getGender());
        typeBase(fieldMobile, student.getMobile());
        //typeBase(fieldBday,student.getDateOfBirth());
        typeBdayByKeys(fieldBday, student.getDateOfBirth());
        addSubjects(fieldSubjects, student.getSubjects());
        selectHobby(student.getHobbies());

        typeBase(currentAddress, student.getAddress());
        typeState(buttonSelectState,student.getState());
        typeCity(buttonSelectCity,student.getCity());

    }

   default void typeCity(By buttonSelectCity, String city){
       driver.findElement(buttonSelectCity).sendKeys(city);
      // driver.findElement(buttonSelectCity).sendKeys(Keys.ENTER);

   };

    default void typeState(By buttonSelectState, String state){
        //clickBase(buttonSelectState);
        driver.findElement(buttonSelectState).sendKeys(state);
       driver.findElement(buttonSelectState).sendKeys(Keys.ENTER);
    };

    default void selectHobby(String hobbies) {
        switch (hobbies) {
            case "Sports":
                clickBase(checkBoxSports);
                break;
            case "Reading":
                clickBase(checkBoxReading);
                break;
            case "Music":
                clickBase(checkBoxMusic);
                break;

        }
    }

    default void addSubjects(By fieldSubjects, String subjects) {
        String[] splitArray = subjects.split(",");
        clickBase(fieldSubjects);
        for (String subject : splitArray) {
            driver.findElement(fieldSubjects).sendKeys(subject);
            driver.findElement(fieldSubjects).sendKeys(Keys.ENTER);

        }
    }

    default void typeBdayByKeys(By fieldBday, String dateOfBirth) {
        WebElement element = driver.findElement(fieldBday);
        element.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println("OS--->" + operationSystem);
        if (operationSystem.startsWith("Win")) {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        } else {
            element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }
        element.sendKeys(dateOfBirth);
        element.sendKeys(Keys.ENTER);

    }

    default void selectGender(String gender) {
        if (gender.equals("Male")) {
            clickBase(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            clickBase(By.xpath("//label[@for='gender-radio-2']"));
        } else {
            clickBase(By.xpath("//label[@for='gender-radio-3']"));
        }

    }

default void clickButtonSubmit(){
        clickBase(buttonSubmit);
}
    default boolean isElementPresent_thanks_for(){
        return isElementPresent(text_thanks_for);
    }

    default void clickButtonCloseModal(){
        clickBase(buttonCloseModal);
        }
}
