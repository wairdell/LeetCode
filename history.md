- 2024/5/7
  - [x] [判断路径是否相交](https://leetcode.cn/problems/path-crossing)
  - [x] [收藏清单](https://leetcode.cn/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list)
    `需要熟悉各种数据结构添加，删除，插件的效率`
  - [x] [省份数量](https://leetcode.cn/problems/number-of-provinces)
  - [x] [二叉树的直径](https://leetcode.cn/problems/diameter-of-binary-tree)
  - [x] [最大连续 1 的个数](https://leetcode.cn/problems/max-consecutive-ones)
  - [x] [01 矩阵](https://leetcode.cn/problems/01-matrix)
  - [x] [N 叉树的最大深度](https://leetcode.cn/problems/maximum-depth-of-n-ary-tree)
  - [x] [相对名次](https://leetcode.cn/problems/relative-ranks)
  - [x] [乘积小于 K 的子数组](https://leetcode.cn/problems/subarray-product-less-than-k)
  - [ ] [最长连续递增序列](https://leetcode.cn/problems/longest-increasing-subsequence)
  - [ ] [买卖股票的最佳时机含手续费](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee)
  - [x] [可被 K 整除的最小整数](https://leetcode.cn/problems/smallest-integer-divisible-by-k)
    `(10 * 1 + 1) % k, (100 * 1 + 10 * 1 + 1) % k， 可以转化为 res = (res % k) * 10 + 1`
  - [x] [在每个树行中找最大值](https://leetcode.cn/problems/find-largest-value-in-each-tree-row)
  - [x] [环形数组是否存在循环](https://leetcode.cn/problems/circular-array-loop)
  - [x] [两数相加 II](https://leetcode.cn/problems/add-two-numbers-ii)
  - [x] [反转链表](https://leetcode.cn/problems/reverse-linked-list)

- 2024/5/6
  - [x] [拆炸弹](https://leetcode.cn/problems/defuse-the-bomb)
  - [x] [输入单词需要的最少按键次数 II](https://leetcode.cn/problems/minimum-number-of-pushes-to-type-word-ii)
  - [x] [找出出现至少三次的最长特殊子字符串 I](https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-i)
  - [x] [边界上的蚂蚁](https://leetcode.cn/problems/ant-on-the-boundary)
  - [x] [移除后集合的最多元素数](https://leetcode.cn/problems/maximum-size-of-a-set-after-removals)
  - [x] [相同分数的最大操作数目 I](https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i)
  - [x] [输入单词需要的最少按键次数 I](https://leetcode.cn/problems/minimum-number-of-pushes-to-type-word-i)
  - [ ] [统计美丽子字符串 II](https://leetcode.cn/problems/count-beautiful-substrings-ii)
  - [x] [最长公共前缀的长度](https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix)
  - [x] [字符串及其反转中是否存在同一子字符串](https://leetcode.cn/problems/existence-of-a-substring-in-a-string-and-its-reverse)

- 2024/5/1
  - [x] [雇佣 K 位工人的总代价](https://leetcode.cn/problems/total-cost-to-hire-k-workers)
  - [x] [到目标字符串的最短距离](https://leetcode.cn/problems/shortest-distance-to-target-string-in-a-circular-array)

- 2024/4/30
    - [x] [满足目标工作时长的员工数目] (https://leetcode.cn/problems/number-of-employees-who-met-the-target)
    - [x] [最美子字符串的数目] (https://leetcode.cn/problems/number-of-wonderful-substrings)
      `'a' 到 'j'组成的字符串至多一个字母出现奇数，用int各个2进制位代表每个字母，用异或的性质来解决奇偶，然后当前字母与前缀至多产生11种可能0 + 1<<(0,9)种可能，当前^who前缀=(1<<n)呢?who前缀=当前^(1<<n)`
    - [ ] [插入区间](https://leetcode.cn/problems/insert-interval)
    - [x] [用栈实现队列](https://leetcode.cn/problems/implement-queue-using-stacks)
    - [x] [所有可能的路径](https://leetcode.cn/problems/all-paths-from-source-to-target)
    - [x] [较大分组的位置](https://leetcode.cn/problems/positions-of-large-groups)
    - [x] [自定义字符串排序](https://leetcode.cn/problems/custom-sort-string)
    - [ ] [和至少为 K 的最短子数组](https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k)
    - [x] [钥匙和房间](https://leetcode.cn/problems/keys-and-rooms)
    - [x] [按奇偶排序数组](https://leetcode.cn/problems/sort-array-by-parity)
    - [x] [三角形的最大周长](https://leetcode.cn/problems/largest-perimeter-triangle)
    - [ ] [排序链表](https://leetcode.cn/problems/sort-list)
    - [x] [求根节点到叶节点数字之和](https://leetcode.cn/problems/sum-root-to-leaf-numbers)
    - [x] [二叉树的前序遍历](https://leetcode.cn/problems/binary-tree-preorder-traversal)

- 2024/4/29
    - [x] [买卖股票的最佳时机 IV](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv)
      `看了代码随想录的视频解决的`
    - [x] [将矩阵按对角线排序](https://leetcode.cn/problems/sort-the-matrix-diagonally)
    - [x] [在 D 天内送达包裹的能力](https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days)
      `将最大的值作为二分查找左节点，所有节点的和作为右节点，然后循环尝试用不同的值去装载，用试出的值判断是否大于要求天数，大于则更新左节点，否则更新右节点`
    - [x] [移除石子使总数最小](https://leetcode.cn/problems/remove-stones-to-minimize-the-total)
      `使用堆解决的，看了题解用计数排序会快点`
    - [x] [找出数组中的第 K 大整数](https://leetcode.cn/problems/find-the-kth-largest-integer-in-the-array)
    - [x] [股票价格波动](https://leetcode.cn/problems/stock-price-fluctuation)
      `利用 treeMap 做价格排序`
    - [x] [连接后等于目标字符串的字符串对](https://leetcode.cn/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target)
    - [x] [找出数组排序后的目标下标](https://leetcode.cn/problems/find-target-indices-after-sorting-array)
      `使用快排标兵解决，看题解直接记录小于target的次数，和等于target的次数，这这两个数做区间循环即可`
    - [x] [数组中第 K 个独一无二的字符串](https://leetcode.cn/problems/kth-distinct-string-in-an-array)
      `用map记录出现的次数，用List记录出现的单词解决，题解有种方式是用map记录次数，第二次循环再查询map中是否大于两次做独一无二的字符串个数++`

- 2024/4/28
    - [x] [简化路径](https://leetcode.cn/problems/simplify-path)
      `才用链表解决的，看了题解使用栈的方式会更好点`
    - [x] [找到冠军 II](https://leetcode.cn/problems/find-champion-ii)
      `最开始想用并查集，但是2可以赢1,3也可以赢1，就产生了两个父节点。再次使用dfs尝试但时间超时了，看了题解使用hash表将输得次数++，输次数为0的就是冠军`
    - [x] [螺旋矩阵](https://leetcode.cn/problems/spiral-matrix)
    - [x] [找到冠军 I](https://leetcode.cn/problems/find-champion-i)
    - [x] [阶乘后的零](https://leetcode.cn/problems/factorial-trailing-zeroes)
      `很久之前刷过题解，直接找到5的个数和2的个数，相乘即为0，又此题是1~n所以2的个数肯定是大于5的，注25,75有多个5，所以取单个数5的个数也要循环处理`
    - [x] [长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum)
      `循环遍历每个节点，并获得相加节点sum,在用前缀表记录，最小子数组就是累加当前索引值的sum - 查找前缀表sum-target最近的索引`
    - [x] [最佳观光组合](https://leetcode.cn/problems/best-sightseeing-pair)
      `j > i, 结果等于最大values[i] + values[j] + i - j，那么可以在遍历j的时候，再把 max(values[i] + i) 记录下来，只用一层 for 循环实现，应该先不看题解，直接用两层for做一遍，再去发现优化点`

- 2024/4/27
    - [x] [数字范围按位与](https://leetcode.cn/problems/bitwise-and-of-numbers-range)
      `第一遍超时，后面想到int最高2的32位，那么判断把当前位+1的位是否小于right的节点就行了`
    - [x] [课程表](https://leetcode.cn/problems/course-schedule)
      `先使用bfs超时了，看了题解用dfs，发现dfs比bfs快很多，因为这道题判断有环，dfs如果发现没环了，可以把当前遍历的这一系列节点都标记为没环，从而枝减后续的循环，这样操作下来时间复杂度应该是N`
    - [x] [查询网格图中每一列的宽度](https://leetcode.cn/problems/find-the-width-of-columns-of-a-grid)

- 2024/4/26
    - [x] [克隆图](https://leetcode.cn/problems/clone-graph)
    - [x] [同构字符串](https://leetcode.cn/problems/isomorphic-strings)
      `用hash记录各个字母的次数`
    - [x] [赎金信](https://leetcode.cn/problems/ransom-note)
    - [x] [加油站](https://leetcode.cn/problems/gas-station)
      `自己的思路是先把加油站以以正负压缩分组(gas = [1,2,3,4,5], cost = [3,4,5,1,2] => [-2, -1, -2, 3, 3] => [-5, 6])，然后找到最大正数的节点`
    - [x] [除自身以外数组的乘积](https://leetcode.cn/problems/product-of-array-except-self)
    - [x] [H 指数](https://leetcode.cn/problems/h-index)
      `hash表记录每种指数的个数，然后倒序判断当前指数大于当前索引，还需当前的指数个数+=后一个指数的个数`
    - [x] [轮转数组](https://leetcode.cn/problems/rotate-array)
    - [x] [删除有序数组中的重复项 II](https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii)
    - [x] [删除有序数组中的重复项](https://leetcode.cn/problems/remove-duplicates-from-sorted-array)
    - [x] [水果成篮](https://leetcode.cn/problems/fruit-into-baskets)
    - [x] [每日温度](https://leetcode.cn/problems/daily-temperatures)
      `单调栈，遍历判断栈最后一个元素是否小于当前元素，小于则出栈并更新出栈元素对应索引的值，后把当前元素入栈`
    - [x] [四数相加 II](https://leetcode.cn/problems/4sum-ii)
      `第一个组和第二个组相加并添加到hash表中记录相加和的次数，第三个组和第四个组相加再去hash表找 要求和的值-当前和的值 的个数`