/**
 *  22. Generate Parentheses
 *  https://leetcode.com/problems/generate-parentheses/description/
 */
class GenerateParentheses {

    /**
     * Version 1: Use DFS
     *            Notice the invalid sign: left > right -> since we can only start from left parenthesis
     *      Time:
     *     Space:
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<String>();
        }
        
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<String>();
        
        helper(result, n, n, sb);
        return result;
    }
    
    private void helper(List<String> result, int left, int right, StringBuilder sb) {
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(sb.toString());
        }
        
        // Invalid format since we start adding left parenthesis
        if (left > right) {
            return;
        } 
        
        helper(result, left - 1, right, sb.append('('));
        sb.deleteCharAt(sb.length() - 1);
        
        helper(result, left, right - 1, sb.append(')'));
        sb.deleteCharAt(sb.length() - 1);
    }
}