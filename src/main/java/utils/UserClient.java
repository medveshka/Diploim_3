package utils;

import io.qameta.allure.Step;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    @Step("Создание пользователя")
    public static Response createUser(User user){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(RoutesConstants.CREATE_USER_API);
    }

    @Step("Удаление пользователя")
    public static Response deleteUser(String accessToken) {
        return given()
                .header("authorization", "bearer "+ accessToken)
                .when()
                .delete(RoutesConstants.DELETE_USER_API);
    }

    @Step("Логин пользователя")
    public static Response logInUser(User user){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(RoutesConstants.LOGIN_USER_API);
    }

}
