### Automated framework for testing web applications [**bookcart.azurewebsites**](https://bookcart.azurewebsites.net/)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)
# How to run tests:
## Preconditions
- The test repository uses webdriver for MacOS
- Java version 17 installed
- Installed maven
## Clone repository
Save the project from GitHub or use the command:

```$ git clone https://github.com/Belyanova/BookCartAutomationTests.git```
## Run all tests
```
$ mvn clean test
```
# What did you decide to test and why?
## UI tests
### Registration page
- Positive tests
   - Registration of a user with data that does not exist in the system
- Negative tests
   - User registration with data existing in the system
### Login page
- Positive tests
     - User login with data existing in the system
     - User login with data existing in the system, but the password was entered incorrectly
- Negative tests
     - User login with data that does not exist in the system
### Search by book title or author
- Positive tests
     - Search for a book by title
     - Search for a book by author
### Adding a book to cart
- Positive tests
     - Adding one book to the cart without user authorization
     - Adding two and removing one book from the cart without user authorization
     - Adding two and changing the number of books in the cart without user authorization
## API tests
### GET
### Checking the contents of books
- Positive tests
     - We check that the name of the picture contains the name of the book, and also that the picture is in the correct .jpg format
### POST
### Login
- Positive tests
     - User login with data existing in the system
- Negative tests
     - User login with data that does not exist in the system
##Allure
- Created reports based on test results
   - for UI tests, the execution steps are described, as well as the creation of screenshots in case of unsuccessful completion
   - for API tests request and response are displayed
# How is the automated framework designed and why?
- The test framework uses the following design patterns:
   - **"Page Object"**: The code is divided into ```Page``` objects, each representing a separate web page. ```BaseTests``` contains basic methods for working with the web driver. Each ```Page Class``` includes methods for interacting with elements of its web page and inherits ```BasePage```.
   - **"Data Provider"**: allows you to run the same tests with different sets of data from an xml file, expanding coverage without additional code.
   - **"Steps"**: creating tests in the form of a sequence of steps.
- The ```utils``` directory contains classes for running tests in different browsers (in this case, chrome and firefox). The ```PropertyReader``` class implements settings for launching from the ```resources/framework.properties``` file. The ```resources``` directory contains drivers for MacOS.
- Used by Allure to visualize test results.
# What else is planned to be done?
- Add more tests covering the main functions of this application
- Deploy local Jenkins and create a job that will run these tests in a docker container, having previously downloaded them from github.

### Автоматизированный фреймворк для тестирования веб-приложения [**bookcart.azurewebsites**](https://bookcart.azurewebsites.net/)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Selenium](https://img.shields.io/badge/-selenium-%43B02A?style=for-the-badge&logo=selenium&logoColor=white)
# Как запустить тесты:
## Предусловия
- В тестовом репозитории используются webdriver для MacOS 
- Установлена java версии 17
- Установлен maven
## Склонировать репозиторий
Сохранить проект с GitHub или использовать команду:

```$ git clone https://github.com/Belyanova/BookCartAutomationTests.git```
## Запуск всех тестов 
```
$ mvn clean test
```
# Что было решено протестировать и почему?
## UI тесты
### Страница регистрации
- Позитивные тесты 
  - Регистрация пользователя с несуществующими в системе данными
- Негативные тесты
  - Регистрация пользователя с существующими в системе данными
### Страница входа в систему
- Позитивные тесты
    - Логин пользователя с существующими в системе данными
    - Логин пользователя с существующими в системе данными, но пароль введен неверно
- Негативные тесты
    - Логин пользователя с несуществующими в системе данными
### Поиск по наименованию или автору книги
- Позитивные тесты
    - Поиск книги по наименованию
    - Поиск книги по автору 
### Добавление книги в корзину
- Позитивные тесты
    - Добавление одной книги в корзину без авторизации пользователя
    - Добавление двух и удаление одной книги из корзины без авторизации пользователя
    - Добавление двух и изменение количества книг в корзине без авторизации пользователя
## API тесты
### GET
### Проверка содежимого книг
- Позитивные тесты
    - Проверяем, что в наименовании картинки содержится наименование книги, а также что картинка в верном формате .jpg
### POST
### Вход в систему
- Позитивные тесты
    - Логин пользователя с существующими в системе данными
- Негативные тесты
    - Логин пользователя с несуществующими в системе данными
## Allure
- Созданы отчеты по итогам выполнения тестов
  - для UI тестов описаны шаги выполнения, а также создание скриншотов в случе неуспешного прохождения
  - для API тестов отображается request и responce
# Как спроектирован автоматизированный фреймворк и почему?
- Тестовый фреймворк использует такие паттерны проектирования:
  - **"Page Object"**: код разделен на объекты ```Page```, каждый отражает отдельную веб-страницу. ```BaseTests``` содержит базовые методы работы с веб-драйвером. Каждый ```Page Class``` включает методы взаимодействия с элементами своей веб-страницы и наследует ```BasePage```.
  - **"Data Provider"**: позволяет запускать одинаковые тесты с разными наборами данных из xml-файла, расширяя покрытие без дополнительного кода.
  - **"Steps"**: создание тестов в виде последовательности шагов.
- В директории ```utils``` находятся классы для реализации запуска тестов в разных браузерах (в данном случае chrome и firefox). Класс ```PropertyReader``` реализует настройки для запуска из файла ```resources/framework.properties```. В каталоге ```resources``` расположены драйверы для MacOS.
- Используется Allure для визуализации результатов тестирования.
# Что еще планируется сделать?
- Добавить больше тестов покрывающих основные функции данного приложения
- Развернуть локальный Jenkins и создать job, которая будет запускать данные тесты в docker container, предварительно скачав их с github.
