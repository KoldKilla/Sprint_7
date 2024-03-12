package ru.yandex.courierTest;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.courier.*;

public class LoginCourierTest {
    private final CourierGenerate courierRandomizer = new CourierGenerate();
    private CourierAssert courierAssert;
    private int courierID;
    private CourierCreds courierCreds;
    private CourierSteps courierSteps;
    private CourierModel courierModel;

    @Before
    @Step("Создание тестовых данных для логина курьера")
    public void setUp() {
        courierSteps = new CourierSteps();
        courierModel = courierRandomizer.createNewRandomCourier();
        courierSteps.createCourier(courierModel);
        courierCreds = CourierCreds.from(courierModel);
        courierAssert = new CourierAssert();
    }

    @Test
    @DisplayName("Логин курьера успешен")
    @Description("Проверяем, что курьер может войти в систему с валидными данными")
    public void courierLoginOkValidData() {
        ValidatableResponse responseLoginCourier = courierSteps.loginCourier(courierCreds);
        courierAssert.loginCourierOk(responseLoginCourier);
        courierID = responseLoginCourier.extract().path("id");
    }

    @Test
    @DisplayName("Логин курьера с пустым полем логина")
    @Description("Проверяем, что курьер не может войти в систему с пустым полем логина")
    public void courierLoginErrorEmptyLogin() {
        CourierCreds courierCredsWithoutLogin = new CourierCreds("", courierModel.getPassword()); // c null тесты виснут
        ValidatableResponse responseLoginErrorMessage = courierSteps.loginCourier(courierCredsWithoutLogin);
        courierAssert.loginCourierError(responseLoginErrorMessage);

    }

    @Test
    @DisplayName("Логин курьера с пустым полем пароля")
    @Description("Проверяем, что курьер не может войти в систему с пустым полем пароля")
    public void courierLoginErrorEmptyPassword() {
        CourierCreds courierCredsWithoutPass = new CourierCreds(courierModel.getLogin(), "");
        ValidatableResponse responseLoginErrorMessage = courierSteps.loginCourier(courierCredsWithoutPass);
        courierAssert.loginCourierError(responseLoginErrorMessage);
    }

    @Test
    @DisplayName("Логин курьера с пустым полями логина и пароля")
    @Description("Проверяем, что курьер не может войти в систему с пустыми полями логина и пароля")
    public void courierLoginErrorEmptyLoginAndPassword() {
        CourierCreds courierCredsWithoutLoginAndPassword = new CourierCreds("", "");
        ValidatableResponse responseLoginErrorMessage = courierSteps.loginCourier(courierCredsWithoutLoginAndPassword);
        courierAssert.loginCourierError(responseLoginErrorMessage);
    }

    @Test
    @DisplayName("Логин курьера c невалидным логином")
    @Description("Проверяем, что курьер не может войти в систему с ранее не зарегистрированным логином")
    public void courierLoginErrorAccountNotFound() {
        CourierCreds courierCredsErrorAccountNotFound = new CourierCreds(CourierGenerate.NEW_LOGIN_FAKED, courierModel.getPassword());
        ValidatableResponse responseLoginErrorMessage = courierSteps.loginCourier(courierCredsErrorAccountNotFound);
        courierAssert.loginCourierErrorAccountNotFound(responseLoginErrorMessage);
    }

    @After
    @Step("Удаление курьера")
    public void deleteCourier() {
        if (courierID != 0) {
            courierSteps.deleteCourier(courierID);
        }
    }
}
