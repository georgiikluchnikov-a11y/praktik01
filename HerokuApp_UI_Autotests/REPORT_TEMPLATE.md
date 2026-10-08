# Практическая работа №12
## UI-автотесты на Selenium + TestNG

### 1. Титульный лист
Дисциплина: ____________________
Группа: ____________________
ФИО: ____________________
Дата: ____________________

### 2. Цель
Освоить самостоятельную разработку и сопровождение UI-автотестов на Java с использованием
Selenium WebDriver и TestNG.

### 3. Среда
ОС: ____________________
JDK: 17+
Maven: 3.9+
Браузер: Google Chrome ____________________
WebDriver: управляется WebDriverManager
IDE: ____________________
Тестируемый стенд: https://practice.expandtesting.com

### 4. Реализованные сценарии
1. Add/Remove Elements (`/add-remove-elements`) — добавить 2 элемента, удалить один, проверить количество.
2. Checkboxes (`/checkboxes`) — проверить состояния двух чекбоксов и изменить их.
3. Dropdown (`/dropdown`) — проверить состав простого списка и выбрать Option 1 и Option 2.
4. Form Validation (`/form-validation`) — отправить корректную форму и проверить отказ при телефоне не по шаблону.
5. Hovers (`/hovers`) — для каждого из трёх профилей выполнить наведение, проверить подпись, перейти в профиль.
6. Inputs (`/inputs`) — ввести значения, использовать ARROW_UP/ARROW_DOWN, проверить Display/Clear Inputs.
7. Notification Messages (`/notification-message`) — нажать ссылку, дождаться и проверить уведомление.
8. Sortable Data Tables (`/tables`) — проверить 7 ячеек первой таблицы XPath-локаторами.

### 5. Запуск
Команда из корня проекта:
`mvn clean test` (без GUI: `mvn clean test -Dheadless=true`)

Результат: ____________________

Вставить скриншот зелёного прогона Maven/IDE.

### 6. Отчёты
Путь: `HerokuApp_UI_Autotests/target/surefire-reports/`

Вставить скриншот отчёта и кратко указать количество passed/failed/skipped.

### 7. Git
Ссылка на репозиторий: https://github.com/georgiikluchnikov-a11y/praktik01
Feature-ветка: `feature/<группа>_<фамилия>_selenium`
Pull Request: ____________________
Reviewer (ментор): ____________________
Hash последнего коммита: ____________________

### 8. Выводы
В ходе работы был создан Maven-проект UI-автотестов. Реализован Page Object, явные ожидания
и корректное закрытие WebDriver. Тесты запускаются через Maven Surefire и автоматически
проверяются в GitHub Actions (headless Chrome). Адрес стенда вынесен в параметр `baseUrl`,
поэтому проект не зависит от конкретного хостинга тренировочного сайта.
