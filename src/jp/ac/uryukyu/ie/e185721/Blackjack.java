package jp.ac.uryukyu.ie.e185721;

import java.util.Random;

//Solverクラスには、2個以上の自作メソッドを含むこと。後述のクラス2に、1つ以上のユニットテストを書くこと。
public class Blackjack {
    public static void main(String[] args){
            Random Toranpu = new Random();

            int Card = Toranpu.nextInt(13);
            int Dealer_point = 0;
            int Player_point = 0;
            int[] Dealer = new int[30];
            int[] Player = new int[30];

        for (int i=0;i<2;i++) {
            Player[i]=Toranpu.nextInt(13)+1;
            if (Player[i]>=10) {
                Player[i]=10;
            }
            if (Player[i]==1) {
                Player[i]=11;
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
        for (int i=2;Player_point<22;i++) {
            System.out.println("現在の点数は"+Player_point+"です。");
            System.out.println("もう一枚引くなら「ヒット」、引かないなら「スタンド」と入力してください");
            String str=br.readLine();
            if (str.equals("ヒット")) {
                Player[i]=Random.nextInt(13)+1;
                if (Player[i]>=10) {
                    Player[i]=10;
                }
                if (Player[i]==1) {
                    Player[i]=11;
                }
                Player_point+=Player[i];
                if(Player_point>=22) {
                    System.out.println("プレイヤーはバーストしました");
                    break;
                }
            }
            if (str.equals("スタンド")) break;
            for (int j=0;Dealer_point<17;j++) {
                Dealer[j]=Random.nextInt(13)+1;
                if (Dealer[j]>=10) {
                    Dealer[j]=10;
                }
                if (Dealer[j]==1) {
                    Dealer[j]=11;
                }
                Dealer_point+=Dealer[j];
                if(Dealer_point>=22) {
                    System.out.println("ディーラーはバーストしました");
                    break;
                }
            }
        }
        

