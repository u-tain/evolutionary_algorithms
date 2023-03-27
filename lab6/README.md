## Отчет

|               | complexity = 0   |                 |               | complexity = 1   |           |
|:-------------:|:----------------:| :--------------:|:-------------:|:----------------:|:---------:|
|               | Время выполнения | Результат       |               | Время выполнения | Результат |
| Single-thread | 86 ms            | 0               | Single-thread | 111 ms           | 7.063     |
| Master-slave  | 347 ms           | 0               | Master-slave  | 210 ms           | 6.712     |
| Islands       | 536 ms           | 0               | Islands       | 635 ms           | 6.786     |
|               | complexity = 2   |                 |               | complexity = 3   |           |
| Single-thread | 119 ms           | 7.242           | Single-thread | 101 ms           | 7.701     |
| Master-slave  | 160 ms           | 7.236           | Master-slave  | 430 ms           | 7.693     |
| Islands       | 914 ms           | 6.825           | Islands       | 1458 ms          | 6.956     |
|               | complexity = 4   |                 |               | complexity = 5   |           |
| Single-thread | 198 ms           | 7.768           | Single-thread | 116 ms           | 6.969     |
| Master-slave  | 159 ms           | 7.557           | Master-slave  | 217 ms           | 7.465     |
| Islands       | 1216 ms          | 6.483           | Islands       | 1451 ms          | 6.872     |

### Вопросы
1. Какая модель лучше при каких условиях?
2. Как повлияет увеличение размерности проемы на алгоритмы?
3. Как повлияет увеличение размера популяции?
4. Есть ли ограничение для количества островов?
