# Сервис генерации случайных последовательностей 

• Задача сгенерировать 5 последовательностей простых чисел длинной от 10 до 100 чисел 
в массиве, длина задается из WEB интерфейса.<br/>
• Используя SpringBoot реализовать вывод HTML страницы.<br/> 
• HTML страница должна задавать длину массива простых чисел. Массив генерируется 
разово и не изменяется до следующего запроса генерации массива из WEB UI.<br/>
• Со страницы HTML запускается алгоритм генерации случайных последовательностей, 
где имеется 2 варианта работы «АВТО» и «СГЕНЕРИРОВАТЬ», при нажатии на кнопку 
«СГЕНЕРИРОВАТЬ» выдается 5 последовательностей чисел по 6 случайных числ из 
каждого массива. Последовательность чисел должна исключать дублия. При нажатии на 
кнопку «АВТО» последовательность генерируется каждые 10 секунд и передается в UI. 
Последовательность чисел отображается в таблице.<br/>
• Обмен данными с сервером осуществлять в формате JSON

