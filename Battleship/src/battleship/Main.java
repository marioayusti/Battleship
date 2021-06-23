package battleship;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import components.JPanelBGImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import components.JOptionPane2;

/**
 *
 * @author lili_work1
 */
public class Main
{

    public static void main(String[] args)
    {
        int filas = 10;
        int columnas = 10;
        char barco = 'L';
        char vh = ',';
        String cad = "";
        String coor = "";
        int[] coorVector = null;
        int[] barcoVector = null;
        String nombreBarco = "";
        int contBarcos = 0;
        String PosicionesBarcosPlayer = "";
        String PosicionesBarcosPC = "";
        String estado = "";
        int contadorPc = 0;
        int contadorPlayer = 0;

        filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de filas \n (Minimo 10 y Maximo 20)", "Tamaño de tablero", JOptionPane.PLAIN_MESSAGE));
        if (!Metodos.tamanoEsValido(filas, columnas))
        {
            filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de filas invalido \n Ingrese nuevamente la cantidad de filas \n Recuerde: (Minimo 10 y Maximo 20)", "Tamaño de tablero", JOptionPane.ERROR_MESSAGE));
            if (!Metodos.tamanoEsValido(filas, columnas))
                filas = Metodos.cambioTamano(filas, columnas);
        }
        columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de columnas \n (Minimo 10 y Maximo 40)", "Tamaño de tablero", JOptionPane.PLAIN_MESSAGE));
        if (!Metodos.tamanoEsValido(filas, columnas))
        {
            columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de columnas invalido \n Ingrese nuevamente la cantidad de columnas \n Recuerde: (Minimo 10 y Maximo 40)", "Tamaño de tablero", JOptionPane.ERROR_MESSAGE));
            if (!Metodos.tamanoEsValido(filas, columnas))
                columnas = Metodos.cambioTamano(filas, columnas);
        }

        char[][] matrixPlayer = new char[filas][columnas];
        char[][] matrixPC = new char[filas][columnas];
        JOptionPane2.showMessageDialog(null, matrixPlayer, matrixPC, "Player", "PC", "Tablero");
        do
        {
            if (barco == 'L')
            {
                do
                {
                    coor = JOptionPane.showInputDialog(null, "Ingrese la coordenada de una lancha", "Posición de los barcos", JOptionPane.PLAIN_MESSAGE);
                    while (!Metodos.esValida(coor, filas, columnas))
                    {
                        coor = JOptionPane.showInputDialog(null, "Coordenada invalida \n ingrese nuevamente la coordenada de la lancha", "Posición de los barcos", JOptionPane.ERROR_MESSAGE);
                    }
                    coorVector = Metodos.convertir(coor);
                    if (!Metodos.estaDisponible(coorVector, null, matrixPlayer, 'L'))
                    {
                        JOptionPane.showMessageDialog(null, "La no puede ser ubicada en estas coordenadas \n por favor intentelo nuevamente", "Posición de los barcos", JOptionPane.ERROR_MESSAGE);
                        JOptionPane2.showMessageDialog(null, matrixPlayer, matrixPC, "Player", "PC", "Ingrese Coordenadas");
                    }
                }
                while (!Metodos.estaDisponible(coorVector, null, matrixPlayer, 'L'));
                matrixPlayer[coorVector[0]][coorVector[1]] = 'L';
            }
            else if (barco == 'P' || barco == 'B'||barco=='A')
            {
                if (barco == 'P')
                    nombreBarco = "portaaviones";
                else if (barco=='B')
                    nombreBarco = "buque";
                else
                    nombreBarco = "buque anti-radar";
                do
                {
                    coor = JOptionPane.showInputDialog(null, "Ingrese Coordenada de un " + nombreBarco, "Posición de los barcos", JOptionPane.PLAIN_MESSAGE);
                    while (!Metodos.esValida(coor, filas, columnas))
                    {
                        coor = JOptionPane.showInputDialog(null, "Coordenada invalida \n ingrese nuevamente la coordenada de el " + nombreBarco, "Posición de los barcos", JOptionPane.ERROR_MESSAGE);
                    }
                    coorVector = Metodos.convertir(coor);
                    cad = JOptionPane.showInputDialog(null, "Ingrese la orientación de el " + nombreBarco + " \n vertical: 'V'\n Horizontal: 'H' ", "Orientación de los barcos", JOptionPane.PLAIN_MESSAGE);
                    while (!Metodos.esValidoCharvh(cad))
                    {
                        cad = JOptionPane.showInputDialog(null, "Orientación invalida \n ingrese nuevamente la orientación \n Recuerde: (vertical: 'V' y Horizontal: 'H') ", "Orientación de los barcos", JOptionPane.ERROR_MESSAGE);
                    }
                    vh = cad.charAt(0);
                    vh = Character.toUpperCase(vh);
                    barcoVector = Metodos.ConvertirBarco(coorVector, filas, columnas, vh, barco);
                    if (!Metodos.estaDisponible(coorVector, barcoVector, matrixPlayer, vh))
                    {
                        JOptionPane.showMessageDialog(null, "El " + nombreBarco + " no puede ser ubicado en estas coordenadas \n por favor intentelo nuevamente", "Posición de los barcos", JOptionPane.ERROR_MESSAGE);
                        JOptionPane2.showMessageDialog(null, matrixPlayer, matrixPC, "Player", "PC", "Ingrese Coordenadas");
                    }
                }
                while (!Metodos.estaDisponible(coorVector, barcoVector, matrixPlayer, vh));
                PosicionesBarcosPlayer += "" + Character.toString(barco) + coorVector[0] + "," + coorVector[1] + vh;
                if (vh == 'H')
                    for (int i = 0; i < barcoVector.length; i++)
                    {
                        matrixPlayer[coorVector[0]][barcoVector[i]] = barco;
                    }
                else
                    for (int i = 0; i < barcoVector.length; i++)
                    {
                        matrixPlayer[barcoVector[i]][coorVector[1]] = barco;
                    }
            }
            JOptionPane2.showMessageDialog(null, matrixPlayer, matrixPC, "Player", "PC", "Tablero");

            if (contBarcos == 0)
                barco = 'B';
            else if (contBarcos == 1)
                barco = 'P';
            else if (contBarcos == 2)
                barco = 'A';
            contBarcos++;
            if (contBarcos > 3 && contBarcos < 6)
            {
                cad = JOptionPane.showInputDialog(null, "Ingrese el tipo de su siguiente barco: \n Lancha: 'L' \n Buque: 'B' \n Portaaviones: 'P'", "Tipo de barco", JOptionPane.QUESTION_MESSAGE);
                while (!Metodos.barcoEsValido(cad))
                {
                    cad = JOptionPane.showInputDialog(null, "Tipo de barco invalido:\n Ingrese el tipo de barco nuevamente: Recuerde: \n Lancha: 'L' \n Buque: 'B' \n Portaaviones: 'P' ", "Tipo de barco", JOptionPane.ERROR_MESSAGE);
                }
                barco = cad.charAt(0);
                barco = Character.toUpperCase(barco);
            }
        }
        while (contBarcos < 6);
        contBarcos = 0;
        barco = 'l';
//barcos PC
        do
        {
            if (barco == 'l')
            {
                do
                {
                    coorVector = Metodos.CoordenadaAleatoria(filas, columnas);
                }
                while (!(Metodos.estaDisponible(coorVector, null, matrixPC, 'L')));
                matrixPC[coorVector[0]][coorVector[1]] = 'l';
            }
            else if (barco == 'b' || barco == 'p'||barco=='a')
            {
                do
                {
                    coorVector = Metodos.CoordenadaAleatoria(filas, columnas);
                    vh = Metodos.vhAleatoria(vh);
                    barcoVector = Metodos.ConvertirBarco(coorVector, filas, columnas, vh, barco);
                }
                while (!Metodos.estaDisponible(coorVector, barcoVector, matrixPC, vh));
                PosicionesBarcosPC += Character.toString(barco) + coorVector[0] + "," + coorVector[1] + vh;
                if (vh == 'H')
                    for (int i = 0; i < barcoVector.length; i++)
                    {
                        matrixPC[coorVector[0]][barcoVector[i]] = barco;
                    }
                else
                    for (int i = 0; i < barcoVector.length; i++)
                    {
                        matrixPC[barcoVector[i]][coorVector[1]] = barco;
                    }
            }
            if (contBarcos == 0)
                barco = 'b';
            else if (contBarcos == 1)
                barco = 'p';
            else if (contBarcos == 2)
                barco = 'a';
            contBarcos++;
            if (contBarcos > 3 && contBarcos < 6)
                barco = Metodos.barcoAleatorio(barco);
        }
        while (contBarcos < 6);
        JOptionPane2.showMessageDialog(null, matrixPlayer, matrixPC, "Player: " + contadorPlayer, "PC: " + contadorPc, "Ingrese Coordenadas");
//disparos
        do
        {
            do
            {
                coor = JOptionPane.showInputDialog(null, "Ingrese coordenadas del disparo");
                if (Metodos.esValida(coor, filas, columnas))
                    coorVector = Metodos.convertir(coor);
                if (!Metodos.esValida(coor, filas, columnas) || !Metodos.estaDisponible(coorVector, null, matrixPC, 'D'))
                    JOptionPane.showMessageDialog(null, "Coordenada invalida: \n intentelo nuevamente", "Coordenada del disparo", JOptionPane.ERROR_MESSAGE);
            }
            while (!Metodos.esValida(coor, filas, columnas) || !Metodos.estaDisponible(coorVector, null, matrixPC, 'D'));
            estado = Metodos.estado(coorVector, matrixPC, filas, columnas, PosicionesBarcosPC);
            JOptionPane.showMessageDialog(null, estado, "PC:", JOptionPane.INFORMATION_MESSAGE);
            if (estado.equals("¡Hundido!"))
                contadorPlayer++;
            JOptionPane2.showMessageDialog(null, matrixPlayer, matrixPC, "Player: " + contadorPlayer, "PC: " + contadorPc, "Ingrese Coordenadas");

            do
            {
                coorVector = Metodos.CoordenadaAleatoria(filas, columnas);
            }
            while (!Metodos.estaDisponible(coorVector, null, matrixPlayer, 'D'));
            estado = Metodos.estado(coorVector, matrixPlayer, filas, columnas, PosicionesBarcosPlayer);
            JOptionPane.showMessageDialog(null, estado, "Player:", JOptionPane.INFORMATION_MESSAGE);
            if (estado.equals("¡Hundido!"))
                contadorPc++;
            JOptionPane2.showMessageDialog(null, matrixPlayer, matrixPC, "Player: " + contadorPlayer, "PC: " + contadorPc, "Ingrese Coordenadas");
        }
        while (!(Metodos.hayGanador(contadorPlayer, contadorPc)));
        JOptionPane.showMessageDialog(null, "Fin del juego");
        JOptionPane.showMessageDialog(null, Metodos.Ganador(contadorPlayer, contadorPc));

    }

}
