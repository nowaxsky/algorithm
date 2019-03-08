# Radix Sort 基數排序法

## 基數排序法
* 是一種分配式的排序法, 將每個位數分配到不同的桶子(bucket)中, 一位一位(個位, 十分位, 百分位...)的比較最後完成排序.
* 從小的位數開始比較稱為LSD(Least significant digital), 從最大位數開始比較稱為MSD(Most significant digital). 

## Big O
* Time complexity: O(kn)
* Space complexity: O(k+n)
* k是最大數的位數.