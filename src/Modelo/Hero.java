package Modelo;

import Auxiliar.Desenho;
import java.io.Serializable;

public class Hero extends Personagem implements Serializable{
    
    public int iContaIntervalos;
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.ehHeroi = true ;
        this.bMortal = true ;
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
    
    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }

    /*TO-DO: este metodo pode ser interessante a todos os personagens que se movem*/
    private boolean validaPosicao(){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao())) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;       
    }
    
    public boolean moveUp() {
        if(super.moveUp())
            return validaPosicao();
        return false;
    }

    public boolean moveDown() {
        if(super.moveDown())
            return validaPosicao();
        return false;
    }

    public boolean moveRight() {
        if(super.moveRight())
            return validaPosicao();
        return false;
    }

    public boolean moveLeft() {
        if(super.moveLeft())
            return validaPosicao();
        return false;
    }    
        public int getFase(){
        return this.contaFase;
    }
    
}
