package kadai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class urag_bnsk {
    public static void main(String[] args) {
        // Map<String, List<Integer>> を使用してデータを保持
        Map<String, List<Integer>> sales = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("入力形式:商品名,金額");
        System.out.println("入力終了:「end」を入力すると終了");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] parts = input.split(",");
            if (parts.length != 2) {
                System.out.println("入力形式が不正。カンマ区切りで入力。");
                continue;
            }

            String product = parts[0].trim();
            String amountInput  = parts[1].trim();

            int amount;
            try {
                amount = Integer.parseInt(amountInput);
                if (amount < 0) {
                    System.out.println("負の数は存在しません。再入力してください。");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("金額が不正です。整数値を入力してください。");
                continue;
            }

            List<Integer> amountsList = sales.get(product);
            if (amountsList == null) {
                amountsList = new ArrayList<>();
                sales.put(product, amountsList);
            }
            amountsList.add(amount);        }

        scanner.close();
        System.out.println("\n=== 分析開始 ===");
        bnsk(sales);
    }

    private static void bnsk(Map<String, List<Integer>> sales) {
        if (sales.isEmpty()) {
            System.out.println("分析するデータがありません。");
            return;
        }

        long total_sales = 0;
        String best_ur_pro = "";
        long max_sales_amount = 0;
        String bset_ur_count = "";
        int max_sales_count = 0;

        System.out.println("\n=== 商品別売上分析 ===");
        for (Map.Entry<String, List<Integer>> entry : sales.entrySet()) {
            String product = entry.getKey();
            List<Integer> amounts = entry.getValue();

            int count = amounts.size();
            long sum = amounts.stream().mapToLong(i -> i).sum();
            double average = (double) sum / count;

            System.out.printf("%s: 回数=%d 合計=%d 平均=%.0f\n", product, count, sum, average);

            total_sales += sum;

            if (sum > max_sales_amount) {
            	max_sales_amount = sum;
                best_ur_pro = product;
            }

            if (count > max_sales_count) {
            	max_sales_count = count;
                bset_ur_count = product;
            }
        }

        System.out.println("\n=== 全体統計 ===");
        System.out.printf("総売上:%d円\n", total_sales);
        System.out.printf("最も売上が多かった商品:%s(%d円)\n", best_ur_pro, max_sales_amount);
        System.out.printf("最もよく売れた商品:%s(%d回)\n", bset_ur_count, max_sales_count);
    }
}
