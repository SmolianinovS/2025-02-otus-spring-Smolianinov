#### Программа по проведению тестирования студентов
• В ресурсах хранятся вопросы и различные ответы к ним в виде
CSV файла.
• Программа должна спросить у пользователя фамилию и имя,
спросить вопросы из CSV-файла и вывести результат
тестирования.
В рамках этого ДЗ (первая часть):
• Только чтение и вывод вопросов (!)Часть на это (!) ДЗ
Описание части на это ДЗ:
• В ресурсах хранятся вопросы и различные ответы к ним в виде
CSV файла (5 вопросов).
• Вопросы могут быть с выбором из нескольких вариантов или
со свободным ответом - на Ваше желание и усмотрение.
• Приложение должно просто вывести вопросы теста из CSVфайла с возможными вариантами ответа.Домашнее задание
Требования:
0. В приложении должна присутствовать объектная модель
(отдаём предпочтение объектам и классам, а не строчкам и
массивам/спискам строчек).
1. Все классы в приложении должны решать строго определённую
задачу (см. п. 18-19 "Правила оформления кода.pdf",
прикреплённые к материалам занятия).
2. Контекст описывается XML-файлом.
3. Все зависимости должны быть настроены в IoC контейнере.
4. Имя ресурса с вопросами (CSV-файла) необходимо
захардкодить строчкой в XML-файле с контекстом.Домашнее задание
5. CSV с вопросами читается именно как ресурс, а не как файл.
6. Scanner, PrintStream и другие стандартные типы в контекст класть не
нужно!
7. Весь ввод-вывод осуществляется на английском языке.
8. Крайне желательно написать юнит-тест какого-нибудь сервиса
(оцениваться будет только попытка написать тест).
9. Помним – «без фанатизма» ☺
Опционально (задание со "звёздочкой"):
1*. Приложение должно корректно запускаться с помощью "java -jar"
Заготовка для выполнения работы:
https://github.com/OtusTeam/Spring/tree/master/templates/hw01-xml-config
