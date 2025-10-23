package kadai_021;

public class DictionaryExec_Chapter21 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

        // 辞書クラスのインスタンスを作成
        Dictionary_Chapter21 dict = new Dictionary_Chapter21();

        // 調べる英単語の配列
        String[] words = { "apple", "banana", "grape", "orange" };

        // 繰り返し処理で検索
        for (String word : words) {
            dict.searchWord(word);
        }
	}

}
