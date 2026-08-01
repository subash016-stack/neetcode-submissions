class Solution {

    List<String> result = new ArrayList<>();

    String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0)
            return result;

        backtrack(0, digits, new StringBuilder());

        return result;
    }

    public void backtrack(int index,
                          String digits,
                          StringBuilder current) {

        if (index == digits.length()) {

            result.add(current.toString());

            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {

            current.append(ch);

            backtrack(index + 1, digits, current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}