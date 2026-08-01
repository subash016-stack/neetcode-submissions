class Solution {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {

        backtrack(0, s, new ArrayList<>());

        return result;
    }

    public void backtrack(int index,
                          String s,
                          List<String> path) {

        // Entire string is used
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            // Check palindrome
            if (isPalindrome(s, index, i)) {

                // Choose
                path.add(s.substring(index, i + 1));

                // Explore
                backtrack(i + 1, s, path);

                // Undo
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}