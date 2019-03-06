package actividad0058;

import java.util.ArrayList;

/**
 * A simple model of an auction. The auction maintains a list of lots of
 * arbitrary length.
 *
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class Auction {

    // The list of Lots in this auction.
    private ArrayList<Lot> lots;
    // The number that will be given to the next lot entered
    // into this auction.
    private int nextLotNumber;

    /**
     * Create a new auction.
     */
    public Auction() {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Enter a new lot into the auction.
     *
     * @param description A description of the lot.
     */
    public void enterLot(String description) {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Show the full list of lots in this auction.
     */
    public void showLots() {
        for (Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Make a bid for a lot. A message is printed indicating whether the bid is
     * successful or not.
     *
     * @param lotNumber The lot being bid for.
     * @param bidder The person bidding for the lot.
     * @param value The value of the bid.
     */
    public void makeABid(int lotNumber, Person bidder, long value) {
        Lot selectedLot = getLot(lotNumber);
        if (selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if (successful) {
                System.out.println("The bid for lot number "
                        + lotNumber + " was successful.");
            } else {
                // Report which bid is higher.
                System.out.println("Lot number: " + lotNumber
                        + " already has a bid of: "
                        + selectedLot.getHighestBid().getValue());
            }
        }
    }

    /**
     * Return the lot with the given number. Return null if a lot with this
     * number does not exist.
     *
     * @param lotNumber The number of the lot to return.
     */
    public Lot getLot(int lotNumber) {
        Lot selectedLot = null;
        for (int i = 0; i < lots.size(); i++) {
            if (lots.get(i).getNumber() == lotNumber) {
                selectedLot = lots.get(i);
            }
        }
        if (selectedLot == null) {
            System.out.println("No se ha encontrado el lote con el número: " + lotNumber);
        }
        return selectedLot;
    }

    public void close() {
        for (Lot lote : lots) {
            Bid bid = lote.getHighestBid();
            if (bid != null) {
                System.out.println("Lote:" + lote.toString());
                System.out.println("Puja más alta hecha por:" + lote.getHighestBid().getBidder().getName());
            } else {
                System.out.println("No hay pujas");
            }
        }
    }

    public ArrayList<Lot> getUnSold() {
        ArrayList<Lot> listaNoVendidos = new ArrayList<>();
        for (Lot lote : lots) {
            if (lote.getHighestBid() == null) {
                listaNoVendidos.add(lote);
            }
        }
        return listaNoVendidos;
    }

    /**
     * Elimina el lote con el número de lote especificado.
     *
     * @param number El número del lote que hay que eliminar,
     * @return El lote con el número dado o null si no existe tal lote.
     */
    public Lot removeLot(int number) {
        Lot selectedLot = null;
        for (int i = 0; i < lots.size(); i++) {
            if (lots.get(i).getNumber() == number) {
                selectedLot = lots.remove(i);
            }
        }
        if (selectedLot == null) {
            System.out.println("No se ha encontrado el lote con el número: " + number);
        }
        return selectedLot;
    }

}
