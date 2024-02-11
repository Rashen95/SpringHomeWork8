/*
Вам необходимо разработать механизм регистрации действий пользователя в вашем Spring Boot приложении.
Используйте Spring AOP для создания журнала действий, в котором будет сохраняться информация о том,
какие методы сервиса вызывались, кем и с какими параметрами.

Создайте аннотацию
@TrackUserAction
.
Реализуйте aspect, который будет регистрировать действия пользователя, когда вызывается метод, отмеченный этой аннотацией.
Примените аннотацию
@TrackUserAction
к нескольким методам в слое сервиса.
Результаты регистрации сохраните в лог-файл.
Не обязательно использовать именно такие аннотации, Это просто пример.
 */

package ru.geekbrains.SpringHomeWork8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringHomeWork8Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringHomeWork8Application.class, args);
    }
}