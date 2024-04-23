package baithuchanh1.bai1;
import java.io.*;
import java.util.*;

public class GraphColoring {

    // Function to find the number of colors required to color the graph
    public static int graphColoring(int[][] graph) {
        int numVertices = graph.length;
        int[] color = new int[numVertices]; // Mảng chứa màu của từng đỉnh
        Arrays.fill(color, -1); // Khởi tạo mảng màu với giá trị -1 (chưa được màu)

        // Bắt đầu từ đỉnh đầu tiên
        color[0] = 0;

        // Lặp qua tất cả các đỉnh
        for (int vertex = 1; vertex < numVertices; vertex++) {
            // Tìm các màu đã được sử dụng bởi các đỉnh kề của đỉnh hiện tại
            boolean[] usedColors = new boolean[numVertices];
            for (int adjacentVertex = 0; adjacentVertex < numVertices; adjacentVertex++) {
                if (graph[vertex][adjacentVertex] == 1 && color[adjacentVertex] != -1) {
                    usedColors[color[adjacentVertex]] = true;
                }
            }

            // Tìm màu không được sử dụng và gán cho đỉnh hiện tại
            int chosenColor;
            for (chosenColor = 0; chosenColor < numVertices; chosenColor++) {
                if (!usedColors[chosenColor]) {
                    break;
                }
            }
            color[vertex] = chosenColor;
        }

        // Tìm số màu đã được sử dụng
        int numColors = 0;
        for (int i = 0; i < numVertices; i++) {
            if (color[i] > numColors) {
                numColors = color[i];
            }
        }

        // Số màu sử dụng sẽ lớn hơn chỉ số màu, nên ta cần cộng thêm 1
        return numColors + 1;
    }

    public static int[][] extractGraphFromFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        // {sv3=[TCC], sv2=[LTDT, TRR], sv1=[TRR, TCC]}
        Map<String, List<String>> map = new HashMap<>();
        // {TRR=0, TCC=2, LTDT=1}
        Map<String, Integer> mapMH = new HashMap<>();
        int[][] result;
        String line;
        int count = 0;
        while((line = reader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
                String codeSV = st.nextToken();
                String codeMH = st.nextToken();
                if(!mapMH.containsKey(codeMH)) mapMH.put(codeMH, count++);

                if(!map.containsKey(codeSV)) {
                    List<String> HMs = new ArrayList<>();
                    HMs.add(codeMH);
                    map.put(codeSV, HMs);
                }else {
                    map.get(codeSV).add(codeMH);
                }
            }
        }
        System.out.println(mapMH);
        System.out.println(map);
        // handle 2 map extract data into result[][]
        int totalVertex = mapMH.size();
        result = new int[totalVertex][totalVertex];
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            String MHFirst = value.getFirst();
            for(int i=1; i< value.size(); i++) {
                String MH = value.get(i);
                result[mapMH.get(MHFirst)][mapMH.get(MH)] = 1;
                result[mapMH.get(MH)][mapMH.get(MHFirst)] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        int[][] graph = {
//                {0, 1, 0, 0, 1, 1, 1},
//                {1, 0, 1, 1, 0, 0, 1},
//                {0, 1, 0, 1, 0, 0, 0},
//                {0, 1, 1, 0, 1, 0, 1},
//                {1, 0, 0, 1, 0, 1 ,1},
//                {1, 0, 0, 0, 1, 0 ,0},
//                {1, 1, 0, 1, 1, 0, 0}
//        };
//        int numColors = graphColoring(graph);
//        System.out.println("Số màu cần: " + numColors);
        int[][] arr = extractGraphFromFile("baithuchanh1//bai1//SV_MONHOC.txt");
        System.out.println(graphColoring(arr));
    }
}
