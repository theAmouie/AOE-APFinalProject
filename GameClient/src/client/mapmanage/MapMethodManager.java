package client.mapmanage;

import client.filemanage.FileManager;
import client.iomanage.IOManager;
import client.jsonmanage.JsonManager;
import javafx.scene.image.ImageView;

import static client.mapmanage.variablerepo.Consts.*;
import static client.mapmanage.variablerepo.Variables.*;

public class MapMethodManager {

    public static void makeManagers() throws Exception {
        fileManager = new FileManager();
        ioManager = new IOManager();

    }

    public static void initPrintMap() throws Exception {
        readJSONMap();
        makeMapOutline();
    }
    private static void readJSONMap() {
        mapJSON = new JsonManager();
        mapJSON.readMap();
        mapTiles = mapJSON.objectList();
    }
    private static void makeMapOutline(){
        mapImages = new ImageView[TOTAL_HOUSE_NUMBER];
        for(int i = 0; i < TOTAL_HOUSE_NUMBER; i++) {
            for(int j=0;j<58;j++) {
                if (mapTiles.get(i)==(j+1)) {
                    mapImages[i] = new ImageView(fileManager.id[j]);
                    break;
                }
                else {
                    mapImages[i] = new ImageView(fileManager.id[29]);
                }
            }
            mapImages[i].setX(returnColumn(i+2)*TILE_WIDTH);
            mapImages[i].setY(returnRow(i+2)*TILE_HEIGHT);
        }
    }

    private static int returnColumn (int homeNumber){
        int columnNumber=0;
        for (int i = 0; i< TOTAL_HOUSE_NUMBER; i++){
            if(i==homeNumber) break;
            else {
                if (i % (ROW_NUMBERS) == 1) {
                    columnNumber = 0;
                } else {
                    columnNumber++;
                }
            }
        }
        return columnNumber;
    }
    private static int returnRow (int homeNumber){
        int rowNumber=0;
        for (int i = 0; i< TOTAL_HOUSE_NUMBER; i++){
            if(i==homeNumber) break;
            else{
                if(i%(ROW_NUMBERS)==1) {
                    rowNumber++;
                }
                else{}
            }
        }
        return --rowNumber;
    }
    public static int returnHouseNumber(int x, int y){
        int houseNumber = -1;
        for(int i=0; i<TOTAL_HOUSE_NUMBER; i++){
            if(x>=returnColumn(i)*TILE_WIDTH && x<returnColumn(i)*TILE_WIDTH+TILE_WIDTH
                    && y>=returnRow(i)*TILE_HEIGHT && y<returnRow(i)*TILE_HEIGHT+TILE_HEIGHT) {
                houseNumber = i;
                break;
            }
        }
        return houseNumber;
    }


}
