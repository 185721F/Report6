package jp.ac.uryukyu.ie.e185721;

import java.util.Random;
import java.util.Scanner;
//Solverクラスには、2個以上の自作メソッドを含むこと。後述のクラス2に、1つ以上のユニットテストを書くこと。
//現地点ディーラーは三枚目も自動で引くのでスタート時点でバーストしているが気にしなくて良い
public class Blackjack {
    public static void main(String[] args){
        Scanner br = new Scanner(System.in);
            Random Toranpu = new Random();

            //Blackjackの条件ポイント
            int Blackjack_point_Player = 0;
            int Blackjack_point_Dealer = 0;
            //得点
            int Dealer_point = 0;
            int Player_point = 0;
            //カードを持てる回数
            int[] Dealer = new int[10];
            int[] Player = new int[10];

        for (int i=0;i<2;i++) {
            //ここの課題としてAを引いた場合に1or11かを判断しないといけないが一枚目で引いてしまった場合、普通は見えるもう一枚のカードを表示することができないのでどうにか表示できるようにしたい。
            //プレイヤーが引いたカード
            Player[i]=Toranpu.nextInt(13)+1;
            //jack.queen.kingを引いた場合の処理
            if (Player[i]>=10) {
                Player[i]=10;
                Blackjack_point_Player += 1;
            }
            //Aを引いた時の処理
            if (Player[i]==1) {
                System.out.print("Please select 1 or 11");
                Scanner serect = new Scanner(System.in);
                String number=serect.nextLine();
                if(number.equals("1")){
                    Player[i]=1;
                }
                if(number.equals("11")){
                    Player[i]=11;
                    Blackjack_point_Player += 2;
                }

            }
            System.out.println("Player"+i+1+"枚目のカード"+Player[i]);
            Player_point+=Player[i];
            if (Player_point>=22) {
                for (int l=0;l<=Player.length;l++) {
                    if (Player[l]==11) {
                        Player[l]=1;
                        Player_point-=10;
                    }
                }
            }
        }
        if(Blackjack_point_Player == 3){
            System.out.println("Player Blackjack");
        }
        for (int j=0;Dealer_point<17;j++) {
            Dealer[j]=Toranpu.nextInt(13)+1;
            if (Dealer[j]>=10) {
                Dealer[j]=10;
                Blackjack_point_Dealer += 1;
            }
            if (Dealer[j]==1) {
                //dealerがAを引いた場合は11を選ぶようにしている。
                    Dealer[j]=11;
                    Blackjack_point_Dealer += 2;
            }
            System.out.println("Dealer"+j+1+"枚目のカード"+Dealer[j]);
            Dealer_point+=Dealer[j];
            if(Dealer_point>=22) {
                System.out.println("Dealer burst");
                break;
            }
        }
        if(Blackjack_point_Dealer ==3){
            System.out.println("Dealer Blackjack");
        }

        for (int i=2;Player_point<22;i++) {
            //ディーラーとプレイヤーのポイントを表示
            System.out.println("The current dealer　score is "+Dealer_point+"point");
            System.out.println("The current player　score is "+Player_point+"point");
            //一枚追加する「Hit」か追加しない「Stand」を選ぶ
            System.out.println("Please enter ｢Hit」 if you draw a card, 「Stand」 if you do not draw");
            String str=br.nextLine();
            if (str.equals("Hit")) {
                Player[i]=Toranpu.nextInt(13)+1;
                if (Player[i]>=10) {
                    Player[i]=10;
                }
                if (Player[i]==1) {
                    System.out.print("Please select 1 or 11");
                    Scanner Hit = new Scanner(System.in);
                    String num=Hit.nextLine();
                    if(num.equals("1")){
                        Player[i]=1;
                    }
                    if(num.equals("11")){
                        Player[i]=11;
                    }
                }
                Player_point+=Player[i];
                if(Player_point>=22) {
                    System.out.println("Player burst");
                    break;
                }
            }
            if (str.equals("Stand")) break;
        }
        //試行の結果、どちらかがバーストした場合でも点数が高い方が勝ってしまったため、先にバーストの判断をして、していなければ点数の勝負で判断するという形にした。
        if(Dealer_point < 22 && Player_point > 21){
            System.out.println("Dealer wins");
        }else if(Dealer_point > 21 && Player_point < 22){
            System.out.println("Player wins");
        }else {
            if (Dealer_point < Player_point) {
                //ポイントがプレイヤーの方が高い
                System.out.println("Player wins");
            } else if (Dealer_point > Player_point) {
                //ポイントがディーラーの方が高い
                System.out.println("Dealer wins");
            } else if (Dealer_point == Player_point) {
                //双方が同じポイント
                System.out.println("Drow");
            } else if (Dealer_point > 21 && Player_point > 21) {
                //双方がバースト
                System.out.println("Dealer wins");
            } else if (Blackjack_point_Dealer == 3) {
                //DealerがBlackjackだった場合(確認済み)
                System.out.println("Dealer wins");
            } else if (Blackjack_point_Player == 3) {
                //PlayerがBlackjackだった場合(確認済み)
                System.out.println("Player wins");
            } else if (Blackjack_point_Dealer == Blackjack_point_Player) {
                //双方がBlackjackだった場合(確認済み)
                System.out.println("Drow");
            }
        }
    }
}


