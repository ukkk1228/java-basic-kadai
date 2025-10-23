package kadai_021;

import java.util.HashMap;
import java.util.Map;

public class Dictionary_Chapter21 {

    // 英単語と意味を保持するHashMap
    private Map<String, String> dictionary = new HashMap<>();

    // コンストラクタで辞書データを登録
    public Dictionary_Chapter21() {
        dictionary.put("apple", "りんご");
        dictionary.put("peach", "桃");
        dictionary.put("banana", "バナナ");
        dictionary.put("lemon", "レモン");
        dictionary.put("pear", "梨");
        dictionary.put("kiwi", "キウィ");
        dictionary.put("strawberry", "いちご");
        dictionary.put("grape", "ぶどう");
        dictionary.put("muscat", "マスカット");
        dictionary.put("cherry", "さくらんぼ");
    }

    // 英単語の意味を調べて出力するメソッド
    public void searchWord(String word) {
        String meaning = dictionary.get(word);

        if (meaning != null) {
            System.out.println(word + "の意味は" + meaning);
        } else {
            System.out.println(word + "は辞書に存在しません");
        }
    }
}
