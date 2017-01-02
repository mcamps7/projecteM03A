package Proj4;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author equip 03 - Isaac, Marc i Montse
 */
public class S15_prj4_e3_CampsC {

    private final static int ID_MIN = 1, ID_MAX = 2000;
    private final static int EDAT_MIN = 5, EDAT_MAX = 17;
    private final static String GENERE_NOIA = "noia", GENERE_NOI = "noi";
    private final static String CINTURO_BLANC = "Blanc", CINTURO_GROC = "Groc",
            CINTURO_TARONJA = "Taronja", CINTURO_VERD = "Verd",
            CINTURO_BLAU = "Blau", CINTURO_MARRO = "Marró";
    private final static int CINTURO_MIN = 1, CINTURO_MAX = 6;
    private final static int PES_MIN = 0;
    private final static int DIA_MIN = 1, DIA_MAX31 = 31, DIA_MAX30 = 30,
            DIA_MAX29 = 29, DIA_MAX28 = 28;
    private final static int MES_MIN = 1, MES_MAX = 12;
    private final static int ANY_ACTUAL = 2016, ANY_MAX = 2100;
    private final static int INTENTS = 3, MAX_JUDOKES = 10;
    private final static int CAMP_CINTURO = 3, CAMP_ANY = 7, CAMP_MES = 6,
            CAMP_DIA = 5, NUM_CAMPS = 8; //8 camps: id, edat, gènere, cinturó, 
    //pes, dia, mes, any

    public static void main(String[] args) {

        int id = -1, edat = -1, genere = -1, cinturo = -1, pes = -1,
                any_pes = -1, mes_pes = -1, maxDiaOK = -1, dia_pes = -1,
                intents, numJudoka = 0, continuar, endreçar, mostrar;
        boolean dadesCorrectes = true, continuarIntro;
        String genere_text = null, cinturo_text = null;

        int[][] judokes = new int[MAX_JUDOKES][NUM_CAMPS - 1];
        int[] ids = new int[MAX_JUDOKES], numPerColor = new int[7];

        boolean judokesIntroduits = false;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("  *****************************\n"
                    + "  *  Entrada dades: JUDOKA " + (numJudoka + 1)
                    + "  *\n  *****************************");
            intents = INTENTS;
            do {
                //Demana l'id
                System.out.print("Id: ");
                if (scanner.hasNextInt()) {
                    id = scanner.nextInt();
                    //verifica l'id
                    if (id < ID_MIN || ID_MAX < id) {
                        System.out.println(" --> L'id ha de ser un nombre "
                                + "enter entre " + ID_MIN + " i " + ID_MAX
                                + ".");
                        dadesCorrectes = false;
                    } else if (Arrays.binarySearch(ids, id) > 0) {
                        System.out.println(" --> L'id " + id + " ja s'ha "
                                + "introduït. Els id's han de ser únics per a "
                                + "cada judoka.");
                        dadesCorrectes = false;
                    } else {
                        dadesCorrectes = true;
                    }
                } else {
                    System.out.println(" --> Cal introduir un nombre enter.");
                    dadesCorrectes = false;
                }
                scanner.nextLine();
                intents--;
            } while (intents > 0 && !dadesCorrectes);

            if (dadesCorrectes) {
                intents = INTENTS;
                do {
                    //Demana l'edat
                    System.out.print("Edat: ");
                    if (scanner.hasNextInt()) {
                        edat = scanner.nextInt();
                        //Verifica l'edat
                        if (edat < EDAT_MIN) {
                            System.out.println(" --> L'edat mínima és de "
                                    + EDAT_MIN + " anys.");
                            dadesCorrectes = false;
                        } else if (edat > EDAT_MAX) {
                            System.out.println(" --> L'edat màxima és de "
                                    + EDAT_MAX + " anys.");
                            dadesCorrectes = false;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println(" --> Cal introduir un nombre "
                                + "enter.");
                        dadesCorrectes = false;
                    }
                    scanner.nextLine();
                    intents--;
                } while (intents > 0 && !dadesCorrectes);
            }

            if (dadesCorrectes) {
                intents = INTENTS;
                do {
                    //Demana el gènere
                    System.out.print("És " + GENERE_NOIA + " (1) o "
                            + GENERE_NOI + " (2): ");
                    if (scanner.hasNextInt()) {
                        genere = scanner.nextInt();
                        //Verfica el gènere
                        if (genere < 1 || genere > 2) {
                            System.out.println(" --> El gènere cal "
                                    + "introduir-lo amb un nombre, "
                                    + GENERE_NOIA + " (1) o " + GENERE_NOI
                                    + " (2), no s'accepten altres valors.");
                            dadesCorrectes = false;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println(" --> Cal introduir un nombre "
                                + "enter.");
                        dadesCorrectes = false;
                    }
                    scanner.nextLine();
                    intents--;
                } while (intents > 0 && !dadesCorrectes);
            }

            if (dadesCorrectes) {
                intents = INTENTS;
                //Llista el color del cinturó
                System.out.print("Quin color de cinturó té?\n\t"
                        + CINTURO_BLANC + " (1)\t" + CINTURO_TARONJA + " (3)\t"
                        + CINTURO_BLAU + "(5)\n\t" + CINTURO_GROC + " (2)\t"
                        + CINTURO_VERD + " (4)\t" + CINTURO_MARRO + " (6)\n");
                do {
                    //Demana el color del cinturó
                    System.out.print("Color: ");
                    if (scanner.hasNextInt()) {
                        cinturo = scanner.nextInt();
                        //Verifica el cinturó
                        if (cinturo < CINTURO_MIN || cinturo > CINTURO_MAX) {
                            System.out.println(" --> Cal introduir el cinturó "
                                    + "amb un nombre entre " + CINTURO_MIN
                                    + " i " + CINTURO_MAX + " tal com s'indica "
                                    + "al llistat.");
                            dadesCorrectes = false;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println(" --> Cal introduir un nombre "
                                + "enter.");
                        dadesCorrectes = false;
                    }
                    scanner.nextLine();
                    intents--;
                } while (intents > 0 && !dadesCorrectes);
            }

            if (dadesCorrectes) {
                intents = INTENTS;
                do {
                    //Demana el pes
                    System.out.print("Pes: ");
                    if (scanner.hasNextInt()) {
                        pes = scanner.nextInt();
                        //Verifica el pes
                        if (pes <= PES_MIN) {
                            System.out.println(" --> El pes ha de ser un "
                                    + "nombre positiu.");
                            dadesCorrectes = false;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println(" --> Cal introduir un nombre "
                                + "enter.");
                        dadesCorrectes = false;
                    }
                    scanner.nextLine();
                    intents--;
                } while (intents > 0 && !dadesCorrectes);
            }

            if (dadesCorrectes) {
                intents = INTENTS;
                System.out.println("Data de pes ");
                do {
                    //Demana l'any de pesatge
                    System.out.print("\tany: ");
                    if (scanner.hasNextInt()) {
                        any_pes = scanner.nextInt();
                        //Verifica l'any
                        if (any_pes < ANY_ACTUAL || any_pes > ANY_MAX) {
                            System.out.println(" --> L'any ha de ser entre "
                                    + "l'any actual i el " + ANY_MAX + ". "
                                    + "Utilitza el format aaaa.");
                            dadesCorrectes = false;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println(" --> Cal introduir un nombre "
                                + "enter.");
                        dadesCorrectes = false;
                    }
                    intents--;
                    scanner.nextLine();
                } while (intents > 0 && !dadesCorrectes);
            }

            if (dadesCorrectes) {
                intents = INTENTS;
                do {
                    //Demana el mes de pesatge
                    System.out.print("\tmes: ");
                    if (scanner.hasNextInt()) {
                        mes_pes = scanner.nextInt();
                        //Verifica el mes
                        switch (mes_pes) {
                            case 1:
                            case 3:
                            case 5:
                            case 7:
                            case 8:
                            case 10:
                            case 12:
                                maxDiaOK = DIA_MAX31;
                                dadesCorrectes = true;
                                break;
                            case 4:
                            case 6:
                            case 9:
                            case 11:
                                maxDiaOK = DIA_MAX30;
                                dadesCorrectes = true;
                                break;
                            case 2:
                                //pot ser any de traspàs
                                if ((any_pes % 4 == 0)
                                        && (!(any_pes % 100 == 0)
                                        || (any_pes % 400 == 0))) {
                                    maxDiaOK = DIA_MAX29;
                                    // o no
                                } else {
                                    maxDiaOK = DIA_MAX28;
                                }
                                dadesCorrectes = true;
                                break;
                            //si el mes no està en el rang esperat avisa
                            default:
                                System.out.println(" --> El mes ha de ser un "
                                        + "nombre entre " + MES_MIN + " i "
                                        + MES_MAX + ". Utilitza el format mm.");
                                dadesCorrectes = false;
                                intents--;
                                break;
                        }
                    } else {
                        // si no s'ha escrit un enter (lletres o decimals...)
                        System.out.println(" --> Cal introduir un nombre "
                                + "enter.");
                        dadesCorrectes = false;
                        intents--;
                    }
                    scanner.nextLine();
                } while (intents > 0 && !dadesCorrectes);
            }

            if (dadesCorrectes) {
                intents = INTENTS;
                do {
                    //Demana el dia de pesatge
                    System.out.print("\tdia: ");
                    if (scanner.hasNextInt()) {
                        dia_pes = scanner.nextInt();
                        //Verifica que el dia es troba entre limits normals
                        if (dia_pes < DIA_MIN || dia_pes > maxDiaOK) {
                            System.out.println(" --> El dia ha de ser un "
                                    + "nombre entre " + DIA_MIN + " i "
                                    + maxDiaOK + ". Utilitza el format dd.");
                            dadesCorrectes = false;
                        } else {
                            dadesCorrectes = true;
                        }
                    } else {
                        System.out.println(" --> Cal introduir un nombre "
                                + "enter.");
                        dadesCorrectes = false;
                    }
                    intents--;
                    scanner.nextLine();
                } while (intents > 0 && !dadesCorrectes);
            }
            //Si les dades introduides son correctes les emmagatzema
            if (dadesCorrectes) {
                judokes[numJudoka] = new int[]{id, edat, genere, cinturo, pes,
                    dia_pes, mes_pes, any_pes};
                ids[numJudoka] = id;
                Arrays.sort(ids);
                judokesIntroduits = true;
            } else {
                System.out.println("\n << ! >>  Les dades introduides no són "
                        + "correctes i no s'han pogut emmagatzemar.");
                numJudoka--;
            }

            if (numJudoka < MAX_JUDOKES - 1) {
                System.out.print("\n -> Vol introduïr les dades d'un/a altre/a "
                        + "judoka? SÍ (1) NO (0) ");
                if (scanner.hasNextInt()) {
                    continuar = scanner.nextInt();
                    switch (continuar) {
                        case 1:
                            continuarIntro = true;
                            numJudoka++;
                            System.out.println();
                            break;
                        case 0:
                            if (numJudoka == 0) {
                                System.out.println("\nS'han introduït les "
                                        + "dades d'" + (numJudoka + 1)
                                        + " judoka.");
                            } else {
                                System.out.println("\nS'han introduït les "
                                        + "dades de " + (numJudoka + 1)
                                        + " judokes.");
                            }
                        default:
                            continuarIntro = false;
                    }
                } else {
                    continuarIntro = false;
                }
                scanner.nextLine();
            } else {
                continuarIntro = false;
                System.out.println(" --> No es poden introduir més judokes, el "
                        + "programa admet " + MAX_JUDOKES + " judokes com a "
                        + "màxim.");
            }
        } while (continuarIntro);

        if (judokesIntroduits) {

            System.out.println("\n Id\tEdat\tGènere\tCinturó\t  Pes\t"
                    + "Data pesatge");
            System.out.println("====\t====\t======\t=======\t  ===\t"
                    + "============");

            for (int i = 0; i <= numJudoka; i++) {
                //Assigna les variables text en funció dels valors 
                //introduits de genere, cinturó i mes.
                switch (judokes[i][2]) {
                    case 1:
                        genere_text = GENERE_NOIA;
                        break;
                    case 2:
                        genere_text = GENERE_NOI;
                        break;
                }

                switch (judokes[i][3]) {
                    case 1:
                        cinturo_text = CINTURO_BLANC;
                        break;
                    case 2:
                        cinturo_text = CINTURO_GROC;
                        break;
                    case 3:
                        cinturo_text = CINTURO_TARONJA;
                        break;
                    case 4:
                        cinturo_text = CINTURO_VERD;
                        break;
                    case 5:
                        cinturo_text = CINTURO_BLAU;
                        break;
                    case 6:
                        cinturo_text = CINTURO_MARRO;
                        break;
                }

                System.out.format("%04d", judokes[i][0]);
                System.out.print("\t" + judokes[i][1] + "\t" + genere_text
                        + "\t" + cinturo_text + "\t  " + judokes[i][4]);
                System.out.format("\t %02d/%02d/%04d%n", judokes[i][5],
                        judokes[i][6], judokes[i][7]);
            }

            if (numJudoka != 0) {

                System.out.println("\n -> Vol ordenar els judokes per edat? "
                        + "SÍ (1) NO (0) ");
                if (scanner.hasNextInt()) {
                    endreçar = scanner.nextInt();
                    if (endreçar == 1) {
                        for (int i = 0; i <= numJudoka; i++) {
                            for (int j = i; j <= numJudoka; j++) {
                                if (judokes[i][1] > judokes[j][1]) {
                                    int[] canviJudoka = judokes[i];
                                    judokes[i] = judokes[j];
                                    judokes[j] = canviJudoka;
                                }
                            }
                        }

                        System.out.println("\n Id\tEdat\tGènere\tCinturó\t  "
                                + "Pes\tData pesatge\n====\t====\t======\t===="
                                + "===\t  ===\t============");

                        for (int i = 0; i <= numJudoka; i++) {
                            //Assigna les variables text en funció dels valors 
                            //introduits de genere, cinturó i mes.
                            switch (judokes[i][2]) {
                                case 1:
                                    genere_text = GENERE_NOIA;
                                    break;
                                case 2:
                                    genere_text = GENERE_NOI;
                                    break;
                            }

                            switch (judokes[i][3]) {
                                case 1:
                                    cinturo_text = CINTURO_BLANC;
                                    break;
                                case 2:
                                    cinturo_text = CINTURO_GROC;
                                    break;
                                case 3:
                                    cinturo_text = CINTURO_TARONJA;
                                    break;
                                case 4:
                                    cinturo_text = CINTURO_VERD;
                                    break;
                                case 5:
                                    cinturo_text = CINTURO_BLAU;
                                    break;
                                case 6:
                                    cinturo_text = CINTURO_MARRO;
                                    break;
                            }

                            System.out.format("%04d", judokes[i][0]);
                            System.out.print("\t" + judokes[i][1] + "\t"
                                    + genere_text + "\t" + cinturo_text + "\t  "
                                    + judokes[i][4]);
                            System.out.format("\t %02d/%02d/%04d%n",
                                    judokes[i][5], judokes[i][6],
                                    judokes[i][7]);
                        }
                    }
                }

                System.out.println("\n -> Vols mostrar la quantitat de judokes"
                        + " segons el color de cinturó? SI (1) NO (0)");
                if (scanner.hasNextInt()) {
                    mostrar = scanner.nextInt();
                    if (mostrar == 1) {
                        for (int i = 0; i <= numJudoka; i++) {
                            numPerColor[judokes[i][CAMP_CINTURO] - 1] += 1;
                        }

                        System.out.println("\n\n  Quantitat de Judokes segons el color "
                                + "del cinturó\n========================================"
                                + "============\n\t" + CINTURO_BLANC + ":\t\t"
                                + numPerColor[0] + "\n\t" + CINTURO_GROC + ":\t\t"
                                + numPerColor[1] + "\n\t" + CINTURO_TARONJA + ":\t"
                                + numPerColor[2] + "\n\t" + CINTURO_VERD + ":\t\t"
                                + numPerColor[3] + "\n\t" + CINTURO_BLAU + ":\t\t"
                                + numPerColor[4] + "\n\t" + CINTURO_MARRO + ":\t\t"
                                + numPerColor[5]);
                    }
                }

                System.out.println("\n -> Vol endreçar els judokes segons algun "
                        + "altre critèri? SI (1) NO (0)");
                if (scanner.hasNextInt()) {
                    endreçar = scanner.nextInt();
                    if (endreçar == 1) {
                        System.out.println("\n -> Segons quin critèri vol "
                                + "endreçar-los?\n\t1. Id\n\t2. Edat\n\t"
                                + "3. Cinturó\n\t4. Pes\n\t5. Data pesatge\n:");
                        if (scanner.hasNextInt()) {
                            endreçar = scanner.nextInt() - 1;
                            if (0 <= endreçar && endreçar <= 3) {
                                for (int i = 0; i <= numJudoka; i++) {
                                    for (int j = i; j <= numJudoka; j++) {
                                        if (judokes[i][endreçar]
                                                > judokes[j][endreçar]) {
                                            int[] canviJudoka = judokes[i];
                                            judokes[i] = judokes[j];
                                            judokes[j] = canviJudoka;
                                        }
                                    }
                                }
                            } else if (endreçar == 4) {
                                for (int i = 0; i <= numJudoka; i++) {
                                    for (int j = i; j <= numJudoka; j++) {
                                        if (judokes[i][CAMP_ANY]
                                                > judokes[j][CAMP_ANY]
                                                || (judokes[i][CAMP_ANY]
                                                == judokes[j][CAMP_ANY]
                                                && (judokes[i][CAMP_MES]
                                                > judokes[j][CAMP_MES]
                                                || (judokes[i][CAMP_MES]
                                                == judokes[j][CAMP_MES]
                                                && judokes[i][CAMP_DIA]
                                                > judokes[j][CAMP_DIA])))) {

                                            int[] canviJudoka = judokes[i];
                                            judokes[i] = judokes[j];
                                            judokes[j] = canviJudoka;
                                        }
                                    }
                                }
                            }

                            if (0 <= endreçar && endreçar <= 4) {

                                System.out.println("\n Id\tEdat\tGènere\tCinturó\t"
                                        + "  Pes\tData pesatge");
                                System.out.println("====\t====\t======\t=======\t  "
                                        + "===\t============");

                                for (int i = 0; i <= numJudoka; i++) {
                                    //Assigna les variables text en funció dels valors 
                                    //introduits de genere, cinturó i mes.
                                    switch (judokes[i][2]) {
                                        case 1:
                                            genere_text = GENERE_NOIA;
                                            break;
                                        case 2:
                                            genere_text = GENERE_NOI;
                                            break;
                                    }

                                    switch (judokes[i][3]) {
                                        case 1:
                                            cinturo_text = CINTURO_BLANC;
                                            break;
                                        case 2:
                                            cinturo_text = CINTURO_GROC;
                                            break;
                                        case 3:
                                            cinturo_text = CINTURO_TARONJA;
                                            break;
                                        case 4:
                                            cinturo_text = CINTURO_VERD;
                                            break;
                                        case 5:
                                            cinturo_text = CINTURO_BLAU;
                                            break;
                                        case 6:
                                            cinturo_text = CINTURO_MARRO;
                                            break;
                                    }

                                    System.out.format("%04d", judokes[i][0]);
                                    System.out.print("\t" + judokes[i][1] + "\t"
                                            + genere_text + "\t" + cinturo_text
                                            + "\t  " + judokes[i][4]);
                                    System.out.format("\t %02d/%02d/%04d%n",
                                            judokes[i][5], judokes[i][6],
                                            judokes[i][7]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
