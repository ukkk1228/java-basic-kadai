package kadai_028;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Jyanken_Chapter28 {
    // 自分のじゃんけんの手を入力するメソッド
    public String getMyChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("じゃんけんの手を入力してください（r：グー、s：チョキ、p：パー）＞ ");
        String choice = sc.nextLine();
        return choice;
    }

    // 対戦相手のじゃんけんの手を乱数で選ぶメソッド
    public String getRandom() {
        String[] hands = {"r", "s", "p"};
        int randomNum = (int) Math.floor(Math.random() * 3); // 0～2の乱数
        return hands[randomNum];
    }

    // じゃんけんを行うメソッド
    public void playGame() {
        // じゃんけんの手と表示用のマップ
        Map<String, String> handMap = new HashMap<>();
        handMap.put("r", "グー");
        handMap.put("s", "チョキ");
        handMap.put("p", "パー");

        // 自分と相手の手を取得
        String myHand = getMyChoice();
        String enemyHand = getRandom();

        // 自分と相手の手を表示
        System.out.println("自分の手：" + handMap.get(myHand));
        System.out.println("相手の手：" + handMap.get(enemyHand));

        // 結果判定
        if (myHand.equals(enemyHand)) {
            System.out.println("あいこです");
        } else if (
            (myHand.equals("r") && enemyHand.equals("s")) ||
            (myHand.equals("s") && enemyHand.equals("p")) ||
            (myHand.equals("p") && enemyHand.equals("r"))
        ) {
            System.out.println("自分の勝ちです");
        } else if (
            (myHand.equals("r") && enemyHand.equals("p")) ||
            (myHand.equals("s") && enemyHand.equals("r")) ||
            (myHand.equals("p") && enemyHand.equals("s"))
        ) {
            System.out.println("自分の負けです");
        } else {
            System.out.println("正しい入力ではありません（r / s / p を入力してください）");
        }
    }
}
