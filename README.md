**Запуск тестового набора:**

открываем терминал и в папке проекта и выполняем команду:

` mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng-api.xml`

передаваемые параметры:

`-Dsurefire.suiteXmlFiles=src/test/resources/testng-api.xml` – запускаемый тестовый набор


**Генерация отчета:**

после выполнения теста выполнить команду:

`allure generate ./target/allure-results --clean -o allure-report `

открыть отчет в браузере: 

`allure open`

очистить отчеты:

`rm -r ./target/allure-results/ allure-report || true`

