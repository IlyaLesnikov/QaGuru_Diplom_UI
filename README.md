## Проект по автоматизации тестирования UI для сайта [АО «Тинькофф Банк»](https://www.tinkoff.ru/)

![logo](media/screen/logo.jpg "Главная страница")

## Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Список автоматизированных тестов](#tests-список-авто/ручных-тестов)
- [Список проверок](#arrow_forward-запуск-тестов-из-терминала)
- [Запуск тестов из консоли](#arrow_forward-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Уведомления в Telegram](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

  ## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.java.com/"><img src="/media/logo/java.svg" width="70" height="70"  alt="Java"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/IJ.svg" width="70" height="70"  alt="IDEA"/></a>
<a href="https://www.selenide.org/"><img src="media/logo/selenide.svg" width="70" height="70" alt="Selenide" title="Selenide"/></a> 
<a href="https://aerokube.com/selenoid/"><img src="media/logo/selenoid.svg" width="70" height="70"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework"><img src="media/logo/allure.svg" width="70" height="70"  alt="Allure"/></a>
<a href="https://gradle.org/"><img src="media/logo/gradle.svg" width="70" height="70"  alt="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/jUnit5.svg" width="70" height="70"  alt="JUnit 5"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/jenkins.svg" width="70" height="70"  alt="Jenkins"/></a>
<a href="https://www.atlassian.com/software/jira/"><img src="media/logo/Jira.svg" width="70" height="70" alt="Jira" title="Jira"/></a> 
<a href="https://github.com/"><img src="media/logo/gitHub.svg" width="70" height="70"  alt="GitHub"/></a>
<a href="https://web.telegram.org/"><img src="media/logo/telegram.svg" width="70" height="70"  alt="Telegram"/></a>
</p>

В проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/).
Cборка - <code>Gradle</code>.  
Использован <code>JUnit 5</code> в качестве фреймворка тестирования.
При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
Для удаленного запуска используется джоба в <code>Jenkins</code>. 
Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>.
  
Содержание Allure-отчета для каждого сценария:
Шаги теста, результат их выполнения
Скриншот страницы на последнем шаге
Page Source
Логи консоли браузера
Видео выполнения автотестов

  
## Список автоматизированных тестов
**Автотесты на основной странице**
- Авторизация с пустым полем в личном кабинете
- Авторизация с несуществующем номером телефона
- Закрытие веб-формы авторизации

**Автотесты на странице "Работа в ИТ"**
- Фильтрация вакансий по направлению
- Фильтрация вакансий по направлению и уровню
- Отображение кнопки "Откликнуться" в карточке вакансии"

**Автотесты на странице "Скачивание приложения"**
- Открытие веб-формы скачивания приложения

## Запуск автотестов

### Запуск тестов на удаленном браузере
Локальный запуск тестов
```
gradle clean WEB 
```
При необходимости также можно переопределить параметры запуска

```
gradle clean WEB 
main -browser=${BROWSER}
-DbrowserVersin=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DbaseURL="${BASE_URL}"
```

### Параметры сборки
В сборку были добавлены следующие параметры:
<code>TASKS</code> - тесты для запуска
<code>BROWSER</code> – браузер для выполнения тестов
<code>BROWSER_VERSION</code> – версия браузера
<code>BROWSER_SIZE</code> – расширения окна
<code>BASE_URL</code> – базовый URL

## <img src="media/logo/jenkins.svg" title="Jenkins" width="4%"/> Страница параметрезированной сборки в Jenkins
<p align="center">
<img title="allure-report" src="media/screen/JenkinsJoba.png">
</p>

## <img src="media/logo/allure.svg" title="Allure TestOps" width="4%"/> Пример [Allure-отчета](https://jenkins.autotests.cloud/job/023_diplom_lia_lesnikov_UI/15/allure/)
В отчете отображены автотесты с прогона и их статусы
<p align="center">
<img title="Allure Overview" src="media/screen/allure_report.png">
</p>

## Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4079/dashboards)

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screen/allureTestOps.png">
</p>

## <img src="media/logo/Jira.svg" title="Allure TestOps" width="4%"/> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1129)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>.

<p align="center">
<img title="Jira Task" src="media/screen/jiraTask.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/telegram.svg"> Уведомления в Telegram с использованием бота

После прогона автотестов Telegram bot отправляет уведомления в Telegram
<p align="center">
<img title="Telegram Notifications" src="media/screen/telegramBot.png"  width="400">
</p>

## Видео запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/gif/selenoid.gif">
</p>
