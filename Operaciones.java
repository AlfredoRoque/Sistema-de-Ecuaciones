package ecuaciones;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.swing.*;
import java.util.List;

public class Operaciones {

    int positionTwo = 1;
    int positionThree = 2;
    int positionFour = 3;
    int positionFive = 4;
    int positionSix = 5;
    int positionSeven = 6;
    int positionEight = 7;
    int positionNine = 8;
    int positionTen = 9;
    int positionEleven = 10;
    int positionTwelve = 11;
    int positionThirteen = 12;
    int positionFourteen = 13;
    int positionFifteen = 14;
    int positionSixteen = 15;
    int positionSeventeen = 16;
    int positionEighteen = 17;
    int size2X2 = 5;
    int size3X3 = 7;
    int result;
    float LESS_ONE_FLOAT = -1.0F;
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
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getEcuResults().getFirst() / sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(positionTwo) * -1.0D * sistemaEcuacion.getyValue().getFirst() / sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(1) + sistemaEcuacion.getyValue().get(positionTwo));
           sistemaEcuacion.setyResult((sistemaEcuacion.getEcuResults().get(positionTwo) + -1.0D * sistemaEcuacion.getxProcess().getFirst()) / sistemaEcuacion.getxProcess().get(2));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getyResult());
           sistemaEcuacion.setxResult((sistemaEcuacion.getEcuResults().get(positionTwo) + -1.0D * sistemaEcuacion.getyProcess().getFirst()) / sistemaEcuacion.getxValue().get(positionTwo));

           //Muestra proceso que se siguio para la solucion
           this.showProcessMessage("Tus ecuaciones son :\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "             \n" + "\ndespejar 'x' en ecuacion 1\n x="
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) * -1.0D + "x /" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "\n"
                   + "\nsustituir 'x' en ecuacion 2 \n " + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) * -1.0D + "y /" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + ")+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo))
                   + "y" + "=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n\nresolver multiplicacion \n "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(1)) + "y+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo))
                   + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "\n " + roundTwoDecimals(sistemaEcuacion.getxProcess().get(2)) + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) * -1.0D
                   + "\n\ndespejar 'y' \n y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) * -1.0D + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(2)) + "\n\ny="
                   + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\nsustituir valor de 'y' en ecuacion 2\n " + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo))
                   + "\n\ndespejar 'x'\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+"
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) * -1.0D + "\nx=" + roundTwoDecimals((sistemaEcuacion.getEcuResults().get(positionTwo) + -1.0D * sistemaEcuacion.getyProcess().getFirst()))
                   + "/" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getxResult())
                   + "\n\n              Los resultados de tus ecuaciones son:                                                          \n"
                   + "                  x =" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "  " + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\n\n");
           this.cleanAll();
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
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(positionTwo) * sistemaEcuacion.getEcuResults().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(positionTwo) * LESS_ONE_FLOAT * sistemaEcuacion.getxValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(positionTwo) * LESS_ONE_FLOAT * sistemaEcuacion.getyValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(positionTwo) + sistemaEcuacion.getxProcess().get(positionTwo));
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(positionTwo) + sistemaEcuacion.getxProcess().get(positionThree));
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().get(positionTwo) + LESS_ONE_FLOAT * sistemaEcuacion.getxProcess().getFirst());

            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(positionThree) * sistemaEcuacion.getEcuResults().getFirst());
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(positionThree) * LESS_ONE_FLOAT * sistemaEcuacion.getxValue().getFirst());
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(positionThree) * LESS_ONE_FLOAT * sistemaEcuacion.getyValue().getFirst());
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxValue().get(positionThree) + sistemaEcuacion.getyProcess().get(1));
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().get(positionThree) + sistemaEcuacion.getyProcess().get(2));
            sistemaEcuacion.getyProcess().add(sistemaEcuacion.getEcuResults().get(positionThree) + LESS_ONE_FLOAT * sistemaEcuacion.getyProcess().getFirst());

            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(3) * sistemaEcuacion.getxProcess().get(5) / sistemaEcuacion.getxProcess().get(3));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(3) * LESS_ONE_FLOAT * sistemaEcuacion.getxProcess().get(4) / sistemaEcuacion.getxProcess().get(3));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(1) + sistemaEcuacion.getyProcess().get(4));

            sistemaEcuacion.setyResult((sistemaEcuacion.getyProcess().get(5) + LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().getFirst()) / sistemaEcuacion.getzProcess().get(2));

            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().get(4) * sistemaEcuacion.getyResult());
            sistemaEcuacion.getzProcess().add((sistemaEcuacion.getyProcess().get(5) + LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().get(3)) / sistemaEcuacion.getyProcess().get(3));

            List<Double> findZValue = new ArrayList<>();
            findZValue.add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getzProcess().get(4));
            findZValue.add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getyResult());
            findZValue.add(sistemaEcuacion.getEcuResults().getFirst() + LESS_ONE_FLOAT * findZValue.getFirst());
            findZValue.add(findZValue.get(2) + LESS_ONE_FLOAT * findZValue.get(1));

            sistemaEcuacion.setzResult(findZValue.get(3) / sistemaEcuacion.getzValue().getFirst());

            //Mensaje con el proceso de la solucion
            this.showProcessMessage("Tus ecuaciones son:\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                    + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst())
                    + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n"
                    + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "y+"
                    + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo)) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo))
                    + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "x+"
                    + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree)) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree))
                    + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "\ndespejar 'z' de ecuacion 1\n"
                    + "z=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+"
                    + LESS_ONE_FLOAT * roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+"
                    + LESS_ONE_FLOAT * roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                    + "y)/" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\nsutituir valor de z en ecuacion 2\n" + "(4)   "
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "x+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(4))
                    + "y=" + roundTwoDecimals((sistemaEcuacion.getEcuResults().get(positionTwo) + LESS_ONE_FLOAT * sistemaEcuacion.getxProcess().getFirst())) + "\nsutituir valor de z en ecuacion 3\n" + "(5)   "
                    + roundTwoDecimals(sistemaEcuacion.getyProcess().get(3)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(4))
                    + "y=" + roundTwoDecimals((sistemaEcuacion.getEcuResults().get(positionThree) + LESS_ONE_FLOAT * sistemaEcuacion.getyProcess().getFirst())) + "\ndespejar 'x' de ecuacion 4\n(6)    x=("
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+" + LESS_ONE_FLOAT * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4)) + "y)/"
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nsustituir valor de x en ecuacion 5\n"
                    + roundTwoDecimals(sistemaEcuacion.getyProcess().get(3)) + "(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+"
                    + LESS_ONE_FLOAT * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4)) + "y)/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nresolver y despejar y\ny="
                    + roundTwoDecimals((sistemaEcuacion.getyProcess().get(5) + LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().getFirst()))
                    + "/" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(2)) + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nsustituir y en ecuacion 6\nx=("
                    + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+" + LESS_ONE_FLOAT * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4))
                    + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "))/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3))
                    + "\nx=(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "+" + LESS_ONE_FLOAT * roundTwoDecimals(sistemaEcuacion.getxProcess().get(4) * sistemaEcuacion.getyResult())
                    + ")/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nx="
                    + roundTwoDecimals((sistemaEcuacion.getxProcess().get(5) + LESS_ONE_FLOAT * sistemaEcuacion.getxProcess().get(4) * sistemaEcuacion.getyResult()))
                    + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(4))
                    + "\nsustituir valor de x e y en ecuacion 1\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                    + "(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(4)) + ")+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                    + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")+" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst())
                    + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(findZValue.getFirst() + findZValue.get(1)) + "+"
                    + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                    + "\nz=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + LESS_ONE_FLOAT * roundTwoDecimals((findZValue.getFirst() + findZValue.get(1)))
                    + ")/" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\nz=" + roundTwoDecimals(sistemaEcuacion.getzResult()) + "\nLos resultados de tus ecuaciones son:\n\nx  = "
                    + roundTwoDecimals(sistemaEcuacion.getzProcess().get(4)) + "     " + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult())
                    + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
            this.cleanAll();
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

            sistemaEcuacion.getyProcess().add(-sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));
            sistemaEcuacion.getyProcess().add(-sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getyValue().get(positionTwo));
            sistemaEcuacion.getyProcess().add(-sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo));

            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getxValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getyValue().getFirst());
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getEcuResults().getFirst());

            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().getFirst() + sistemaEcuacion.getyProcess().getFirst());
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(1) + sistemaEcuacion.getyProcess().get(1));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(2) + sistemaEcuacion.getyProcess().get(2));
            sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(2) / sistemaEcuacion.getzProcess().getFirst());

            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getzProcess().get(3));
            sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() + -1.0D * sistemaEcuacion.getxProcess().get(3));

            sistemaEcuacion.setyResult(sistemaEcuacion.getxProcess().get(4) / sistemaEcuacion.getyValue().getFirst());

            this.showProcessMessage("Tus ecuaciones son :\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                    + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                    + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo))
                    + "y = " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "             \n"
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
            this.cleanAll();
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

           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().get(positionTwo) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(positionTwo) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getEcuResults().get(positionTwo) * -sistemaEcuacion.getxValue().getFirst());

           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().getFirst() + sistemaEcuacion.getyProcess().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(1) + sistemaEcuacion.getyProcess().get(1));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(2) + sistemaEcuacion.getyProcess().get(2));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getxValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getxValue().get(positionThree));

           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyValue().get(positionThree) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzValue().get(positionThree) * -sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getEcuResults().get(positionThree) * -sistemaEcuacion.getxValue().getFirst());

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
                   + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "z="
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo))
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree))
                   + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree)) + "y+"
                   + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree)) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree))
                   + "\neliminar 'x' con ecuacion 1 y 2\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y+"
                   + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo))
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo)) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo))
                   + "\n(4)   " + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3))
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(4)) + "z=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5))
                   + "\neliminar 'x' con ecuacion 1 y 3\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree))
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree)) + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree))
                   + "\n(5)   " + roundTwoDecimals(sistemaEcuacion.getyProcess().get(3))
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(4)) + "z=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(5))
                   + "\neliminar 'y' con ecuacion 4 y 5 y despejar 'z'\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3))
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(4)) + "z=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "\n"
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().get(3)) + "y+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(4)) + "z="
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().get(5)) + "\n  " + roundTwoDecimals(sistemaEcuacion.getzProcess().get(5))
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(6)) + "\nz=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(6)) + "/"
                   + roundTwoDecimals(sistemaEcuacion.getzProcess().get(5)) + "\nz=" + roundTwoDecimals(sistemaEcuacion.getzResult())
                   + "\nsutituir 'z' en ecuacion 4 y despejar 'y'\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "y+"
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(4)) + "(" + roundTwoDecimals(sistemaEcuacion.getzResult()) + ")"
                   + "=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "y+"
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().get(6)) + "=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "\n"
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "y=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(5)) + "-"
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().get(6)) + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(7)) + "/"
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(3)) + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nsutituir 'y' y 'z' en ecuacion 1 y despejar x\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")+"
                   + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "(" + roundTwoDecimals(sistemaEcuacion.getzResult()) + ")=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "-" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(7)) + "-(" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(8)) + ")"
                   + "\nx=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(11)) + "/" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "\nx=" + roundTwoDecimals(sistemaEcuacion.getxResult())
                   + "\n\n             Los resultados de tus ecuaciones son:\n\nx  = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = "
                   + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
           this.cleanAll();
       }
   }

   public void Determinantes2x2() {

       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size2X2);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result == JOptionPane.OK_OPTION) {
           this.getFieldsValues(sistemaEcuacion, xFields, yFields, resFields);

           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getyValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().getFirst() - sistemaEcuacion.getxProcess().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getyValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(positionFour) - sistemaEcuacion.getxProcess().get(positionFive));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyProcess().getFirst() - sistemaEcuacion.getyProcess().get(positionTwo));
           sistemaEcuacion.setxResult(sistemaEcuacion.getxProcess().get(positionSix) / sistemaEcuacion.getxProcess().get(positionThree));
           sistemaEcuacion.setyResult(sistemaEcuacion.getyProcess().get(positionThree) / sistemaEcuacion.getxProcess().get(positionThree));

           this.showProcessMessage("Tus ecuaciones son:\n" +
                   roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo))
                   + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo))
                   + "\nsacar determinante principal utilizando columna 'x' e 'y'\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                   + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "\n" +
                   roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo))
                   + "\nmultiplicar columnas\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                   + "(" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + ")=" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst()) + "\n" +
                   roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "(" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + ")="
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo)) + "\nrestar resultados\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst())
                   + "-(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo)) + ")=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree))
                   + "      Dp=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree)) +
                   "\ndeterminante 'x' utilizando resultados e 'y'\n" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "\nresolver\n" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "(" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + ")="
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFour)) + "\n" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + ")=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFive)) +
                   "\nrestar\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFour)) + "-(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFive))
                   + ")=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSix)) + "      Dp=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSix)) +
                   "\ndeterminante 'y' utilizando resultados e 'x'\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "\nresolver\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                   + "(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo))
                   + ")=" + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "("
                   + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + ")=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionTwo)) +
                   "\nrestar\n" + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) + "-(" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionTwo))
                   + ")=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionThree))
                   + "      Dp=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionThree)) + "\ndividie Dx y Dy entre Dp\nx="
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSix)) + "/"
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree)) + "=" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "\ny=" +
                   roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionThree)) + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree))
                   + "=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nLos resultados de tus ecuaciones son:                                            \n"
                   + "                x = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     \n\n");
           this.cleanAll();
       }
   }

   public void Determinantes3x3() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size3X3);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,zFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       if (result == JOptionPane.OK_OPTION) {
           this.getFieldsValues(sistemaEcuacion, xFields, yFields, zFields, resFields);

           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getzValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getyValue().get(positionThree) * sistemaEcuacion.getzValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxValue().get(positionThree) * sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getzValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getxValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(positionTwo) * sistemaEcuacion.getyValue().get(positionThree) * sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().get(positionThree) * sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().getFirst() + sistemaEcuacion.getxProcess().get(positionTwo) + sistemaEcuacion.getxProcess().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(positionFour) + sistemaEcuacion.getxProcess().get(positionFive) + sistemaEcuacion.getxProcess().get(positionSix));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(positionSeven) - sistemaEcuacion.getxProcess().get(positionEight));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getzValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getzValue().get(positionTwo) * sistemaEcuacion.getEcuResults().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo) * sistemaEcuacion.getyValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getEcuResults().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getzValue().get(positionTwo) * sistemaEcuacion.getyValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo) * sistemaEcuacion.getzValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(positionTen) + sistemaEcuacion.getxProcess().get(positionEleven) + sistemaEcuacion.getxProcess().get(positionTwelve));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(positionThirteen) + sistemaEcuacion.getxProcess().get(positionFourteen) + sistemaEcuacion.getxProcess().get(positionFifteen));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getxProcess().get(positionSixteen) - sistemaEcuacion.getxProcess().get(positionSeventeen));

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo) * sistemaEcuacion.getzValue().get(positionThree));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getEcuResults().get(positionThree) * sistemaEcuacion.getzValue().getFirst());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxValue().get(positionThree) * sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getzValue().get(positionTwo));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo) * sistemaEcuacion.getxValue().get(positionThree));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(positionTwo) * sistemaEcuacion.getEcuResults().get(positionThree) * sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().get(positionThree) * sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getxValue().get(positionTwo));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyProcess().getFirst() + sistemaEcuacion.getyProcess().get(positionTwo) + sistemaEcuacion.getyProcess().get(positionThree));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyProcess().get(positionFour) + sistemaEcuacion.getyProcess().get(positionFive) + sistemaEcuacion.getyProcess().get(positionSix));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyProcess().get(positionSeven) - sistemaEcuacion.getyProcess().get(positionEight));

           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getEcuResults().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo) * sistemaEcuacion.getxValue().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getyValue().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getEcuResults().getFirst() * sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getxValue().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo) * sistemaEcuacion.getyValue().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getEcuResults().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().getFirst() + sistemaEcuacion.getzProcess().get(positionTwo) + sistemaEcuacion.getzProcess().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(positionFour) + sistemaEcuacion.getzProcess().get(positionFive) + sistemaEcuacion.getzProcess().get(positionSix));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(positionSeven) - sistemaEcuacion.getzProcess().get(positionEight));

           sistemaEcuacion.setxResult(sistemaEcuacion.getxProcess().get(positionEighteen) / sistemaEcuacion.getxProcess().get(positionNine));
           sistemaEcuacion.setyResult(sistemaEcuacion.getyProcess().get(positionNine) / sistemaEcuacion.getxProcess().get(positionNine));
           sistemaEcuacion.setzResult(sistemaEcuacion.getzProcess().get(positionNine) / sistemaEcuacion.getxProcess().get(positionNine));


           this.showProcessMessage("Tus ecuaciones son:\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y+ " + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst())
                   + "z= " + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo))
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "x+"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree)) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree)) + "z="
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "\nsacar determinante del sistema por metodo sarrus\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo))
                   + "               (" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo)) + "+" +
                   roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree)) + ")-(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFour))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFive)) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSix))
                   + ")\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree)) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree)) + "               Ds=("
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSeven)) + ")-(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionEight))
                   + ")=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionNine)) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo))
                   + "\nsacar determinante 'x' por metodo sarrus\n" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "   " + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "\n" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "\n" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree)) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree))
                   + "   " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree))
                   + "\n(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTen)) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionEleven))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwelve)) + ")-(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThirteen))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFourteen)) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFifteen))
                   + ")\nDx=(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSixteen)) + ")-(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSeventeen)) + ")="
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionEighteen)) + "\nsacar determinante 'y' por metodo sarrus\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                   + "   " + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\n" +
                   roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo)) + "              (" + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst())
                   + "+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionThree)) + ")-(" +
                   roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionFour)) + "+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionFive))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionSix)) + ")\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree)) + "                 Dy=("
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionSeven)) + ")-(" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionEight))
                   + ")=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionNine)) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo)) + "\nsacar determinante 'z' por metodo sarrus\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "   " + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                   + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo))
                   + "   " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "   " + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree))
                   + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree)) + "   " + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "   "
                   + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "   " + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree))
                   + "\n(" + roundTwoDecimals(sistemaEcuacion.getzProcess().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTwo))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionThree)) + ")-(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionFour))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionFive)) + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionSix))
                   + ")\nDz=(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionSeven)) + ")-(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionEight)) + ")="
                   + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionNine)) + "\nsacar los valores de las incognitas\nx=Dx/Ds=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionEighteen))
                   + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionNine)) + "=" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "\ny=Dy/Ds="
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionNine)) + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionNine))
                   + "=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nx=Dz/Ds=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionNine))
                   + "/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionNine)) + "="
                   + roundTwoDecimals(sistemaEcuacion.getzResult()) + "\nLos resultados de tus ecuaciones son:\n" + "         x = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = "
                   + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
           this.cleanAll();
       }
   }

   public void Igualacion2x2() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size2X2);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

       if (result == JOptionPane.OK_OPTION) {
           this.getFieldsValues(sistemaEcuacion, xFields, yFields, resFields);

           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getxValue().getFirst());
           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getxValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getEcuResults().getFirst());
           sistemaEcuacion.getxProcess().add(sistemaEcuacion.getyValue().get(positionTwo) * sistemaEcuacion.getxProcess().getFirst());

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getxProcess().get(positionTwo));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getxProcess().get(positionFour) + LESS_ONE_FLOAT * sistemaEcuacion.getyProcess().get(positionTwo));
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyProcess().getFirst() + LESS_ONE_FLOAT * sistemaEcuacion.getxProcess().get(positionThree));

           sistemaEcuacion.setxResult(sistemaEcuacion.getyProcess().get(positionFour) / sistemaEcuacion.getyProcess().get(positionThree));
           sistemaEcuacion.setyResult((sistemaEcuacion.getEcuResults().get(positionTwo) + sistemaEcuacion.getxProcess().get(positionTwo) * sistemaEcuacion.getxResult()) / sistemaEcuacion.getyValue().get(positionTwo));

           this.showProcessMessage("Tus ecuaciones son:\n" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo))
                   + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "y=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "\n\ndespejar 'y' en ambas ecuaciones\n"
                   + "y=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst())
                   + "x)/" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "\ny=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo)) + "x)/"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "\n\nigualar ambos despejes\n" + "(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst()) + "x)/" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "=" + "("
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo))
                   + "x)/" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "\n\nresolver\n"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst()) + "x) = "
                   + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+"
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo)) + "x)\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFour)) + "x = " + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst())
                   + "+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionTwo))
                   + "x" + "\n\nsimplificar ecuacion\n" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFour)) + "x+" +
                   roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionTwo) * LESS_ONE_FLOAT) + "x=" + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst())
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree) * LESS_ONE_FLOAT)
                   + "\n" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionThree)) + "x=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionFour))
                   + "\nx=" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionFour)) + "/" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionThree)) + "\nx="
                   + roundTwoDecimals(sistemaEcuacion.getxResult()) + "\n\nsutituir 'x' en la ecuacion que mas convenga\n" + "y=("
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+(" + roundTwoDecimals(sistemaEcuacion.getxResult()) + "))/"
                   + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "\ny=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\n\nLos resultados de tus ecuaciones son:                                \n"
                   + "                 x = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = " + roundTwoDecimals(sistemaEcuacion.getyResult()));
           this.cleanAll();
       }
   }

   public void Igualacion3x3() {
       //Panel para ingresar los valores de las ecuaciones
       panel = this.cratePanel(size3X3);

       //Generar los fields necesarios
       this.generateFields(panel, xFields,yFields,zFields,resFields);

       result = JOptionPane.showConfirmDialog(null, panel,
               "Indica los valores de tus ecuaciones", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
       if (result == JOptionPane.OK_OPTION) {
           this.getFieldsValues(sistemaEcuacion, xFields, yFields, zFields, resFields);

           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getyValue().getFirst());
           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getzValue().getFirst());
           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getyValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getzValue().get(positionTwo));
           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getyValue().get(positionThree));
           sistemaEcuacion.getxProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getzValue().get(positionThree));
           sistemaEcuacion.getxProcess().add((sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getxProcess().getFirst()) + LESS_ONE_FLOAT * (sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getxProcess().get(positionThree)));
           sistemaEcuacion.getxProcess().add((sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getxProcess().get(positionTwo)) + LESS_ONE_FLOAT * (sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getxProcess().get(positionFour)));
           sistemaEcuacion.getxProcess().add((sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionTwo)) + LESS_ONE_FLOAT * (sistemaEcuacion.getxValue().get(positionTwo) * sistemaEcuacion.getEcuResults().getFirst()));

           sistemaEcuacion.getyProcess().add((sistemaEcuacion.getxValue().get(positionThree) * sistemaEcuacion.getxProcess().getFirst()) + LESS_ONE_FLOAT * (sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getxProcess().get(positionFive)));

           sistemaEcuacion.getzProcess().add((sistemaEcuacion.getxValue().get(positionThree) * sistemaEcuacion.getxProcess().get(positionTwo)) + LESS_ONE_FLOAT * (sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getxProcess().get(positionSix)));
           sistemaEcuacion.getzProcess().add((sistemaEcuacion.getxValue().getFirst() * sistemaEcuacion.getEcuResults().get(positionThree)) + LESS_ONE_FLOAT * (sistemaEcuacion.getxValue().get(positionThree) * sistemaEcuacion.getEcuResults().getFirst()));
           sistemaEcuacion.getzProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getxProcess().get(positionEight));
           sistemaEcuacion.getzProcess().add(LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().getFirst());
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().getFirst() * sistemaEcuacion.getxProcess().get(positionNine));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getyProcess().getFirst() * sistemaEcuacion.getzProcess().get(positionThree));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(positionSeven) * sistemaEcuacion.getzProcess().get(positionTwo));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getxProcess().get(positionSeven) * sistemaEcuacion.getzProcess().get(positionFour));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(positionSix) + LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().get(positionEight));
           sistemaEcuacion.getzProcess().add(sistemaEcuacion.getzProcess().get(positionSeven) + LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().get(positionFive));

           sistemaEcuacion.setzResult(sistemaEcuacion.getzProcess().get(positionTen) / sistemaEcuacion.getzProcess().get(positionNine));

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzProcess().getFirst() * sistemaEcuacion.getzResult());

           sistemaEcuacion.setyResult((sistemaEcuacion.getzProcess().get(positionTwo) + LESS_ONE_FLOAT * sistemaEcuacion.getyProcess().get(positionTwo)) / sistemaEcuacion.getyProcess().getFirst());

           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getyValue().getFirst() * sistemaEcuacion.getyResult());
           sistemaEcuacion.getyProcess().add(sistemaEcuacion.getzValue().getFirst() * sistemaEcuacion.getzResult());

           sistemaEcuacion.setxResult((sistemaEcuacion.getEcuResults().getFirst() + LESS_ONE_FLOAT * (sistemaEcuacion.getyProcess().get(positionThree) + sistemaEcuacion.getyProcess().get(positionFour))) / sistemaEcuacion.getxValue().getFirst());

           this.showProcessMessage("Tus ecuaciones son:\n(1)    " + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst())
                   + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst()) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst())
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n(2)    " + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo))
                   + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionTwo)) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionTwo))
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "\n(3)    " + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree))
                   + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().get(positionThree)) + "y+" + roundTwoDecimals(sistemaEcuacion.getzValue().get(positionThree))
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "\ndespejar la misma incognita en las 3 ecuaciones\n"
                   + "(4)     x=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst())
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo)) + "z)/"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "\n(5)     x=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree)) + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFour))
                   + "z)/" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "\n(6)     x=("
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFive))
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSix)) + "z)/"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "\nigualar ecuacion 4 con 5\n("
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst()) + "y+"
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo)) + "z)/"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "=(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionTwo)) + "+"
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionThree)) + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFour))
                   + "z)/" + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionTwo)) + "\nresolver por producto cruzado\n(7)     "
                   + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSeven)) + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionEight))
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionNine)) + "\nigualar ecuacion 4 con 6\n(" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst())
                   + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().getFirst()) + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionTwo))
                   + "z)/" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "=("
                   + roundTwoDecimals(sistemaEcuacion.getEcuResults().get(positionThree)) + "+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionFive))
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSix)) + "z)/"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().get(positionThree)) + "\nresolver por producto cruzado\n(8)     "
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst())
                   + "y+" + roundTwoDecimals(sistemaEcuacion.getzProcess().getFirst()) + "z=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTwo))
                   + "\ndespejar la misma incognita en ecuacion 7 y 8\n (9)     y=(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionNine))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionThree)) + "z)/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSeven))
                   + "     (10)   y=(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTwo)) + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionFour))
                   + "z)/" + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) + "\nigualr ecuaciones 9 y 10\n"
                   + "(" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionNine)) + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionThree))
                   + "z)/" + roundTwoDecimals(sistemaEcuacion.getxProcess().get(positionSeven)) + "=(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTwo))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionFour)) + "z)/"
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) + "\nresolver por producto cruzado\n"
                   + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionSix)) + "z+" + roundTwoDecimals(LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().get(positionEight))
                   + "z=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionSeven)) + "+" + roundTwoDecimals(LESS_ONE_FLOAT * sistemaEcuacion.getzProcess().get(positionFive))
                   + "\n" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionNine)) + "z=" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTen)) + "\nz="
                   + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTen)) + "/" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionNine))
                   + "  =" + roundTwoDecimals(sistemaEcuacion.getzResult()) + "\nsustituir 'z' en ecuacion 8 para sacar 'y'\n"
                   + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst()) + "y+" + roundTwoDecimals(sistemaEcuacion.getzProcess().getFirst())
                   + "(" + roundTwoDecimals(sistemaEcuacion.getzResult()) + ")="
                   + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTwo)) + "\ny=(" + roundTwoDecimals(sistemaEcuacion.getzProcess().get(positionTwo))
                   + "+" + roundTwoDecimals(sistemaEcuacion.getyProcess().get(positionTwo)) + ")/" + roundTwoDecimals(sistemaEcuacion.getyProcess().getFirst())
                   + "     y=" + roundTwoDecimals(sistemaEcuacion.getyResult()) + "\nsustituir 'z' e 'y' en ecuacion 1 para sacar 'x'\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x+" + roundTwoDecimals(sistemaEcuacion.getyValue().getFirst())
                   + "(" + roundTwoDecimals(sistemaEcuacion.getyResult()) + ")+"
                   + roundTwoDecimals(sistemaEcuacion.getzValue().getFirst()) + "(" + roundTwoDecimals(sistemaEcuacion.getzResult())
                   + ")=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "\n"
                   + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "x=" + roundTwoDecimals(sistemaEcuacion.getEcuResults().getFirst()) + "+"
                   + roundTwoDecimals(LESS_ONE_FLOAT * (sistemaEcuacion.getyProcess().get(positionThree) + sistemaEcuacion.getyProcess().get(positionFour)))
                   + "\nx=" + roundTwoDecimals((sistemaEcuacion.getEcuResults().getFirst() + LESS_ONE_FLOAT * (sistemaEcuacion.getyProcess().get(positionThree) + sistemaEcuacion.getyProcess().get(positionFour))))
                   + "/" + roundTwoDecimals(sistemaEcuacion.getxValue().getFirst()) + "  =" + roundTwoDecimals(sistemaEcuacion.getxResult())
                   + "\n            Los resultados de tus ecuaciones son:\n\nx  = " + roundTwoDecimals(sistemaEcuacion.getxResult()) + "     " + "y = "
                   + roundTwoDecimals(sistemaEcuacion.getyResult()) + "     " + "z = " + roundTwoDecimals(sistemaEcuacion.getzResult()));
           this.cleanAll();
       }
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

    private void cleanAll(){
        sistemaEcuacion = new SistemaEcuacion();
        xFields = new ArrayList<>();
        yFields = new ArrayList<>();
        zFields = new ArrayList<>();
        resFields = new ArrayList<>();
    }
}
