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
        