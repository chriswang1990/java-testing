package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]
*/

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        int len = intervals.size();
        List<Interval> ans = new ArrayList<Interval>();
        if (len == 0) {
            return ans;
        }
        ans.add(intervals.get(0));
        for (int i = 1; i < len; i++) {
            Interval cur = intervals.get(i);
            Interval prev = ans.get(ans.size() - 1);
            if (cur.start <= prev.end) {
                if (cur.end <= prev.end) {
                    continue;
                } else {
                    ans.set(ans.size() - 1, new Interval(prev.start, cur.end));
                }
            } else {
                ans.add(cur);
            }
        }
        return ans;
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
