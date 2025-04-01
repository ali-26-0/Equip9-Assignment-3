import java.util.*;

public class Equip9 {

   
    public static List<Integer> processQueries(int n, List<String[]> maintenanceLogs, List<String[]> queries) {
        List<Integer> result = new ArrayList<>();
        
        // I shall process each query
        for (String[] query : queries) {
            int startDate = Integer.parseInt(query[0]);
            int endDate = Integer.parseInt(query[1]);
            int totalCost = 0;
            
            // We will Iterate over all maintenance logs to sum costs for the current query
            for (String[] log : maintenanceLogs) {
                int logDate = Integer.parseInt(log[1]);
                int logCost = Integer.parseInt(log[2]);
                
                // I can add the cost If the log date is within the query date range
                if (logDate >= startDate && logDate <= endDate) {
                    totalCost += logCost;
                }
            }
            
            // Here i will just add the result for this query
            result.add(totalCost);
        }

        return result;
    }

    public static void main(String[] args) {
        // Example Input
        int n = 5;
        List<String[]> maintenanceLogs = Arrays.asList(
            new String[]{"A", "20230101", "100"},
            new String[]{"A", "20230110", "200"},
            new String[]{"B", "20230102", "150"},
            new String[]{"B", "20230105", "50"},
            new String[]{"A", "20230115", "300"}
        );
        
        List<String[]> queries = Arrays.asList(
            new String[]{"20230101", "20230105"},
            new String[]{"20230110", "20230115"},
            new String[]{"20230103", "20230110"}
        );

        
        List<Integer> result = processQueries(n, maintenanceLogs, queries);
        
        
        for (int cost : result) {
            System.out.println(cost);
        }
    }
}