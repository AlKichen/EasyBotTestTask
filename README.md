# Инструкция по запуску приложения
## Запуск через jar файл
1) запустить jar file - здесь в репозитории GitHub - я создал [Release](https://github.com/AlKichen/EasyBotTestTask/releases/tag/publish) с этим файлом
2) Приложение запустится на [http://localhost:8080](http://localhost:8080)
3) Далее после успешного запуска, перейти по ссылке  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html). На странице Swagger UI можно ознакомиться со всеми endpoints, которые предоставляет это приложение,
   а также протестировать их.
## Запуск через IntelliJ IDEA
1) Необходимо запустить приложение, запустив метод main в классе ComputerStoreApplication, 
который находится в папке src.main.java.com.alKich.computerStore
2) Далее после успешного запуска, перейти по ссылке  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
На странице Swagger UI можно ознакомиться со всеми endpoints, которые предоставляет это приложение,
а также протестировать их, поскольку данные по умолчанию уже добавлены в БД (посмотреть на данные можно в классе CommandLineRunnerImpl, 
который находится в пакете src.main.java.com.alKich.computerStore.init)



