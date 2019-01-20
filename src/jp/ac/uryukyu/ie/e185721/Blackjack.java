package jp.ac.uryukyu.ie.e185721;

import java.util.Random;
import java.util.Scanner;
//Solverクラスには、2個以上の自作メソッドを含むこと。後述のクラス2に、1つ以上のユニットテストを書くこと。
//現地点ディーラーは三枚目も自動で引くのでスタート時点でバーストしているが気にしなくて良い
public class Blackjack {
    public static void main(String[] args){
        Scanner br = new Scanner(System.in);
            Random Toranpu = new Random();


            int Blackjack_point_Player = 0;
            int Blackjack_point_Dealer = 0;
            String win = "Blackjack";
            int Dealer_point = 0;
            int Player_point = 0;
            int[] Dealer = new int[30];
            int[] Player = new int[30];

        for (int i=0;i<2;i++) {
            //プレイヤーが引いたカード
            Player[i]=Toranpu.nextInt(13)+1;
            //jack.queen.kingを引いた場合の処理
            if (Player[i]>=10) {
                Player[i]=10;
                Blackjack_point_Player += 1;
            }
            if (Player[i]==1) {
                Scanner serect = new Scanner(System.in);
                String number=serect.nextLine();
                //Aを引いた時の処理
                System.out.print("Please select 1 or 11");
                if(number.equals("1")){
                    Player[i]=1;
                }
                if(number.equals("11")){
                    Player[i]=11;
                    Blackjack_point_Player += 2;
                }

            }
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
                System.out.print("Please select 1 or 11");
                Scanner serect = new Scanner(System.in);
                String number=serect.nextLine();
                if(number.equals("1")){
                    Dealer[j]=1;
                }
                if(number.equals("11")){
                    Dealer[j]=11;
                    Blackjack_point_Dealer += 2;
                }
            }
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
                    Player[i]=11;
                }
                Player_point+=Player[i];
                if(Player_point>=22) {
                    System.out.println("Player burst");
                    break;
                }
            }
            if (str.equals("Stand")) break;
        }
        if (Dealer_point > 21 && Player_point < 22) {
            //ディーラーがバースト
            System.out.println("Player wins");
        }else if (Dealer_point < Player_point) {
            //ポイントがプレイヤーの方が高い
            System.out.println("Player wins");
        }else if (Dealer_point > Player_point) {
            //ポイントがディーラーの方が高い
            System.out.println("Dealer wins");
        }else if (Dealer_point < 22 && Player_point> 21) {
            //プレイヤーがバースト
            System.out.println("Dealer wins");
        } else if (Dealer_point == Player_point) {
            //双方が同じポイント
            System.out.println("Drow");
        }else if(Dealer_point > 21&& Player_point >21){
            //双方がバースト
            System.out.println("Dealer wins");
        }
    }
}


