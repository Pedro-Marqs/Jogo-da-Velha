import java.util.Scanner;
import java.util.Random;

public class Jogo_Da_Velha {
    public static void main(String[] args) throws Exception {
        Scanner ler=new Scanner(System.in);
        Random gerador = new Random();
        String[][] jogo = new String[3][3];
        jogo[0][0] = "1"; jogo[0][1] = "2"; jogo[0][2] = "3";
        jogo[1][0] = "4"; jogo[1][1] = "5"; jogo[1][2] = "6";
        jogo[2][0] = "7"; jogo[2][1] = "8"; jogo[2][2] = "9";
        int i, l=0, c=0,posi, jogador = 1, rodada=0, modo;

        System.out.println("Digite 1 para jogar contra outro jogador ou 2 para jogar contra o computador");
        modo=ler.nextInt();
        for(int L=0;L==0;){
            if(modo<1||modo>2){
                System.out.println("Valor inválido, digite novamente");
                modo=ler.nextInt();
            } else{
                L=1;
            }
        }

        //Exibir tabuleiro
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(jogo[x][y]);
                System.out.print(" ");
            }
        System.out.println("");
        }

        //Laço para rodar até preencher todas as posições ou
        //alguém vencer
        for (i = 0; i == 0;) {
            System.out.println("Informe a posição que você deseja escolher");
            for(int k=0;k==0;){ //Escolher posição
                if(jogador==1){
                    //posição do jogador 1
                    posi = ler.nextInt();
                } else{
                    //posição do jogador 2(Pessoa ou PC)
                    //Pessoa
                    if(modo==1){
                        posi = ler.nextInt();
                    } else{//PC
                        //gerar número aleatório
                        posi = 1 + gerador.nextInt(9);
                    }
                }
                if(posi>=1&&posi<=9){
                    //posição escolhida no tabuleiro
                    switch (posi) {
                        case 1:
                            l=0;
                            c=0;
                            break;
                        case 2:
                            l=0;
                            c=1;
                            break;
                        case 3:
                            l=0;
                            c=2;
                            break;
                        case 4:
                            l=1;
                            c=0;
                            break;
                        case 5:
                            l=1;
                            c=1;
                            break;
                        case 6:
                            l=1;
                            c=2;
                            break;
                        case 7:
                            l=2;
                            c=0;
                            break;
                        case 8:
                            l=2;
                            c=1;
                            break;
                        case 9:
                            l=2;
                            c=2;
                            break;
                        default:
                            break;
                    }
                    //se k for != de X ou O significa que a posição pode ser
                    //escolhida
                    if(jogo[l][c]!="X"||jogo[l][c]!="O"){
                        k=1;
                    }
                } else{
                    System.out.println("Posição inválida");
                    System.out.println("Digite novamente");
                }
            }
            
            //alterna entre jogador 1 e 2
            if (jogador == 1) {
                jogo[l][c] = "X";
                jogador = 2;
            } else {
                jogo[l][c] = "O";
                jogador = 1;
            }

            //exibe o tabuleiro
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    System.out.print(jogo[x][y]);
                    System.out.print(" ");
                }
                System.out.println("");
            }
            //verifica se houve uma linha completa
            if (jogo[0][0] == jogo[0][1] && jogo[0][0] == jogo[0][2] && jogo[0][0] != null ||//L1
                jogo[1][0] == jogo[1][1] && jogo[1][0] == jogo[1][2] && jogo[1][0] != null ||//L2
                jogo[2][0] == jogo[2][1] && jogo[2][0] == jogo[2][2] && jogo[2][0] != null ||//L3
                jogo[0][0] == jogo[1][0] && jogo[0][0] == jogo[2][0] && jogo[0][0] != null ||//C1
                jogo[0][1] == jogo[1][1] && jogo[0][1] == jogo[2][1] && jogo[0][1] != null ||//C2
                jogo[0][2] == jogo[1][2] && jogo[0][2] == jogo[2][2] && jogo[0][2] != null ||//C3
                jogo[0][0] == jogo[1][1] && jogo[0][0] == jogo[2][2] && jogo[0][0] != null ||//D1
                jogo[0][2] == jogo[1][1] && jogo[0][2] == jogo[2][0] && jogo[0][2] != null) {//D2
                i = 1;//se i!=0 para de repetir
            } else{//analisa se deu velha
                for(int x=0;x<3;x++){//analisa quantas rodadas já foram
                    for(int y=0;y<3;y++){
                        if(jogo[x][y]=="O"||jogo[x][y]=="X"){
                            rodada++;
                        }
                    }
                }
                if(rodada==9){
                    i=1;
                } else{
                    rodada=0;
                }
            }
        }
        System.out.println("Fim de jogo");
        if(rodada==9){
            System.out.println("Empate");
        } else if (jogador == 2) {
            System.out.println("X venceu!!!");
        } else{
            System.out.println("O venceu!!!");
        }
    }
}
