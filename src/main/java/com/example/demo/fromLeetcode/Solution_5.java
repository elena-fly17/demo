package com.example.demo.fromLeetcode;

// 26 ЗАДАЧА ИЗ СПИСКА BLIND CURATED 75
public class Solution_5 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Т.к. в задаче сказано, что количество узлов в дереве может быть в диапазоне [0, 100],
        // то, значит, узлом может быть и null. И если в деревьях, пришедших в метод,
        // узлы представляют собой null, то эти деревья считаются одинаковыми
        if (p == null & q == null) {
            return true;
        }

        // Если один из узлов null, а другой нет, то они не одинаковы
        if (p == null | q == null) {
            return false;
        }

        // Проверяем значения текущих узлов и рекурсивно вызываем для левых и правых поддеревьев
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
