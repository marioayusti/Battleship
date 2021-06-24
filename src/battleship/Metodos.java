/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import javax.swing.JOptionPane;

/**
 *
 * @author salas
 */
public class Metodos
{

    public static boolean tamanoEsValido(int filas, int columnas)
    {
        boolean esValido = true;
        if (filas < 10 || filas > 20)
            esValido = false;
        else if (columnas < 10 || columnas > 40)
            esValido = false;
        return esValido;
    }

    public static int cambioTamano(int filas, int columnas)
    {
        int tamanonuevo = 0;
        if (filas < 10)
            tamanonuevo = 10;
        else if (filas > 20)
            tamanonuevo = 20;
        else if (columnas < 10)
            tamanonuevo = 10;
        else if (columnas > 40)
            tamanonuevo = 40;
        return tamanonuevo;
    }

    //esta me dice si la coordenada es valida o no.
    public static boolean esValida(String coor, int filas, int columnas)
    {
        boolean esValida = false;
        coor = coor.trim().toUpperCase();
        if (coor.length() == 2)
        {
            if (Character.isLetter(coor.charAt(0)) && Character.isDigit(coor.charAt(1)))
                if ((coor.charAt(0) - 65) < filas)
                    esValida = true;
        }
        else if (coor.length() == 3)
            if (Character.isLetter(coor.charAt(0)) && Character.isDigit(coor.charAt(1)) && Character.isDigit(coor.charAt(2)))
                if ((coor.charAt(0) - 65) < filas && Integer.parseInt(coor.charAt(1) + "" + coor.charAt(2)) <= columnas)
                    esValida = true;
        return esValida;
    }

    //verifica si la horientacion es valida
    public static boolean esValidoCharvh(String cad)
    {
        boolean esValido = false;
        if (!(cad.equals("")))
            if (cad.length() == 1)
            {
                cad = cad.toUpperCase();
                if (cad.equals("H") || cad.equals("V"))
                    esValido = true;
            }
        return esValido;
    }

    public static boolean barcoEsValido(String cad)
    {
        boolean esValido = false;
        if (!(cad.equals("")))
            if (cad.length() == 1)
            {
                cad = cad.toUpperCase();
                if (cad.equals("P") || cad.equals("B") || cad.equals("L"))
                    esValido = true;
            }
        return esValido;
    }

    public static int[] CoordenadaAleatoria(int filas, int columnas)
    {
        int[] coorVector = new int[2];
        coorVector[0] = (int) (Math.random() * filas);
        coorVector[1] = (int) (Math.random() * columnas);
        return coorVector;
    }

    public static char vhAleatoria(char vh)
    {
        int aux = 0;
        aux = (int) (Math.random() * 3);
        if (aux % 2 == 0)
            vh = 'H';
        else
            vh = 'V';
        return vh;
    }

    public static char barcoAleatorio(char barco)
    {
        int aux = 0;
        aux = (int) (1 + (Math.random() * 3));
        if (aux == 1)
            barco = 'l';
        else if (aux == 2)
            barco = 'b';
        else if (aux == 3)
            barco = 'p';
        return barco;
    }

    //esto convierte la coordenada en numeros
    public static int[] convertir(String coor)
    {
        int[] coorVector = new int[2];
        String cadaux = "";
        coor = coor.trim().toUpperCase();
        coorVector[0] = (coor.charAt(0) - 65);
        if (coor.length() == 2)
            cadaux += coor.charAt(1);
        else if (coor.length() == 3)
            cadaux += (coor.charAt(1) + "" + coor.charAt(2));
        coorVector[1] = (Integer.parseInt(cadaux) - 1);
        return coorVector;
    }

    public static int[] convertir2(String PosicionesBarcos, int i)
    {
        PosicionesBarcos += "mario";
        int[] coorBarco = new int[3];
        String cadaux = "";
        int aux = (i + 1);
        for (int h = 0; h < 2; h++)
        {
            for (int j = aux; Character.isDigit(PosicionesBarcos.charAt(j)); j++)
            {
                cadaux += Character.toString(PosicionesBarcos.charAt(j));
                if ((Character.isDigit(PosicionesBarcos.charAt(j + 1)) == false) && (Character.isDigit(PosicionesBarcos.charAt(j + 2))))
                {
                    coorBarco[h] = Integer.parseInt(cadaux);
                    cadaux = "";
                    aux = (j + 2);
                }
                else if (Character.isDigit(PosicionesBarcos.charAt(j + 1)) == false && Character.isDigit(PosicionesBarcos.charAt(j + 2)) == false)
                {
                    coorBarco[h] = Integer.parseInt(cadaux);
                    if (PosicionesBarcos.charAt(j + 1) == 'H')
                        coorBarco[2] = 0;
                    else
                        coorBarco[2] = 1;
                }
            }
        }
        return coorBarco;
    }

    // verifica si el espacio esta disponible
    public static boolean estaDisponible(int[] coorVector, int[] barcoVector, char[][] matrix, char vh)
    {
        boolean disponible = true;
        if (vh == 'D')
        {
            if (matrix[coorVector[0]][coorVector[1]] == 'X' || matrix[coorVector[0]][coorVector[1]] == 'O')
                disponible = false;
        }
        else if (vh == 'L')
        {
            if (matrix[coorVector[0]][coorVector[1]] != '\u0000')
                disponible = false;
        }
        else if (vh == 'H')
        {
            for (int i = 0; i < barcoVector.length && disponible; i++)
            {
                if (matrix[coorVector[0]][barcoVector[i]] != '\u0000')
                    disponible = false;
            }
        }
        else if (vh == 'V')
        {
            for (int i = 0; i < barcoVector.length && disponible; i++)
            {
                if (matrix[barcoVector[i]][coorVector[1]] != '\u0000')
                    disponible = false;
            }
        }
        else
            disponible = false;
        return disponible;
    }

    public static int[] ConvertirBarco(int[] coorVector, int filas, int columnas, char vh, char barco)
    {
        int[] barcoVector = null;
        int p = 0;
        int aux = 0;
        int aux2 = 0;
        int min = 1;
        if (barco == 'B' || barco == 'b' || barco == 'A' || barco=='a')
            barcoVector = new int[3];
        else
        {
            barcoVector = new int[5];
            min = 2;
        }
        if (vh == 'H')
        {
            aux2 = columnas;
            p = 1;
        }
        else
            aux2 = filas;
        if (coorVector[p] >= min)
        {
            if (coorVector[p] == (aux2 - 1))
                coorVector[p] -= min;
            else if (min == 2 && coorVector[p] == (aux2 - 2))
                coorVector[p]--;
            for (int i = 0; i < barcoVector.length; i++)
            {
                if (i % 2 == 0)
                {
                    barcoVector[i] = (coorVector[p] + aux);
                    aux++;
                }
                else
                    barcoVector[i] = (coorVector[p] - (aux));
            }
        }
        else if (coorVector[p] == 0 || coorVector[p] == 1)
            for (int i = 0; i < barcoVector.length; i++)
            {
                barcoVector[i] = i;
            }
        return barcoVector;
    }
    
    

    public static int[] buscador(String PosicionesBarcos, char barco, int filas, int columnas, int[] coorVector)
    {
        int[] coorBarco = null;
        int[] barcoVector = null;
        boolean aparece = false;

        for (int i = 0; i < PosicionesBarcos.length() && (!aparece); i++)
        {
            if (PosicionesBarcos.charAt(i) == barco)
            {
                coorBarco = convertir2(PosicionesBarcos, i);
                if (coorBarco[2] == 0)
                {
                    if (coorBarco[0] == coorVector[0])
                    {
                        barcoVector = ConvertirBarco(coorBarco, filas, columnas, 'H', barco);
                        for (int j = 0; j < barcoVector.length && aparece == false; j++)
                        {
                            if (barcoVector[j] == coorBarco[1])
                                aparece = true;
                        }
                    }
                }
                else if (coorBarco[1] == coorVector[1])
                {

                    barcoVector = ConvertirBarco(coorBarco, filas, columnas, 'V', barco);
                    for (int j = 0; j < barcoVector.length && aparece == false; j++)
                    {
                        if (barcoVector[j] == coorBarco[0])
                            aparece = true;
                    }
                }
            }
        }
        return coorBarco;
    }

    public static String estado(int[] coorVector, char[][] matrix, int filas, int columnas, String PosicionesBarcos)
    {
        String estado = "";
        int[] coorBarco = null;
        int[] coorVector2 = new int[3];
        int cont = 0;
        int barcoTamano = 0;
        char barco = matrix[coorVector[0]][coorVector[1]];
        char ref = ',';
        if (barco == 'A'||barco=='a')
            matrix[coorVector[0]][coorVector[1]] = 'o';
        else if (matrix[coorVector[0]][coorVector[1]] == '\u0000')
            matrix[coorVector[0]][coorVector[1]] = 'X';
        else
            matrix[coorVector[0]][coorVector[1]] = 'O';
        ref = matrix[coorVector[0]][coorVector[1]];
        if (barco == '\u0000')
            estado = "¡Agua!";
        else if (barco == 'L' || barco == 'l')
            estado = "¡Hundido!";
        else
        {
            if (barco == 'b' || barco == 'B'||barco=='a'||barco=='A')
                barcoTamano = 3;
            else if (barco == 'p' || barco == 'P')
                barcoTamano = 5;

            coorVector2 = buscador(PosicionesBarcos, barco, filas, columnas, coorVector);
            if (coorVector2[2] == 0)
            {
                coorBarco = ConvertirBarco(coorVector2, filas, columnas, 'H', barco);
                for (int i = 0; i < coorBarco.length; i++)
                {
                    if (matrix[coorVector[0]][coorBarco[i]] == ref)
                        cont++;
                }
            }
            else
            {
                coorBarco = ConvertirBarco(coorVector2, filas, columnas, 'V', barco);
                for (int i = 0; i < coorBarco.length; i++)
                {
                    if (matrix[coorBarco[i]][coorVector[1]] == ref)
                        cont++;
                }
            }
            if (barco == 'A'||barco == 'a')
                if (cont == barcoTamano)
                {
                    estado = "¡Hundido!";
                    if (coorVector2[2] == 0)
                    for (int i = 0; i < coorBarco.length; i++)
                    {
                        matrix[coorVector[0]][coorBarco[i]] = 'O';
                    }
                else
                    for (int i = 0; i < coorBarco.length; i++)
                    {
                        matrix[coorBarco[i]][coorVector[1]] = 'O';
                    }
                }
                else
                    estado = "¡Agua!";
            else if (cont == barcoTamano)
                estado = "¡Hundido!";
            else
                estado = "¡Averiado!";
        }
        return estado;
    }

    public static boolean hayGanador(int contadorPlayer, int contadorPC)
    {
        boolean hayGanador = false;
        if (contadorPlayer == 6 || contadorPC == 6)
            hayGanador = true;
        return hayGanador;
    }

    public static String Ganador(int contadorPlayer, int contadorPC)
    {
        String ganador = "";
        if (contadorPlayer == contadorPC)
            ganador = "El juego termino en Empate!!";
        else if (contadorPlayer > contadorPC)
            ganador = "El ganador es el jugador!!";
        else
            ganador = "El ganador es el PC!!";
        return ganador;
    }
}
