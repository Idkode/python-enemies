import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Game extends  JFrame implements  KeyListener{

    BufferedImage backBuffer;
    int FPS = 30;
    int janela_W = 1080;
    int janela_H = 720;

    /* Declarando o menu Com:
    * 4 itens, coordenadas x e y = 100, ativo = true
    * olhe o método abaixo cenarios() */
    Menu menu_principal = new Menu(4, (janela_W / 2) - 50, (janela_H / 2) - 50, true);
    Menu submenu = new Menu(2, (janela_W / 2) - 50, (janela_H / 2) - 50, true);

    Menu submenu_2 = new Menu(2, (janela_W / 2) - 50, (janela_H / 2) - 50, true);

    /* Método que vai desenhar na tela alguns possíveis cenários do game
    * lá em Menu.java cenário foi definido como -1
    * se cenário == 0 muda a cor do fundo e mostra m texto
    * se cenário == n muda a cor do fundo e mostra um texto*/

    //Obter o método desenhar gráficos
    public void cenarios(){
        Graphics bbg = backBuffer.getGraphics();
        bbg.setFont(new Font("Arial", Font.BOLD, 20));
        if(menu_principal.cenario == 0){
            bbg.setColor(new Color(100, 255, 193));
            Game game1 = new Game();
            game1.run_sub();
            // aqui você pode escolher o que irá aparecer caso o usuário escolha este item do menu
        }
        if(menu_principal.cenario == 1){
            bbg.setColor((new Color(234, 100, 255)));
            Game game2 = new Game();
            game2.run_sub2();
        }
        if(menu_principal.cenario == 2){
            bbg.setColor(new Color(100, 100, 255));
            bbg.fillRect(0, 0, janela_W, janela_H);
            bbg.setColor(Color.BLACK);
            bbg.drawString("Ajuda: ", 100, 200);
        }
        if(menu_principal.cenario == 3){
            System.exit(0); // esse comando fecha o game
        }
    }

    public void atualizar(){
    }

    //---------------------------------------- FUNÇÕES MENU PRINCIPAL ------------------------------------------------//

    public void desenhar_Graficos(){
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        bbg.setColor(Color.cyan);
        bbg.fillRect(0, 0, janela_W, janela_W); // Pinta o fundo com um quadrado da cor selecionada

        menu_principal.desenhar_menu(); // isso desenhará o menu
        cenarios(); // isso irá desenhar os cenários escolhidos no menu

        g.drawImage(backBuffer, 0, 0, this); // Isso deve ficar sempre no final
    }

    //Método inicializar()
    public void inicializar(){
        setTitle("Snakes!!!");
        setSize(janela_W, janela_H);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        backBuffer = new BufferedImage(janela_W, janela_H, BufferedImage.TYPE_INT_RGB);

        // adicionar um escutador de teclas
        addKeyListener(this);

        // definindo o texto de cada item do menu
        menu_principal.itens[0] = "Jogar";
        menu_principal.itens[1] = "Opções";
        menu_principal.itens[2] = "Ajuda";
        menu_principal.itens[3] = "Sair";

        menu_principal.bbg = backBuffer.getGraphics();
    }

    // Run Menu
    public void run(){
        inicializar();
        while (true){
            atualizar();
            desenhar_Graficos();
            try {
                Thread.sleep(1000 / FPS);
            } catch (Exception e){
                System.out.println("Thread interrompida");
            }
        }
    }

    //---------------------------------------- FUNÇÕES SUBMENU 1------------------------------------------------------//

    // inicializar o submenu 1
    public void inicializar_sub(){
        setSize(janela_W, janela_H);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        backBuffer = new BufferedImage(janela_W, janela_H, BufferedImage.TYPE_INT_RGB);

        // adicionar um escutador de teclas
        addKeyListener(this);

        // definindo o texto dos itens
        submenu.itens[0] = "Modo História";
        submenu.itens[1] = "Jogo Livre";

        submenu.bbg = backBuffer.getGraphics();
    }

    // Desenhar gráficos submenu 1
    public void desenhar_graficos_sub(){
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        bbg.setColor(Color.CYAN);
        bbg.fillRect(0, 0, janela_W, janela_W); // Pinta o fundo com um quadrado da cor selecionada

        submenu.desenhar_menu(); // isso desenhará o menu
        cenarios(); // isso irá desenhar os cenários escolhidos no menu

        g.drawImage(backBuffer, 0, 0, this); // Isso deve ficar sempre no final
    }

    // Run submenu 1
    public void run_sub(){
        inicializar_sub();
        while (true){
            atualizar();
            desenhar_graficos_sub();
            try{
                Thread.sleep(1000 / FPS);
            } catch (Exception e){
                System.out.println("Thread interrompida");
            }
        }
    }

    //---------------------------------------- FUNÇÕES SUBMENU 2 -----------------------------------------------------//

    // Inicializar o submenu 2
    public void inicializar_sub_2(){
        setSize(janela_W, janela_H);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        backBuffer = new BufferedImage(janela_W, janela_H, BufferedImage.TYPE_INT_RGB);

        // adicionar um escutador de teclas
        addKeyListener(this);

        // definindo o texto dos itens
        submenu_2.itens[0] = "Idioma";
        submenu_2.itens[1] = "Skin da cobra";

        submenu_2.bbg = backBuffer.getGraphics();
    }

    // Desenhar gráficos submenu 2
    public void desenhar_graficos_sub2(){
        Graphics g = getGraphics();
        Graphics bbg = backBuffer.getGraphics();
        bbg.setColor(Color.PINK);
        bbg.fillRect(0, 0, janela_W, janela_W); // Pinta o fundo com um quadrado da cor selecionada

        submenu_2.desenhar_menu(); // isso desenhará o menu
        cenarios(); // isso irá desenhar os cenários escolhidos no menu

        g.drawImage(backBuffer, 0, 0, this); // Isso deve ficar sempre no final
    }

    // Run submenu 2
    public void run_sub2(){
        inicializar_sub_2();
        while (true){
            atualizar();
            desenhar_graficos_sub2();
            try{
                Thread.sleep(1000 / FPS);
            } catch (Exception e){
                System.out.println("Thread interrompida");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        // aqui chamamos os métodos que irá controlar o menu pelo teclado
        menu_principal.controlar(e); // controla o menu
        menu_principal.voltar_ao_menu(e); // faz voltar para o menu quando pressionamos "Esc."

        submenu.controlar(e);
        submenu.voltar_ao_menu(e);

        submenu_2.controlar(e);
        submenu_2.voltar_ao_menu(e);
    }

    public void keyReleased(KeyEvent e) {
    }
}
