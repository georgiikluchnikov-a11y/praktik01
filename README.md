# praktik-01 — UI-автотесты (Selenium + TestNG)

[![UI tests](https://github.com/georgiikluchnikov-a11y/praktik01/actions/workflows/ui-tests.yml/badge.svg)](https://github.com/georgiikluchnikov-a11y/praktik01/actions/workflows/ui-tests.yml)

Учебный проект по практической работе №12: UI-автотесты на Java с использованием
Selenium WebDriver, TestNG и паттерна Page Object.

Тесты работают против живого тренировочного сайта
[practice.expandtesting.com](https://practice.expandtesting.com) — он доступен без регистрации
и содержит отдельные страницы под каждый тип элементов.

> Почему не `the-internet.herokuapp.com`: приложение на Heroku отключено, все страницы кроме
> главной отдают 404. Адрес сайта вынесен в параметр `baseUrl`, поэтому проект можно направить
> на любой другой стенд без правки кода.

## Стек

| Технология | Версия |
|---|---|
| Java | 17 |
| Maven | 3.9+ |
| Selenium WebDriver | 4.49.0 |
| TestNG | 7.12.0 |
| WebDriverManager | 5.9.2 |
| Allure (опционально) | 2.25.0 |

## Структура проекта

```text
praktik-01/
├── pom.xml                              # агрегатор (parent) для всех модулей
├── HerokuApp_UI_Autotests/
│   ├── pom.xml                          # модуль с тестами
│   ├── testng.xml                       # TestNG suite
│   ├── REPORT_TEMPLATE.md               # шаблон отчёта по практической работе
│   └── src/test/java/
│       ├── base/TestBase.java           # запуск/остановка браузера, BASE_URL, ожидание
│       ├── pages/                       # Page Object (8 страниц)
│       └── tests/                       # 8 тест-классов
└── .github/workflows/ui-tests.yml       # CI: сборка и прогон тестов в GitHub Actions
```

## Требования

- JDK 17 или новее (`java -version`)
- Maven 3.9+ (`mvn -v`)
- Google Chrome (WebDriverManager сам скачает подходящий chromedriver)

## Запуск тестов

Из корня проекта (собираются и запускаются тесты всех модулей):

```bash
mvn clean test
```

Без графического интерфейса (как в CI):

```bash
mvn clean test -Dheadless=true
```

Только один класс или один метод:

```bash
mvn test -Dtest=CheckboxesTest
mvn test -Dtest=InputsTest#fillInputsUseArrowsAndDisplayValues
```

Другой адрес тестируемого стенда:

```bash
mvn test -DbaseUrl=https://example.com
```

Запуск внутри модуля работает так же:

```bash
cd HerokuApp_UI_Autotests
mvn clean test
```

## Отчёты

- Surefire HTML/XML-отчёты: `HerokuApp_UI_Autotests/target/surefire-reports/`
- Результаты Allure: `HerokuApp_UI_Autotests/target/allure-results/`
- Локальный отчёт Allure: `mvn allure:serve` (нужен установленный Allure CLI)

## Реализованные сценарии

| № | Страница | Тест | Проверка |
|---|---|---|---|
| 1 | `/add-remove-elements` | `AddRemoveElementsTest` | добавить 2 элемента, удалить один, проверить количество |
| 2 | `/checkboxes` | `CheckboxesTest` | состояния двух чекбоксов и их переключение |
| 3 | `/dropdown` | `DropdownTest` | состав списка, выбор Option 1 и Option 2 |
| 4 | `/form-validation` | `FormValidationTest` | успешная отправка формы и отказ при телефоне не по шаблону |
| 5 | `/hovers` | `HoversTest` | наведение на 3 профиля, подпись, переход в профиль |
| 6 | `/inputs` | `InputsTest` | ввод значений, ARROW_UP/ARROW_DOWN, Display/Clear Inputs |
| 7 | `/notification-message` | `NotificationMessagesTest` | клик по ссылке и проверка текста уведомления |
| 8 | `/tables` | `SortableDataTablesTest` | 7 ячеек первой таблицы через XPath-локаторы |

## CI (GitHub Actions)

Workflow `.github/workflows/ui-tests.yml` запускается на `push` и `pull_request` в `main`,
выполняет `mvn -B clean test -Dheadless=true` на Ubuntu с JDK 17 и прикладывает
`surefire-reports` и `allure-results` как артефакты сборки.

## Git-процесс

```bash
git checkout -b feature/<группа>_<фамилия>_selenium
git add .
git commit -m "feat: add Page Objects and UI tests"
git push -u origin feature/<группа>_<фамилия>_selenium
```

Далее открыть Pull Request в `main` и добавить ментора в Reviewers.
