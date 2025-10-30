package kadai;

import java.util.InputMismatchException;
import java.util.Scanner;

public class dentaku {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // --- 1つ目の数値を入力 ---
            System.out.print("1つ目の数値を入力してください: ");
            double num1 = sc.nextDouble();

            // --- 演算子を入力 ---
            System.out.print("演算子を入力してください (+ - * / %): ");
            String op = sc.next();

            // --- 2つ目の数値を入力 ---
            System.out.print("2つ目の数値を入力してください: ");
            double num2 = sc.nextDouble();

            double result = 0;
            boolean error = false;
            String errorMessage = "";

            // --- 計算処理 ---
            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        error = true;
                        errorMessage = "計算できません(0で割ることはできません)";
                    } else {
                        result = num1 / num2;
                    }
                    break;
                case "%":
                    if (num2 == 0) {
                        error = true;
                        errorMessage = "計算できません(0で割ることはできません)";
                    } else {
                        result = num1 % num2;
                    }
                    break;
                default:
                    error = true;
                    errorMessage = "不正な演算子が入力されました";
            }

            // --- 結果出力 ---
            System.out.print("結果: " + num1 + " " + op + " " + num2 + " = ");
            if (error) {
                System.out.println(errorMessage);
            } else {
                System.out.println(result);
            }

        } catch (InputMismatchException e) {
            System.out.println("エラー: 数値以外が入力されました。プログラムを終了します。");
        } catch (Exception e) {
            System.out.println("エラー: 入力または計算中に問題が発生しました。");
        } finally {
            sc.close();
        }
    }
}
