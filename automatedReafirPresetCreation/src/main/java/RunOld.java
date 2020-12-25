import org.sikuli.script.*;

import java.util.List;
import java.util.Map;

public class RunOld {


   // make sure to shrink images by 50% so it will work with mac retina

   public static void main(String[] args) throws Exception {

      Map<Integer, List<DataPoint>> dataPointsMap = DataPointsMap.get();

      Pattern currentTrackPattern = new Pattern(RunOld.class.getResource("currentTrack.png"));
      Pattern closeButtonPattern = new Pattern(RunOld.class.getResource("closeButton.png"));
      Pattern base1Pattern = new Pattern(RunOld.class.getResource("base1.png"));
      Pattern base2Pattern = new Pattern(RunOld.class.getResource("base2.png"));
      Pattern plus68Pattern = new Pattern(RunOld.class.getResource("plus68.png"));
      Pattern plusZeroPattern = new Pattern(RunOld.class.getResource("plusZero.png"));
      Pattern insertPointPattern = new Pattern(RunOld.class.getResource("insertPoint.png"));
      Pattern setPattern = new Pattern(RunOld.class.getResource("set.png"));
      Pattern frequencyPattern = new Pattern(RunOld.class.getResource("frequency.png"));
      Pattern gainPattern = new Pattern(RunOld.class.getResource("gain.png"));
      Pattern okButtonPattern = new Pattern(RunOld.class.getResource("okButton.png"));
      Pattern plusButtonPattern = new Pattern(RunOld.class.getResource("plusButton.png"));
      Pattern exportPatchPattern = new Pattern(RunOld.class.getResource("exportPatch.png"));
      Pattern savePresetPattern = new Pattern(RunOld.class.getResource("savePreset.png"));
      Pattern presetNamePattern = new Pattern(RunOld.class.getResource("presetName.png"));
      Pattern saveAsPattern = new Pattern(RunOld.class.getResource("saveAs.png"));
      Pattern savePatchButtonPattern = new Pattern(RunOld.class.getResource("savePatchButton.png"));
      Pattern fiftyPattern = new Pattern(RunOld.class.getResource("fifty.png"));
      Pattern removeFxPattern = new Pattern(RunOld.class.getResource("removeFx.png"));

      Screen screen = new Screen(0);

      Location reaperIconLocation = new Location(0, 330);

      screen.mouseMove(reaperIconLocation);
      screen.click(reaperIconLocation);

      for (int i = 1; i >= 1; i--) {

         Location base1FxButton = getLocation(screen, base1Pattern).offset(140, 0);
//         Location base2FxButton = getLocation(screen, base2Pattern).offset(140, 0);
         Location currentTrackFxButton = getLocation(screen, currentTrackPattern).offset(140, 0);

         screen.dragDrop(base1FxButton, currentTrackFxButton);

         List<DataPoint> dataPoints = dataPointsMap.get(i);

         if (dataPoints.size() != 29) {
            throw new Exception("size of baseUnits " + i + " is not 29");
         }

         for (int j = 0; j < 29; j++) {

            Location topRightOfReafir = getLocation(screen, plusZeroPattern).offset(-25, 2);
            screen.rightClick(topRightOfReafir);

            Location insertPoint = getLocation(screen, insertPointPattern);
            screen.click(insertPoint);

            Thread.sleep(500);
            Location bottomLeftOfReafir = getLocation(screen, fiftyPattern).offset(0, -20);
            screen.mouseMove(bottomLeftOfReafir);
            Thread.sleep(1000);
            screen.rightClick(topRightOfReafir);

            try {
               Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
               screen.click(set);
            } catch (FindFailed findFailed) {

               System.out.println("failed to insert point, trying again");

               Location insertPoint2 = getLocation(screen, insertPointPattern);
               screen.click(insertPoint2);

               Thread.sleep(500);
               Location bottomLeftOfReafir2 = getLocation(screen, fiftyPattern).offset(0, -20);
               screen.mouseMove(bottomLeftOfReafir2);
               Thread.sleep(1000);
               screen.rightClick(topRightOfReafir);

               Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
               screen.click(set);
            }


            Location frequencyField;

            try {
               frequencyField = screen.wait(frequencyPattern.similar((float) 0.90), 5).getTarget().offset(55, 0);
            } catch (FindFailed findFailed) {
               System.out.println("failed to set point, trying again");

               try {

                  Thread.sleep(500);
                  Location bottomLeftOfReafir3 = getLocation(screen, fiftyPattern).offset(0, -20);
                  screen.mouseMove(bottomLeftOfReafir3);
                  Thread.sleep(1000);
                  screen.rightClick(topRightOfReafir);

                  Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
                  screen.click(set);
               } catch (FindFailed findFailed2) {

                  System.out.println("failed to insert point, trying again");

                  Thread.sleep(500);
                  Location bottomLeftOfReafir3 = getLocation(screen, fiftyPattern).offset(0, -20);
                  screen.mouseMove(bottomLeftOfReafir3);
                  Thread.sleep(1000);
                  screen.rightClick(topRightOfReafir);

                  Location insertPoint2 = getLocation(screen, insertPointPattern);
                  screen.click(insertPoint2);

                  Thread.sleep(500);
                  Location bottomLeftOfReafir2 = getLocation(screen, fiftyPattern).offset(0, -20);
                  screen.mouseMove(bottomLeftOfReafir2);
                  Thread.sleep(1000);
                  screen.rightClick(topRightOfReafir);

                  Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
                  screen.click(set);
               }

               frequencyField = screen.wait(frequencyPattern.similar((float) 0.90), 5).getTarget().offset(55, 0);

            }



            screen.mouseMove(frequencyField);
            screen.type(Key.BACKSPACE);

            screen.doubleClick(frequencyField);

            backspaceTenTimes(screen);

            screen.type(dataPoints.get(j).getFrequencyValue().toString());

            Location gainField = getLocation(screen, gainPattern).offset(65, 0);
            screen.doubleClick(gainField);

            backspaceTenTimes(screen);

            screen.type(dataPoints.get(j).getDbValue().toString());

            Location okButton = getLocation(screen, okButtonPattern);
            screen.click(okButton);

            Thread.sleep(500);
//            Location bottomLeftOfReafir = getLocation(screen, fiftyPattern).offset(0, -20);
            screen.mouseMove(bottomLeftOfReafir);
            Thread.sleep(1000);
            screen.mouseMove(topRightOfReafir);
            Thread.sleep(500);
         }

         Location plusButton = getLocation(screen, plusButtonPattern);
         screen.click(plusButton);

         Location exportPatch = getLocation(screen, exportPatchPattern);
         screen.click(exportPatch);

         Location saveAsField = getLocation(screen, saveAsPattern).offset(70, 0);
         screen.mouseMove(saveAsField);
         screen.type(Key.BACKSPACE);

         screen.doubleClick(saveAsField);

         backspaceTenTimes(screen);

         screen.type(i + "bU");

         Location savePatchButton = getLocation(screen, savePatchButtonPattern);
         screen.click(savePatchButton);

         Thread.sleep(500);
         Location bottomLeftOfReafir = getLocation(screen, fiftyPattern).offset(0, -20);
         Location topRightOfReafir = getLocation(screen, plusZeroPattern).offset(-25, 2);
         screen.mouseMove(bottomLeftOfReafir);
         Thread.sleep(1000);
         screen.mouseMove(topRightOfReafir);
         Thread.sleep(500);

         screen.click(plusButton);

         Location savePreset = getLocation(screen, savePresetPattern);
         screen.click(savePreset);

         Location presetNameField = getLocation(screen, presetNamePattern).offset(100, 0);
         screen.mouseMove(presetNameField);
         screen.type(Key.BACKSPACE);

         screen.doubleClick(presetNameField);

         backspaceTenTimes(screen);
         screen.type(i + "bU");

         Location okButton = getLocation(screen, okButtonPattern);
         screen.click(okButton);

         Thread.sleep(500);
         screen.mouseMove(bottomLeftOfReafir);
         Thread.sleep(1000);
         screen.mouseMove(topRightOfReafir);
         Thread.sleep(500);

         Location removeFx = getLocation(screen, removeFxPattern);
         screen.click(removeFx);
         Thread.sleep(1000);

         Location closeButton = getLocation(screen, closeButtonPattern);
         screen.click(closeButton);
      }




      /////




      for (int i = -1; i >= -100; i--) {

//         Location base1FxButton = getLocation(screen, base1Pattern).offset(140, 0);
         Location base2FxButton = getLocation(screen, base2Pattern).offset(140, 0);
         Location currentTrackFxButton = getLocation(screen, currentTrackPattern).offset(140, 0);

         screen.dragDrop(base2FxButton, currentTrackFxButton);

         List<DataPoint> dataPoints = dataPointsMap.get(i);

         if (dataPoints.size() != 29) {
            throw new Exception("size of baseUnits " + i + " is not 29");
         }

         for (int j = 0; j < 29; j++) {

            Location topRightOfReafir = getLocation(screen, plusZeroPattern).offset(-25, 2);
            screen.rightClick(topRightOfReafir);

            Location insertPoint = getLocation(screen, insertPointPattern);
            screen.click(insertPoint);

            Thread.sleep(500);
            Location bottomLeftOfReafir = getLocation(screen, fiftyPattern).offset(0, -20);
            screen.mouseMove(bottomLeftOfReafir);
            Thread.sleep(1000);

            screen.rightClick(topRightOfReafir);

            try {
               Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
               screen.click(set);
            } catch (FindFailed findFailed) {

               System.out.println("failed to insert point, trying again");

               Location insertPoint2 = getLocation(screen, insertPointPattern);
               screen.click(insertPoint2);

               Thread.sleep(500);
               Location bottomLeftOfReafir2 = getLocation(screen, fiftyPattern).offset(0, -20);
               screen.mouseMove(bottomLeftOfReafir2);
               Thread.sleep(1000);

               screen.rightClick(topRightOfReafir);

               Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
               screen.click(set);
            }

            Location frequencyField;

            try {
               frequencyField = screen.wait(frequencyPattern.similar((float) 0.90), 5).getTarget().offset(55, 0);
            } catch (FindFailed findFailed) {
               System.out.println("failed to set point, trying again");

               try {
                  Thread.sleep(500);
                  Location bottomLeftOfReafir3 = getLocation(screen, fiftyPattern).offset(0, -20);
                  screen.mouseMove(bottomLeftOfReafir3);
                  Thread.sleep(1000);
                  screen.rightClick(topRightOfReafir);

                  Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
                  screen.click(set);
               } catch (FindFailed findFailed2) {

                  System.out.println("failed to insert point, trying again");

                  Thread.sleep(500);
                  Location bottomLeftOfReafir3 = getLocation(screen, fiftyPattern).offset(0, -20);
                  screen.mouseMove(bottomLeftOfReafir3);
                  Thread.sleep(1000);
                  screen.rightClick(topRightOfReafir);

                  Location insertPoint2 = getLocation(screen, insertPointPattern);
                  screen.click(insertPoint2);

                  Thread.sleep(500);
                  Location bottomLeftOfReafir2 = getLocation(screen, fiftyPattern).offset(0, -20);
                  screen.mouseMove(bottomLeftOfReafir2);
                  Thread.sleep(1000);
                  screen.rightClick(topRightOfReafir);

                  Location set = screen.wait(setPattern.similar((float) 0.90), 5).getTarget();
                  screen.click(set);
               }

               frequencyField = screen.wait(frequencyPattern.similar((float) 0.90), 5).getTarget().offset(55, 0);

            }

            screen.mouseMove(frequencyField);
            screen.type(Key.BACKSPACE);

            screen.doubleClick(frequencyField);

            backspaceTenTimes(screen);

            screen.type(dataPoints.get(j).getFrequencyValue().toString());

            Location gainField = getLocation(screen, gainPattern).offset(65, 0);
            screen.doubleClick(gainField);

            backspaceTenTimes(screen);

            screen.type(dataPoints.get(j).getDbValue().toString());

            Location okButton = getLocation(screen, okButtonPattern);
            screen.click(okButton);

            Thread.sleep(500);
//            Location bottomLeftOfReafir = getLocation(screen, fiftyPattern).offset(0, -20);
            screen.mouseMove(bottomLeftOfReafir);
            Thread.sleep(1000);
            screen.mouseMove(topRightOfReafir);
            Thread.sleep(500);
         }

         Location plusButton = getLocation(screen, plusButtonPattern);
         screen.click(plusButton);

         Location exportPatch = getLocation(screen, exportPatchPattern);
         screen.click(exportPatch);

         Location saveAsField = getLocation(screen, saveAsPattern).offset(70, 0);
         screen.mouseMove(saveAsField);
         backspaceTenTimes(screen);

         screen.doubleClick(saveAsField);

         backspaceTenTimes(screen);

         screen.type(i + "bU");

         Location savePatchButton = getLocation(screen, savePatchButtonPattern);
         screen.click(savePatchButton);

         Thread.sleep(500);
         Location bottomLeftOfReafir = getLocation(screen, fiftyPattern).offset(0, -20);
         Location topRightOfReafir = getLocation(screen, plusZeroPattern).offset(-25, 2);
         screen.mouseMove(bottomLeftOfReafir);
         Thread.sleep(1000);
         screen.mouseMove(topRightOfReafir);
         Thread.sleep(500);

         screen.click(plusButton);

         Location savePreset = getLocation(screen, savePresetPattern);
         screen.click(savePreset);

         Location presetNameField = getLocation(screen, presetNamePattern).offset(100, 0);
         screen.mouseMove(presetNameField);
         screen.type(Key.BACKSPACE);

         screen.doubleClick(presetNameField);

         backspaceTenTimes(screen);
         screen.type(i + "bU");

         Location okButton = getLocation(screen, okButtonPattern);
         screen.click(okButton);

         Thread.sleep(500);
         screen.mouseMove(bottomLeftOfReafir);
         Thread.sleep(1000);
         screen.mouseMove(topRightOfReafir);
         Thread.sleep(500);

         Location removeFx = getLocation(screen, removeFxPattern);
         screen.click(removeFx);
         Thread.sleep(1000);

         Location closeButton = getLocation(screen, closeButtonPattern);
         screen.click(closeButton);
      }





   }

   private static Location getLocation(Screen screen, Pattern arg) throws Exception {
      return screen.wait(arg.similar((float) 0.90), 5).getTarget();
   }

   private static void backspaceTenTimes(Screen screen) {
      for (int k = 0; k < 10; k++) {
         screen.type(Key.BACKSPACE);
      }
   }
}