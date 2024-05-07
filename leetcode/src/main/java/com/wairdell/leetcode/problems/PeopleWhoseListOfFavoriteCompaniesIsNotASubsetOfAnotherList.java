package com.wairdell.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * date   : 2024/5/7 9:49
 * desc   : 收藏清单 https://leetcode.cn/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list
 */
public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {

    public static void main(String[] args) {
        PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList anotherList = new PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList();
        /*System.out.println(anotherList.peopleIndexes(Arrays.asList(
                Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google","microsoft"),
                Arrays.asList("google","facebook"),
                Arrays.asList("google"),
                Arrays.asList("amazon")
        )));

        System.out.println(anotherList.peopleIndexes(Arrays.asList(
                Arrays.asList("leetcode","google","facebook"),
                Arrays.asList("leetcode","amazon"),
                Arrays.asList("facebook","google")
        )));

        System.out.println(anotherList.peopleIndexes(Arrays.asList(
                Arrays.asList("leetcode"),
                Arrays.asList("google"),
                Arrays.asList("facebook"),
                Arrays.asList("amazon")
        )));*/

        System.out.println(anotherList.peopleIndexes(Arrays.asList(
                Arrays.asList("arrtztkotazhufrsfczr", "knzgidixqgtnahamebxf", "zibvccaoayyihidztflj"),
                Arrays.asList("cffiqfviuwjowkppdajm", "owqvnrhuzwqohquamvsz"),
                Arrays.asList("knzgidixqgtnahamebxf", "owqvnrhuzwqohquamvsz", "qzeqyrgnbplsrgqnplnl"),
                Arrays.asList("arrtztkotazhufrsfczr", "cffiqfviuwjowkppdajm"),
                Arrays.asList("arrtztkotazhufrsfczr", "knzgidixqgtnahamebxf", "owqvnrhuzwqohquamvsz", "qzeqyrgnbplsrgqnplnl", "zibvccaoayyihidztflj")
        )));
    }


    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Set<String>> exitsMap = new HashMap<>();

        ans.add(0);
        exitsMap.put(0, new HashSet<>(favoriteCompanies.get(0)));

        for (int i = 0; i < favoriteCompanies.size(); i++) {
            Collections.sort(favoriteCompanies.get(i));
        }
        for (int i = 1; i < favoriteCompanies.size(); i++) {
            ans.add(i);

            List<String> current = favoriteCompanies.get(i);
            for (int j = 0; j < ans.size() - 1; j++) {
                Set<String> exits = exitsMap.get(ans.get(j));
                if (exits.size() <= current.size()) continue;
                int k = 0;
                for (; k < current.size(); k++) {
                    if (!exits.contains(current.get(k))) break;
                }
                if (k == current.size()) {
                    ans.remove(Integer.valueOf(i));
                    break;
                }
            }

            if (ans.contains(i)) {

                Set<String> currentSet = new HashSet<>(current);
                Iterator<Integer> iterator = ans.iterator();
                while (iterator.hasNext()) {
                    int next = iterator.next();

                    if (next == i) continue;

                    List<String> exits = favoriteCompanies.get(next);
                    if (current.size() <= exits.size()) continue;
                    int k = 0;
                    for (; k < exits.size(); k++) {
                        if (!currentSet.contains(exits.get(k)))
                            break;
                    }
                    if (k == exits.size()) {
                        iterator.remove();
                        exitsMap.remove(next);
                    }
                }
                exitsMap.put(i, currentSet);
            }
        }
        return ans;
    }

}
