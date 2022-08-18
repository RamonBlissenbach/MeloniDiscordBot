package eu.ramonblissenbach.melonidiscordbot.utils;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class ItemReader {

    private static String itemName;

    public ItemReader(String itemName) {
        ItemReader.itemName = itemName;
    }

    public String getItemName() {
        try {
            itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
            URL url = new URL("https://melonwert.de/?item_name=" + itemName);
            Scanner scanner = new Scanner(url.openStream(), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(itemName)) {
                    if (!line.contains("value=\"" + itemName + "\"")) {
                        if (!line.contains("img")) {
                            return line.replaceAll("<h2>", "").replaceAll("</h2>", "").replaceAll(" ", "");
                        }
                    }
                }
            }
            return "Es wurde kein Item gefunden!";
        } catch (IOException e) {
            return "Failed";
        }
    }

    public String getItemImage() {
        try {
            itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
            URL url = new URL("https://melonwert.de/?item_name=" + itemName);
            Scanner scanner = new Scanner(url.openStream(), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(itemName)) {
                    if (!line.contains("value=\"" + itemName + "\"")) {
                        if (line.contains("img")) {
                            return "https://melonwert.de/" + line.replaceAll("        <img src=\"", "").replaceAll("\" width=\"5%\" alt=\"Item\">", "");
                        }
                    }
                }
            }
            return "https://melonwert.de/items/Barrier.png";
        } catch (IOException e) {
            return "https://melonwert.de/items/Barrier.png";
        }
    }

    public String getItemPrice() {
        try {
            itemName = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);
            URL url = new URL("https://melonwert.de/?item_name=" + itemName);
            Scanner scanner = new Scanner(url.openStream(), "UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Aktueller Preis:")) {
                    return line.replaceAll("        <h4>Aktueller Preis: <span style=\"color: #FFFF55\">", "").replaceAll("</span></h4>", "");
                }
            }
            return "Es wurde kein Preis gefunden!";
        } catch (IOException e) {
            return "Failed";
        }
    }

}
