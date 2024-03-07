package ru.yandex.constants;

public class ScooterEndpoints {
    public final static String BASE_URL = "http://qa-scooter.praktikum-services.ru/";
    public final static String COURIER_POST_LOGIN = "/api/v1/courier/login";
    public final static String COURIER_POST_CREATE = "/api/v1/courier";
    public final static String COURIER_DELETE = "/api/v1/courier/:id";
    public final static String ORDER_PUT_CANCEL = "/api/v1/orders/cancel";
    public final static String ORDER_GET_LIST = "/api/v1/orders";
    public final static String ORDER_POST_CREATE = "/api/v1/orders";
}
