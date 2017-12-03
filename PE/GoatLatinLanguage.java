/**
 *	Goat Latin Language
 */
class GoatLatinLanguage {

    public String goat(String source) {
        String[] strs = source.trim().split("\\s+");
        HashSet<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('i');
        set.add('e');
        set.add('o');
        set.add('u');

        StringBuilder sb = new StringBuilder();
        String aStr = constructStr(strs.length);

        int count = 1;
        for (String str : strs) {
            if (set.contains(Character.toLowerCase(str.charAt(0)))) {
                sb.append(str);
                sb.append("ma");
            } else {
                sb.append(str.substring(1, str.length()));
                sb.append(str.charAt(0));
            }
            sb.append(aStr.substring(0, count++));
            sb.append(" ");
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private String constructStr(int count) {
        StringBuilder sb = new StringBuilder();

        while (count > 0) {
            sb.append("a");
            count--;
        }
        return sb.toString();
    }

    // For test
    public static void main(String[] argv) {
        Solution s = new Solution();
        String source = "I speak Goat Latin";
        System.out.println(s.goat(source));
    }
}