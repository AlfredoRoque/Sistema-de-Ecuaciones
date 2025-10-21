package ecuaciones;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class Interfaz extends JFrame {
   private JMenu comandos2;
   private JMenuItem det2;
   private JButton det2bot;
   private JMenuItem det3;
   private JButton det3bot;
   private JButton igua2bot;
   private JMenuItem igua3;
   private JButton igua3bot;
   private JMenuItem igualacion2;
   private JButton jButton1;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JMenuBar jMenuBar1;
   private JMenuItem jMenuItem1;
   private JMenuItem suma2;
   private JButton suma2bot;
   private JMenuItem suma3;
   private JButton suma3bot;
   private JButton sus2bot;
   private JMenu sust;
   private JMenuItem sust2;
   private JButton sust3bot;
   private JMenuItem susti3;

   public Interfaz() {
      this.initComponents();
   }

   private void initComponents() {
      this.sus2bot = new JButton();
      this.jLabel1 = new JLabel();
      this.jLabel2 = new JLabel();
      this.sust3bot = new JButton();
      this.jButton1 = new JButton();
      this.igua2bot = new JButton();
      this.det2bot = new JButton();
      this.suma2bot = new JButton();
      this.igua3bot = new JButton();
      this.det3bot = new JButton();
      this.suma3bot = new JButton();
      this.jLabel3 = new JLabel();
      this.jLabel4 = new JLabel();
      this.jLabel5 = new JLabel();
      this.jMenuBar1 = new JMenuBar();
      this.comandos2 = new JMenu();
      this.igualacion2 = new JMenuItem();
      this.suma2 = new JMenuItem();
      this.sust2 = new JMenuItem();
      this.det2 = new JMenuItem();
      this.sust = new JMenu();
      this.igua3 = new JMenuItem();
      this.suma3 = new JMenuItem();
      this.susti3 = new JMenuItem();
      this.det3 = new JMenuItem();
      this.jMenuItem1 = new JMenuItem();
      this.setDefaultCloseOperation(3);
      this.sus2bot.setFont(new Font("Arial Black", 0, 12));
      this.sus2bot.setText("SUSTITUCION");
      this.sus2bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.sus2botActionPerformed(evt);
         }
      });
      this.jLabel1.setFont(new Font("Arial Black", 0, 12));
      this.jLabel1.setText("METODOS 2X2 :");
      this.jLabel2.setFont(new Font("Arial Black", 0, 12));
      this.jLabel2.setText("METODOS 3X3 :");
      this.sust3bot.setFont(new Font("Arial Black", 0, 12));
      this.sust3bot.setText("SUSTITUCION");
      this.sust3bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.sust3botActionPerformed(evt);
         }
      });
      this.jButton1.setFont(new Font("Arial Black", 0, 12));
      this.jButton1.setText("SALIR");
      this.jButton1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.jButton1ActionPerformed(evt);
         }
      });
      this.igua2bot.setFont(new Font("Arial Black", 0, 12));
      this.igua2bot.setText("IGUALACION");
      this.igua2bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.igua2botActionPerformed(evt);
         }
      });
      this.det2bot.setFont(new Font("Arial Black", 0, 12));
      this.det2bot.setText("DETERMINANTES");
      this.det2bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.det2botActionPerformed(evt);
         }
      });
      this.suma2bot.setFont(new Font("Arial Black", 0, 12));
      this.suma2bot.setText("SUMA y RESTA");
      this.suma2bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.suma2botActionPerformed(evt);
         }
      });
      this.igua3bot.setFont(new Font("Arial Black", 0, 12));
      this.igua3bot.setText("IGUALACION");
      this.igua3bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.igua3botActionPerformed(evt);
         }
      });
      this.det3bot.setFont(new Font("Arial Black", 0, 12));
      this.det3bot.setText("DETERMINANTES");
      this.det3bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.det3botActionPerformed(evt);
         }
      });
      this.suma3bot.setFont(new Font("Arial Black", 0, 12));
      this.suma3bot.setText("SUMA y RESTA");
      this.suma3bot.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.suma3botActionPerformed(evt);
         }
      });
      this.jLabel3.setFont(new Font("Arial Black", 0, 12));
      this.jLabel3.setText("Eligue el metodo por el cual quieres resolver tu sistema de ecuaciones presionando el boton o ");
      this.jLabel4.setFont(new Font("Arial Black", 0, 12));
      this.jLabel4.setText(" digtando el comando correspondiente (revisa en la barra de menu los comandos). ");
      this.jLabel5.setFont(new Font("Arial Black", 0, 12));
      this.jLabel5.setText("  Ingresa los datos tal y como se piden.");
      this.comandos2.setText("Comandos 2x2");
      this.comandos2.setFont(new Font("Arial Black", 0, 12));
      this.igualacion2.setAccelerator(KeyStroke.getKeyStroke(73, 8));
      this.igualacion2.setText("Igualacion");
      this.igualacion2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.igualacion2ActionPerformed(evt);
         }
      });
      this.comandos2.add(this.igualacion2);
      this.suma2.setAccelerator(KeyStroke.getKeyStroke(521, 8));
      this.suma2.setText("Suma y Resta");
      this.suma2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.suma2ActionPerformed(evt);
         }
      });
      this.comandos2.add(this.suma2);
      this.sust2.setAccelerator(KeyStroke.getKeyStroke(83, 8));
      this.sust2.setText("Sustitucion");
      this.sust2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.sust2ActionPerformed(evt);
         }
      });
      this.comandos2.add(this.sust2);
      this.det2.setAccelerator(KeyStroke.getKeyStroke(68, 8));
      this.det2.setText("Determinantes");
      this.det2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.det2ActionPerformed(evt);
         }
      });
      this.comandos2.add(this.det2);
      this.jMenuBar1.add(this.comandos2);
      this.sust.setText("Comandos 3x3");
      this.sust.setFont(new Font("Arial Black", 0, 12));
      this.igua3.setAccelerator(KeyStroke.getKeyStroke(73, 2));
      this.igua3.setText("Igualacion");
      this.igua3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.igua3ActionPerformed(evt);
         }
      });
      this.sust.add(this.igua3);
      this.suma3.setAccelerator(KeyStroke.getKeyStroke(521, 2));
      this.suma3.setText("Suma y Resta");
      this.suma3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.suma3ActionPerformed(evt);
         }
      });
      this.sust.add(this.suma3);
      this.susti3.setAccelerator(KeyStroke.getKeyStroke(83, 2));
      this.susti3.setText("Sustitucion");
      this.susti3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.susti3ActionPerformed(evt);
         }
      });
      this.sust.add(this.susti3);
      this.det3.setAccelerator(KeyStroke.getKeyStroke(68, 2));
      this.det3.setText("Determinante");
      this.det3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.det3ActionPerformed(evt);
         }
      });
      this.sust.add(this.det3);
      this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(66, 2));
      this.jMenuItem1.setText("Salir");
      this.jMenuItem1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            Interfaz.this.jMenuItem1ActionPerformed(evt);
         }
      });
      this.sust.add(this.jMenuItem1);
      this.jMenuBar1.add(this.sust);
      this.setJMenuBar(this.jMenuBar1);
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(238, 238, 238).addComponent(this.jButton1).addGap(40, 40, 40)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(49, 49, 49).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.igua3bot, -2, 127, -2).addComponent(this.sus2bot)).addGap(135, 135, 135).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.det3bot).addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.suma3bot, -2, 149, -2).addComponent(this.det2bot).addComponent(this.suma2bot, -2, 149, -2)))).addComponent(this.igua2bot, -2, 127, -2).addComponent(this.sust3bot))).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jLabel3)).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4, -2, 630, -2))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel5))).addContainerGap(-1, 32767)));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jLabel5).addGap(21, 21, 21).addComponent(this.jLabel1).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.suma2bot).addComponent(this.sus2bot)).addPreferredGap(ComponentPlacement.RELATED, 33, 32767).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.igua2bot).addComponent(this.det2bot)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel2, -2, 26, -2).addComponent(this.jButton1)).addGap(11, 11, 11).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.sust3bot).addComponent(this.suma3bot)).addGap(54, 54, 54).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.det3bot).addComponent(this.igua3bot)).addGap(72, 72, 72)));
      this.pack();
   }

   private void igua3ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Igualacion3x3(x);
   }

   private void sust2ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      a.Sustitucion2x2();
   }

   private void igualacion2ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Igualacion2x2(x);
   }

   private void susti3ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      a.Sustitucion3x3();
   }

   private void sus2botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      a.Sustitucion2x2();
   }

   private void sust3botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      a.Sustitucion3x3();
   }

   private void jButton1ActionPerformed(ActionEvent evt) {
      System.exit(0);
   }

   private void suma3botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Sumayresta3x3(x);
   }

   private void suma2botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Sumayresta2x2(x);
   }

   private void igua2botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Igualacion2x2(x);
   }

   private void det2botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Determinantes2x2(x);
   }

   private void suma3ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Sumayresta3x3(x);
   }

   private void det3ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Determinantes3x3(x);
   }

   private void suma2ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Sumayresta2x2(x);
   }

   private void det2ActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Determinantes2x2(x);
   }

   private void jMenuItem1ActionPerformed(ActionEvent evt) {
      System.exit(0);
   }

   private void igua3botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Igualacion3x3(x);
   }

   private void det3botActionPerformed(ActionEvent evt) {
      Operaciones a = new Operaciones();
      int x = 0;
      a.Determinantes3x3(x);
   }
}
