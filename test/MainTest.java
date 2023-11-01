import org.junit.Test;
import org.junit.Before;


import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private HashMap<Integer, Adventurer> adventurersMap;
//    private ArrayList<ArrayList <String>> inputInfo;
    @Before
    public void setUp() {
        adventurersMap = new HashMap<>();
//        inputInfo = new ArrayList<>();
    }

    @Test
    public void main() {
        String args = "256\n" +
                "1 654011 opD5fE*b\n" +
                "1 925582 qkf$u?Z?b1\n" +
                "1 268338 Ke7ge+\n" +
                "13 925582 Cg^V6IlAid\n" +
                "2 654011 984448 i=3pSY3h7 74 2799542 RegularBottle\n" +
                "7 268338 361416 vNabIE 3 2531501\n" +
                "2 925582 300848 i=3pSY3h7 63 2383462 RecoverBottle 0.990\n" +
                "7 654011 974459 Cg^V6IlAid 4 2077501\n" +
                "2 268338 474499 VfHMNPyD 69 2909112 RegularBottle\n" +
                "20 925582\n" +
                "3 925582 300848\n" +
                "4 925582 772837 e!1F?? 1 2558080 RegularEquipment\n" +
                "7 654011 966601 7kPMQ 4 2241496\n" +
                "4 654011 633413 IR^3L*Ktc! 3 2316500 CritEquipment 75\n" +
                "2 268338 12526 &+^1/ 36 2479571 RegularBottle\n" +
                "18 268338 925582\n" +
                "2 268338 645165 &+^1/ 45 2453879 ReinforcedBottle 0.422\n" +
                "2 925582 921806 &+^1/ 87 2491460 RegularBottle\n" +
                "4 925582 383748 IR^3L*Ktc! 5 2309693 RegularEquipment\n" +
                "12 268338 VfHMNPyD\n" +
                "13 268338 Cg^V6IlAid\n" +
                "12 925582 i=3pSY3h7\n" +
                "10 654011 984448\n" +
                "2 654011 142841 &+^1/ 91 2311667 RecoverBottle 0.353\n" +
                "7 268338 697327 Cg^V6IlAid 4 2585273\n" +
                "2 925582 174803 VfHMNPyD 66 2969459 RecoverBottle 0.590\n" +
                "19 268338\n" +
                "7 925582 267477 vNabIE 3 2277862\n" +
                "7 654011 555307 Cg^V6IlAid 3 2409990\n" +
                "5 925582 383748\n" +
                "4 654011 11417 e!1F?? 4 2398284 CritEquipment 94\n" +
                "7 268338 300988 vNabIE 2 2847575\n" +
                "7 925582 563956 Cg^V6IlAid 2 2222789\n" +
                "3 654011 142841\n" +
                "2 268338 745184 i=3pSY3h7 44 2656310 RecoverBottle 0.125\n" +
                "4 268338 904557 e!1F?? 2 2752477 RegularEquipment\n" +
                "2 925582 338406 VfHMNPyD 88 2520961 ReinforcedBottle 0.645\n" +
                "7 268338 578309 Cg^V6IlAid 5 2858991\n" +
                "4 925582 594088 IR^3L*Ktc! 5 2532784 CritEquipment 98\n" +
                "2 654011 823138 &+^1/ 45 2742881 RecoverBottle 0.286\n" +
                "7 925582 729491 Cg^V6IlAid 5 2105334\n" +
                "22 925582\n" +
                "22 654011\n" +
                "2 925582 4442 VfHMNPyD 87 2833077 RecoverBottle 0.319\n" +
                "20 654011\n" +
                "11 925582 563956\n" +
                "12 925582 i=3pSY3h7\n" +
                "2 925582 521150 &+^1/ 65 2362107 RegularBottle\n" +
                "13 925582 vNabIE\n" +
                "2 654011 156568 i=3pSY3h7 60 2725926 RegularBottle\n" +
                "20 654011\n" +
                "4 268338 232749 IR^3L*Ktc! 2 2312611 CritEquipment 89\n" +
                "13 268338 7kPMQ\n" +
                "2 925582 912667 &+^1/ 60 2338429 RegularBottle\n" +
                "7 654011 416202 vNabIE 5 2172878\n" +
                "4 268338 322432 e!1F?? 5 2260423 CritEquipment 82\n" +
                "4 654011 497769 IR^3L*Ktc! 4 2034279 CritEquipment 69\n" +
                "10 654011 156568\n" +
                "6 268338 322432\n" +
                "13 925582 vNabIE\n" +
                "19 268338\n" +
                "2 268338 207402 &+^1/ 13 2477033 RecoverBottle 0.047\n" +
                "8 268338 578309\n" +
                "13 268338 7kPMQ\n" +
                "7 925582 517432 7kPMQ 1 2450228\n" +
                "7 268338 742418 vNabIE 4 2355829\n" +
                "2 654011 729485 i=3pSY3h7 58 2502975 RegularBottle\n" +
                "22 268338\n" +
                "11 925582 517432\n" +
                "4 925582 124593 iF41SO/RSq 3 2305694 RegularEquipment\n" +
                "7 925582 212179 7kPMQ 5 2456186\n" +
                "22 654011\n" +
                "2 654011 818787 i=3pSY3h7 87 2032061 RecoverBottle 0.230\n" +
                "14 3 9 qkf$u?Z?b1 Ke7ge+ opD5fE*b\n" +
                "2001/01-Ke7ge+-&+^1/\n" +
                "2001/01-Ke7ge+-&+^1/\n" +
                "2001/01-Ke7ge+@#-IR^3L*Ktc!\n" +
                "2001/01-opD5fE*b@#-IR^3L*Ktc!\n" +
                "2001/01-opD5fE*b-&+^1/\n" +
                "2002/01-Ke7ge+@opD5fE*b-IR^3L*Ktc!\n" +
                "2002/02-qkf$u?Z?b1-&+^1/\n" +
                "2003/02-Ke7ge+-&+^1/\n" +
                "2004/02-Ke7ge+@opD5fE*b-e!1F??\n" +
                "4 654011 835674 e!1F?? 4 2935821 RegularEquipment\n" +
                "2 925582 134603 VfHMNPyD 35 2602473 ReinforcedBottle 0.109\n" +
                "4 654011 581354 e!1F?? 4 2693339 CritEquipment 64\n" +
                "7 925582 812776 vNabIE 2 2296337\n" +
                "23 654011 856154 IR^3L*Ktc! EpicEquipment 0.586\n" +
                "7 925582 107869 vNabIE 2 2157034\n" +
                "4 654011 864768 e!1F?? 2 2604805 RegularEquipment\n" +
                "4 654011 497663 e!1F?? 1 2401802 CritEquipment 82\n" +
                "2 925582 628898 &+^1/ 38 2584724 RegularBottle\n" +
                "2 925582 836334 i=3pSY3h7 86 2317787 RecoverBottle 0.124\n" +
                "4 925582 271719 e!1F?? 5 2784980 EpicEquipment 0.875\n" +
                "5 925582 772837\n" +
                "7 654011 804956 Cg^V6IlAid 5 2075963\n" +
                "18 268338 654011\n" +
                "13 654011 Cg^V6IlAid\n" +
                "2 925582 91083 &+^1/ 40 2944376 RecoverBottle 0.037\n" +
                "5 268338 322432\n" +
                "11 925582 563956\n" +
                "10 654011 818787\n" +
                "22 654011\n" +
                "22 925582\n" +
                "7 268338 879798 7kPMQ 4 2267131\n" +
                "4 654011 148274 e!1F?? 4 2158614 EpicEquipment 0.724\n" +
                "7 654011 773309 7kPMQ 3 2208849\n" +
                "20 268338\n" +
                "18 654011 925582\n" +
                "21 654011 823138\n" +
                "7 654011 945643 Cg^V6IlAid 3 2622597\n" +
                "8 654011 974459\n" +
                "10 654011 823138\n" +
                "7 925582 251288 7kPMQ 2 2884918\n" +
                "9 654011 497769\n" +
                "2 268338 359702 &+^1/ 82 2834460 RecoverBottle 0.417\n" +
                "7 654011 735419 Cg^V6IlAid 1 2348922\n" +
                "13 925582 7kPMQ\n" +
                "7 268338 505142 7kPMQ 4 2452438\n" +
                "8 268338 300988\n" +
                "7 925582 572888 vNabIE 1 2334881\n" +
                "10 654011 823138\n" +
                "7 268338 709452 7kPMQ 3 2879804\n" +
                "2 925582 680977 &+^1/ 22 2472022 RegularBottle\n" +
                "18 268338 925582\n" +
                "7 654011 42800 7kPMQ 1 2377309\n" +
                "4 925582 863445 e!1F?? 4 2751336 EpicEquipment 0.259\n" +
                "4 654011 170519 e!1F?? 4 2829265 RegularEquipment\n" +
                "7 268338 268604 Cg^V6IlAid 5 2693680\n" +
                "4 268338 332220 e!1F?? 2 2549823 RegularEquipment\n" +
                "2 925582 156957 i=3pSY3h7 98 2662915 RecoverBottle 0.499\n" +
                "22 925582\n" +
                "5 268338 232749\n" +
                "2 925582 608816 i=3pSY3h7 18 2528188 RegularBottle\n" +
                "4 654011 861530 IR^3L*Ktc! 5 2348567 CritEquipment 71\n" +
                "5 925582 124593\n" +
                "2 268338 425396 i=3pSY3h7 22 2959505 ReinforcedBottle 0.098\n" +
                "2 925582 880663 VfHMNPyD 83 2018465 ReinforcedBottle 0.106\n" +
                "8 925582 267477\n" +
                "2 925582 939748 VfHMNPyD 10 2124722 ReinforcedBottle 0.612\n" +
                "14 3 10 qkf$u?Z?b1 Ke7ge+ opD5fE*b\n" +
                "2004/02-Ke7ge+@#-IR^3L*Ktc!\n" +
                "2004/02-Ke7ge+-&+^1/\n" +
                "2005/02-Ke7ge+@qkf$u?Z?b1-e!1F??\n" +
                "2005/03-opD5fE*b-i=3pSY3h7\n" +
                "2005/03-qkf$u?Z?b1@Ke7ge+-e!1F??\n" +
                "2005/03-opD5fE*b@Ke7ge+-e!1F??\n" +
                "2005/03-qkf$u?Z?b1-&+^1/\n" +
                "2005/03-qkf$u?Z?b1@Ke7ge+-IR^3L*Ktc!\n" +
                "2005/03-opD5fE*b@Ke7ge+-iF41SO/RSq\n" +
                "2005/03-qkf$u?Z?b1@#-iF41SO/RSq\n" +
                "4 925582 985970 IR^3L*Ktc! 5 2197057 CritEquipment 69\n" +
                "2 268338 731882 i=3pSY3h7 27 2664918 RecoverBottle 0.846\n" +
                "21 654011 42800\n" +
                "2 268338 766366 VfHMNPyD 89 2757706 RecoverBottle 0.485\n" +
                "2 268338 487694 VfHMNPyD 67 2575107 RegularBottle\n" +
                "2 654011 407995 VfHMNPyD 42 2240794 RecoverBottle 0.653\n" +
                "4 654011 104926 IR^3L*Ktc! 3 2769855 CritEquipment 64\n" +
                "23 654011 919197 IR^3L*Ktc! CritEquipment 69\n" +
                "5 654011 856154\n" +
                "5 268338 332220\n" +
                "7 925582 605010 vNabIE 3 2695919\n" +
                "7 654011 841496 7kPMQ 1 2594713\n" +
                "12 268338 VfHMNPyD\n" +
                "13 268338 vNabIE\n" +
                "8 654011 804956\n" +
                "6 654011 835674\n" +
                "4 654011 333195 iF41SO/RSq 2 2117739 EpicEquipment 0.579\n" +
                "13 925582 7kPMQ\n" +
                "13 268338 Cg^V6IlAid\n" +
                "11 654011 841496\n" +
                "7 925582 948896 Cg^V6IlAid 4 2190110\n" +
                "4 925582 578760 IR^3L*Ktc! 5 2091203 CritEquipment 95\n" +
                "2 268338 229627 VfHMNPyD 42 2527837 RegularBottle\n" +
                "2 268338 411460 &+^1/ 26 2645433 RegularBottle\n" +
                "7 654011 622881 Cg^V6IlAid 2 2348097\n" +
                "19 925582\n" +
                "19 925582\n" +
                "21 268338 879798\n" +
                "4 654011 29930 iF41SO/RSq 1 2412437 CritEquipment 95\n" +
                "2 925582 161888 VfHMNPyD 97 2231377 ReinforcedBottle 0.157\n" +
                "4 654011 717927 iF41SO/RSq 4 2761000 EpicEquipment 0.679\n" +
                "4 925582 639718 iF41SO/RSq 4 2554751 EpicEquipment 0.252\n" +
                "4 925582 700213 iF41SO/RSq 4 2455873 EpicEquipment 0.180\n" +
                "2 654011 257436 i=3pSY3h7 92 2521987 ReinforcedBottle 0.578\n" +
                "7 925582 898846 vNabIE 5 2849433\n" +
                "9 654011 861530\n" +
                "4 268338 779331 iF41SO/RSq 4 2381139 EpicEquipment 0.208\n" +
                "7 654011 395866 vNabIE 2 2944994\n" +
                "8 925582 212179\n" +
                "4 268338 310730 iF41SO/RSq 4 2822578 RegularEquipment\n" +
                "2 654011 280841 VfHMNPyD 72 2963653 RegularBottle\n" +
                "4 925582 739401 e!1F?? 5 2079210 RegularEquipment\n" +
                "7 654011 873545 Cg^V6IlAid 5 2903268\n" +
                "4 925582 604107 IR^3L*Ktc! 5 2249170 CritEquipment 100\n" +
                "4 654011 676961 iF41SO/RSq 1 2923134 RegularEquipment\n" +
                "5 268338 779331\n" +
                "7 268338 61229 Cg^V6IlAid 4 2453771\n" +
                "4 654011 859864 e!1F?? 3 2531696 RegularEquipment\n" +
                "23 654011 787896 TGYgCtNFM Food\n" +
                "7 268338 119413 Cg^V6IlAid 5 2027911\n" +
                "7 925582 474337 7kPMQ 1 2029815\n" +
                "2 654011 546494 &+^1/ 91 2228748 ReinforcedBottle 0.177\n" +
                "2 268338 183370 i=3pSY3h7 71 2097273 ReinforcedBottle 0.755\n" +
                "7 654011 944577 vNabIE 2 2428752\n" +
                "11 268338 61229\n" +
                "6 654011 676961\n" +
                "2 654011 204219 &+^1/ 90 2099938 ReinforcedBottle 0.285\n" +
                "8 654011 622881\n" +
                "7 268338 349914 Cg^V6IlAid 3 2568234\n" +
                "12 654011 VfHMNPyD\n" +
                "2 925582 391901 VfHMNPyD 41 2959322 RegularBottle\n" +
                "2 654011 248457 i=3pSY3h7 99 2841711 RecoverBottle 0.391\n" +
                "10 268338 229627\n" +
                "7 268338 455550 Cg^V6IlAid 2 2099730\n" +
                "12 654011 VfHMNPyD\n" +
                "4 268338 950133 iF41SO/RSq 5 2953987 CritEquipment 62\n" +
                "10 268338 359702\n" +
                "2 925582 874187 i=3pSY3h7 86 2207411 ReinforcedBottle 0.529\n" +
                "19 654011\n" +
                "4 925582 988230 e!1F?? 5 2531696 RegularEquipment\n" +
                "8 925582 729491\n" +
                "7 654011 721614 vNabIE 3 2957857\n" +
                "13 654011 vNabIE\n" +
                "4 268338 250054 IR^3L*Ktc! 5 2122638 CritEquipment 79\n" +
                "7 654011 516177 vNabIE 1 2744427\n" +
                "7 925582 426266 vNabIE 5 2674037\n" +
                "2 268338 454146 VfHMNPyD 65 2247749 ReinforcedBottle 0.595\n" +
                "6 654011 29930\n" +
                "7 654011 411067 Cg^V6IlAid 4 2566374\n" +
                "4 654011 733319 e!1F?? 5 2395406 EpicEquipment 0.875\n" +
                "4 268338 369039 iF41SO/RSq 1 2151049 EpicEquipment 0.922\n" +
                "2 268338 977173 &+^1/ 66 2959118 RegularBottle\n" +
                "2 654011 548101 VfHMNPyD 69 2982384 RecoverBottle 0.470\n" +
                "4 654011 562358 IR^3L*Ktc! 3 2662748 EpicEquipment 0.985\n" +
                "7 925582 456531 vNabIE 2 2594025\n" +
                "2 654011 14908 i=3pSY3h7 10 2444805 RegularBottle\n" +
                "13 925582 7kPMQ\n" +
                "4 268338 76316 IR^3L*Ktc! 4 2079084 CritEquipment 85\n" +
                "4 925582 80858 e!1F?? 3 2170465 CritEquipment 78\n" +
                "2 268338 14925 &+^1/ 99 2014950 RegularBottle\n" +
                "5 654011 333195\n" +
                "2 268338 710087 i=3pSY3h7 37 2290063 RegularBottle\n" +
                "2 925582 223881 VfHMNPyD 22 2183928 RecoverBottle 0.853\n" +
                "4 925582 408852 e!1F?? 1 2665343 RegularEquipment\n" +
                "10 268338 977173\n" +
                "4 654011 586807 e!1F?? 3 2084863 CritEquipment 65\n" +
                "4 654011 855691 e!1F?? 5 2909234 EpicEquipment 0.189\n" +
                "7 268338 248808 7kPMQ 4 2911110\n" +
                "11 268338 61229\n" +
                "7 925582 450149 Cg^V6IlAid 3 2176814\n" +
                "19 654011\n" +
                "2 268338 450718 VfHMNPyD 38 2152416 RecoverBottle 0.449\n" +
                "2 925582 394887 VfHMNPyD 67 2870672 RegularBottle\n" +
                "8 654011 945643\n" +
                "8 654011 944577\n" +
                "2 654011 892253 i=3pSY3h7 42 2368725 ReinforcedBottle 0.504\n" +
                "2 654011 159672 &+^1/ 50 2355660 RecoverBottle 0.444\n" +
                "2 925582 388525 i=3pSY3h7 26 2008953 RegularBottle\n" +
                "4 268338 43956 IR^3L*Ktc! 4 2005768 RegularEquipment\n" +
                "11 268338 455550\n" +
                "4 268338 454058 e!1F?? 3 2326983 EpicEquipment 0.315\n" +
                "5 268338 43956\n" +
                "12 268338 VfHMNPyD\n" +
                "4 654011 576155 e!1F?? 4 2251626 RegularEquipment\n" +
                "8 268338 742418\n" +
                "4 925582 944427 e!1F?? 4 2817323 RegularEquipment\n" +
                "7 268338 295000 vNabIE 3 2904194\n" +
                "5 925582 271719\n" +
                "12 925582 &+^1/\n" +
                "7 925582 368057 7kPMQ 2 2147388\n" +
                "20 654011\n" +
                "23 654011 749714 IR^3L*Ktc! RegularEquipment\n" +
                "12 268338 VfHMNPyD\n" +
                "23 925582 128236 FxadboHFc Food\n";

        ByteArrayInputStream in = new ByteArrayInputStream(args.getBytes());
        System.setIn(in);

        Main.main(new String[] {});
    }

    @Test
    public void operation() {

    }

    @Test
    public void adventurerAdd() {
    }

    @Test
    public void bottleAdd() {
    }

    @Test
    public void bottleDelete() {
    }

    @Test
    public void equipmentAdd() {
    }

    @Test
    public void equipmentDelete() {
    }

    @Test
    public void equipmentUpgrade() {
    }

    @Test
    public void foodAdd() {
    }

    @Test
    public void foodDelete() {
    }

    @Test
    public void equipmentCarry() {
    }

    @Test
    public void bottleCarry() {
    }

    @Test
    public void foodCarry() {
    }

    @Test
    public void bottleUse() {
    }

    @Test
    public void foodUse() {
    }
}