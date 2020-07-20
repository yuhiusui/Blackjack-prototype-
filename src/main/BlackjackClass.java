package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BlackjackClass {
	public static void main(String[] args) {
		System.out.println("ゲームを開始します");
//		山札作成
		List <Integer> deck = new ArrayList<>(52);

//		山札をシャッフル
		Collections.shuffle(deck);

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
		System.out.println("あなたの1枚目のカードは" + toDescription(player.get(0)));
		System.out.println("ディーラーの1枚目のカードは" + toDescription(dealer.get(0)));
		System.out.println("あなたの2枚めのカードは" + toDescription(player.get(1)));
		System.out.println("ディーラーの2枚めのカードは秘密です。");

//		ポイントを集計
		int playerPoint = sumPoint(player);
		int dealerPoint = sumPoint(dealer);
		System.out.println("あなたの現在のポイントは" + playerPoint + "です。" );

//		プレイヤーのドローフェーズ
		while(true) {
			System.out.print("カードを引きますか y or n");
			Scanner scan = new Scanner(System.in);
            String str = scan.next();

			if("n".contentEquals(str)) {
				break;
			} else if("y".contentEquals(str)) {
				player.add(deck.get(deckCount));
				deckCount++;
				playerHands++;
			} else {
				System.out.println("あなたの入力は" + str + " です。y か n を入力してください。");
			}
		}

//		ディーラーのドローフェーズ(17以上になったらストップ)
		while(true) {
			if (dealerPoint >= 17) {
				break;
			} else {
				dealer.add(deck.get(deckCount));
				deckCount++;
			}

			dealerPoint = sumPoint(dealer);

			if(isBusted(dealerPoint)) {
				System.out.println("ディーラーがバーストしました。あなたの勝利です");
				return;
			}
		}
//		ポイントを比較する
		System.out.println("あなたのポイントは"+playerPoint);
		System.out.println("ディーラーのポイントは"+dealerPoint);

		if (playerPoint == dealerPoint) {
			System.out.println("引き分けです。");
		} else if(playerPoint > dealerPoint) {
		    System.out.println("勝ちました！");
		} else {
		    System.out.println("負けました・・・");
		}
	}

//		山札に値を入れ、シャッフルするメソッド
	private static void shuffleDeck(List<Integer>deck) {
		for(int i = 1; i <= 52; i++) {
			deck.add(i);
		}
		Collections.shuffle(deck);
	}

//	手札がバーストしているか判定するメソッド
	private static boolean isBusted(int point) {
		if (point <= 21) {
			return false;
		} else {
			return true;
		}
	}

//	現在の合計ポイントを計算するメソッド
	private static int sumPoint(List<Integer> list) {
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum = sum + toPoint(toNumber(list.get(i)));
		}

		return sum;
	}

//	山札の通し番号を得点計算用のポイントに変換するメソッド.J/Q/Kは10とする
    private static int toPoint(int num) {
    	if (num == 11 || num ==12 || num == 13) {
    		num = 10;
    	}

    	return num;
    }



//    山札の数を（スート）の（ランク）の文字列に置き換えるメソッド
    private static String toDescription(int cardNumber) {
    	String rank = toRank(toNumber(cardNumber));
        String suit = toSuit(cardNumber);

        return suit + "の" + rank;
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
