package ru.yandex.courier;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class CourierGenerate {
    static Faker faker = new Faker();

    public static final String NEW_LOGIN_FAKED = faker.name().username();
    @Step("Создание нового курьера с рандомными данными")
    public CourierModel createNewRandomCourier() {
        return new CourierModel(
                faker.name().username(),
                faker.internet().password(),
                faker.name().firstName());
    }
}
