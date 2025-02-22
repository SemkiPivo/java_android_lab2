# Практическая работа №2

**Основное задание данной работы:**

*Создать простое приложение-кликер. Главное и единственное окно приложения
должно демонстрировать кнопку с надписью “Нажми меня” и надпись “Вы нажали кнопку 0 раз”.
При каждом нажатии на кнопку,надпись соответствующим образом изменяется.*

Большая часть приложения написана по методическим указаниям, однако в данной работе, в отличие от первой, есть задания для самостоятельного выполнения. Их реализация описана в разборе методов файла MainActivity.java.

## Файл activity_main.xml

> Путь к файлу activity_main.xml: app\src\main\res\layout\activity_main.xml

### Методы и компоненты

    1. ConstraintLayout
      Тип: Контейнер макета.

    2. TextView (Текст: "Вы нажали кнопку")
        Тип: Отображает текст.

    3. TextView (Текст: "N раз")
        Тип: Отображает текст.

    4. Button (Добавить)
        Тип: Кнопка.

    5. Button (Отнять)
        Тип: Кнопка.

    6. ImageButton (Сбросить)
        Тип: Кнопка с изображением.


## Файл MainActivity.java

> Путь к файлу MainActivity.java:  app\src\main\java\com\example\lab2\MainActivity.java

### Методы и компоненты:

1. onCreate(Bundle savedInstanceState)

Этот метод вызывается при создании активности.
В нем происходит инициализация и настройка всех необходимых компонентов.
Подробнее метод описан в <a href="https://github.com/SemkiPivo/java_android_lab1">репозитории практической работы №1</a>.

Переменные:

        score = 0 - целочисленная переменная, в которую заносится количество нажатий. Изначально равна нулю.

Инициализация компонентов:

        mainTextView, addButton, retractButton, revertButton — это все компоненты, которые были определены в макете activity_main.xml и теперь инициализируются в коде.

Установка начального текста для mainTextView: mainTextView.setText(score + "\nРаз");

Установка слушателей событий:

        addButton.setOnClickListener(clickListener); — устанавливает clickListener как слушатель нажатий на addButton.

        retractButton.setOnClickListener(clickListener); — устанавливает clickListener как слушатель нажатий на retractButton.

        revertButton.setOnClickListener(clickListener); — устанавливает clickListener как слушатель нажатий на revertButton.

2. clickListener (View.OnClickListener)

Это анонимный класс, который реализует интерфейс View.OnClickListener.
Он обрабатывает нажатия на кнопки addButton, retractButton и revertButton:

Обработка нажатий:

        Если нажата кнопка addButton, значение score увеличивается на 1.

        Если нажата кнопка retractButton, значение score уменьшается на 1.

        Если нажата кнопка revertButton, значение score сбрасывается на 0.

Формирование текста для mainTextView:

        В зависимости от значения score, определяется правильное склонение слова "раз" или "раза".

        Если score равен 2, 3 или 4 (исключая числа от 11 до 14 и от -11 до -14), то используется слово "раза".

        В остальных случаях используется слово "раз".

    Обновление текста mainTextView: mainTextView.setText(score + "\n" + text);

Данный код содержит базовую функциональность Android-приложения,
включая обработку нажатий на кнопки, изменение значения счетчика и обновление текста на экране.
