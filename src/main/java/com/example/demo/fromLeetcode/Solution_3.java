package com.example.demo.fromLeetcode;

import com.example.demo.fromLeetcode.ListNode;

// 8 ЗАДАЧА ИЗ СПИСКА BLIND CURATED 75
public class Solution_3 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

        // TODO - объяснение логики представленного выше кода с рекурсией
        // Суть: нужно найти самое наибольшее число, чтобы начать рекурсивное схлопывание
        // в обратном направлении.
        // Объяснение на примере двух списков: 1 список - [1, 2, 3], 2 список - [2, 4, 8]
        // 1) Сравниваются первые два элемента из обоих списков: 1 < 2,
        //    поэтому во 2 ноду 1 списка запишется результат работы метода,
        //    в который передаем параметры: список [2, 3] и список [2, 4 ,8].
        //    Кроме того, сдвигается на следующую ноду указатель в первом списке
        // 2) Сравниваются первые два элемента из обоих списков: 2 = 2,
        //    поэтому во 2 ноду 2 списка запишется результат работы метода,
        //    в который передаем параметры: список [2, 3] и [4, 8].
        //    Кроме того, сдвигается на следующую ноду указатель во 2 списке
        // 3) Сравниваются первые два элемента из обоих списков: 2 < 4,
        //    поэтому в 3 ноду 1 списка запишется результат работы метода,
        //    в который передаем параметры: список [3] и список [4, 8]
        //    Кроме того, сдвигается на следующую ноду указатель в 1 списке
        // 4) Сравниваются первые два элемента из обоих списков: 3 < 4,
        //    поэтому в 4 ноду 1 списка запишется результат работы метода,
        //    в который передаем параметры: null (т.к. в списке больше нет нод) и список [4, 8]
        // 5) Т.к. list1 теперь равен null, т.к. в 1 списке больше нет нод, то метод вернет list2,
        //    состоящий из [4, 8]. Начинается схлопывание рекурсии в обратном направлении.
        // 6) В 4 ноду 1 списка записывается возвращенный в пункте 5 результат. И метод возвращает
        //    list2, на данный момент состоящий из [4, 8]
        // 7) Затем в 3 ноду 1 списка записывается результат работы метода,
        //    в который были переданы параметры: список [3] и список [4, 8]. Значит, в 3 ноду
        //    запишется список list1, состоящий на данный момент из [3, 4, 8]
        // 8) Затем во 2 ноду 2 списка записывается результат работы метода,
        //    в который были переданы параметры: список [2, 3] и список [4, 8]. Значит, во 2 ноду
        //    запишется список list1, на данный момент состоящий из [2, 3, 4, 8]
        // 9) Затем во 2 ноду 1 списка записывается результат работы метода,
        //    в который были переданы параметры: список [2, 3] и список [2, 4 ,8]. Значит, во 2 ноду
        //    1 списка запишется список list2, на данный момент состоящий из [2, 2, 3, 4, 8].
        //    И происходит возврат list1
    }
}
