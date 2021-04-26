package direktoriopack;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Directorios {//obtencion de directorios

    String[] dirs;
    int i = 0;
    int tam = 0;

    public String[] conjuntoDirectorios(String host) {
        try {
            String url = "https://itescam.edu.mx";

            Document doc = Jsoup.connect(host).get();
            Elements imports = doc.select("a[href]");
            dirs = new String[imports.size()];
            tam = imports.size();

            for (Element link : imports) {
                dirs[i] = (link.tagName() + link.attr("abs:href") + "\n");
                i++;
            }
            return dirs;
        } catch (Exception e) {
        }
        return null;
    }

    public int getTamaño() {
        return tam;
    }

}
