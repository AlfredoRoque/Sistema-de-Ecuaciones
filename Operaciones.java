package ecuaciones;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class Operaciones {
    int xPositionTwo = 1;
    int xPositionThree = 2;
    int yPositionTwo = 1;
    int yPositionThree = 2;
    int zPositionTwo = 1;
    int zPositionThree = 2;
    int resPositionTwo = 1;
    int resPositionThree = 2;
    int size2X2 = 5;
    int size3X3 = 7;
    int result;
    SistemaEcuacion sistemaEcuacion = new SistemaEcuacion();
    JPanel panel;
    List<JTextField> xFields = new ArrayList<>();
    List<JTextField> yFields = new ArrayList<>();
    List<JTextField> zFields = new ArrayList<>();
    List<JTextField> resFields = new ArrayList<>();

    /**
     * Metodo para resolver un sistema de ecuaciones de 2X2
     */
   public void Sustitucion2x2() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size2X2);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       if (result == JOptionPane.OK_OPTION) {
           this.getFieldsValues(sistemaEcuacion, xFields,yFields,resFields);

           //Proceso utilizando sustitucion para resolver sistema 2X2
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(xPositionTwo) * sistemaEcuacion.getEcuResults().getFirst() / sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(xPositionTwo) * -1.0D * sistemaEcuacion.getyValue().getFirst() / sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(1) + sistemaEcuacion.getyValue().get(yPositionTwo));
           sistemaEcuacion.setyResult((sistemaEcuacion.getEcuResults().get(resPositionTwo) + -1.0D * sistemaEcuacion.getxProcess().getFirst()) / sistemaEcuacion.getxProcess().get(2));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().get(yPositionTwo) * sistemaEcuacion.getyResult());
           sistemaEcuacion.setxResult((sistemaEcuacion.getEcuResults().get(resPositionTwo) + -1.0D * sistemaEcuacion.getyProcess().getFirst()) / sistemaEcuacion.getxValue().get(xPositionTwo));

           //Muestra proceso que se siguio para la solucion
           this.showProcessMessage("Tus ecuaciones son :\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(xPositionTwo)) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(yPositionTwo)) + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionTwo)) + "             \n" + "\ndespejar 'x' en ecuacion 1\n x="
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) * -1.0D + "x /" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "\n"
                   + "\nsustituir 'x' en ecuacion 2 \n " + roundTwoDecimals(sistemaEcuacion.getxValue().get(xPositionTwo)) + "(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) * -1.0D + "y /" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + ")+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(yPositionTwo))
                   + "y" + "=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n\nresolver multiplicacion \n "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(1)) + "y+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(yPositionTwo))
                   + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionTwo)) + "\n " + roundTwoDecimals(sistemaEcuacion.getxProcess().get(2)) + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) * -1.0D
                   + "\n\ndespejar 'y' \n y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) * -1.0D + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(2)) + "\n\ny="
                   + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\nsustituir valor de 'y' en ecuacion 2\n " + roundTwoDecimals(sistemaEcuacion.getxValue().get(xPositionTwo)) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(yPositionTwo)) + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionTwo))
                   + "\n\ndespejar 'x'\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(xPositionTwo)) + "x=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionTwo)) + "+"
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) * -1.0D + "\nx=" + roundTwoDecimals((sistemaEcuacion.getEcuResults().get(resPositionTwo) + -1.0D * sistemaEcuacion.getyProcess().getFirst()))
                   + "/" + roundTwoDecimals(sistemaEcuacion.getxValue().get(xPositionTwo)) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getxResult())
                   + "\n\n              Los resultados de tus ecuaciones son:                                                          \n"
                   + "                  x =" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "  " + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\n\n");
       }
   }

    /**
     * Metodo para resolver un sistema de ecuaciones de 3X3
     */
    public void Sustitucion3x3() {
        //Panel para ingresar los valores de las ecuaciones
        panel = this.cratePanel(size3X3);

        //Generar los fields necesarios
        this.generateFields(panel, xFields,yFields,zFields,resFields);

        result = JOptionPane.showConfirmDialog(null, panel,
                "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            this.getFieldsValues(sistemaEcuacion, xFields,yFields,zFields,resFields);

            //Proceso utilizando sustitucion para resolver sistema 3X3
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(zPositionTwo) * sistemaEcuacion.getEcuResults().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(zPositionTwo) * -1.0F * sistemaEcuacion.getxValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(zPositionTwo) * -1.0F * sistemaEcuacion.getyValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(xPositionTwo) + sistemaEcuacion.getxProcess().get(xPositionTwo));
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(yPositionTwo) + sistemaEcuacion.getxProcess().get(xPositionThree));
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().get(yPositionTwo) + -1.0F * sistemaEcuacion.getxProcess().getFirst());

            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(zPositionThree) * sistemaEcuacion.getEcuResults().getFirst());
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(zPositionThree) * -1.0F * sistemaEcuacion.getxValue().getFirst());
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(zPositionThree) * -1.0F * sistemaEcuacion.getyValue().getFirst());
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxValue().get(zPositionThree) + sistemaEcuacion.getyProcess().get(1));
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().get(yPositionThree) + sistemaEcuacion.getyProcess().get(2));
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getEcuResults().get(resPositionThree) + -1.0F * sistemaEcuacion.getyProcess().getFirst());

            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(3) * sistemaEcuacion.getxProcess().get(5) / sistemaEcuacion.getxProcess().get(3));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(3) * -1.0F * sistemaEcuacion.getxProcess().get(4) / sistemaEcuacion.getxProcess().get(3));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(1) + sistemaEcuacion.getyProcess().get(4));

            sistemaEcuacion.setyResult((sistemaEcuacion.getyProcess().get(5) + -1.0F * sistemaEcuacion.getzProcess().getFirst()) / sistemaEcuacion.getzProcess().get(2));

            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(4) * sistemaEcuacion.getyResult());
            sistemaEcuacion.getzProcess().add((sistemaEcuacion.getyProcess().get(5) + -1.0F * sistemaEcuacion.getzProcess().get(3)) / sistemaEcuacion.getyProcess().get(3));

            List<Double> findZValue = new ArrayList<>();
            findZValue.add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getzProcess().get(4));
            findZValue.add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getyResult());
            findZValue.add(sistemaEcuacion.getEcuResults().getFirst() + -1.0F * findZValue.getFirst());
            findZValue.add(findZValue.get(2) + -1.0F * findZValue.get(1));

            sistemaEcuacion.setzResult(findZValue.get(3) / sistemaEcuacion.getzValue().getFirst());

            //Mensaje con el proceso de la solucion
            this.showProcessMessage("Tus ecuaciones son:\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                    + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst())
                    + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n"
                    + roundTwoDecimals(sistemaEcuacion.getxValue().get(xPositionTwo)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(yPositionTwo)) + "y+"
                    + roundTwoDecimals(sistemaEcuacion.getzValue().get(zPositionTwo)) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(yPositionTwo))
                    + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(zPositionThree)) + "x+"
                    + roundTwoDecimals(sistemaEcuacion.getyValue().get(yPositionThree)) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(zPositionThree))
                    + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionThree)) + "\ndespejar 'z' de ecuacion 1\n"
                    + "z=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+"
                    + -1.0F * roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+"
                    + -1.0F * roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                    + "y)/" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\nsutituir valor de z en ecuacion 2\n" + "(4)   "
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "x+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(4))
                    + "y=" + roundTwoDecimals((sistemaEcuacion.getEcuResults().get(yPositionTwo) + -1.0F * sistemaEcuacion.getxProcess().getFirst())) + "\nsutituir valor de z en ecuacion 3\n" + "(5)   "
                    + roundTwoDecimals(sistemaEcuacion.getyProcess().get(3)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(4))
                    + "y=" + roundTwoDecimals((sistemaEcuacion.getEcuResults().get(resPositionThree) + -1.0F * sistemaEcuacion.getyProcess().getFirst())) + "\ndespejar 'x' de ecuacion 4\n(6)    x=("
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+" + -1.0F * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4)) + "y)/"
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nsustituir valor de x en ecuacion 5\n"
                    + roundTwoDecimals(sistemaEcuacion.getyProcess().get(3)) + "(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+"
                    + -1.0F * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4)) + "y)/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nresolver y despejar y\ny="
                    + roundTwoDecimals((sistemaEcuacion.getyProcess().get(5) + -1.0F * sistemaEcuacion.getzProcess().getFirst()))
                    + "/" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(2)) + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nsustituir y en ecuacion 6\nx=("
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+" + -1.0F * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4))
                    + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "))/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3))
                    + "\nx=(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+" + -1.0F * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4) * sistemaEcuacion.getyResult())
                    + ")/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nx="
                    + roundTwoDecimals((sistemaEcuacion.getxProcess().get(5) + -1.0F * sistemaEcuacion.getxProcess().get(4) * sistemaEcuacion.getyResult()))
                    + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(4))
                    + "\nsustituir valor de x e y en ecuacion 1\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                    + "(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(4)) + ")+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                    + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")+" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst())
                    + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(findZValue.getFirst() + findZValue.get(1)) + "+"
                    + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                    + "\nz=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + -1.0F * roundTwoDecimals((findZValue.getFirst() + findZValue.get(1)))
                    + ")/" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\nz=" + roundTwoDecimals(sistemaEcuacion.getzResult()) + "\nLos resultados de tus ecuaciones son:\n\nx  = "
                    + roundTwoDecimals(sistemaEcuacion.getzProcess().get(4)) + "     " + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult())
                    + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
        }
   }

    public void SumayrestaReduccion2x2() {
        //Panel para ingresar los valores de las ecuaciones
        panel = this.cratePanel(size2X2);

        //Generar los fields necesarios
        this.generateFields(panel, xFields,yFields,resFields);

        result = JOptionPane.showConfirmDialog(null, panel,
                "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            this.getFieldsValues(sistemaEcuacion, xFields, yFields, resFields);

            sistemaEcuacion.getyProcess().add(-sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(xPositionTwo));
            sistemaEcuacion.getyProcess().add(-sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getyValue().get(yPositionTwo));
            sistemaEcuacion.getyProcess().add(-sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getEcuResults().get(resPositionTwo));

            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(yPositionTwo) * sistemaEcuacion.getxValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(yPositionTwo) * sistemaEcuacion.getyValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(yPositionTwo) * sistemaEcuacion.getEcuResults().getFirst());

            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().getFirst() + sistemaEcuacion.getyProcess().getFirst());
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(1) + sistemaEcuacion.getyProcess().get(1));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(2) + sistemaEcuacion.getyProcess().get(2));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(2) / sistemaEcuacion.getzProcess().getFirst());

            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getzProcess().get(3));
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() + -1.0D * sistemaEcuacion.getxProcess().get(3));

            sistemaEcuacion.setyResult(sistemaEcuacion.getxProcess().get(4) / sistemaEcuacion.getyValue().getFirst());

            this.showProcessMessage("Tus ecuaciones son :\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                    + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                    + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(xPositionTwo)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(yPositionTwo))
                    + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(resPositionTwo)) + "             \n"
                    + "\neliminar 'y' multiplicando\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst())
                    + "x+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(1)) + "y=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(2))
                    + "\n" + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(1))
                    + "y=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(2)) + "\n\nSumar valores nuevos\n"
                    + roundTwoDecimals(sistemaEcuacion.getzProcess().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(1))
                    + "y=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(2)) + "\n" + roundTwoDecimals(sistemaEcuacion.getzProcess().getFirst())
                    + "x=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(2)) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(2))
                    + "/" + roundTwoDecimals(sistemaEcuacion.getzProcess().getFirst()) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(3))
                    + "\n\nsustituir 'x' en alguna ecuacion\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                    + "(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(3)) + ")+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                    + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y="
                    + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + -1.0D * roundTwoDecimals(sistemaEcuacion.getxProcess().get(3))
                    + "\ny=" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "/" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                    + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\nLos resultados de tus ecuaciones son:                             \n\n"
                    + "                 x =" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(3)) + "     "
                    + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\n");
        }
   }

   public void Sumayresta3x3() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size3X3);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,zFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       if (result == JOptionPane.OK_OPTION) {
           this.getFieldsValues(sistemaEcuacion, xFields,yFields,zFields,resFields);

           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(yPositionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getxValue().get(yPositionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getxValue().get(yPositionTwo));

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().get(yPositionTwo) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(zPositionTwo) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getEcuResults().get(zPositionTwo) * -sistemaEcuacion.getxValue().getFirst());

           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().getFirst() + sistemaEcuacion.getyProcess().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(1) + sistemaEcuacion.getyProcess().get(1));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(2) + sistemaEcuacion.getyProcess().get(2));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(zPositionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getxValue().get(zPositionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getxValue().get(zPositionThree));

           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyValue().get(yPositionThree) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzValue().get(zPositionThree) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getEcuResults().get(resPositionThree) * -sistemaEcuacion.getxValue().getFirst());

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxProcess().get(6) + sistemaEcuacion.getzProcess().getFirst());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxProcess().get(7) + sistemaEcuacion.getzProcess().get(1));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxProcess().get(8) + sistemaEcuacion.getzProcess().get(2));

           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(4) * sistemaEcuacion.getyProcess().get(3));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(5) * sistemaEcuacion.getyProcess().get(3));

           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(4) * -sistemaEcuacion.getxProcess().get(3));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(5) * -sistemaEcuacion.getxProcess().get(3));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(9) + sistemaEcuacion.getzProcess().get(3));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(10) + sistemaEcuacion.getzProcess().get(4));
           sistemaEcuacion.setzResult(sistemaEcuacion.getzProcess().get(6) / sistemaEcuacion.getzProcess().get(5));

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxProcess().get(4) * sistemaEcuacion.getzResult());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxProcess().get(5) - sistemaEcuacion.getyProcess().get(6));
           sistemaEcuacion.setyResult(sistemaEcuacion.getyProcess().get(7) / sistemaEcuacion.getxProcess().get(3));

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getyResult());
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getzResult());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() - sistemaEcuacion.getyProcess().get(8) - sistemaEcuacion.getzProcess().get(7));

           sistemaEcuacion.setxResult(sistemaEcuacion.getxProcess().get(11) / sistemaEcuacion.getxValue().getFirst());

           //Mensaje con el proceso de la solucion
           this.showProcessMessage("Tus ecuaciones son:\n" + sistemaEcuacion.getxValue().getFirst()
                   + "x+" + sistemaEcuacion.getyValue().getFirst() + "y+" + sistemaEcuacion.getzValue().getFirst() + "z="
                   + sistemaEcuacion.getEcuResults().getFirst() + "\n" + sistemaEcuacion.getxValue().get(yPositionTwo) + "x+"
                   + sistemaEcuacion.getyValue().get(yPositionTwo) + "y+" + sistemaEcuacion.getzValue().get(zPositionTwo)
                   + "z=" + sistemaEcuacion.getEcuResults().get(zPositionTwo) + "\n" + sistemaEcuacion.getxValue().get(zPositionThree)
                   + "x+" + sistemaEcuacion.getyValue().get(zPositionThree) + "y+"
                   + sistemaEcuacion.getzValue().get(zPositionThree) + "z=" + sistemaEcuacion.getEcuResults().get(resPositionThree)
                   + "\neliminar 'x' con ecuacion 1 y 2\n" + sistemaEcuacion.getxValue().getFirst() + "x+" + sistemaEcuacion.getyValue().getFirst() + "y+"
                   + sistemaEcuacion.getzValue().getFirst() + "z=" + sistemaEcuacion.getEcuResults().getFirst() + "\n"
                   + sistemaEcuacion.getxValue().get(yPositionTwo) + "x+" + sistemaEcuacion.getyValue().get(yPositionTwo)
                   + "y+" + sistemaEcuacion.getzValue().get(zPositionTwo) + "z=" + sistemaEcuacion.getEcuResults().get(zPositionTwo) + "\n(4)   " + sistemaEcuacion.getxProcess().get(3)
                   + "y+" + sistemaEcuacion.getxProcess().get(4) + "z=" + sistemaEcuacion.getxProcess().get(5)
                   + "\neliminar 'x' con ecuacion 1 y 3\n" + sistemaEcuacion.getxValue().getFirst() + "x+" + sistemaEcuacion.getyValue().getFirst()
                   + "y+" + sistemaEcuacion.getzValue().getFirst() + "z=" + sistemaEcuacion.getEcuResults().getFirst() + "\n"
                   + sistemaEcuacion.getxValue().get(zPositionThree) + "x+" + sistemaEcuacion.getyValue().get(zPositionThree)
                   + "y+" + sistemaEcuacion.getzValue().get(zPositionThree) + "z=" + sistemaEcuacion.getEcuResults().get(resPositionThree)
                   + "\n(5)   " + sistemaEcuacion.getyProcess().get(3)
                   + "y+" + sistemaEcuacion.getyProcess().get(4) + "z=" + sistemaEcuacion.getyProcess().get(5)
                   + "\neliminar 'y' con ecuacion 4 y 5 y despejar 'z'\n" + sistemaEcuacion.getxProcess().get(3)
                   + "y+" + sistemaEcuacion.getxProcess().get(4) + "z=" + sistemaEcuacion.getxProcess().get(5) + "\n"
                   + sistemaEcuacion.getyProcess().get(3) + "y+" + sistemaEcuacion.getyProcess().get(4) + "z="
                   + sistemaEcuacion.getyProcess().get(5) + "\n  " + sistemaEcuacion.getzProcess().get(5)
                   + "z=" + sistemaEcuacion.getzProcess().get(6) + "\nz=" + sistemaEcuacion.getzProcess().get(6) + "/"
                   + sistemaEcuacion.getzProcess().get(5) + "\nz=" + sistemaEcuacion.getzResult()
                   + "\nsutituir 'z' en ecuacion 4 y despejar 'y'\n" + sistemaEcuacion.getxProcess().get(3) + "y+"
                   + sistemaEcuacion.getxProcess().get(4) + "(" + sistemaEcuacion.getzResult() + ")"
                   + "=" + sistemaEcuacion.getxProcess().get(5) + "\n" + sistemaEcuacion.getxProcess().get(3) + "y+"
                   + sistemaEcuacion.getyProcess().get(6) + "=" + sistemaEcuacion.getxProcess().get(5) + "\n"
                   + sistemaEcuacion.getxProcess().get(3) + "y=" + sistemaEcuacion.getxProcess().get(5) + "-"
                   + sistemaEcuacion.getyProcess().get(6) + "\ny=" + sistemaEcuacion.getyProcess().get(7) + "/"
                   + sistemaEcuacion.getxProcess().get(3) + "\ny=" + sistemaEcuacion.getyResult() + "\nsutituir 'y' y 'z' en ecuacion 1 y despejar x\n"
                   + sistemaEcuacion.getxValue().getFirst() + "x+" + sistemaEcuacion.getyValue().getFirst() + "(" + sistemaEcuacion.getyResult() + ")+"
                   + sistemaEcuacion.getzValue().getFirst() + "(" + sistemaEcuacion.getzResult() + ")=" + sistemaEcuacion.getEcuResults().getFirst() + "\n"
                   + sistemaEcuacion.getxValue().getFirst() + "x=" + sistemaEcuacion.getEcuResults().getFirst()
                   + "-" + sistemaEcuacion.getzProcess().get(7) + "-(" + sistemaEcuacion.getyProcess().get(8) + ")"
                   + "\nx=" + sistemaEcuacion.getxProcess().get(11) + "/" + sistemaEcuacion.getxValue().getFirst() + "\nx=" + sistemaEcuacion.getxResult()
                   + "\n\n             Los resultados de tus ecuaciones son:\n\nx  = " + sistemaEcuacion.getxResult() + "     " + "y = "
                   + sistemaEcuacion.getyResult() + "     " + "z = " + sistemaEcuacion.getzResult());
       }
   }

   public void Determinantes2x2() {
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

   public void Determinantes3x3() {
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

   public void Igualacion2x2() {
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

   public void Igualacion3x3() {
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

    @SafeVarargs
    private void getFieldsValues(SistemaEcuacion sistemaEcuacion, List<JTextField>... fieldsSize) {
        //Obtener los valores capturados en los inputs
        for (int i = 0; i < fieldsSize[0].size(); i++) {
            sistemaEcuacion.getxValue().add(Double.parseDouble(fieldsSize[0].get(i).getText()));
            sistemaEcuacion.getyValue().add(Double.parseDouble(fieldsSize[1].get(i).getText()));
            if(fieldsSize.length <= 3){
                sistemaEcuacion.getEcuResults().add(Double.parseDouble(fieldsSize[2].get(i).getText()));
            }else {
                sistemaEcuacion.getzValue().add(Double.parseDouble(fieldsSize[2].get(i).getText()));
                sistemaEcuacion.getEcuResults().add(Double.parseDouble(fieldsSize[3].get(i).getText()));
            }
        }
    }

    private double roundTwoDecimals(double number){
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void showProcessMessage(String messageProcess) {
        JOptionPane.showMessageDialog(null,messageProcess,"Resultados", 1);
    }

    private JPanel cratePanel(int sizeEcu) {
        return new JPanel(new GridLayout(0, sizeEcu, 10, 10));
    }
}
