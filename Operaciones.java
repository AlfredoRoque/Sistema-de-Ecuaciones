package ecuaciones;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class Operaciones {

    int xPositionTwo = 1;
    int xPositionThree = 2;
    int yPositionTwo = 1;
    int yPositionThree = 2;
    int resPositionTwo = 1;
    int resPositionThree = 2;

   public void Sustitucion2x2() {
       SistemaEcuacion sistemaEcuacion = new SistemaEcuacion();
       JPanel panel = new JPanel(new GridLayout(0, 5, 10, 10));

       // Listas para guardar referencias a los campos
       List<JTextField> xFields = new ArrayList<>();
       List<JTextField> yFields = new ArrayList<>();
       List<JTextField> resFields = new ArrayList<>();
       for (int i = 0; i <= 1; i++) {
           JTextField xValue = new JTextField();
           JTextField yValue = new JTextField();
           JTextField ecuRes = new JTextField();
           panel.add(xValue);
           panel.add(new JLabel("X +"));
           panel.add(yValue);
           panel.add(new JLabel("Y = "));
           panel.add(ecuRes);
           xFields.add(xValue);
           yFields.add(yValue);
           resFields.add(ecuRes);
       }

       int result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result == JOptionPane.OK_OPTION) {

           for (int i = 0; i < xFields.size(); i++) {
               sistemaEcuacion.getxValue().add(Double.parseDouble(xFields.get(i).getText()));
               sistemaEcuacion.getyValue().add(Double.parseDouble(yFields.get(i).getText()));
               sistemaEcuacion.getEcuResults().add(Double.parseDouble(resFields.get(i).getText()));
           }
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(xPositionTwo) * sistemaEcuacion.getEcuResults().getFirst() / sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(xPositionTwo) * -1.0D * sistemaEcuacion.getyValue().getFirst() / sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(1) + sistemaEcuacion.getyValue().get(yPositionTwo));
           sistemaEcuacion.setyResult((sistemaEcuacion.getEcuResults().get(resPositionTwo) + -1.0D * sistemaEcuacion.getxProcess().getFirst()) / sistemaEcuacion.getxProcess().get(2));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().get(yPositionTwo) * sistemaEcuacion.getyResult());
           sistemaEcuacion.setxResult((sistemaEcuacion.getEcuResults().get(resPositionTwo) + -1.0D * sistemaEcuacion.getyProcess().getFirst()) / sistemaEcuacion.getxValue().get(xPositionTwo));

           JOptionPane.showMessageDialog(null,
                   "Tus ecuaciones son :\n" + sistemaEcuacion.getxValue().getFirst() + "x+"
                           + sistemaEcuacion.getyValue().getFirst() + "y = " + sistemaEcuacion.getEcuResults().getFirst() + "\n" + sistemaEcuacion.getxValue().get(xPositionTwo) + "x+"
                           + sistemaEcuacion.getyValue().get(yPositionTwo) + "y = " + sistemaEcuacion.getEcuResults().get(resPositionTwo) + "             \n" + "\ndespejar 'x' en ecuacion 1\n x="
                           + sistemaEcuacion.getEcuResults().getFirst() + "+" + sistemaEcuacion.getyValue().getFirst() * -1.0D + "x /" + sistemaEcuacion.getxValue().getFirst() + "\n"
                           + "\nsustituir 'x' en ecuacion 2 \n " + sistemaEcuacion.getxValue().get(xPositionTwo) + "(" + sistemaEcuacion.getEcuResults().getFirst() + "+"
                           + sistemaEcuacion.getyValue().getFirst() * -1.0D + "y /" + sistemaEcuacion.getxValue().getFirst() + ")+" + sistemaEcuacion.getyValue().get(yPositionTwo)
                           + "y" + "=" + sistemaEcuacion.getEcuResults().getFirst() + "\n\nresolver multiplicacion \n "
                           + sistemaEcuacion.getEcuResults().getFirst() + "+" + sistemaEcuacion.getxProcess().get(1) + "y+" + sistemaEcuacion.getyValue().get(yPositionTwo)
                           + "y=" + sistemaEcuacion.getEcuResults().get(resPositionTwo) + "\n " + sistemaEcuacion.getxProcess().get(2) + "y=" + sistemaEcuacion.getEcuResults().get(resPositionTwo) + "+" + sistemaEcuacion.getEcuResults().getFirst() * -1.0D
                           + "\n\ndespejar 'y' \n y=" + sistemaEcuacion.getEcuResults().get(resPositionTwo) + "+" + sistemaEcuacion.getEcuResults().getFirst() * -1.0D + "/" + sistemaEcuacion.getxProcess().get(2) + "\n\ny="
                           + sistemaEcuacion.getyResult() + "\n\nsustituir valor de 'y' en ecuacion 2\n " + sistemaEcuacion.getxValue().get(xPositionTwo) + "x+"
                           + sistemaEcuacion.getyValue().get(yPositionTwo) + "(" + sistemaEcuacion.getyResult() + ")=" + sistemaEcuacion.getEcuResults().get(resPositionTwo)
                           + "\n\ndespejar 'x'\n" + sistemaEcuacion.getxValue().get(xPositionTwo) + "x=" + sistemaEcuacion.getEcuResults().get(resPositionTwo) + "+"
                           + sistemaEcuacion.getyProcess().getFirst() * -1.0D + "\nx=" + (sistemaEcuacion.getEcuResults().get(resPositionTwo) + -1.0D * sistemaEcuacion.getyProcess().getFirst())
                           + "/" + sistemaEcuacion.getxValue().get(xPositionTwo) + "\nx=" + sistemaEcuacion.getxResult()
                           + "\n\n              Los resultados de tus ecuaciones son:                                                          \n"
                           + "                  x =" + sistemaEcuacion.getxResult() + "  " + "y = " + sistemaEcuacion.getyResult() + "\n\n\n", "Resultados", 1);
       }
   }

   public void Sustitucion3x3(int a) {
      float x1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 1", "Capturador", 3));
      float x2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 1", "Capturador", 3));
      float x3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 1", "Capturador", 3));
      float y1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 2", "Capturador", 3));
      float y2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 2", "Capturador", 3));
      float y3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 2", "Capturador", 3));
      float z1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 3", "Capturador", 3));
      float z2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 3", "Capturador", 3));
      float z3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 3", "Capturador", 3));
      float xres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 1", "Capturador", 3));
      float yres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 2", "Capturador", 3));
      float zres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 3", "Capturador", 3));
      float x1n = y3 * xres;
      float x2n = y3 * -1.0F * x1;
      float x3n = y3 * -1.0F * x2;
      float x4n = y1 + x2n;
      float x5n = y2 + x3n;
      float x6n = yres + -1.0F * x1n;
      float y1n = z3 * xres;
      float y2n = z3 * -1.0F * x1;
      float y3n = z3 * -1.0F * x2;
      float y4n = z1 + y2n;
      float y5n = z2 + y3n;
      float y6n = zres + -1.0F * y1n;
      float z1n = y4n * x6n / x4n;
      float z2n = y4n * -1.0F * x5n / x4n;
      float z3n = z2n + y5n;
      float y = (y6n + -1.0F * z1n) / z3n;
      float z4n = y5n * y;
      float z5n = (y6n + -1.0F * z4n) / y4n;
      float w1 = x1 * z5n;
      float w2 = x2 * y;
      float w3 = xres + -1.0F * w1;
      float w4 = w3 + -1.0F * w2;
      float z = w4 / x3;
      JOptionPane.showMessageDialog((Component)null, "Tus ecuaciones son:\n" + x1 + "x+" + x2 + "y+" + x3 + "z=" + xres + "\n" + y1 + "x+" + y2 + "y+" + y3 + "z=" + yres + "\n" + z1 + "x+" + z2 + "y+" + z3 + "z=" + zres + "\ndespejar 'z' de ecuacion 1\n" + "z=(" + xres + "+" + -1.0F * x1 + "x+" + -1.0F * x2 + "y)/" + x3 + "\nsutituir valor de z en ecuacion 2\n" + "(4)   " + x4n + "x+" + x5n + "y=" + (yres + -1.0F * x1n) + "\nsutituir valor de z en ecuacion 3\n" + "(5)   " + y4n + "x+" + y5n + "y=" + (zres + -1.0F * y1n) + "\ndespejar 'x' de ecuacion 4\n(6)    x=(" + x6n + "+" + -1.0F * x5n + "y)/" + x4n + "\nsustituir valor de x en ecuacion 5\n" + y4n + "(" + x6n + "+" + -1.0F * x5n + "y)/" + x4n + "\nresolver y despejar y\ny=" + (y6n + -1.0F * z1n) + "/" + z3n + "\ny=" + y + "\nsustituir y en ecuacion 6\nx=(" + x6n + "+" + -1.0F * x5n + "(" + y + "))/" + x4n + "\nx=(" + x6n + "+" + -1.0F * x5n * y + ")/" + x4n + "\nx=" + (x6n + -1.0F * x5n * y) + "/" + x4n + "\nx=" + z5n + "\nsustituir valor de x e y en ecuacion 1\n" + x1 + "(" + z5n + ")+" + x2 + "(" + y + ")+" + x3 + "z=" + xres + "\n" + w1 + w2 + "+" + x3 + "z=" + xres + "\nz=(" + xres + "+" + -1.0F * (w1 + w2) + ")/" + x3 + "\nz=" + z + "\nLos resultados de tus ecuaciones son:\n\nx  = " + z5n + "     " + "y = " + y + "     " + "z = " + z, "Resultados", 1);
   }

   public void Sumayresta2x2(int a) {
      double x1 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "primer dato fila 1", "Capturador", 3));
      double x2 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "segundo dato fila 1", "Capturador", 3));
      double y1 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "primer dato fila 2", "Capturador", 3));
      double y2 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "segundo dato fila 2", "Capturador", 3));
      double xres = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 1", "Capturador", 3));
      double yres = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 2", "Capturador", 3));
      double y1n = -x2 * y1;
      double y2n = -x2 * y2;
      double yresn = -x2 * yres;
      double x1n = y2 * x1;
      double x2n = y2 * x2;
      double xresn = y2 * xres;
      double z1 = x1n + y1n;
      double z2 = x2n + y2n;
      double z3 = xresn + yresn;
      double z1n = z3 / z1;
      double x3n = x1 * z1n;
      double x4n = xres + -1.0D * x3n;
      double y = x4n / x2;
      JOptionPane.showMessageDialog((Component)null, "Tus ecuaciones son :\n" + x1 + "x+" + x2 + "y = " + xres + "\n" + y1 + "x+" + y2 + "y = " + yres + "             \n" + "\neliminar 'y' multiplicando\n" + x1n + "x+" + x2n + "y=" + xresn + "\n" + y1n + "x+" + y2n + "y=" + yresn + "\n\nSumar valores nuevos\n" + z1 + "x+" + z2 + "y=" + z3 + "\n" + z1 + "x=" + z3 + "\nx=" + z3 + "/" + z1 + "\nx=" + z1n + "\n\nsustituir 'x' en alguna ecuacion\n" + x1 + "(" + z1n + ")+" + x2 + "y=" + xres + "\n" + x2 + "y=" + xres + "+" + -1.0D * x3n + "\ny=" + x1 + "/" + x2 + "\ny=" + y + "\n\nLos resultados de tus ecuaciones son:                             \n\n" + "                 x =" + z1n + "     " + "y = " + y + "\n\n", "Resultados", 1);
   }

   public void Sumayresta3x3(int a) {
      double x1 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 1", "Capturador", 3));
      double x2 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 1", "Capturador", 3));
      double x3 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 1", "Capturador", 3));
      double y1 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 2", "Capturador", 3));
      double y2 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 2", "Capturador", 3));
      double y3 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 2", "Capturador", 3));
      double z1 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 3", "Capturador", 3));
      double z2 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 3", "Capturador", 3));
      double z3 = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 3", "Capturador", 3));
      double xr = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 1", "Capturador", 3));
      double yr = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 2", "Capturador", 3));
      double zr = (double)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 3", "Capturador", 3));
      double xi = x1 * y1;
      double xm = x2 * y1;
      double xp = x3 * y1;
      double xf = xr * y1;
      double yi = y1 * -x1;
      double ym = y2 * -x1;
      double yp = y3 * -x1;
      double yf = yr * -x1;
      double var10000 = yi + xi;
      double xdos = xm + ym;
      double xtres = xp + yp;
      double xres = xf + yf;
      double xi2 = x1 * z1;
      double xm2 = x2 * z1;
      double xp2 = x3 * z1;
      double xf2 = xr * z1;
      double zi = z1 * -x1;
      double zm = z2 * -x1;
      double zp = z3 * -x1;
      double zf = zr * -x1;
      var10000 = xi2 + zi;
      double ydos = xm2 + zm;
      double ytres = xp2 + zp;
      double yres = xf2 + zf;
      double xi3 = xdos * ydos;
      double xm3 = xtres * ydos;
      double xf3 = xres * ydos;
      double zi2 = ydos * -xdos;
      double zm2 = ytres * -xdos;
      double zf2 = yres * -xdos;
      var10000 = xi3 + zi2;
      double z2res = xm3 + zm2;
      double z3res = xf3 + zf2;
      double z = z3res / z2res;
      double y1res = xtres * z;
      double ye = xres - y1res;
      double y = ye / xdos;
      double yprim = x2 * y;
      double zprim = x3 * z;
      double equis = xr - yprim - zprim;
      double x = equis / x1;
      JOptionPane.showMessageDialog((Component)null, "Tus ecuaciones son:\n" + x1 + "x+" + x2 + "y+" + x3 + "z=" + xr + "\n" + y1 + "x+" + y2 + "y+" + y3 + "z=" + yr + "\n" + z1 + "x+" + z2 + "y+" + z3 + "z=" + zr + "\neliminar 'x' con ecuacion 1 y 2\n" + x1 + "x+" + x2 + "y+" + x3 + "z=" + xr + "\n" + y1 + "x+" + y2 + "y+" + y3 + "z=" + yr + "\n(4)   " + xdos + "y+" + xtres + "z=" + xres + "\neliminar 'x' con ecuacion 1 y 3\n" + x1 + "x+" + x2 + "y+" + x3 + "z=" + xr + "\n" + z1 + "x+" + z2 + "y+" + z3 + "z=" + zr + "\n(5)   " + ydos + "y+" + ytres + "z=" + yres + "\neliminar 'y' con ecuacion 4 y 5 y despejar 'z'\n" + xdos + "y+" + xtres + "z=" + xres + "\n" + ydos + "y+" + ytres + "z=" + yres + "\n  " + z2res + "z=" + z3res + "\nz=" + z3res + "/" + z2res + "\nz=" + z + "\nsutituir 'z' en ecuacion 4 y despejar 'y'\n" + xdos + "y+" + xtres + "(" + z + ")" + "=" + xres + "\n" + xdos + "y+" + y1res + "=" + xres + "\n" + xdos + "y=" + xres + "-" + y1res + "\ny=" + ye + "/" + xdos + "\ny=" + y + "\nsutituir 'y' y 'z' en ecuacion 1 y despejar x\n" + x1 + "x+" + x2 + "(" + y + ")+" + x3 + "(" + z + ")=" + xr + "\n" + x1 + "x=" + xr + "-" + zprim + "-(" + yprim + ")" + "\nx=" + equis + "/" + x1 + "\nx=" + x + "\n\n             Los resultados de tus ecuaciones son:\n\nx  = " + x + "     " + "y = " + y + "     " + "z = " + z, "Resultados", 1);
   }

   public void Determinantes2x2(int a) {
      float x1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "primer dato fila 1", "Capturador", 3));
      float x2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "segundo dato fila 1", "Capturador", 3));
      float y1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "primer dato fila 2", "Capturador", 3));
      float y2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "segundo dato fila 2", "Capturador", 3));
      float xres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 1", "Capturador", 3));
      float yres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 2", "Capturador", 3));
      float m1 = x1 * y2;
      float m2 = x2 * y1;
      float dp = m1 - m2;
      float mx1 = xres * y2;
      float mx2 = x2 * yres;
      float dx = mx1 - mx2;
      float my1 = x1 * yres;
      float my2 = xres * y1;
      float dy = my1 - my2;
      float x = dx / dp;
      float y = dy / dp;
      JOptionPane.showMessageDialog((Component)null, "Tus ecuaciones son:\n" + x1 + "x+" + x2 + "y=" + xres + "\n" + y1 + "x+" + y2 + "y=" + yres + "\nsacar determinante principal utilizando columna 'x' e 'y'\n" + x1 + "   " + x2 + "\n" + y1 + "   " + y2 + "\nmultiplicar columnas\n" + x1 + "(" + y2 + ")=" + m1 + "\n" + x2 + "(" + y1 + ")=" + m2 + "\nrestar resultados\n" + m1 + "-(" + m2 + ")=" + dp + "      Dp=" + dp + "\ndeterminante 'x' utilizando resultados e 'y'\n" + xres + "   " + x2 + "\n" + yres + "   " + y2 + "\nresolver\n" + xres + "(" + y2 + ")=" + mx1 + "\n" + x2 + "(" + yres + ")=" + mx2 + "\nrestar\n" + mx1 + "-(" + mx2 + ")=" + dx + "      Dp=" + dx + "\ndeterminante 'y' utilizando resultados e 'x'\n" + x1 + "   " + xres + "\n" + y1 + "   " + yres + "\nresolver\n" + x1 + "(" + yres + ")=" + my1 + "\n" + xres + "(" + y1 + ")=" + my2 + "\nrestar\n" + my1 + "-(" + my2 + ")=" + dy + "      Dp=" + dy + "\ndividie Dx y Dy entre Dp\nx=" + dx + "/" + dp + "=" + x + "\ny=" + dy + "/" + dp + "=" + y + "\nLos resultados de tus ecuaciones son:                                            \n" + "                x = " + x + "     " + "y = " + y + "     \n\n", "Resultados", 1);
   }

   public void Determinantes3x3(int a) {
      float x1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 1", "Capturador", 3));
      float x2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 1", "Capturador", 3));
      float x3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 1", "Capturador", 3));
      float y1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 2", "Capturador", 3));
      float y2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 2", "Capturador", 3));
      float y3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 2", "Capturador", 3));
      float z1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 3", "Capturador", 3));
      float z2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 3", "Capturador", 3));
      float z3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 3", "Capturador", 3));
      float xres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 1", "Capturador", 3));
      float yres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 2", "Capturador", 3));
      float zres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 3", "Capturador", 3));
      float di1 = x1 * y2 * z3;
      float di2 = y1 * z2 * x3;
      float di3 = z1 * x2 * y3;
      float di4 = x3 * y2 * z1;
      float di5 = y3 * z2 * x1;
      float di6 = z3 * x2 * y1;
      float rdi1 = di1 + di2 + di3;
      float rdi2 = di4 + di5 + di6;
      float dp = rdi1 - rdi2;
      float dix1 = xres * y2 * z3;
      float dix2 = x2 * y3 * zres;
      float dix3 = x3 * yres * z2;
      float dix4 = x3 * y2 * zres;
      float dix5 = xres * y3 * z2;
      float dix6 = x2 * yres * z3;
      float rdix1 = dix1 + dix2 + dix3;
      float rdix2 = dix4 + dix5 + dix6;
      float dx = rdix1 - rdix2;
      float diy1 = x1 * yres * z3;
      float diy2 = y1 * zres * x3;
      float diy3 = z1 * xres * y3;
      float diy4 = x3 * yres * z1;
      float diy5 = y3 * zres * x1;
      float diy6 = z3 * xres * y1;
      float rdiy1 = diy1 + diy2 + diy3;
      float rdiy2 = diy4 + diy5 + diy6;
      float dy = rdiy1 - rdiy2;
      float diz1 = x1 * y2 * zres;
      float diz2 = x2 * yres * z1;
      float diz3 = xres * y1 * z2;
      float diz4 = xres * y2 * z1;
      float diz5 = x1 * yres * z2;
      float diz6 = x2 * y1 * zres;
      float rdiz1 = diz1 + diz2 + diz3;
      float rdiz2 = diz4 + diz5 + diz6;
      float dz = rdiz1 - rdiz2;
      float x = dx / dp;
      float y = dy / dp;
      float z = dz / dp;
      JOptionPane.showMessageDialog((Component)null, "Tus ecuaciones son:\n" + x1 + "x+" + x2 + "y+" + x3 + "z=" + xres + "\n" + y1 + "x+" + y2 + "y+" + y3 + "z=" + yres + "\n" + z1 + "x+" + z2 + "y+" + z3 + "z=" + zres + "\nsacar determinante del sistema por metodo sarrus\n" + x1 + "   " + x2 + "   " + x3 + "\n" + y1 + "   " + y2 + "   " + y3 + "               (" + di1 + "+" + di2 + "+" + di3 + ")-(" + di4 + "+" + di5 + "+" + di6 + ")\n" + z1 + "   " + z2 + "   " + z3 + "               Ds=(" + rdi1 + ")-(" + rdi2 + ")=" + dp + "\n" + x1 + "   " + x2 + "   " + x3 + "\n" + y1 + "   " + y2 + "   " + y3 + "\nsacar determinante 'x' por metodo sarrus\n" + xres + "   " + x2 + "   " + x3 + "   " + xres + "   " + x2 + "\n" + yres + "   " + y2 + "   " + y3 + "   " + yres + "   " + y2 + "\n" + zres + "   " + z2 + "   " + z3 + "   " + zres + "   " + z2 + "\n(" + dix1 + "+" + dix2 + "+" + dix3 + ")-(" + dix4 + "+" + dix5 + "+" + dix6 + ")\nDx=(" + rdix1 + ")-(" + rdix2 + ")=" + dx + "\nsacar determinante 'y' por metodo sarrus\n" + x1 + "   " + xres + "   " + x3 + "\n" + y1 + "   " + yres + "   " + y3 + "              (" + diy1 + "+" + diy2 + "+" + diy3 + ")-(" + diy4 + "+" + diy5 + "+" + diy6 + ")\n" + z1 + "   " + zres + "   " + z3 + "                 Dy=(" + rdiy1 + ")-(" + rdiy2 + ")=" + dy + "\n" + x1 + "   " + xres + "   " + x3 + "\n" + y1 + "   " + yres + "   " + y3 + "\nsacar determinante 'z' por metodo sarrus\n" + x1 + "   " + x2 + "   " + xres + "   " + x1 + "   " + x2 + "\n" + y1 + "   " + y2 + "   " + yres + "   " + y1 + "   " + y2 + "\n" + z1 + "   " + z2 + "   " + zres + "   " + z1 + "   " + z2 + "\n(" + diz1 + "+" + diz2 + "+" + diz3 + ")-(" + diz4 + "+" + diz5 + "+" + diz6 + ")\nDz=(" + rdiz1 + ")-(" + rdiz2 + ")=" + dz + "\nsacar los valores de las incognitas\nx=Dx/Ds=" + dx + "/" + dp + "=" + x + "\ny=Dy/Ds=" + dy + "/" + dp + "=" + y + "\nx=Dz/Ds=" + dz + "/" + dp + "=" + z + "\nLos resultados de tus ecuaciones son:\n" + "         x = " + x + "     " + "y = " + y + "     " + "z = " + z, "Resultados", 1);
   }

   public void Igualacion2x2(int a) {
      float x1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "primer dato fila 1", "Capturador", 3));
      float x2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "segundo dato fila 1", "Capturador", 3));
      float y1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "primer dato fila 2", "Capturador", 3));
      float y2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "segundo dato fila 2", "Capturador", 3));
      float xres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 1", "Capturador", 3));
      float yres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 2", "Capturador", 3));
      float x2cl = -1.0F * x1;
      float y2cl = -1.0F * y1;
      float li = y2 * xres;
      float li2 = y2 * x2cl;
      float ld = x2 * yres;
      float ld2 = x2 * y2cl;
      float li3 = li2 + -1.0F * ld2;
      float ld3 = ld + -1.0F * li;
      float x = ld3 / li3;
      float y = (yres + y2cl * x) / y2;
      JOptionPane.showMessageDialog((Component)null, "Tus ecuaciones son:\n" + x1 + "x+" + x2 + "y=" + xres + "\n" + y1 + "x+" + y2 + "y=" + yres + "\n\ndespejar 'y' en ambas ecuaciones\n" + "y=(" + xres + "+" + x2cl + "x)/" + x2 + "\ny=(" + yres + "+" + y2cl + "x)/" + y2 + "\n\nigualar ambos despejes\n" + "(" + xres + "+" + x2cl + "x)/" + x2 + "=" + "(" + yres + "+" + y2cl + "x)/" + y2 + "\n\nresolver\n" + y2 + "(" + xres + "+" + x2cl + "x) = " + x2 + "(" + yres + "+" + y2cl + "x)\n" + li + "+" + li2 + "x = " + ld + "+" + ld2 + "x" + "\n\nsimplificar ecuacion\n" + li2 + "x+" + ld2 * -1.0F + "x=" + ld + "+" + li * -1.0F + "\n" + li3 + "x=" + ld3 + "\nx=" + ld3 + "/" + li3 + "\nx=" + x + "\n\nsutituir 'x' en la ecuacion que mas convenga\n" + "y=(" + yres + "+(" + x + "))/" + y2 + "\ny=" + y + "\n\nLos resultados de tus ecuaciones son:                                \n" + "                 x = " + x + "     " + "y = " + y, "Resultados", 1);
   }

   public void Igualacion3x3(int a) {
      float x1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 1", "Capturador", 3));
      float x2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 1", "Capturador", 3));
      float x3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 1", "Capturador", 3));
      float y1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 2", "Capturador", 3));
      float y2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 2", "Capturador", 3));
      float y3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 2", "Capturador", 3));
      float z1 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 1 fila 3", "Capturador", 3));
      float z2 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 2 fila 3", "Capturador", 3));
      float z3 = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "dato 3 fila 3", "Capturador", 3));
      float xres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 1", "Capturador", 3));
      float yres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 2", "Capturador", 3));
      float zres = (float)Integer.parseInt(JOptionPane.showInputDialog((Component)null, "resultado de ecuacion 3", "Capturador", 3));
      float x2cl = -1.0F * x2;
      float x3cl = -1.0F * x3;
      float y2cl = -1.0F * y2;
      float y3cl = -1.0F * y3;
      float z2cl = -1.0F * z2;
      float z3cl = -1.0F * z3;
      float li = y1 * xres;
      float li2 = y1 * x2cl;
      float li3 = y1 * x3cl;
      float ld = x1 * yres;
      float ld2 = x1 * y2cl;
      float ld3 = x1 * y3cl;
      float suy = li2 + -1.0F * ld2;
      float suz = li3 + -1.0F * ld3;
      float sres = ld + -1.0F * li;
      float lis = z1 * xres;
      float li2s = z1 * x2cl;
      float li3s = z1 * x3cl;
      float lds = x1 * zres;
      float ld2s = x1 * z2cl;
      float ld3s = x1 * z3cl;
      float sy = li2s + -1.0F * ld2s;
      float sz = li3s + -1.0F * ld3s;
      float sr2 = lds + -1.0F * lis;
      float suzc = -1.0F * suz;
      float szc = -1.0F * sz;
      float lit = sy * sres;
      float lit2 = sy * suzc;
      float ldt = suy * sr2;
      float ldt2 = suy * szc;
      float sumz = lit2 + -1.0F * ldt2;
      float sumr = ldt + -1.0F * lit;
      float z = sumr / sumz;
      float ys = sz * z;
      float y = (sr2 + -1.0F * ys) / sy;
      float xs = x2 * y;
      float xs2 = x3 * z;
      float xd = (xres + -1.0F * (xs + xs2)) / x1;
      JOptionPane.showMessageDialog((Component)null, "Tus ecuaciones son:\n(1)    " + x1 + "x+" + x2 + "y+" + x3 + "z=" + xres + "\n(2)    " + y1 + "x+" + y2 + "y+" + y3 + "z=" + yres + "\n(3)    " + z1 + "x+" + z2 + "y+" + z3 + "z=" + zres + "\ndespejar la misma incognita en las 3 ecuaciones\n" + "(4)     x=(" + xres + "+" + x2cl + "y+" + x3cl + "z)/" + x1 + "\n(5)     x=(" + yres + "+" + y2cl + "y+" + y3cl + "z)/" + y1 + "\n(6)     x=(" + zres + "+" + z2cl + "y+" + z3cl + "z)/" + z1 + "\nigualar ecuacion 4 con 5\n(" + xres + "+" + x2cl + "y+" + x3cl + "z)/" + x1 + "=(" + yres + "+" + y2cl + "y+" + y3cl + "z)/" + y1 + "\nresolver por producto cruzado\n(7)     " + suy + "y+" + suz + "z=" + sres + "\nigualar ecuacion 4 con 6\n(" + xres + "+" + x2cl + "y+" + x3cl + "z)/" + x1 + "=(" + zres + "+" + z2cl + "y+" + z3cl + "z)/" + z1 + "\nresolver por producto cruzado\n(8)     " + sy + "y+" + sz + "z=" + sr2 + "\ndespejar la misma incognita en ecuacion 7 y 8\n (9)     y=(" + sres + "+" + suzc + "z)/" + suy + "     (10)   y=(" + sr2 + "+" + szc + "z)/" + sy + "\nigualr ecuaciones 9 y 10\n" + "(" + sres + "+" + suzc + "z)/" + suy + "=(" + sr2 + "+" + szc + "z)/" + sy + "\nresolver por producto cruzado\n" + lit2 + "z+" + -1.0F * ldt2 + "z=" + ldt + "+" + -1.0F * lit + "\n" + sumz + "z=" + sumr + "\nz=" + sumr + "/" + sumz + "  =" + z + "\nsustituir 'z' en ecuacion 8 para sacar 'y'\n" + sy + "y+" + sz + "(" + z + ")=" + sr2 + "\ny=(" + sr2 + "+" + ys + ")/" + sy + "     y=" + y + "\nsustituir 'z' e 'y' en ecuacion 1 para sacar 'x'\n" + x1 + "x+" + x2 + "(" + y + ")+" + x3 + "(" + z + ")=" + xres + "\n" + x1 + "x=" + xres + "+" + -1.0F * (xs + xs2) + "\nx=" + (xres + -1.0F * (xs + xs2)) + "/" + x1 + "  =" + xd + "\n            Los resultados de tus ecuaciones son:\n\nx  = " + xd + "     " + "y = " + y + "     " + "z = " + z, "Resultados", 1);
   }
}
