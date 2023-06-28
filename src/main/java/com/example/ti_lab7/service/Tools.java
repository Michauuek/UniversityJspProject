package com.example.ti_lab7.service;

import jakarta.servlet.ServletContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Tools {

    public static String pobierzSzablon(String plik, ServletContext context) throws IOException {
        StringBuffer wyjscie = new StringBuffer("");
        String tekst = "";
        InputStream is = context.getResourceAsStream("/WEB-INF/widok/" + plik);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            while ((tekst = reader.readLine()) != null) {
                wyjscie.append(tekst).append("\n");
            }
        } else wyjscie.append("Brak pliku " + plik);
        return wyjscie.toString();
    }

    public static String uzupelnij(String szablon, String znacznik,
                                   String plik, ServletContext context) throws IOException {
        StringBuffer wyjscie = new StringBuffer("");
        String tekst = "";
        InputStream is = context.getResourceAsStream("/WEB-INF/widok/" + plik);
        if (is != null) {
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            if(znacznik.equals("TRESC")) {
                if ((tekst = reader.readLine()) != null) {
                    szablon = dodajSkrypt(szablon, tekst.split(";"));
                }
                if ((tekst = reader.readLine()) != null) {
                    szablon = szablon.replace("[[ONLOAD]]", "\""+tekst+"\"");
                }
            }
            while ((tekst = reader.readLine()) != null) {
                wyjscie.append(tekst).append("\n");

            }
        } else wyjscie.append("Brak pliku " + plik);

        return szablon.replace("[[" + znacznik + "]]", wyjscie.toString());
    }

    public static int parsujInteger(String wejscie, int domyslna) {
        int wyjscie = domyslna;
        try {
            wyjscie = Integer.parseInt(wejscie);
        } catch (NumberFormatException nfe) { // null lub zły format
            wyjscie = domyslna;
        }
        return wyjscie;
    }

    public static String parsujStrone(String wejscie, String prawidlowe) {
        String wyjscie = "glowna";
        String[] strony = prawidlowe.split(";");
        if(wejscie == null)
            wyjscie = "glowna";
        for(String poprawna : strony){
            if(poprawna.equals(wejscie)){
                wyjscie = wejscie;
                return wyjscie;
            }
        }
        return wyjscie;
    }

    public static String dodajSkrypt(String szablon, String[] pliki){
        String out="";
        for(String plik : pliki){
            out += ("<script type=\"text/javascript\" src=" + plik + "></script>");
        }
        return szablon.replace("[[SKRYPTY]]", out);
    }
}