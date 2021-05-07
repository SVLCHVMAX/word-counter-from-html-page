# word-counter-from-html-page
Консольное приложение, позволяющее скачать html страницу по заданному url-адресу и посчитать количество уникальных слов на странице. Приложение также сохраняет статистику по словам в базу данных.

# Запуск
Для запуска требуются:
* JDK 8 или новее
* Maven
* PostgreSQL DB

Создайте новую базу данных с именем words. Username=postgres, password=postgres.

В консоли перейдите в директорию проекта и выполните команду

    mvn package
    
### Параметры запуска
Приложение требует для запуска один аргумент - url-адрес сайта, для которго нужно посчитать количество слов. Для запуска выполните

    java -jar counter-words-0.0.1-SNAPSHOT.jar https://example.com
    
где https://example.com - имя сайта, для которого считаются слова.


Программа создаст в директории target две папки: downloads - где лежат скачанные html-страницы, logs - ошибки, возникшие во время работы приложения.
Статистика по количеству уникальных слов будет выведена в консоль и сохранена в базу данных words в таблицу word.

    

