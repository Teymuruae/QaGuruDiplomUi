# Автотесты для сайта [Demoblaze](https://www.demoblaze.com)
## :pushpin: Содержание:
___
+ [Стек технологий](#briefcase-стек-технологий)
+ [Запуск автотестов](#bow_and_arrow-запуск-автотестов)
+ [Сборка в Jenkins](#-сборка-в-jenkins)

____
## :briefcase: Стек технологий

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="media/logo/Intelij_IDEA.svg"/></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/logo/Java.svg"/></a>
<a href="https://rest-assured.io/"><img width="6%" title="Rest Assured" src="media/logo/RestAssured.svg"/></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/logo/Selenide.svg"/></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="media/logo/Selenoid.svg"/></a>
<a href="https://github.com/allure-framework/allure2"><img width="6%" title="Allure Report" src="media/logo/Allure_Report.svg"/></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/logo/Gradle.svg"/></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="media/logo/JUnit5.svg"/></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/logo/GitHub.svg"/></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/logo/Jenkins.svg"/></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="media/logo/Telegram.svg"/></a>
</p>

___
+ IntelliJ IDEA - Интегрированная среда разработки программного обеспечения
+ Java - язык программирования, который был использован для написания автотестов
+ Selenide - фреймворк для написания автотестов
+ Selenoid - приложение, использованное для удаленного запуска браузеров
+ Allure Report - для формирования отчетов
+ Gradle - сборщик кода
+ JUnit - фреймворк для автоматического тестирования программ
+ GitHub - удаленный репозиторий для хранения кода
+ Jenkins - сервер для удаленного запуска тестов
+ Telegram - платформа для обмена сообщениями, куда будут приходить отчеты запуска тестов

___
**Содержание Allure-отчета:**
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

## :bow_and_arrow: Запуск автотестов
___
**Команда запуска тестов локально, из терминала**
```
gradle clean test -Dbrowser="Chrome100" -DbaseUrl="https://www.demoblaze.com"
```
---
**Для локального запуска необходимо**
+ Создать в папке <code>src/test/resources</code> auth.properties и remoteauth.properties
+ В auth.properties указать:
  + token=значение из cookie "tokenp_"
  + username=имя пользователя сайта
  + password=пароль от сайта
+ В remoteauth.properties указать:
  + remoteUser=логин от Selenoid
  + remotePass=пароль от Selenoid

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/Jenkins.svg"> [Сборка в Jenkins](https://jenkins.autotests.cloud/job/19-TimBart-DiplomUi/)
**Шаги для запуска тестов:**
1. Зайти в сборку
2. Перейти в раздел <code>Собрать с параметрами</code>
3. Выбрать необходимые параметры
4. Нажать кнопку <code>Собрать</code>

<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins.png">
</p>

___
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/Allure_Report.svg"> [Пример Allure-отчета](https://jenkins.autotests.cloud/job/19-TimBart-DiplomUi/14/allure/)


<p align="center">
<img title="Allure Overview" src="media/screens/allure.png">
</p>

___

### <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки специальный бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с отчетом о прогоне тестов.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/Bot.png">
</p>

### <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплен не только скриншот, но и видео прохождения теста
<p align="center">
  <img title="Selenoid Video" src="media/screens/Video.gif">
</p>