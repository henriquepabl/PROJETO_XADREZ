package projectxadrez;

public class Peao extends Peca {
    //atributos
    private Boolean jaMoveu;
    //classe construtor
    public Peao(String cor){
        super(cor);
        jaMoveu = false;
    }
    public void setJaMoveu(Boolean situacao){
        jaMoveu = situacao;
    }
    @Override
    public String desenho() { return "P"; }

    @Override
    public Boolean movimentoValido(int linhaO,char colunaO,int linhaD,char colunaD){
        int direcao = 0;
        if(getCor().equals("branco"))direcao = 1;
        else direcao = -1;
        if(linhaD == (linhaO + direcao) && colunaO == colunaD)return true;//avancou para frente uma casa

        if (colunaO == colunaD && linhaD - linhaO == 2 * direcao && !jaMoveu) return true;//avancou duas casas
        //lembrar de quem chamar ela pela primeira vez setar que ja moveu se for a primeria vez;para isso deixei get e set da variavel
        //verifica ela com o get e se ela ainda nao foi movida quando mover seta com true;
        if (Math.abs(colunaD - colunaO) == 1 && linhaD - linhaO == direcao) return true;
        
        return false;

    }
    @Override
    public String caminho(int linhaO,char colunaO,int linhaD,char colunaD){
        if(!movimentoValido(linhaO, colunaO, linhaD, colunaD))return "";
        StringBuilder caminho = new StringBuilder();//basicamente é um objeto string que é vazio e pode ir concatenando, indicações do gepeto
        //eu tinha feito de uma forma padrao mas ele disse que tinha ficado ruim e indico isso

        // Converter colunas para inteiros 
        int colO = colunaO - 'a';
        int colD = colunaD - 'a';

        int linhaPasso = 0;
        int colPasso = 0;
        if(linhaD > linhaO)linhaPasso = 1;
        else if(linhaD < linhaO)linhaPasso = -1;
        
        if(colD > colO)colPasso = 1;
        else if(colD < colO)colPasso = -1;

        int l = linhaO;
        int c = colO;

        while (l != linhaD || c != colD) {
            // Avança uma casa no caminho
            l += linhaPasso;
            c += colPasso;

            // Converte coluna de volta pra char
            char colChar = (char)('a' + c);
            caminho.append(l).append(colChar);
        }
        return caminho.toString();
    }
}
