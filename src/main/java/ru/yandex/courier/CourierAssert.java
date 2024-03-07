package ru.yandex.courier;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class CourierAssert {
    @Step("Регистрация нового курьера с валидными данными")
    public void createCourierOk(ValidatableResponse response) {
        response.assertThat()
                .statusCode(201)
                .body("ok", is(true));
    }

    @Step("Проверка ответа сервера при неполных данных")
    public void createCourierError(ValidatableResponse response) {
        response.assertThat()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Step("Проверка ответа сервера при регистрации под зарегистрированным логином")
    public void createCourierSameLoginError(ValidatableResponse response) {
        response.assertThat()
                .statusCode(409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Step("Проверка получения ID при логине с валидными данными")
    public int loginCourierOk(ValidatableResponse response) {
        return response.assertThat()
                .statusCode(200)
                .body("id", greaterThan(0))
                .extract()
                .path("id");
    }

    @Step("Проверка ответа сервера при логине с неполными данными")
    public void loginCourierError(ValidatableResponse response) {
        response.assertThat()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Step("Проверка ответа сервера при логине с невалидными данными")
    public void loginCourierErrorAccountNotFound(ValidatableResponse response) {
        response.assertThat()
                .statusCode(404)
                .body("message", equalTo("Учетная запись не найдена"));
    }
}
