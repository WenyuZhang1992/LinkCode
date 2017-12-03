/**
 *	Given a huge file having dynamic data, 
 *  write a program to read last n lines from the file at any point without reading the entire file.
 *  Similar to implementation of "tail -n k" shell command
 */
import java.nio.files.*;
import java.io.*;
import java.util.*;

public class ImplementTail {

    /** Version 1: Use minHeap to track lineCount of each String
     *       Time: O(nlogk)
     *      Space: O(k)
     */
    public List<String> tail(String path, int k) throws IOException {
        Scanner sc = new Scanner(Paths.get(path));
        Queue<LineNode> heap = new PriorityQueue<LineNode>(new LineNodeComparator());
        int count = 0;

        while (sc.hasNextLine()) {
            heap.add(new LineNode(sc.nextLine(), count++));
            while (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> result = new ArrayList<String>();
        while (heap.size() > 0) {
            result.add(heap.poll().line);
        }

        return result;
    }

    private class LineNode {
        int count;
        String line;

        public LineNode(String line, int count) {
            this.line = line;
            this.count = count;
        }
    }

    private class LineNodeComparator implements Comparator<LineNode> {
        public int compare(LineNode l1, LineNode l2) {
            return l1.count - l2.count;
        }
    }

    /** 
     *  Version 2: Use RandomAcessFile to access File object from the end
     */
    public List<String> tail(File file, int k) {
        int readLine = 0;
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        RandomAccessFile raFile = null;

        try {
            raFile = new RandomAccessFile(file, "r");

            // Pointer should be type long
            long pointer = raFile.length() - 1;
            for (long i = pointer; i >= 0; i--) {
                raFile.seek(i);
                char c = (char)raFile.read();

                if (c == '\n') {
                    readLine++;
                    result.add(sb.reverse().toString());
                    sb.delete(0, sb.length());
                    if (readLine == k) {
                        break;
                    }
                } else {
                    sb.append(c);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raFile != null) {
                try {
                    raFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public static void main(String args[]) {
        ImplementTail it = new ImplementTail();
        try {
            List<String> result = it.tail("test.txt", 1);
            for (String str : result) {
             System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}