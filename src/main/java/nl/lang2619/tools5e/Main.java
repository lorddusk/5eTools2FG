package nl.lang2619.tools5e;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    JSONParser parser = new JSONParser();
    try {
      Object obj = parser.parse(new FileReader("input/barb.json"));

      JSONObject jsonObject = (JSONObject) obj;

      JSONObject compendium = (JSONObject) jsonObject.get("compendium");
      JSONArray clazz = (JSONArray) compendium.get("class");

      for (int i = 0; i < clazz.size(); i++) {
        JSONObject currClass = (JSONObject) clazz.get(i);
        String name = (String) currClass.get("name");
        String hitdice = (String) currClass.get("hd");
        String savingThrows = (String) currClass.get("proficiency");

        JSONArray autolevel = (JSONArray) currClass.get("autolevel");
        //Class Level Stats
        for (int j = 0; j < autolevel.size(); j++) {
          JSONObject levelFeature = (JSONObject) autolevel.get(j);
          //Loop through to get all the level features (in this case barbarian rage, rage amounts, etc.
        }

        //Class Level Features
        for (int k = 20; k < 21; k++) {
          JSONObject levelFeature = (JSONObject) autolevel.get(k);
          JSONArray feature = (JSONArray) levelFeature.get("feature");
          for (Object aFeature : feature) {
            JSONObject featureLevel = (JSONObject) aFeature;
            String featureName = (String) featureLevel.get("name");
            JSONArray featureText = (JSONArray) featureLevel.get("text");

            if (featureName.equals("Starting Proficiencies")) {
              for (int l = 0; l < featureText.size(); l++) {
                //Loop through text to parse Armor / Weapons / Tools / Skills
              }
            }
            if (featureName.equals("Starting Equipment")) {
              for (int l = 0; l < featureText.size(); l++) {
                //Loop through text to parse starting equipment
              }
            }
          }
        }
      }

    } catch (ParseException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
