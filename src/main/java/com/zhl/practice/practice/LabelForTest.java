package com.zhl.practice.practice;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-01 10:26
 **/
public class LabelForTest {

    public static void main(String[] args) {
                 int i = 0;
                 outer:
                 for(; true ;) {
                             inner:
                             for(; i < 10; i++) {
                                     prt("i = " + i);
                                     if(i == 2) {
                                            prt("continue");
                                            continue;
                                         }
                                     if(i == 3) {
                                            prt("break");
                                            i++;
                                            break;
                                         }
                                     if(i == 7) {
                                             prt("continue outer");
                                             i++;
                                             continue outer;
                                         }
                                     if(i == 8) {
                                              prt("break outer");
                                              break outer;
                                         }
                                     for(int k = 0; k < 5; k++) {
                                             if(k == 3) {
                                                      prt("continue inner");
                                                      continue inner;
                                                 }
                                         }
                                }
                       } }
     static void prt(String s) { System.out.println(s); }
}
