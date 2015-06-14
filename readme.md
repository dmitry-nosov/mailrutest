# Запуск тестов
Данный репозиторий содержит Eclipse Maven проект, который реализует тестовое задание. Для запуска тестов используйте
`mvn test`

Для изменения ориентации дисплея поставьте в файле `test.properties` требуемое значение: *LANDSCAPE* или *PORTRAIT*.

# Соглашения и ограничения
Далее я рассматриваю ограничения, которые, как я предполагаю, должны быть выполнены для успешного прохождения тестов, а также ограничения на проверки в самих тестов, требуемые для необходимого баланса между усилиями по написанию тестов и эффективностью полученных тестов в нахождении дефектов.

1. Я использовал учетную запись testformailru01@mail.ru/hardpass для тестирования. Предполагается, что тестирование будет произведено на этой фикстуре (Входящие содержат 4 письма, 1 непрочитанное).

2. Язык клиентского приложения *английский* (используется для идентификации окна с Move To, так что это требование обязательно для выполнения теста; в более сложном варианте нужно будет адаптировать проверку под изменения локали).

3. Я проверял на Android 4.3 768x1280, так что считаю это рекомендуемым эмулятором.

4. Тесты не проверяют верстку приложения, а именно: дизайн (стили, картинки), размеры и взаимное расположение элементов (это же функциональные тесты :)). Также к верстке я отношу изначальное расположение элементов, а также все последующие изменения в расположении элементов (кроме, естественно, видимости тех элементов, которые нам нужны для совершения операций). Две основных причины для этого решения: если начать проверять, то достаточно сложно провести черту, где стоит остановиться и почему проверять именно этот элемент, а не другой. Т.е. мы получим **существенные затраты**, но при этом мы все равно **не будем иметь никакой гарантии**, что верстка останется корректной. Я уверен, что существуют более эффективные способы проверки верстки, в частности, через работу с образами.

5. Тесты проверяют только заданные функции. Частично это связано с нехваткой времени для более глубокого обдумывания, какие вариации имеет смысл проверить, частично с тем, что нет доступа к разработчику/коду, который мог бы подсказать, где используются стандартные события и виджеты, которые не имеет смысл проверять, а где стоило бы поглубже покопать (например, стоит ли повторять выполнение некоторых операций несколько раз). Практики, конечно, везде разные, но обычно перегрузка тестов проверками скорее всего приведет к дублированию проверок и к массовым падениям тестов по одной и той же причине (что усложнит исследование причины падения).

6. Тесты не проверяют функции при выходе из контекста приложения (выход из приложения, сворачивание приложения), одновременное выполнение с разных устройств, выполнение в экстремальных условиях (отсутствие памяти, отсутствие дискового пространства, отсутствие сети), работу с кнопкой Back.
