# Algorithmic Problem Solutions (Other Questions)

This directory contains clean, robust, and optimal Java solutions to the algorithmic questions:

1. **[BusiestBusRow.java](file:///c:/Users/krishna%20agarwal/OneDrive/Desktop/feature_session10/other_questions/BusiestBusRow.java)** (Problem 10: Busiest Bus Row)
2. **[ClassAttendanceTracker.java](file:///c:/Users/krishna%20agarwal/OneDrive/Desktop/feature_session10/other_questions/ClassAttendanceTracker.java)** (Problem 6: Class Attendance Tracker)
3. **[DutyRosterRotation.java](file:///c:/Users/krishna%20agarwal/OneDrive/Desktop/feature_session10/other_questions/DutyRosterRotation.java)** (Problem 8: Duty Roster Rotation)
4. **[ExamScoreBandCounter.java](file:///c:/Users/krishna%20agarwal/OneDrive/Desktop/feature_session10/other_questions/ExamScoreBandCounter.java)** (Problem 4: Exam Score Band Counter)
5. **[SecondBestScore.java](file:///c:/Users/krishna%20agarwal/OneDrive/Desktop/feature_session10/other_questions/SecondBestScore.java)** (Problem 7: Second-Best Score)

---

## Detailed Problem Analysis & Complexity Requirements

### 1. Problem 10: Busiest Bus Row
- **Task:** Return row index with the largest seat total and the total itself. On ties, return the smaller row index.
- **Constraints:** $1 \le r, c \le 10$, $0 \le \text{grid}[i][j] \le 3$.
- **Time Complexity:** $O(r \times c)$ — Every cell in the grid is traversed once.
- **Space Complexity:** $O(1)$ additional space.
- **Tie-breaker:** Using strict inequality `rowTotal > maxTotal` ensures that the lowest row index is preserved when equal sums occur.

---

### 2. Problem 6: Class Attendance Tracker
- **Task:** Return total present days and the longest consecutive unbroken run of present days from a binary array.
- **Constraints:** $1 \le n \le 100$, values are $0$ or $1$.
- **Single Pass:** Yes, solved in a single loop traversal.
- **Time Complexity:** $O(n)$.
- **Space Complexity:** $O(1)$ auxiliary space.
- **Strategy:** Increment a running count on $1$, reset to $0$ on $0$, and update `longestStreak = max(longestStreak, currentStreak)`.

---

### 3. Problem 8: Duty Roster Rotation
- **Task:** Rotate names array to the right by $k$ positions where $k$ can be up to $10^9$.
- **Constraints:** $1 \le n \le 100$, $0 \le k \le 10^9$.
- **Why Single-Place Rotation is Slow:**
  Shifting by 1 position $k$ times requires $O(k \times n)$ operations. When $k = 10^9$ and $n = 100$, operations reach $10^{11}$, exceeding time limits by several orders of magnitude.
- **Optimal Strategy:**
  Use $k \pmod n$ to eliminate redundant full rotations. Place each element at index $(i + k) \pmod n$, or use the 3-step in-place reversal algorithm.
- **Time Complexity:** $O(n)$.
- **Space Complexity:** $O(n)$ to produce a new rotated array (or $O(1)$ auxiliary space if in-place).

---

### 4. Problem 4: Exam Score Band Counter
- **Task:** Count scores $s$ in range $[\text{low}, \text{high}]$ from a sorted array ($n \le 10^6$) queried frequently. Linear scan ($O(n)$) is forbidden.
- **Comparison:**
  - Linear Scan: $O(n)$ time per query. For $10^6$ elements, multiple queries cause severe timeouts.
  - Binary Search: $O(\log n)$ time per query, $O(1)$ space.
- **Handling Edge Duplicates:**
  Standard binary search stops at *any* match. Due to duplicate values at boundaries:
  1. **Lower Bound (`lowerBound`):** Find first index where $\text{score} \ge \text{low}$. On match, continue searching left (`right = mid - 1`).
  2. **Upper Bound (`upperBound`):** Find first index where $\text{score} > \text{high}$. On match, continue searching right (`left = mid + 1`).
  - Total count in $[\text{low}, \text{high}]$ is $\text{upperBound} - \text{lowerBound}$.

---

### 5. Problem 7: Second-Best Score
- **Task:** Find second-highest distinct score or $-1$ if none exists. Sorting the array is strictly prohibited.
- **Comparison with Sorting:**
  - Sorting: $O(n \log n)$ time and $O(n)$ or $O(\log n)$ space; prohibited by task constraint.
  - Single Pass: $O(n)$ time and $O(1)$ space.
- **Strategy:** Maintain `highest` and `second`. If `score > highest`, `second = highest; highest = score`. If `score < highest && score > second`, `second = score`. Duplicates of `highest` are naturally bypassed.
