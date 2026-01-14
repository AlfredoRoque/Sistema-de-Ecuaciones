package ecuaciones;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class Operaciones {

    //Equation sistem positions
    int positionTwo = 1;
    int positionThree = 2;
    int positionFour = 3;

    //Equation sistem x steps process
    BigDecimal xProcess1;
    BigDecimal xProcess2;
    BigDecimal xProcess3;
    BigDecimal xProcess4;
    BigDecimal xProcess5;
    BigDecimal xProcess6;
    BigDecimal xProcess7;
    BigDecimal xProcess8;
    BigDecimal xProcess9;
    BigDecimal xProcess10;
    BigDecimal xProcess11;
    BigDecimal xProcess12;
    BigDecimal xProcess13;
    BigDecimal xProcess14;
    BigDecimal xProcess15;
    BigDecimal xProcess16;
    BigDecimal xProcess17;
    BigDecimal xProcess18;

    //Equation sistem y step process
    BigDecimal yProcess1;
    BigDecimal yProcess2;
    BigDecimal yProcess3;
    BigDecimal yProcess4;
    BigDecimal yProcess5;
    BigDecimal yProcess6;
    BigDecimal yProcess7;
    BigDecimal yProcess8;
    BigDecimal yProcess9;
    BigDecimal yProcess10;

    //Equation sistem z step process
    BigDecimal zProcess1;
    BigDecimal zProcess2;
    BigDecimal zProcess3;
    BigDecimal zProcess4;
    BigDecimal zProcess5;
    BigDecimal zProcess6;
    BigDecimal zProcess7;
    BigDecimal zProcess8;
    BigDecimal zProcess9;
    BigDecimal zProcess10;

    //Equation sistem x values
    BigDecimal x1;
    BigDecimal x2;
    BigDecimal x3;

    //Equation sistem y values
    BigDecimal y1;
    BigDecimal y2;
    BigDecimal y3;

    //Equation sistem z values
    BigDecimal z1;
    BigDecimal z2;
    BigDecimal z3;

    //Equation sistem results values
    BigDecimal res1;
    BigDecimal res2;
    BigDecimal res3;

    //Equation sistem size
    int size2X2 = 5;
    int size3X3 = 7;
    int result;
    SistemaEcuacion sistemaEcuacion = new SistemaEcuacion();
    JPanel panel;
    List<JTextField> xFields = new ArrayList<>();
    List<JTextField> yFields = new ArrayList<>();
    List<JTextField> zFields = new ArrayList<>();
    List<JTextField> resFields = new ArrayList<>();
    StringBuilder responseMessage = new StringBuilder();

    /**
     * Metodo para resolver un sistema de ecuaciones de 2X2 por sustitucion
     */
   public void Sustitucion2x2() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size2X2);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       if (result != JOptionPane.OK_OPTION) return;

       this.getFieldsValues(sistemaEcuacion, xFields,yFields,resFields);

       //Proceso utilizando sustitucion para resolver sistema 2X2
       this.get2x2Values();
       xProcess1 = x2.multiply(res1).divide(x1,2,RoundingMode.HALF_UP);
       xProcess2 =x2.multiply(y1).negate().divide(x1,2,RoundingMode.HALF_UP);
       xProcess3 = xProcess2.add(y2);
       sistemaEcuacion.setyResult(res2.subtract(xProcess1).divide(xProcess3, 2, RoundingMode.HALF_UP));
       yProcess1 = y2.multiply(sistemaEcuacion.getyResult());
       sistemaEcuacion.setxResult(res2.subtract(yProcess1).divide(x2,2,RoundingMode.HALF_UP));

       responseMessage.append("Tus ecuaciones son :\n").append(roundTwoDecimals(x1)).append("x+")
               .append(roundTwoDecimals(y1)).append("y = ").append(roundTwoDecimals(res1)).append("\n")
               .append(roundTwoDecimals(x2)).append("x+").append(roundTwoDecimals(y2)).append("y = ")
               .append(roundTwoDecimals(res2)).append("             \n").append("\ndespejar 'x' en ecuacion 1\n x=")
               .append(roundTwoDecimals(res1)).append("+").append(roundTwoDecimals(y1.negate())).append("x /")
               .append(roundTwoDecimals(x1)).append("\n").append("\nsustituir 'x' en ecuacion 2 \n ")
               .append(roundTwoDecimals(x2)).append("(").append(roundTwoDecimals(res1)).append("+")
               .append(roundTwoDecimals(y1.negate())).append("y /").append(roundTwoDecimals(x1)).append(")+")
               .append(roundTwoDecimals(y2)).append("y=").append(roundTwoDecimals(res1)).append("\n\n")
               .append("resolver multiplicacion \n ").append(roundTwoDecimals(res1)).append("+")
               .append(roundTwoDecimals(xProcess2)).append("y+").append(roundTwoDecimals(y2)).append("y=")
               .append(roundTwoDecimals(res2)).append("\n ").append(roundTwoDecimals(xProcess3)).append("y=")
               .append(roundTwoDecimals(res2)).append("+").append(roundTwoDecimals(res1.negate())).append("\n\n")
               .append("despejar 'y' \n y=").append(roundTwoDecimals(res2)).append("+")
               .append(roundTwoDecimals(res1.negate())).append("/").append(roundTwoDecimals(xProcess3)).append("\n\ny=")
               .append(roundTwoDecimals(sistemaEcuacion.getyResult())).append("\n\n")
               .append("sustituir valor de 'y' en ecuacion 2\n ").append(roundTwoDecimals(x2)).append("x+")
               .append(roundTwoDecimals(y2)).append("(").append(roundTwoDecimals(sistemaEcuacion.getyResult())).append(")=")
               .append(roundTwoDecimals(res2)).append("\n\n").append("despejar 'x'\n").append(roundTwoDecimals(x2)).append("x=")
               .append(roundTwoDecimals(res2)).append("+").append(roundTwoDecimals(yProcess1.negate())).append("\n")
               .append("x=").append(roundTwoDecimals(res2.subtract(yProcess1))).append("/")
               .append(roundTwoDecimals(x2)).append("\n").append("x=")
               .append(roundTwoDecimals(sistemaEcuacion.getxResult())).append("\n\n")
               .append("              Los resultados de tus ecuaciones son:                                                          \n")
               .append("                  x =").append(roundTwoDecimals(sistemaEcuacion.getxResult()))
               .append("  y = ").append(roundTwoDecimals(sistemaEcuacion.getyResult())).append("\n\n\n");
       this.showProcessMessage(responseMessage.toString());
       this.cleanAll();
   }


    /**
     * Metodo para resolver un sistema de ecuaciones de 3X3 por sustitucion
     */
    public void Sustitucion3x3() {
        //Panel para ingresar los valores de las ecuaciones
        panel = this.cratePanel(size3X3);

        //Generar los fields necesarios
        this.generateFields(panel, xFields,yFields,zFields,resFields);

        result = JOptionPane.showConfirmDialog(null, panel,
                "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result != JOptionPane.OK_OPTION) return;

        this.getFieldsValues(sistemaEcuacion, xFields,yFields,zFields,resFields);

        //Proceso utilizando sustitucion para resolver sistema 3X3
        this.get3x3Values();

        xProcess1 = z2.multiply(res1).divide(z1, 10, RoundingMode.HALF_UP);
        xProcess2 = z2.negate().multiply(x1).divide(z1, 10, RoundingMode.HALF_UP);
        xProcess3 = z2.negate().multiply(y1).divide(z1, 10, RoundingMode.HALF_UP);
        xProcess4 = x2.add(xProcess2);
        xProcess5 = y2.add(xProcess3);
        xProcess6 = res2.subtract(xProcess1);

        yProcess1 = z3.multiply(res1).divide(z1, 10, RoundingMode.HALF_UP);
        yProcess2 = z3.negate().multiply(x1).divide(z1, 10, RoundingMode.HALF_UP);
        yProcess3 = z3.negate().multiply(y1).divide(z1, 10, RoundingMode.HALF_UP);
        yProcess4 = x3.add(yProcess2);
        yProcess5 = y3.add(yProcess3);
        yProcess6 = res3.subtract(yProcess1);

        zProcess1 = yProcess4.multiply(xProcess6).divide(xProcess4, 2, RoundingMode.HALF_UP);
        zProcess2 = yProcess4.negate().multiply(xProcess5).divide(xProcess4, 2, RoundingMode.HALF_UP);
        zProcess3 = zProcess2.add(yProcess5);

        sistemaEcuacion.setyResult(yProcess6.subtract(zProcess1).divide(zProcess3, 2, RoundingMode.HALF_UP));

        zProcess4 = yProcess5.multiply(sistemaEcuacion.getyResult());
        zProcess5 = yProcess6.subtract(zProcess4).divide(yProcess4, 2, RoundingMode.HALF_UP);

        List<BigDecimal> findZValue = new ArrayList<>();
        findZValue.add(x1.multiply(zProcess5));
        findZValue.add(y1.multiply(sistemaEcuacion.getyResult()));
        findZValue.add(res1.subtract(findZValue.getFirst()));
        findZValue.add(findZValue.get(positionThree).subtract(findZValue.get(positionTwo)));

        sistemaEcuacion.setzResult(findZValue.get(positionFour).divide(z1,2, RoundingMode.HALF_UP));

        responseMessage.append("Tus ecuaciones son:\n")
                .append(roundTwoDecimals(x1)).append("x+").append(roundTwoDecimals(y1)).append("y+").append(roundTwoDecimals(z1)).append("z=")
                .append(roundTwoDecimals(res1)).append("\n").append(roundTwoDecimals(x2)).append("x+")
                .append(roundTwoDecimals(y2)).append("y+").append(roundTwoDecimals(z2)).append("z=")
                .append(roundTwoDecimals(res2)).append("\n").append(roundTwoDecimals(x3)).append("x+")
                .append(roundTwoDecimals(y3)).append("y+").append(roundTwoDecimals(z3)).append("z=")
                .append(roundTwoDecimals(res3)).append("\n").append("despejar 'z' de ecuacion 1\n")
                .append("z=(").append(roundTwoDecimals(res1)).append("+").append(roundTwoDecimals(x1.negate())).append("x+")
                .append(roundTwoDecimals(y1.negate())).append("y)/").append(roundTwoDecimals(z1)).append("\n")
                .append("sutituir valor de z en ecuacion 2\n(4)   ").append(roundTwoDecimals(xProcess4)).append("x+")
                .append(roundTwoDecimals(xProcess5)).append("y=").append(roundTwoDecimals(res2.subtract(xProcess1))).append("\n")
                .append("sutituir valor de z en ecuacion 3\n(5)   ").append(roundTwoDecimals(yProcess4)).append("x+")
                .append(roundTwoDecimals(yProcess5)).append("y=").append(roundTwoDecimals(res3.subtract(yProcess1))).append("\n")
                .append("despejar 'x' de ecuacion 4\n(6)    x=(").append(roundTwoDecimals(xProcess6)).append("+")
                .append(roundTwoDecimals(xProcess5).negate()).append("y)/").append(roundTwoDecimals(xProcess4)).append("\n")
                .append("sustituir valor de x en ecuacion 5\n").append(roundTwoDecimals(yProcess4)).append("(")
                .append(roundTwoDecimals(xProcess6)).append("+").append(roundTwoDecimals(xProcess5.negate())).append("y)/")
                .append(roundTwoDecimals(xProcess4)).append("\n").append("resolver y despejar y\ny=")
                .append(roundTwoDecimals(yProcess6.subtract(zProcess1))).append("/").append(roundTwoDecimals(zProcess3)).append("\n")
                .append("y=").append(roundTwoDecimals(sistemaEcuacion.getyResult())).append("\n").append("sustituir y en ecuacion 6\nx=(")
                .append(roundTwoDecimals(xProcess6)).append("+").append(roundTwoDecimals(xProcess5.negate())).append("(")
                .append(roundTwoDecimals(sistemaEcuacion.getyResult())).append("))/").append(roundTwoDecimals(xProcess4)).append("\n")
                .append("x=(").append(roundTwoDecimals(xProcess6)).append("+").append(roundTwoDecimals(xProcess5.multiply(sistemaEcuacion.getyResult())).negate())
                .append(")/").append(roundTwoDecimals(xProcess4)).append("\n").append("x=")
                .append(roundTwoDecimals(xProcess6.subtract(xProcess5.multiply(sistemaEcuacion.getyResult())))).append("/")
                .append(roundTwoDecimals(xProcess4)).append("\n").append("x=").append(roundTwoDecimals(zProcess5)).append("\n")
                .append("sustituir valor de x e y en ecuacion 1\n").append(roundTwoDecimals(x1)).append("(")
                .append(roundTwoDecimals(zProcess5)).append(")+").append(roundTwoDecimals(y1)).append("(")
                .append(roundTwoDecimals(sistemaEcuacion.getyResult())).append(")+").append(roundTwoDecimals(z1)).append("z=")
                .append(roundTwoDecimals(res1)).append("\n").append(roundTwoDecimals(findZValue.getFirst().add(findZValue.get(positionTwo))))
                .append("+").append(roundTwoDecimals(z1)).append("z=").append(roundTwoDecimals(res1)).append("\n")
                .append("z=(").append(roundTwoDecimals(res1)).append("+")
                .append(roundTwoDecimals(findZValue.getFirst().add(findZValue.get(positionTwo)).negate()))
                .append(")/").append(roundTwoDecimals(z1)).append("\n").append("z=")
                .append(roundTwoDecimals(sistemaEcuacion.getzResult())).append("\n")
                .append("Los resultados de tus ecuaciones son:\n\n").append("x  = ").append(roundTwoDecimals(zProcess5))
                .append("     y = ").append(roundTwoDecimals(sistemaEcuacion.getyResult()))
                .append("     z = ").append(roundTwoDecimals(sistemaEcuacion.getzResult()));
        this.showProcessMessage(responseMessage.toString());
        this.cleanAll();
   }

    /**
     * Metodo para resolver un sistema de ecuaciones de 2X2 por suma y resta
     */
    public void SumayrestaReduccion2x2() {
        //Panel para ingresar los valores de las ecuaciones
        panel = this.cratePanel(size2X2);

        //Generar los fields necesarios
        this.generateFields(panel, xFields,yFields,resFields);

        result = JOptionPane.showConfirmDialog(null, panel,
                "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result != JOptionPane.OK_OPTION) return;

        this.getFieldsValues(sistemaEcuacion, xFields, yFields, resFields);
        this.get2x2Values();

        yProcess1 = y1.negate().multiply(x2);
        yProcess2 = y1.negate().multiply(y2);
        yProcess3 = y1.negate().multiply(res2);

        xProcess1 = y2.multiply(x1);
        xProcess2 = y2.multiply(y1);
        xProcess3 = y2.multiply(res1);

        zProcess1 = xProcess1.add(yProcess1);
        zProcess2 = xProcess2.add(yProcess2);
        zProcess3 = xProcess3.add(yProcess3);
        zProcess4 = zProcess3.divide(zProcess1,2,RoundingMode.HALF_UP);

        xProcess4 = x1.multiply(zProcess4);
        xProcess5 = res1.subtract(xProcess4);

        sistemaEcuacion.setyResult(xProcess5.divide(y1,2,RoundingMode.HALF_UP));

        this.showProcessMessage("Tus ecuaciones son :\n" + roundTwoDecimals(x1)
                + "x+" + roundTwoDecimals(y1) + "y = " + roundTwoDecimals(res1)
                + "\n" + roundTwoDecimals(x2) + "x+" + roundTwoDecimals(y2)
                + "y = " + roundTwoDecimals(res2) + "             \n"
                + "\neliminar 'y' multiplicando\n" + roundTwoDecimals(xProcess1)
                + "x+" + roundTwoDecimals(xProcess2) + "y=" + roundTwoDecimals(xProcess3)
                + "\n" + roundTwoDecimals(yProcess1) + "x+" + roundTwoDecimals(yProcess2)
                + "y=" + roundTwoDecimals(yProcess3) + "\n\nSumar valores nuevos\n"
                + roundTwoDecimals(zProcess1) + "x+" + roundTwoDecimals(zProcess2)
                + "y=" + roundTwoDecimals(zProcess3) + "\n" + roundTwoDecimals(zProcess1)
                + "x=" + roundTwoDecimals(zProcess3) + "\nx=" + roundTwoDecimals(zProcess3)
                + "/" + roundTwoDecimals(zProcess1) + "\nx=" + roundTwoDecimals(zProcess4)
                + "\n\nsustituir 'x' en alguna ecuacion\n" + roundTwoDecimals(x1)
                + "(" + roundTwoDecimals(zProcess4) + ")+" + roundTwoDecimals(y1)
                + "y=" + roundTwoDecimals(res1) + "\n" + roundTwoDecimals(y1) + "y="
                + roundTwoDecimals(res1) + "+" + roundTwoDecimals(xProcess4.negate())
                + "\ny=" + roundTwoDecimals(x1) + "/" + roundTwoDecimals(y1)
                + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\nLos resultados de tus ecuaciones son:                             \n\n"
                + "                 x =" + roundTwoDecimals(zProcess4) + "     "
                + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\n");
        this.cleanAll();
   }

   /**
    * Metodo para resolver un sistema de ecuaciones de 3X3 por suma y resta
    */
   public void Sumayresta3x3() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size3X3);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,zFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result != JOptionPane.OK_OPTION) return;

       this.getFieldsValues(sistemaEcuacion, xFields,yFields,zFields,resFields);
       this.get3x3Values();

       xProcess1 = y1.multiply(x2);
       xProcess2 = z1.multiply(x2);
       xProcess3 = res1.multiply(x2);

       yProcess1 = y2.multiply(x1.negate());
       yProcess2 = z2.multiply(x1.negate());
       yProcess3 = res2.multiply(x1.negate());

       xProcess4 = xProcess1.add(yProcess1);
       xProcess5 = xProcess2.add(yProcess2);
       xProcess6 = xProcess3.add(yProcess3);
       xProcess7 = y1.multiply(x3);
       xProcess8 = z1.multiply(x3);
       xProcess9 = res1.multiply(x3);

       zProcess1 = y3.multiply(x1.negate());
       zProcess2 = z3.multiply(x1.negate());
       zProcess3 = res3.multiply(x1.negate());

       yProcess4 = xProcess7.add(zProcess1);
       yProcess5 = xProcess8.add(zProcess2);
       yProcess6 = xProcess9.add(zProcess3);

       xProcess10 = xProcess5.multiply(yProcess4);
       xProcess11 = xProcess6.multiply(yProcess4);

       zProcess4 = yProcess5.multiply(xProcess4.negate());
       zProcess5 = yProcess6.multiply(xProcess4.negate());
       zProcess6 = xProcess10.add(zProcess4);
       zProcess7 = xProcess11.add(zProcess5);
       sistemaEcuacion.setzResult(zProcess7.divide(zProcess6,2,RoundingMode.HALF_UP));

       yProcess7 = xProcess5.multiply(sistemaEcuacion.getzResult());
       yProcess8 = xProcess6.subtract(yProcess7);
       sistemaEcuacion.setyResult(yProcess8.divide(xProcess4,2,RoundingMode.HALF_UP));

       yProcess9 = y1.multiply(sistemaEcuacion.getyResult());
       zProcess8 = z1.multiply(sistemaEcuacion.getzResult());
       xProcess12 = res1.subtract(yProcess9).subtract(zProcess8);

       sistemaEcuacion.setxResult(xProcess12.divide(x1,2,RoundingMode.HALF_UP));

       //Mensaje con el proceso de la solucion
       this.showProcessMessage("Tus ecuaciones son:\n" + x1
               + "x+" + roundTwoDecimals(y1) + "y+" + roundTwoDecimals(z1) + "z="
               + roundTwoDecimals(res1) + "\n" + roundTwoDecimals(x2) + "x+"
               + roundTwoDecimals(y2) + "y+" + roundTwoDecimals(z2)
               + "z=" + roundTwoDecimals(res2) + "\n" + roundTwoDecimals(x3)
               + "x+" + roundTwoDecimals(y3) + "y+"
               + roundTwoDecimals(z3) + "z=" + roundTwoDecimals(res3)
               + "\neliminar 'x' con ecuacion 1 y 2\n" + roundTwoDecimals(x1) + "x+" + roundTwoDecimals(y1) + "y+"
               + roundTwoDecimals(z1) + "z=" + roundTwoDecimals(res1) + "\n"
               + roundTwoDecimals(x2) + "x+" + roundTwoDecimals(y2)
               + "y+" + roundTwoDecimals(z2) + "z=" + roundTwoDecimals(res2)
               + "\n(4)   " + roundTwoDecimals(xProcess4)
               + "y+" + roundTwoDecimals(xProcess5) + "z=" + roundTwoDecimals(xProcess6)
               + "\neliminar 'x' con ecuacion 1 y 3\n" + roundTwoDecimals(x1) + "x+" + roundTwoDecimals(y1)
               + "y+" + roundTwoDecimals(z1) + "z=" + roundTwoDecimals(res1) + "\n"
               + roundTwoDecimals(x3) + "x+" + roundTwoDecimals(y3)
               + "y+" + roundTwoDecimals(z3) + "z=" + roundTwoDecimals(res3)
               + "\n(5)   " + roundTwoDecimals(yProcess4)
               + "y+" + roundTwoDecimals(yProcess5) + "z=" + roundTwoDecimals(yProcess6)
               + "\neliminar 'y' con ecuacion 4 y 5 y despejar 'z'\n" + roundTwoDecimals(xProcess4)
               + "y+" + roundTwoDecimals(xProcess5) + "z=" + roundTwoDecimals(xProcess6) + "\n"
               + roundTwoDecimals(yProcess4) + "y+" + roundTwoDecimals(yProcess5) + "z="
               + roundTwoDecimals(yProcess6) + "\n  " + roundTwoDecimals(zProcess6)
               + "z=" + roundTwoDecimals(zProcess7) + "\nz=" + roundTwoDecimals(zProcess7) + "/"
               + roundTwoDecimals(zProcess6) + "\nz=" + roundTwoDecimals(sistemaEcuacion.getzResult())
               + "\nsutituir 'z' en ecuacion 4 y despejar 'y'\n" + roundTwoDecimals(xProcess4) + "y+"
               + roundTwoDecimals(xProcess5) + "(" + roundTwoDecimals(sistemaEcuacion.getzResult()) + ")"
               + "=" + roundTwoDecimals(xProcess6) + "\n" + roundTwoDecimals(xProcess4) + "y+"
               + roundTwoDecimals(yProcess7) + "=" + roundTwoDecimals(xProcess6) + "\n"
               + roundTwoDecimals(xProcess4) + "y=" + roundTwoDecimals(xProcess6) + "-"
               + roundTwoDecimals(yProcess7) + "\ny=" + roundTwoDecimals(yProcess8) + "/"
               + roundTwoDecimals(xProcess4) + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nsutituir 'y' y 'z' en ecuacion 1 y despejar x\n"
               + roundTwoDecimals(x1) + "x+" + roundTwoDecimals(y1) + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")+"
               + roundTwoDecimals(z1) + "(" + roundTwoDecimals(sistemaEcuacion.getzResult()) + ")=" + roundTwoDecimals(res1) + "\n"
               + roundTwoDecimals(x1) + "x=" + roundTwoDecimals(res1)
               + "-" + roundTwoDecimals(zProcess8) + "-(" + roundTwoDecimals(yProcess9) + ")"
               + "\nx=" + roundTwoDecimals(xProcess12) + "/" + roundTwoDecimals(x1) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getxResult())
               + "\n\n             Los resultados de tus ecuaciones son:\n\nx  = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = "
               + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
       this.cleanAll();
   }

    /**
     * Metodo para resolver un sistema de ecuaciones de 2X2 por determinantes
     */
   public void Determinantes2x2() {

       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size2X2);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result != JOptionPane.OK_OPTION) return;
       this.getFieldsValues(sistemaEcuacion, xFields, yFields, resFields);
       this.get2x2Values();

       xProcess1 = x1.multiply(y2);
       xProcess2 = y1.multiply(x2);
       xProcess3 = xProcess1.subtract(xProcess2);
       xProcess4 = res1.multiply(y2);
       xProcess5 = y1.multiply(res2);
       xProcess6 = xProcess4.subtract(xProcess5);

       yProcess1 = x1.multiply(res2);
       yProcess2 = res1.multiply(x2);
       yProcess3 = yProcess1.subtract(yProcess2);

       sistemaEcuacion.setxResult(xProcess6.divide(xProcess3,2,RoundingMode.HALF_UP));
       sistemaEcuacion.setyResult(yProcess3.divide(xProcess3,2,RoundingMode.HALF_UP));

       this.showProcessMessage("Tus ecuaciones son:\n" +
               roundTwoDecimals(x1) + "x+" + roundTwoDecimals(y1)
               + "y=" + roundTwoDecimals(res1)
               + "\n" + roundTwoDecimals(x2) + "x+" + roundTwoDecimals(y2)
               + "y=" + roundTwoDecimals(res2)
               + "\nsacar determinante principal utilizando columna 'x' e 'y'\n" + roundTwoDecimals(x1)
               + "   " + roundTwoDecimals(y1) + "\n" +
               roundTwoDecimals(x2) + "   " + roundTwoDecimals(y2)
               + "\nmultiplicar columnas\n" + roundTwoDecimals(x1)
               + "(" + roundTwoDecimals(y2) + ")=" + roundTwoDecimals(xProcess1) + "\n" +
               roundTwoDecimals(y1) + "(" + roundTwoDecimals(x2) + ")="
               + roundTwoDecimals(xProcess2) + "\nrestar resultados\n" + roundTwoDecimals(xProcess1)
               + "-(" + roundTwoDecimals(xProcess2) + ")=" + roundTwoDecimals(xProcess3)
               + "      Dp=" + roundTwoDecimals(xProcess3) +
               "\ndeterminante 'x' utilizando resultados e 'y'\n" + roundTwoDecimals(res1) + "   "
               + roundTwoDecimals(y1) + "\n" + roundTwoDecimals(res2) + "   "
               + roundTwoDecimals(y2) + "\nresolver\n" + roundTwoDecimals(res1)
               + "(" + roundTwoDecimals(y2) + ")="
               + roundTwoDecimals(xProcess4) + "\n" + roundTwoDecimals(y1)
               + "(" + roundTwoDecimals(res2) + ")=" + roundTwoDecimals(xProcess5) +
               "\nrestar\n" + roundTwoDecimals(xProcess4) + "-(" + roundTwoDecimals(xProcess5)
               + ")=" + roundTwoDecimals(xProcess6) + "      Dp=" + roundTwoDecimals(xProcess6) +
               "\ndeterminante 'y' utilizando resultados e 'x'\n" + roundTwoDecimals(x1) + "   "
               + roundTwoDecimals(res1) + "\n" + roundTwoDecimals(x2) + "   "
               + roundTwoDecimals(res2) + "\nresolver\n" + roundTwoDecimals(x1)
               + "(" + roundTwoDecimals(res2)
               + ")=" + roundTwoDecimals(yProcess1) + "\n" + roundTwoDecimals(res1) + "("
               + roundTwoDecimals(x2) + ")=" + roundTwoDecimals(yProcess2) +
               "\nrestar\n" + roundTwoDecimals(yProcess1) + "-(" + roundTwoDecimals(yProcess2)
               + ")=" + roundTwoDecimals(yProcess3)
               + "      Dp=" + roundTwoDecimals(yProcess3) + "\ndividie Dx y Dy entre Dp\nx="
               + roundTwoDecimals(xProcess6) + "/"
               + roundTwoDecimals(xProcess3) + "=" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "\ny=" +
               roundTwoDecimals(yProcess3) + "/" + roundTwoDecimals(xProcess3)
               + "=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nLos resultados de tus ecuaciones son:                                            \n"
               + "                x = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     "
               + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     \n\n");
       this.cleanAll();
   }

    /**
     * Metodo para resolver un sistema de ecuaciones de 3X3 por determinantes
     */
   public void Determinantes3x3() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size3X3);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,zFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result != JOptionPane.OK_OPTION) return;
       this.getFieldsValues(sistemaEcuacion, xFields, yFields, zFields, resFields);
       this.get3x3Values();

       xProcess1 = x1.multiply(y2).multiply(z3);
       xProcess2 = x2.multiply(y3).multiply(z1);
       xProcess3 = x3.multiply(y1).multiply(z2);
       xProcess4 = z1.multiply(y2).multiply(x3);
       xProcess5 = z2.multiply(y3).multiply(x1);
       xProcess6 = z3.multiply(y1).multiply(x2);
       xProcess7 = xProcess1.add(xProcess2).add(xProcess3);
       xProcess8 = xProcess4.add(xProcess5).add(xProcess6);
       xProcess9 = xProcess7.subtract(xProcess8);
       xProcess10 = res1.multiply(y2).multiply(z3);
       xProcess11 = y1.multiply(z2).multiply(res3);
       xProcess12 = z1.multiply(res2).multiply(y3);
       xProcess13 = z1.multiply(y2).multiply(res3);
       xProcess14 = res1.multiply(z2).multiply(y3);
       xProcess15 = y1.multiply(res2).multiply(z3);
       xProcess16 = xProcess10.add(xProcess11).add(xProcess12);
       xProcess17 = xProcess13.add(xProcess14).add(xProcess15);
       xProcess18 = xProcess16.subtract(xProcess17);

       yProcess1 = x1.multiply(res2).multiply(z3);
       yProcess2 = x2.multiply(res3).multiply(z1);
       yProcess3 = x3.multiply(res1).multiply(z2);
       yProcess4 = z1.multiply(res2).multiply(x3);
       yProcess5 = z2.multiply(res3).multiply(x1);
       yProcess6 = z3.multiply(res1).multiply(x2);
       yProcess7 = yProcess1.add(yProcess2).add(yProcess3);
       yProcess8 = yProcess4.add(yProcess5).add(yProcess6);
       yProcess9 = yProcess7.subtract(yProcess8);

       zProcess1 = x1.multiply(y2).multiply(res3);
       zProcess2 = y1.multiply(res2).multiply(x3);
       zProcess3 = res1.multiply(x2).multiply(y3);
       zProcess4 = res1.multiply(y2).multiply(x3);
       zProcess5 = x1.multiply(res2).multiply(y3);
       zProcess6 = y1.multiply(x2).multiply(res3);
       zProcess7 = zProcess1.add(zProcess2).add(zProcess3);
       zProcess8 = zProcess4.add(zProcess5).add(zProcess6);
       zProcess9 = zProcess7.subtract(zProcess8);

       sistemaEcuacion.setxResult(xProcess18.divide(xProcess9,2,RoundingMode.HALF_UP));
       sistemaEcuacion.setyResult(yProcess9.divide(xProcess9,2,RoundingMode.HALF_UP));
       sistemaEcuacion.setzResult(zProcess9.divide(xProcess9,2,RoundingMode.HALF_UP));


       this.showProcessMessage("Tus ecuaciones son:\n" + roundTwoDecimals(x1) + "x+"
               + roundTwoDecimals(y1) + "y+ " + roundTwoDecimals(z1)
               + "z= " + roundTwoDecimals(res1) + "\n" + roundTwoDecimals(x2) + "x+"
               + roundTwoDecimals(y2) + "y+" + roundTwoDecimals(z2)
               + "z=" + roundTwoDecimals(res2) + "\n" + roundTwoDecimals(x3) + "x+"
               + roundTwoDecimals(y3) + "y+" + roundTwoDecimals(z3) + "z="
               + roundTwoDecimals(res3) + "\nsacar determinante del sistema por metodo sarrus\n"
               + roundTwoDecimals(x1) + "   " + roundTwoDecimals(y1) + "   "
               + roundTwoDecimals(z1) + "\n" + roundTwoDecimals(x2) + "   "
               + roundTwoDecimals(y2) + "   " + roundTwoDecimals(z2)
               + "               (" + roundTwoDecimals(xProcess1) + "+" + roundTwoDecimals(xProcess2) + "+" +
               roundTwoDecimals(xProcess3) + ")-(" + roundTwoDecimals(xProcess4)
               + "+" + roundTwoDecimals(xProcess5) + "+" + roundTwoDecimals(xProcess6)
               + ")\n" + roundTwoDecimals(x3) + "   "
               + roundTwoDecimals(y3) + "   " + roundTwoDecimals(z3) + "               Ds=("
               + roundTwoDecimals(xProcess7) + ")-(" + roundTwoDecimals(xProcess8)
               + ")=" + roundTwoDecimals(xProcess9) + "\n" + roundTwoDecimals(x1) + "   "
               + roundTwoDecimals(y1) + "   " + roundTwoDecimals(z1) + "\n"
               + roundTwoDecimals(x2) + "   "
               + roundTwoDecimals(y2) + "   " + roundTwoDecimals(z2)
               + "\nsacar determinante 'x' por metodo sarrus\n" + roundTwoDecimals(res1)
               + "   " + roundTwoDecimals(y1) + "   "
               + roundTwoDecimals(z1) + "   " + roundTwoDecimals(res1)
               + "   " + roundTwoDecimals(y1)
               + "\n" + roundTwoDecimals(res2) + "   " + roundTwoDecimals(y2) + "   "
               + roundTwoDecimals(z2) + "   " + roundTwoDecimals(res2) + "   "
               + roundTwoDecimals(y2) + "\n" + roundTwoDecimals(res3) + "   "
               + roundTwoDecimals(y3) + "   " + roundTwoDecimals(z3)
               + "   " + roundTwoDecimals(res3) + "   " + roundTwoDecimals(y3)
               + "\n(" + roundTwoDecimals(xProcess10) + "+" + roundTwoDecimals(xProcess11)
               + "+" + roundTwoDecimals(xProcess12) + ")-(" + roundTwoDecimals(xProcess13)
               + "+" + roundTwoDecimals(xProcess14) + "+" + roundTwoDecimals(xProcess15)
               + ")\nDx=(" + roundTwoDecimals(xProcess16) + ")-(" + roundTwoDecimals(xProcess17) + ")="
               + roundTwoDecimals(xProcess18) + "\nsacar determinante 'y' por metodo sarrus\n" + roundTwoDecimals(x1)
               + "   " + roundTwoDecimals(res1) + "   " + roundTwoDecimals(z1) + "\n" +
               roundTwoDecimals(x2) + "   " + roundTwoDecimals(res2) + "   "
               + roundTwoDecimals(z2) + "              (" + roundTwoDecimals(yProcess1)
               + "+" + roundTwoDecimals(yProcess2) + "+" + roundTwoDecimals(yProcess3) + ")-(" +
               roundTwoDecimals(yProcess4) + "+" + roundTwoDecimals(yProcess5)
               + "+" + roundTwoDecimals(yProcess6) + ")\n" + roundTwoDecimals(x3) + "   "
               + roundTwoDecimals(res3) + "   " + roundTwoDecimals(z3) + "                 Dy=("
               + roundTwoDecimals(yProcess7) + ")-(" + roundTwoDecimals(yProcess8)
               + ")=" + roundTwoDecimals(yProcess9) + "\n" + roundTwoDecimals(x1) + "   "
               + roundTwoDecimals(res1) + "   " + roundTwoDecimals(z1) + "\n" + roundTwoDecimals(x2) + "   "
               + roundTwoDecimals(res2) + "   " + roundTwoDecimals(z2) + "\nsacar determinante 'z' por metodo sarrus\n"
               + roundTwoDecimals(x1) + "   " + roundTwoDecimals(y1) + "   "
               + roundTwoDecimals(res1) + "   " + roundTwoDecimals(x1)
               + "   " + roundTwoDecimals(y1)
               + "\n" + roundTwoDecimals(x2) + "   " + roundTwoDecimals(y2)
               + "   " + roundTwoDecimals(res2) + "   " + roundTwoDecimals(x2) + "   "
               + roundTwoDecimals(y2) + "\n" + roundTwoDecimals(x3)
               + "   " + roundTwoDecimals(y3) + "   " + roundTwoDecimals(res3) + "   "
               + roundTwoDecimals(x3) + "   " + roundTwoDecimals(y3)
               + "\n(" + roundTwoDecimals(zProcess1) + "+" + roundTwoDecimals(zProcess2)
               + "+" + roundTwoDecimals(zProcess3) + ")-(" + roundTwoDecimals(zProcess4)
               + "+" + roundTwoDecimals(zProcess5) + "+" + roundTwoDecimals(zProcess6)
               + ")\nDz=(" + roundTwoDecimals(zProcess7) + ")-(" + roundTwoDecimals(zProcess8) + ")="
               + roundTwoDecimals(zProcess9) + "\nsacar los valores de las incognitas\nx=Dx/Ds=" + roundTwoDecimals(xProcess18)
               + "/" + roundTwoDecimals(xProcess9) + "=" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "\ny=Dy/Ds="
               + roundTwoDecimals(yProcess9) + "/" + roundTwoDecimals(xProcess9)
               + "=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nx=Dz/Ds=" + roundTwoDecimals(zProcess9)
               + "/" + roundTwoDecimals(xProcess9) + "="
               + roundTwoDecimals(sistemaEcuacion.getzResult()) + "\nLos resultados de tus ecuaciones son:\n"
               + "         x = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = "
               + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
       this.cleanAll();
   }

    /**
     * Metodo para resolver un sistema de ecuaciones de 2X2 por igualacion
     */
   public void Igualacion2x2() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size2X2);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result != JOptionPane.OK_OPTION) return;
       this.getFieldsValues(sistemaEcuacion, xFields, yFields, resFields);
       this.get2x2Values();

       xProcess1 = x1.negate();
       xProcess2 = x2.negate();
       xProcess3 = y2.multiply(res1);
       xProcess4 = y2.multiply(xProcess1);

       yProcess1 = y1.multiply(res2);
       yProcess2 = y1.multiply(xProcess2);
       yProcess3 = xProcess4.subtract(yProcess2);
       yProcess4 = yProcess1.subtract(xProcess3);

       sistemaEcuacion.setxResult(yProcess4.divide(yProcess3,2,RoundingMode.HALF_UP));
       sistemaEcuacion.setyResult((res2.add(xProcess2.multiply(sistemaEcuacion.getxResult()))).divide(y2,2,RoundingMode.HALF_UP));

       this.showProcessMessage("Tus ecuaciones son:\n" + roundTwoDecimals(x1) + "x+" + roundTwoDecimals(y1)
               + "y=" + roundTwoDecimals(res1) + "\n" + roundTwoDecimals(x2)
               + "x+" + roundTwoDecimals(y2) + "y=" + roundTwoDecimals(res2) + "\n\ndespejar 'y' en ambas ecuaciones\n"
               + "y=(" + roundTwoDecimals(res1) + "+" + roundTwoDecimals(xProcess1)
               + "x)/" + roundTwoDecimals(y1)
               + "\ny=(" + roundTwoDecimals(res2) + "+" + roundTwoDecimals(xProcess2) + "x)/"
               + roundTwoDecimals(y2) + "\n\nigualar ambos despejes\n" + "(" + roundTwoDecimals(res1)
               + "+" + roundTwoDecimals(xProcess1) + "x)/" + roundTwoDecimals(y1) + "=" + "("
               + roundTwoDecimals(res2) + "+" + roundTwoDecimals(xProcess2)
               + "x)/" + roundTwoDecimals(y2) + "\n\nresolver\n"
               + roundTwoDecimals(y2) + "(" + roundTwoDecimals(res1)
               + "+" + roundTwoDecimals(xProcess1) + "x) = "
               + roundTwoDecimals(y1) + "(" + roundTwoDecimals(res2) + "+"
               + roundTwoDecimals(xProcess2) + "x)\n" + roundTwoDecimals(xProcess3)
               + "+" + roundTwoDecimals(xProcess4) + "x = " + roundTwoDecimals(yProcess1)
               + "+" + roundTwoDecimals(yProcess2)
               + "x" + "\n\nsimplificar ecuacion\n" + roundTwoDecimals(xProcess4) + "x+" +
               roundTwoDecimals(yProcess2.negate()) + "x=" + roundTwoDecimals(yProcess1)
               + "+" + roundTwoDecimals(xProcess3.negate())
               + "\n" + roundTwoDecimals(yProcess3) + "x=" + roundTwoDecimals(yProcess4)
               + "\nx=" + roundTwoDecimals(yProcess4) + "/" + roundTwoDecimals(yProcess3) + "\nx="
               + roundTwoDecimals(sistemaEcuacion.getxResult()) + "\n\nsutituir 'x' en la ecuacion que mas convenga\n" + "y=("
               + roundTwoDecimals(res2) + "+(" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "))/"
               + roundTwoDecimals(y2) + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\nLos resultados de tus ecuaciones son:                                \n"
               + "                 x = " + roundTwoDecimals(sistemaEcuacion.getxResult())
               + "     " + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()));
       this.cleanAll();
   }

    /**
     * Metodo para resolver un sistema de ecuaciones de 2X2 por igualacion
     */
   public void Igualacion3x3() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size3X3);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,zFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result != JOptionPane.OK_OPTION) return;
       this.getFieldsValues(sistemaEcuacion, xFields, yFields, zFields, resFields);
       this.get3x3Values();

       xProcess1 = y1.negate();
       xProcess2 = z1.negate();
       xProcess3 = y2.negate();
       xProcess4 = z2.negate();
       xProcess5 = y3.negate();
       xProcess6 = z3.negate();
       xProcess7 = (x2.multiply(xProcess1)).subtract(x1.multiply(xProcess3));
       xProcess8 = (x2.multiply(xProcess2)).subtract(x1.multiply(xProcess4));
       xProcess9 = (x1.multiply(res2)).subtract(x2.multiply(res1));

       yProcess1 = (x3.multiply(xProcess1)).subtract(x1.multiply(xProcess5));

       zProcess1 = (x3.multiply(xProcess2)).subtract(x1.multiply(xProcess6));
       zProcess2 = (x1.multiply(res3)).subtract(x3.multiply(res1));
       zProcess3 = xProcess8.negate();
       zProcess4 = zProcess1.negate();
       zProcess5 = yProcess1.multiply(xProcess9);
       zProcess6 = yProcess1.multiply(zProcess3);
       zProcess7 = xProcess7.multiply(zProcess2);
       zProcess8 = xProcess7.multiply(zProcess4);
       zProcess9 = zProcess6.subtract(zProcess8);
       zProcess10 = zProcess7.subtract(zProcess5);

       sistemaEcuacion.setzResult(zProcess10.divide(zProcess9,2,RoundingMode.HALF_UP));

       yProcess2 = zProcess1.multiply(sistemaEcuacion.getzResult());

       sistemaEcuacion.setyResult((zProcess2.subtract(yProcess2)).divide(yProcess1,2,RoundingMode.HALF_UP));

       yProcess3 = y1.multiply(sistemaEcuacion.getyResult());
       yProcess4 = z1.multiply(sistemaEcuacion.getzResult());

       sistemaEcuacion.setxResult((res1.subtract((yProcess3.add(yProcess4)))).divide(x1,2,RoundingMode.HALF_UP));

       this.showProcessMessage("Tus ecuaciones son:\n(1)    " + roundTwoDecimals(x1)
               + "x+" + roundTwoDecimals(y1) + "y+" + roundTwoDecimals(z1)
               + "z=" + roundTwoDecimals(res1) + "\n(2)    " + roundTwoDecimals(x2)
               + "x+" + roundTwoDecimals(y2) + "y+" + roundTwoDecimals(z2)
               + "z=" + roundTwoDecimals(res2) + "\n(3)    " + roundTwoDecimals(x3)
               + "x+" + roundTwoDecimals(y3) + "y+" + roundTwoDecimals(z3)
               + "z=" + roundTwoDecimals(res3) + "\ndespejar la misma incognita en las 3 ecuaciones\n"
               + "(4)     x=(" + roundTwoDecimals(res1) + "+" + roundTwoDecimals(xProcess1)
               + "y+" + roundTwoDecimals(xProcess2) + "z)/"
               + roundTwoDecimals(x1) + "\n(5)     x=(" + roundTwoDecimals(res2)
               + "+" + roundTwoDecimals(xProcess3) + "y+" + roundTwoDecimals(xProcess4)
               + "z)/" + roundTwoDecimals(x2) + "\n(6)     x=("
               + roundTwoDecimals(res3) + "+" + roundTwoDecimals(xProcess5)
               + "y+" + roundTwoDecimals(xProcess6) + "z)/"
               + roundTwoDecimals(x3) + "\nigualar ecuacion 4 con 5\n("
               + roundTwoDecimals(res1) + "+" + roundTwoDecimals(xProcess1) + "y+"
               + roundTwoDecimals(xProcess2) + "z)/"
               + roundTwoDecimals(x1) + "=(" + roundTwoDecimals(res2) + "+"
               + roundTwoDecimals(xProcess3) + "y+" + roundTwoDecimals(xProcess4)
               + "z)/" + roundTwoDecimals(x2) + "\nresolver por producto cruzado\n(7)     "
               + roundTwoDecimals(xProcess7) + "y+" + roundTwoDecimals(xProcess8)
               + "z=" + roundTwoDecimals(xProcess9) + "\nigualar ecuacion 4 con 6\n(" + roundTwoDecimals(res1)
               + "+" + roundTwoDecimals(xProcess1) + "y+" + roundTwoDecimals(xProcess2)
               + "z)/" + roundTwoDecimals(x1) + "=("
               + roundTwoDecimals(res3) + "+" + roundTwoDecimals(xProcess5)
               + "y+" + roundTwoDecimals(xProcess6) + "z)/"
               + roundTwoDecimals(x3) + "\nresolver por producto cruzado\n(8)     "
               + roundTwoDecimals(yProcess1)
               + "y+" + roundTwoDecimals(zProcess1) + "z=" + roundTwoDecimals(zProcess2)
               + "\ndespejar la misma incognita en ecuacion 7 y 8\n (9)     y=(" + roundTwoDecimals(xProcess9)
               + "+" + roundTwoDecimals(zProcess3) + "z)/" + roundTwoDecimals(xProcess7)
               + "     (10)   y=(" + roundTwoDecimals(zProcess2) + "+" + roundTwoDecimals(zProcess4)
               + "z)/" + roundTwoDecimals(yProcess1) + "\nigualr ecuaciones 9 y 10\n"
               + "(" + roundTwoDecimals(xProcess9) + "+" + roundTwoDecimals(zProcess3)
               + "z)/" + roundTwoDecimals(xProcess7) + "=(" + roundTwoDecimals(zProcess2)
               + "+" + roundTwoDecimals(zProcess4) + "z)/"
               + roundTwoDecimals(yProcess1) + "\nresolver por producto cruzado\n"
               + roundTwoDecimals(zProcess6) + "z+" + roundTwoDecimals(zProcess8.negate())
               + "z=" + roundTwoDecimals(zProcess7) + "+" + roundTwoDecimals(zProcess5.negate())
               + "\n" + roundTwoDecimals(zProcess9) + "z=" + roundTwoDecimals(zProcess10) + "\nz="
               + roundTwoDecimals(zProcess10) + "/" + roundTwoDecimals(zProcess9)
               + "  =" + roundTwoDecimals(sistemaEcuacion.getzResult()) + "\nsustituir 'z' en ecuacion 8 para sacar 'y'\n"
               + roundTwoDecimals(yProcess1) + "y+" + roundTwoDecimals(zProcess1)
               + "(" + roundTwoDecimals(sistemaEcuacion.getzResult()) + ")="
               + roundTwoDecimals(zProcess2) + "\ny=(" + roundTwoDecimals(zProcess2)
               + "+" + roundTwoDecimals(yProcess2) + ")/" + roundTwoDecimals(yProcess1)
               + "     y=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nsustituir 'z' e 'y' en ecuacion 1 para sacar 'x'\n"
               + roundTwoDecimals(x1) + "x+" + roundTwoDecimals(y1)
               + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")+"
               + roundTwoDecimals(z1) + "(" + roundTwoDecimals(sistemaEcuacion.getzResult())
               + ")=" + roundTwoDecimals(res1) + "\n"
               + roundTwoDecimals(x1) + "x=" + roundTwoDecimals(res1) + "+"
               + roundTwoDecimals((yProcess3.add(yProcess4)).negate())
               + "\nx=" + roundTwoDecimals((res1.subtract(yProcess3.add(yProcess4))))
               + "/" + roundTwoDecimals(x1) + "  =" + roundTwoDecimals(sistemaEcuacion.getxResult())
               + "\n            Los resultados de tus ecuaciones son:\n\nx  = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = "
               + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
       this.cleanAll();
   }

    /**
     * Genera los campos de texto necesarios para capturar los valores de las ecuaciones
     * @param panel: el panel donde se agregarán los campos de texto
     * @param fieldsSize: las listas que almacenarán los campos de texto para cada variable
     */
    @SafeVarargs
    private void generateFields(JPanel panel, List<JTextField>... fieldsSize) {
        for (int i = 1; i <= fieldsSize.length-1; i++) {
            JTextField xValue = new JTextField();
            JTextField yValue = new JTextField();
            JTextField zValue = new JTextField();
            JTextField ecuRes = new JTextField();
            panel.add(xValue);
            panel.add(new JLabel("X +"));
            fieldsSize[0].add(xValue);
            fieldsSize[1].add(yValue);
            if(fieldsSize.length <= 3) {
                panel.add(yValue);
                panel.add(new JLabel("Y = "));
                fieldsSize[2].add(ecuRes);
            }else{
                panel.add(yValue);
                panel.add(new JLabel("Y + "));
                panel.add(zValue);
                panel.add(new JLabel("Z = "));
                fieldsSize[2].add(zValue);
                fieldsSize[3].add(ecuRes);
            }
            panel.add(ecuRes);
        }
    }

    /**
     * Obtiene los valores ingresados en los campos de texto y los almacena en el objeto SistemaEcuacion
     *
     * @param sistemaEcuacion: el objeto donde se almacenarán los valores
     * @param fieldsSize: las listas que contienen los campos de texto para cada variable
     */
    @SafeVarargs
    private void getFieldsValues(SistemaEcuacion sistemaEcuacion, List<JTextField>... fieldsSize) {
        //Obtener los valores capturados en los inputs
        for (int i = 0; i < fieldsSize[0].size(); i++) {
            sistemaEcuacion.getxValue().add(new BigDecimal(fieldsSize[0].get(i).getText()));
            sistemaEcuacion.getyValue().add(new BigDecimal(fieldsSize[1].get(i).getText()));
            if(fieldsSize.length <= 3){
                sistemaEcuacion.getEcuResults().add(new BigDecimal(fieldsSize[2].get(i).getText()));
            }else {
                sistemaEcuacion.getzValue().add(new BigDecimal(fieldsSize[2].get(i).getText()));
                sistemaEcuacion.getEcuResults().add(new BigDecimal(fieldsSize[3].get(i).getText()));
            }
        }
    }

    /**
     * Metodo para redondear un BigDecimal a dos decimales
     *
     * @param number: el numero a redondear
     * @return BigDecimal redondeado a dos decimales
     */
    private BigDecimal roundTwoDecimals(BigDecimal number){
        return number.setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * Muestra un mensaje con el proceso y resultados de las ecuaciones
     *
     * @param messageProcess: el mensaje a mostrar
     */
    private void showProcessMessage(String messageProcess) {
        JOptionPane.showMessageDialog(null,messageProcess,"Resultados", 1);
    }

    /**
     * Crea un panel con un GridLayout para ingresar los valores de las ecuaciones
     *
     * @param sizeEcu: el numero de ecuaciones
     * @return JPanel con el GridLayout configurado
     */
    private JPanel cratePanel(int sizeEcu) {
        return new JPanel(new GridLayout(0, sizeEcu, 10, 10));
    }

    /**
     * Limpia todas las variables y listas utilizadas en el proceso
     */
    private void cleanAll(){
        sistemaEcuacion = new SistemaEcuacion();
        xFields = new ArrayList<>();
        yFields = new ArrayList<>();
        zFields = new ArrayList<>();
        resFields = new ArrayList<>();
        xProcess1 = new BigDecimal(0);
        xProcess2 = new BigDecimal(0);
        xProcess3 = new BigDecimal(0);
        xProcess4 = new BigDecimal(0);
        xProcess5 = new BigDecimal(0);
        xProcess6 = new BigDecimal(0);
        xProcess7 = new BigDecimal(0);
        xProcess8 = new BigDecimal(0);
        xProcess9 = new BigDecimal(0);
        xProcess10 = new BigDecimal(0);
        xProcess11 = new BigDecimal(0);
        xProcess12  = new BigDecimal(0);
        xProcess13 = new BigDecimal(0);
        xProcess14 = new BigDecimal(0);
        xProcess15 = new BigDecimal(0);
        xProcess16 = new BigDecimal(0);
        xProcess17 = new BigDecimal(0);
        xProcess18 = new BigDecimal(0);
        yProcess1 = new BigDecimal(0);
        yProcess2 = new BigDecimal(0);
        yProcess3 = new BigDecimal(0);
        yProcess4 = new BigDecimal(0);
        yProcess5 = new BigDecimal(0);
        yProcess6 = new BigDecimal(0);
        yProcess7 = new BigDecimal(0);
        yProcess8 = new BigDecimal(0);
        yProcess9 = new BigDecimal(0);
        yProcess10 = new BigDecimal(0);
        zProcess1 = new BigDecimal(0);
        zProcess2 = new BigDecimal(0);
        zProcess3 = new BigDecimal(0);
        zProcess4 = new BigDecimal(0);
        zProcess5 = new BigDecimal(0);
        zProcess6 = new BigDecimal(0);
        zProcess7 = new BigDecimal(0);
        zProcess8 = new BigDecimal(0);
        zProcess9 = new BigDecimal(0);
        zProcess10 = new BigDecimal(0);
        x1 = new BigDecimal(0);
        x2 = new BigDecimal(0);
        x3 = new BigDecimal(0);
        y1 = new BigDecimal(0);
        y2 = new BigDecimal(0);
        y3 = new BigDecimal(0);
        z1 = new BigDecimal(0);
        z2 = new BigDecimal(0);
        z3 = new BigDecimal(0);
        res1 = new BigDecimal(0);
        res2 = new BigDecimal(0);
        res3 = new BigDecimal(0);
        responseMessage = new StringBuilder();
    }

    /**
     * Obtiene los valores de las ecuaciones 2X2 y los asigna a las variables correspondientes
     */
    private void get2x2Values(){
        x1 = sistemaEcuacion.getxValue().getFirst();
        y1 = sistemaEcuacion.getyValue().getFirst();
        res1 = sistemaEcuacion.getEcuResults().getFirst();
        x2 = sistemaEcuacion.getxValue().get(positionTwo);
        y2 = sistemaEcuacion.getyValue().get(positionTwo);
        res2 = sistemaEcuacion.getEcuResults().get(positionTwo);
    }

    /**
     * Obtiene los valores de las ecuaciones 3X3 y los asigna a las variables correspondientes
     */
    private void get3x3Values(){
        x1 = sistemaEcuacion.getxValue().getFirst();
        y1 = sistemaEcuacion.getyValue().getFirst();
        z1 = sistemaEcuacion.getzValue().getFirst();
        res1 = sistemaEcuacion.getEcuResults().getFirst();
        x2 = sistemaEcuacion.getxValue().get(positionTwo);
        y2 = sistemaEcuacion.getyValue().get(positionTwo);
        z2 = sistemaEcuacion.getzValue().get(positionTwo);
        res2 = sistemaEcuacion.getEcuResults().get(positionTwo);
        x3 = sistemaEcuacion.getxValue().get(positionThree);
        y3 = sistemaEcuacion.getyValue().get(positionThree);
        z3 = sistemaEcuacion.getzValue().get(positionThree);
        res3 = sistemaEcuacion.getEcuResults().get(positionThree);
    }
}
