// //////////////////////////////////////////////////////////////////////////////
// HotelModel: $Source$
// TODO Class summary goes here
//
// Created : 15 nov. 2005 by jfsmart
// Last modified $Date$ by $Author$
// Revision: $Revision$
// Version : $ID$
// Copyright (c) 2005
// //////////////////////////////////////////////////////////////////////////////

package com.javaworld.hotels.model;

import java.util.ArrayList;
import java.util.List;

import com.javaworld.hotels.businessobjects.Hotel;

/**
 * Une classe simple proposant quelques services pour la base de données
 * d'hotels.
 * @author jfsmart
 */
public class HotelModel {

    /**
     * La liste de toutes les villes connues dans la base de données.
     */
    private static String[] villes = { "Paris", "Londres" };

    /**
     * La liste de tous les hotels de la base de données.
     */
    private static Hotel[] hotels = {
            new Hotel("Hotel Latin", "Quartier latin", "Paris", 3),
            new Hotel("Hotel Etoile", "Place de l'Etoile", "Paris", 4),
            new Hotel("Hotel Vendome", "Place Vendome", "Paris", 5),
            new Hotel("Hotel Hilton", "Trafalgar Square", "Londres", 4),
            new Hotel("Hotel Ibis", "The City", "Londres", 3), };

    /**
     * Retourne les hôtels dans une ville donnée.
     * @param ville le nom de la ville
     * @return une liste d'objets Hotel
     */
    public List <Hotel> trouveHotelsParVille(String ville) {
        List <Hotel> hotelsTrouves = new ArrayList <Hotel>();
        for (Hotel hotel : hotels) {
            if (hotel.getVille().equalsIgnoreCase(ville)) {
                hotelsTrouves.add(hotel);
            }
        }
        return hotelsTrouves;
    }

    /**
     * Retourne la liste des villes de la base de données qui ont un hôtel.
     * @return une liste des noms de villes
     */
    public String[] trouveVillesDiponibles() {
        return villes;
    }
}
