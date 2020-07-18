package net.sejuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlackjackClass {
	public static void main(String[] args) {
		System.out.println("ゲームを開始します");
//		山札作成
		List <Integer> deck = new ArrayList<>(52);

//		山札をシャッフル

//		プレイヤー・ディーラーの手札リストを作成
		List <Integer> player = new ArrayList<>();
		List <Integer> dealer = new ArrayList<>();

//		互いにカードを二枚引く
		player.add(deck.get(0));
		dealer.add(deck.get(1));
		player.add(deck.get(2));
		dealer.add(deck.get(3));

//		deckCount:山札の進行状況を記録する
		int deckCount = 4;

//		プレイヤーの手札枚数を記録する変数playerHandsを定義
		int playerHands = 2;

//		手札のポイントを表示

//		ポイントを集計

//		プレイヤーのドローフェーズ

//		ディーラーのドローフェーズ(17以上になったらストップ)

//		ポイントを比較する
	}

//		山札に値を入れ、シャッフルするメソッド
	private static void shuffleDeck(List<Integer>deck) {
//		リストに1-52の連番を代入
		for(int i = 1; i <= 52; i++) {
			deck.add(i);
		}
//		山札をシャッフル
		Collections.shuffle(deck);
	}

//	手札がバーストしているか判定するメソッド
	private static boolean isBusted(int point) {

	}

//	現在の合計ポイントを計算するメソッド
	private static int sumPoint(List<Integer> list) {

	}

//	山札の通し番号を得点計算用のポイントに変換するメソッド.J/Q/Kは10とする
    private static int toPoint(int num) {

    }



//    山札の数を（スート）の（ランク）の文字列に置き換えるメソッド
    private static String toDescription(int cardNumber) {

   }


//    山札の数をカードの数に置き換えるメソッド
    private static int toNumber(int cardNumber) {
    	int number = cardNumber % 13;
    	if(number ==0) {
    		number = 13;
    	}

    	return number;
    }

//    カード番号をランク（AやJ,Q,K）に変換するメソッド
    private static String toRank(int number) {
    	switch(number) {
        case 1:
            return "A";
        case 11:
            return "J";
        case 12:
            return "Q";
        case 13:
            return "K";
        default:
            String str = String.valueOf(number);
            return str;
        }
    }

//   山札の数をスート（ハートやスペードなどのマーク）に置き換えるメソッド
    private static String toSuit(int cardNumber) {
    	switch((cardNumber - 1)/13) {
    	case 0:
    		return "クラブ";
    	case 1:
    		return "ダイヤ";
    	case 2:
    		return "ハート";
    	case 3:
    	 	return "スペード";
    	default:
    		return "例外です";
    	}
    }
}
