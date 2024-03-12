package ru.yandex.courier;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static ru.yandex.constants.ScooterEndpoints.*;

public class CourierSteps {
    public static RequestSpecification requestSpec() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }

    @Step("Регистрация нового курьера")
    public ValidatableResponse createCourier(CourierModel courierModel) {
        return requestSpec()
                .body(courierModel)
                .when()
                .post(COURIER_POST_CREATE)
                .then();
    }

    @Step("Авторизация курьера")
    public ValidatableResponse loginCourier(CourierCreds courierCreds) {
        return requestSpec()
                .body(courierCreds)
                .when()
                .post(COURIER_POST_LOGIN)
                .then();
    }

    @Step("Удаление курьера")
    public ValidatableResponse deleteCourier(int courierId) {
        return requestSpec()
                .when()
                .delete(COURIER_DELETE + courierId)
                .then();
    }
}
