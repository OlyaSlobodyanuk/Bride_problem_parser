/**
 * Created by AstureS on 06.06.2017.
 */
import java.io.*;

public class BrideProblemParser {
    private int n = 5;

    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("res\\output.html", false)) {
            try (BufferedReader reader = new BufferedReader(new FileReader("res\\input.txt"))) {
                String line;
                boolean sampleStart = false;

                writer.write("<html>\n");
                writer.write("<head>\n");
                writer.write("<style type=\"text/css\">\n" +
                        "    tr.win { background: #aaff80; }\n" +
                        "    tr.lose { background: #ff8080; }\n" +
                        "  </style>\n" +
                        " </head>\n" +
                        " <body>\n");

                while ((line = reader.readLine()) != null) {
                    if (line.contains("SAMPLE SIZE")) {
                        if(sampleStart) {
                            writer.write("</table>\n");
                        }
                        sampleStart = true;
                        writer.write("<h2> Количество пропущенных \nженихов" + line.substring(line.indexOf('=') + 1, line.length()) + "</h2>");
                        writer.write("<table table border=\"1\" cellpadding=\"1\" cellspacing=\"1\">\n");
                        reader.readLine();
                        reader.readLine();
                        line = reader.readLine();
                    }

                    if (!line.equals("\n")) {

                        String result = line.substring(0, line.indexOf("-"));
                        String sol = line.substring(line.indexOf("-"), line.length());

                        if (sol.charAt(2) == '1') {
                            writer.write("<tr class=\"win\">\n" +
                                    "    <td>");
                            writer.write(result + "</td>\n</tr>\n");
                        } else {
                            writer.write("<tr class=\"lose\">\n" +
                                    "    <td>");
                            writer.write(result + "</td>\n</tr>\n");
                        }
                    }
                }
                writer.write("</table>\n" +
                        "</body>\n" +
                        "</html>\n");
                writer.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}