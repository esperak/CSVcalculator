package input;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.TreeSet;

public class CSVReader {

    public static void main(String[] args) {

        String csvFile = "C:\\Users\\Matej\\IdeaProjects\\started_2017-04-20_CET_17_55.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        int pocet_riadkov = 0;

        // stromy
        TreeSet<Double> tree_dostupna_pamat_mb = new TreeSet<Double>();
        TreeSet<Double> tree_vytazenie_disku_sda_percent = new TreeSet<Double>();
        TreeSet<Double> tree_zatazenie_1min = new TreeSet<Double>();
        TreeSet<Double> tree_vytazenie_burza_jar_cpu_percent = new TreeSet<Double>();
        TreeSet<Double> tree_vytazenie_burza_jar_mem_percent = new TreeSet<Double>();
        TreeSet<Double> tree_vytazenie_databazy_cpu_percent = new TreeSet<Double>();
        TreeSet<Double> tree_vytazenie_databazy_mem_percent = new TreeSet<Double>();

        // sum
        Double sum_dostupna_pamat_mb = 0.0;
        Double sum_vytazenie_disku_sda_percent = 0.0;
        Double sum_zatazenie_1min = 0.0;
        Double sum_vytazenie_burza_jar_cpu_percent = 0.0;
        Double sum_vytazenie_burza_jar_mem_percent = 0.0;
        Double sum_vytazenie_databazy_cpu_percent = 0.0;
        Double sum_vytazenie_databazy_mem_percent = 0.0;

        try {
            // pokus sa precitat CSV
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] prvok = line.split(cvsSplitBy);
                pocet_riadkov ++;


                try {
                    sum_dostupna_pamat_mb += Double.parseDouble(prvok[3]);
                    tree_dostupna_pamat_mb.add(Double.parseDouble(prvok[3]));

                }catch(NumberFormatException exception){}
                try {
                    sum_vytazenie_disku_sda_percent += Double.parseDouble(prvok[4]);
                    tree_vytazenie_disku_sda_percent.add(Double.parseDouble(prvok[4]));

                }catch(NumberFormatException exception){}
                try {
                    sum_zatazenie_1min += Double.parseDouble(prvok[8]);
                    tree_zatazenie_1min.add(Double.parseDouble(prvok[8]));

                }catch(NumberFormatException exception){}
                try {
                    sum_vytazenie_burza_jar_cpu_percent += Double.parseDouble(prvok[18]);
                    tree_vytazenie_burza_jar_cpu_percent.add(Double.parseDouble(prvok[18]));

                }catch(NumberFormatException exception){}
                try {
                    tree_vytazenie_burza_jar_mem_percent.add(Double.parseDouble(prvok[19]));
                    sum_vytazenie_burza_jar_mem_percent += Double.parseDouble(prvok[19]);
                }catch(NumberFormatException exception){}
                try {
                    sum_vytazenie_databazy_cpu_percent += Double.parseDouble(prvok[20]);
                    tree_vytazenie_databazy_cpu_percent.add(Double.parseDouble(prvok[20]));

                }catch(NumberFormatException exception){}
                try {
                    sum_vytazenie_databazy_mem_percent += Double.parseDouble(prvok[21]);
                    tree_vytazenie_databazy_mem_percent.add(Double.parseDouble(prvok[21]));

                }catch(NumberFormatException exception){}

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /*

        Iterator<Double> iterator = tree_zatazenie_1min.iterator();
        System.out.print("tree_zatazenie_1min data: ");

        // Displaying the Tree set data
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }

        System.out.println();

        System.out.println("tree_zatazenie_1min sucet: " + sum_zatazenie_1min);
        System.out.println("tree_zatazenie_1min pocet_riadkov: " + pocet_riadkov);
        System.out.println("tree_zatazenie_1min priemer: " + (sum_zatazenie_1min / pocet_riadkov));

        */


        // HTML Vypis



        System.out.println(
                "<html>\n" +
                "<head>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<img src=\"grafy/dostupna_pamat_mb.png\">");

        System.out.println("<h3>minimum: " + tree_dostupna_pamat_mb.first() + "</h3>");
        System.out.println("<h3>maximum: " + tree_dostupna_pamat_mb.last() + "</h3>");
        System.out.println("<h3>priemer: " + String.format( "%.2f", (sum_dostupna_pamat_mb / pocet_riadkov) ) + "</h3>");
        System.out.println("<br><br><br><br><br><br><br><br><br><br>\n");

        System.out.println("<img src=\"grafy/vytazenie_disku_sda_percent.png\">");
        System.out.println("<h3>minimum: " + tree_vytazenie_disku_sda_percent.first() + "</h3>");
        System.out.println("<h3>maximum: " + tree_vytazenie_disku_sda_percent.last() + "</h3>");
        System.out.println("<h3>priemer: " + String.format( "%.2f", (sum_vytazenie_disku_sda_percent / pocet_riadkov) ) + "</h3>");
        System.out.println("<br><br><br><br><br><br><br><br><br><br>\n");

        System.out.println("<img src=\"grafy/zatazenie_1min.png\">");
        System.out.println("<h3>minimum: " + tree_zatazenie_1min.first() + "</h3>");
        System.out.println("<h3>maximum: " + tree_zatazenie_1min.last() + "</h3>");
        System.out.println("<h3>priemer: " + String.format( "%.2f", (sum_zatazenie_1min / pocet_riadkov) ) + "</h3>");
        System.out.println("<br><br><br><br><br><br><br><br><br><br>\n");

        System.out.println("<img src=\"grafy/vytazenie_burza_jar_cpu_percent.png\">");
        System.out.println("<h3>minimum: " + tree_vytazenie_burza_jar_cpu_percent.first() + "</h3>");
        System.out.println("<h3>maximum: " + tree_vytazenie_burza_jar_cpu_percent.last() + "</h3>");
        System.out.println("<h3>priemer: " + String.format( "%.2f", (sum_vytazenie_burza_jar_cpu_percent / pocet_riadkov) ) + "</h3>");
        System.out.println("<br><br><br><br><br><br><br><br><br><br>\n");

        System.out.println("<img src=\"grafy/vytazenie_burza_jar_mem_percent.png\">");
        System.out.println("<h3>minimum: " + tree_vytazenie_burza_jar_mem_percent.first() + "</h3>");
        System.out.println("<h3>maximum: " + tree_vytazenie_burza_jar_mem_percent.last() + "</h3>");
        System.out.println("<h3>priemer: " + String.format( "%.2f", (sum_vytazenie_burza_jar_mem_percent / pocet_riadkov) ) + "</h3>");
        System.out.println("<br><br><br><br><br><br><br><br><br><br>\n");

        System.out.println("<img src=\"grafy/vytazenie_databazy_cpu_percent.png\">");
        System.out.println("<h3>minimum: " + tree_vytazenie_databazy_cpu_percent.first() + "</h3>");
        System.out.println("<h3>maximum: " + tree_vytazenie_databazy_cpu_percent.last() + "</h3>");
        System.out.println("<h3>priemer: " + String.format( "%.2f", (sum_vytazenie_databazy_cpu_percent / pocet_riadkov) ) + "</h3>");
        System.out.println();

        System.out.println("<img src=\"grafy/vytazenie_databazy_mem_percent.png\">");
        System.out.println("<h3>minimum: " + tree_vytazenie_databazy_mem_percent.first() + "</h3>");
        System.out.println("<h3>maximum: " + tree_vytazenie_databazy_mem_percent.last() + "</h3>");
        System.out.println("<h3>priemer: " + String.format( "%.2f", (sum_vytazenie_databazy_mem_percent / pocet_riadkov) ) + "</h3>");
        System.out.println("<br><br><br><br><br><br><br><br><br><br>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>");



    }

}