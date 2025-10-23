package ecuaciones;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Interfaz extends JFrame {

    public Interfaz() {
      this.initComponents();
   }
    Operaciones a = new Operaciones();

   private void initComponents() {
       JButton sus2bot = new JButton();
       JLabel jLabel1 = new JLabel();
       JLabel jLabel2 = new JLabel();
       JButton sust3bot = new JButton();
       JButton jButton1 = new JButton();
       JButton igua2bot = new JButton();
       JButton det2bot = new JButton();
       JButton suma2bot = new JButton();
       JButton igua3bot = new JButton();
       JButton det3bot = new JButton();
       JButton suma3bot = new JButton();
       JLabel jLabel3 = new JLabel();
       JLabel jLabel4 = new JLabel();
       JLabel jLabel5 = new JLabel();
       JMenuBar jMenuBar1 = new JMenuBar();
       JMenu comandos2 = new JMenu();
       JMenuItem igualacion2 = new JMenuItem();
       JMenuItem suma2 = new JMenuItem();
       JMenuItem sust2 = new JMenuItem();
       JMenuItem det2 = new JMenuItem();
       JMenu sust = new JMenu();
       JMenuItem igua3 = new JMenuItem();
       JMenuItem suma3 = new JMenuItem();
       JMenuItem susti3 = new JMenuItem();
       JMenuItem det3 = new JMenuItem();
       JMenuItem jMenuItem1 = new JMenuItem();
      this.setDefaultCloseOperation(3);
      sus2bot.setFont(new Font("Arial Black", 0, 12));
      sus2bot.setText("SUSTITUCION");
      sus2bot.addActionListener(Interfaz.this::sus2botActionPerformed);
      jLabel1.setFont(new Font("Arial Black", 0, 12));
      jLabel1.setText("METODOS 2X2 :");
      jLabel2.setFont(new Font("Arial Black", 0, 12));
      jLabel2.setText("METODOS 3X3 :");
      sust3bot.setFont(new Font("Arial Black", 0, 12));
      sust3bot.setText("SUSTITUCION");
      sust3bot.addActionListener(Interfaz.this::sust3botActionPerformed);
      jButton1.setFont(new Font("Arial Black", 0, 12));
      jButton1.setText("SALIR");
      jButton1.addActionListener(Interfaz.this::jButton1ActionPerformed);
      igua2bot.setFont(new Font("Arial Black", 0, 12));
      igua2bot.setText("IGUALACION");
      igua2bot.addActionListener(Interfaz.this::igua2botActionPerformed);
      det2bot.setFont(new Font("Arial Black", 0, 12));
      det2bot.setText("DETERMINANTES");
      det2bot.addActionListener(Interfaz.this::det2botActionPerformed);
      suma2bot.setFont(new Font("Arial Black", 0, 12));
      suma2bot.setText("SUMA y RESTA");
      suma2bot.addActionListener(Interfaz.this::suma2botActionPerformed);
      igua3bot.setFont(new Font("Arial Black", 0, 12));
      igua3bot.setText("IGUALACION");
      igua3bot.addActionListener(Interfaz.this::igua3botActionPerformed);
      det3bot.setFont(new Font("Arial Black", 0, 12));
      det3bot.setText("DETERMINANTES");
      det3bot.addActionListener(Interfaz.this::det3botActionPerformed);
      suma3bot.setFont(new Font("Arial Black", 0, 12));
      suma3bot.setText("SUMA y RESTA");
      suma3bot.addActionListener(Interfaz.this::suma3botActionPerformed);
      jLabel3.setFont(new Font("Arial Black", 0, 12));
      jLabel3.setText("Eligue el metodo por el cual quieres resolver tu sistema de ecuaciones presionando el boton o ");
      jLabel4.setFont(new Font("Arial Black", 0, 12));
      jLabel4.setText(" digtando el comando correspondiente (revisa en la barra de menu los comandos). ");
      jLabel5.setFont(new Font("Arial Black", 0, 12));
      jLabel5.setText("  Ingresa los datos tal y como se piden.");
      comandos2.setText("Comandos 2x2");
      comandos2.setFont(new Font("Arial Black", 0, 12));
      igualacion2.setAccelerator(KeyStroke.getKeyStroke(73, 8));
      igualacion2.setText("Igualacion");
      igualacion2.addActionListener(Interfaz.this::igualacion2ActionPerformed);
      comandos2.add(igualacion2);
      suma2.setAccelerator(KeyStroke.getKeyStroke(521, 8));
      suma2.setText("Suma y Resta");
      suma2.addActionListener(Interfaz.this::suma2ActionPerformed);
      comandos2.add(suma2);
      sust2.setAccelerator(KeyStroke.getKeyStroke(83, 8));
      sust2.setText("Sustitucion");
      sust2.addActionListener(Interfaz.this::sust2ActionPerformed);
      comandos2.add(sust2);
      det2.setAccelerator(KeyStroke.getKeyStroke(68, 8));
      det2.setText("Determinantes");
      det2.addActionListener(Interfaz.this::det2ActionPerformed);
      comandos2.add(det2);
      jMenuBar1.add(comandos2);
      sust.setText("Comandos 3x3");
      sust.setFont(new Font("Arial Black", 0, 12));
      igua3.setAccelerator(KeyStroke.getKeyStroke(73, 2));
      igua3.setText("Igualacion");
      igua3.addActionListener(Interfaz.this::igua3ActionPerformed);
      sust.add(igua3);
      suma3.setAccelerator(KeyStroke.getKeyStroke(521, 2));
      suma3.setText("Suma y Resta");
      suma3.addActionListener(Interfaz.this::suma3ActionPerformed);
      sust.add(suma3);
      susti3.setAccelerator(KeyStroke.getKeyStroke(83, 2));
      susti3.setText("Sustitucion");
      susti3.addActionListener(Interfaz.this::susti3ActionPerformed);
      sust.add(susti3);
      det3.setAccelerator(KeyStroke.getKeyStroke(68, 2));
      det3.setText("Determinante");
      det3.addActionListener(Interfaz.this::det3ActionPerformed);
      sust.add(det3);
      jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(66, 2));
      jMenuItem1.setText("Salir");
      jMenuItem1.addActionListener(Interfaz.this::jMenuItem1ActionPerformed);
      sust.add(jMenuItem1);
      jMenuBar1.add(sust);
      this.setJMenuBar(jMenuBar1);
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(jLabel1).addComponent(jLabel2)).addGap(238, 238, 238).addComponent(jButton1).addGap(40, 40, 40)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(49, 49, 49).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(igua3bot, -2, 127, -2).addComponent(sus2bot)).addGap(135, 135, 135).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(det3bot).addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(suma3bot, -2, 149, -2).addComponent(det2bot).addComponent(suma2bot, -2, 149, -2)))).addComponent(igua2bot, -2, 127, -2).addComponent(sust3bot))).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addComponent(jLabel3)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(jLabel4, -2, 630, -2))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel5))).addContainerGap(-1, 32767)));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel3).addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel5).addGap(21, 21, 21).addComponent(jLabel1).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(suma2bot).addComponent(sus2bot)).addPreferredGap(ComponentPlacement.RELATED, 33, 32767).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(igua2bot).addComponent(det2bot)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jLabel2, -2, 26, -2).addComponent(jButton1)).addGap(11, 11, 11).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(sust3bot).addComponent(suma3bot)).addGap(54, 54, 54).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(det3bot).addComponent(igua3bot)).addGap(72, 72, 72)));
      this.pack();
   }

   private void igua3ActionPerformed(ActionEvent evt) {
      a.Igualacion3x3();
   }

   private void sust2ActionPerformed(ActionEvent evt) {
      a.Sustitucion2x2();
   }

   private void igualacion2ActionPerformed(ActionEvent evt) {
      a.Igualacion2x2();
   }

   private void susti3ActionPerformed(ActionEvent evt) {
      a.Sustitucion3x3();
   }

   private void sus2botActionPerformed(ActionEvent evt) {
      a.Sustitucion2x2();
   }

   private void sust3botActionPerformed(ActionEvent evt) {
      a.Sustitucion3x3();
   }

   private void jButton1ActionPerformed(ActionEvent evt) {
      System.exit(0);
   }

   private void suma3botActionPerformed(ActionEvent evt) {
      a.Sumayresta3x3();
   }

   private void suma2botActionPerformed(ActionEvent evt) {
      a.SumayrestaReduccion2x2();
   }

   private void igua2botActionPerformed(ActionEvent evt) {
      a.Igualacion2x2();
   }

   private void det2botActionPerformed(ActionEvent evt) {
      a.Determinantes2x2();
   }

   private void suma3ActionPerformed(ActionEvent evt) {
      a.Sumayresta3x3();
   }

   private void det3ActionPerformed(ActionEvent evt) {
      a.Determinantes3x3();
   }

   private void suma2ActionPerformed(ActionEvent evt) {
      a.SumayrestaReduccion2x2();
   }

   private void det2ActionPerformed(ActionEvent evt) {
      a.Determinantes2x2();
   }

   private void jMenuItem1ActionPerformed(ActionEvent evt) {
      System.exit(0);
   }

   private void igua3botActionPerformed(ActionEvent evt) {
      a.Igualacion3x3();
   }

   private void det3botActionPerformed(ActionEvent evt) {
      a.Determinantes3x3();
   }
}
