## Отчет

|               | complexity = 0   |                 |               | complexity = 1   |           |
|:-------------:|:----------------:| :--------------:|:-------------:|:----------------:|:---------:|
|               | Время выполнения | Результат       |               | Время выполнения | Результат |
| Single-thread | 86 ms            | 0               | Single-thread | 111 ms           | 7.063     |
| Master-slave  | 347 ms           | 0               | Master-slave  | 210 ms           | 6.712     |
| Islands       | 536 ms           | 0               | Islands       | 635 ms           | 7.107     |
|               | complexity = 2   |                 |               | complexity = 3   |           |
| Single-thread | 119 ms           | 7.242           | Single-thread | 101 ms           | 7.401     |
| Master-slave  | 160 ms           | 7.236           | Master-slave  | 430 ms           | 7.593     |
| Islands       | 914 ms           | 7.286           | Islands       | 1458 ms          | 7.709     |
|               | complexity = 4   |                 |               | complexity = 5   |           |
| Single-thread | 198 ms           | 7.368           | Single-thread | 116 ms           | 6.969     |
| Master-slave  | 159 ms           | 7.447           | Master-slave  | 217 ms           | 7.265     |
| Islands       | 1216 ms          | 7.591           | Islands       | 1359 ms          | 7.411     |

### Вопросы
1. Какая модель лучше при каких условиях?
  
   При проведении экспериментов чаще все островной алгоритм выдавал лучший результат, но у него есть существенный недостаток - он сильно медленнее многопоточного алгоритма. Поэтому нельзя однозначно сказать какая из этих моделей лучше.
2. Как повлияет увеличение размерности проблемы на алгоритмы?
   
      Островной алгоритм стал работать еще дольше, а результаты многопоточного алгоритма ухудшились(при этом время работы особо не изменилось)
3. Как повлияет увеличение размера популяции?
   
   Увеличение размера популяции позволит обоим алгоритмам добиться лучших результатов, а так же уменьшится время их работы.
4. Есть ли ограничение для количества островов?
   
   С увеличением островов растет результат работы алгоритма, а также и время его работы. Кроме того при выборе количества островов нуобходимо учитывать количество доступных ресурсов (памяти и процессорной мощности) компьютера, на котором запускается алгоритм. При слишком большом количестве островов может появиться проблема с избыточной нагрузкой на систему, что приведет к снижению производительности алгоритма.
