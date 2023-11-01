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
        String args1 = "489\n" +
                "1 131562 GgDR3h1Xyy\n" +
                "1 383187 P/Hg3G9e\n" +
                "1 837058 ^4vL7a1v^g\n" +
                "1 674341 ?wgidh\n" +
                "18 674341 837058\n" +
                "18 131562 383187\n" +
                "20 131562\n" +
                "18 674341 837058\n" +
                "20 383187\n" +
                "2 837058 650547 SHGvGG!dNq 21 186781207 ReinforcedBottle 0.231\n" +
                "18 131562 837058\n" +
                "12 837058 SHGvGG!dNq\n" +
                "4 837058 377270 /MpITw8 3 175873391 CritEquipment 87\n" +
                "18 131562 674341\n" +
                "7 131562 887220 I4Fl2nB12 3 174618433\n" +
                "12 837058 SHGvGG!dNq\n" +
                "4 383187 530534 bE97oUpR5t 5 204064713 RegularEquipment\n" +
                "19 837058\n" +
                "18 674341 383187\n" +
                "19 837058\n" +
                "8 131562 887220\n" +
                "9 383187 530534\n" +
                "7 837058 291408 tx?sdqVmt20 5 145740604\n" +
                "7 131562 513184 3y/yf21 4 124196409\n" +
                "1 979853 iTYF+v\n" +
                "12 837058 SHGvGG!dNq\n" +
                "20 837058\n" +
                "20 674341\n" +
                "4 674341 573832 /MpITw8 0 165922655 EpicEquipment  0.728\n" +
                "18 837058 979853\n" +
                "9 383187 530534\n" +
                "21 674341 573832\n" +
                "11 837058 291408\n" +
                "11 131562 513184\n" +
                "19 674341\n" +
                "20 979853\n" +
                "20 131562\n" +
                "20 131562\n" +
                "1 855269 GpkdO&q\n" +
                "9 674341 573832\n" +
                "9 837058 377270\n" +
                "18 383187 855269\n" +
                "4 979853 19051 /MpITw8 5 199710251 EpicEquipment  0.545\n" +
                "20 383187\n" +
                "1 3917 itH84\n" +
                "19 674341\n" +
                "11 837058 291408\n" +
                "19 979853\n" +
                "2 674341 861762 tU&oyYd 59 165148994 RecoverBottle 0.827\n" +
                "19 674341\n" +
                "2 837058 633786 wfWbABE0f8 37 128354453 ReinforcedBottle 0.891\n" +
                "2 3917 236642 SHGvGG!dNq 17 179090929 RecoverBottle 0.955\n" +
                "19 131562\n" +
                "9 383187 530534\n" +
                "20 383187\n" +
                "20 3917\n" +
                "2 979853 296878 tU&oyYd 86 191283150 ReinforcedBottle 0.860\n" +
                "4 3917 62011 bE97oUpR5t 4 185174976 CritEquipment 75\n" +
                "9 383187 530534\n" +
                "19 855269\n" +
                "12 837058 SHGvGG!dNq\n" +
                "10 837058 650547\n" +
                "20 837058\n" +
                "18 383187 837058\n" +
                "20 837058\n" +
                "7 383187 788441 sX+pF89paO63 1 119987355\n" +
                "7 131562 959303 ue?PrGA64 1 199052074\n" +
                "10 979853 296878\n" +
                "4 131562 339457 bE97oUpR5t 3 118105591 CritEquipment 84\n" +
                "13 131562 ue?PrGA64\n" +
                "1 772019 1wtifY$Rz\n" +
                "9 674341 573832\n" +
                "9 131562 339457\n" +
                "2 3917 882437 tU&oyYd 14 125330973 RegularBottle\n" +
                "18 674341 855269\n" +
                "20 837058\n" +
                "11 837058 291408\n" +
                "18 3917 772019\n" +
                "11 131562 959303\n" +
                "7 131562 785128 bs45%B%Mq77 3 125341789\n" +
                "2 383187 975280 tU&oyYd 21 156935749 ReinforcedBottle 0.465\n" +
                "11 131562 785128\n" +
                "9 383187 530534\n" +
                "19 979853\n" +
                "4 3917 564106 L4aAiy 2 161331120 RegularEquipment\n" +
                "10 383187 975280\n" +
                "12 383187 tU&oyYd\n" +
                "1 21806 v6=kahh52V\n" +
                "10 3917 882437\n" +
                "1 597125 GdrEIcrc\n" +
                "19 597125\n" +
                "1 344975 C$ON$sH\n" +
                "19 383187\n" +
                "7 344975 791817 Gd3FwyiF91 1 176151319\n" +
                "2 3917 92190 SHGvGG!dNq 37 155315048 RegularBottle\n" +
                "9 979853 19051\n" +
                "18 3917 344975\n" +
                "3 979853 296878\n" +
                "20 597125\n" +
                "20 674341\n" +
                "13 837058 tx?sdqVmt20\n" +
                "2 674341 188920 wfWbABE0f8 15 152810922 RecoverBottle 0.917\n" +
                "1 715777 DT/2rCWm\n" +
                "21 383187 855269\n" +
                "19 597125\n" +
                "11 344975 791817\n" +
                "18 674341 855269\n" +
                "7 772019 247160 pwRGDpD105 3 172790881\n" +
                "2 344975 120357 tU&oyYd 69 117540576 RegularBottle\n" +
                "21 674341 573832\n" +
                "19 131562\n" +
                "7 837058 114990 Pu%&%0CUUm109 2 183109627\n" +
                "19 855269\n" +
                "2 855269 78842 SHGvGG!dNq 42 197566005 ReinforcedBottle 0.295\n" +
                "20 131562\n" +
                "2 131562 937046 wfWbABE0f8 94 183920117 ReinforcedBottle 0.613\n" +
                "3 855269 78842\n" +
                "3 837058 650547\n" +
                "2 3917 761307 tU&oyYd 94 117257595 ReinforcedBottle 0.812\n" +
                "2 597125 507686 SHGvGG!dNq 89 211372093 ReinforcedBottle 0.854\n" +
                "4 855269 433025 /MpITw8 3 127716649 RegularEquipment\n" +
                "9 674341 573832\n" +
                "17 837058\n" +
                "19 837058\n" +
                "17 979853\n" +
                "18 3917 855269\n" +
                "20 855269\n" +
                "4 131562 480298 L4aAiy 0 206307761 RegularEquipment\n" +
                "18 344975 21806\n" +
                "21 3917 92190\n" +
                "7 3917 788120 1ni%gp$an128 1 166460952\n" +
                "2 674341 758794 wfWbABE0f8 50 206748716 RegularBottle\n" +
                "17 3917\n" +
                "19 344975\n" +
                "21 674341 855269\n" +
                "18 837058 855269\n" +
                "12 597125 SHGvGG!dNq\n" +
                "6 3917 62011\n" +
                "20 715777\n" +
                "17 837058\n" +
                "18 674341 344975\n" +
                "18 3917 674341\n" +
                "16 837058\n" +
                "19 837058\n" +
                "7 837058 153666 DBQ%bE142 4 119558442\n" +
                "10 131562 937046\n" +
                "4 715777 435158 L4aAiy 3 124420023 RegularEquipment\n" +
                "12 837058 wfWbABE0f8\n" +
                "11 3917 788120\n" +
                "9 131562 480298\n" +
                "19 855269\n" +
                "9 131562 339457\n" +
                "12 131562 wfWbABE0f8\n" +
                "20 715777\n" +
                "17 855269\n" +
                "7 3917 358108 9?v^x153 4 165450821\n" +
                "7 855269 194840 WOf$E154 1 141531918\n" +
                "20 21806\n" +
                "4 131562 243856 L4aAiy 3 209182603 EpicEquipment  0.170\n" +
                "8 837058 153666\n" +
                "18 3917 979853\n" +
                "17 715777\n" +
                "16 131562\n" +
                "20 855269\n" +
                "7 855269 906431 WU^R^9lW3t162 3 198931198\n" +
                "13 344975 Gd3FwyiF91\n" +
                "17 772019\n" +
                "7 674341 839560 K%n!pea165 4 130931074\n" +
                "12 383187 tU&oyYd\n" +
                "15 2043/04\n" +
                "12 344975 tU&oyYd\n" +
                "17 344975\n" +
                "8 837058 114990\n" +
                "6 3917 564106\n" +
                "16 344975\n" +
                "6 3917 62011\n" +
                "2 674341 629917 tU&oyYd 46 171795082 RegularBottle\n" +
                "19 772019\n" +
                "9 3917 564106\n" +
                "2 3917 136370 wfWbABE0f8 32 143549619 RecoverBottle 0.897\n" +
                "19 21806\n" +
                "9 837058 377270\n" +
                "18 979853 855269\n" +
                "6 715777 435158\n" +
                "2 674341 808657 tU&oyYd 57 181039692 ReinforcedBottle 0.243\n" +
                "18 715777 3917\n" +
                "3 3917 236642\n" +
                "10 344975 120357\n" +
                "11 772019 247160\n" +
                "17 772019\n" +
                "18 837058 855269\n" +
                "15 2025/01\n" +
                "17 3917\n" +
                "15 2094/07\n" +
                "9 855269 433025\n" +
                "20 855269\n" +
                "21 131562 513184\n" +
                "19 979853\n" +
                "20 855269\n" +
                "15 2000/07\n" +
                "14 1 3 P/Hg3G9e\n" +
                "2000/01-P/Hg3G9e-tU&oyYd\n" +
                "2000/01-P/Hg3G9e-tU&oyYd\n" +
                "2000/01-P/Hg3G9e-tU&oyYd\n" +
                "12 344975 tU&oyYd\n" +
                "12 344975 tU&oyYd\n" +
                "17 855269\n" +
                "8 3917 788120\n" +
                "18 597125 855269\n" +
                "20 3917\n" +
                "18 715777 3917\n" +
                "19 383187\n" +
                "18 3917 344975\n" +
                "21 979853 855269\n" +
                "4 674341 790932 L4aAiy 1 138591522 EpicEquipment  0.798\n" +
                "19 837058\n" +
                "4 131562 119396 /MpITw8 4 129714905 EpicEquipment  0.818\n" +
                "7 674341 907159 Ghx1a8212 5 144565797\n" +
                "6 855269 433025\n" +
                "18 131562 855269\n" +
                "14 5 10 C$ON$sH v6=kahh52V P/Hg3G9e GpkdO&q 1wtifY$Rz\n" +
                "2000/02-GpkdO&q-SHGvGG!dNq\n" +
                "2000/02-C$ON$sH-tU&oyYd\n" +
                "2000/03-1wtifY$Rz-9^BW+oR\n" +
                "2000/03-1wtifY$Rz@#-wNMCk/\n" +
                "2000/03-1wtifY$Rz@#-qU8d2\n" +
                "2000/03-v6=kahh52V-Og!ia5V\n" +
                "2000/03-v6=kahh52V-Me9&DU6\n" +
                "2000/04-1wtifY$Rz@P/Hg3G9e-!itO1Z\n" +
                "2000/05-1wtifY$Rz-fhbM47T2=\n" +
                "2000/05-C$ON$sH@GpkdO&q-FYuN/9L8=\n" +
                "12 131562 wfWbABE0f8\n" +
                "6 383187 530534\n" +
                "6 131562 119396\n" +
                "21 131562 785128\n" +
                "16 855269\n" +
                "20 3917\n" +
                "11 383187 788441\n" +
                "20 3917\n" +
                "15 2000/05\n" +
                "9 383187 530534\n" +
                "7 383187 195193 N&x0bTGW226 4 150044002\n" +
                "9 3917 62011\n" +
                "16 772019\n" +
                "12 837058 wfWbABE0f8\n" +
                "17 131562\n";
        String args2 = "1 654011 opD5fE*b\n" +
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
        String args = args1 + args2;
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